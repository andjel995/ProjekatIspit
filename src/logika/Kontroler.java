package logika;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import domen.Angazovanje;
import storage.StorageAngazovanje;
import storage.StorageKorisnik;
import storage.StoragePredmet;
import storage.StorageProfesor;
import domen.Korisnik;
import domen.Predmet;
import domen.Profesor;
import domen.RezultatCuvanja;
import domen.TipNastave;
import java.util.ArrayList;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Kontroler {
    private static Kontroler instanca;
    private StorageAngazovanje storageAngazovanje;
    private StorageKorisnik storageKorisnik;
    private StoragePredmet storagePredmet;
    private StorageProfesor storageProfesor;
   
    private Kontroler() {
        storageAngazovanje = new StorageAngazovanje();
        storageKorisnik = new StorageKorisnik();
        storagePredmet = new StoragePredmet();
        storageProfesor = new StorageProfesor();
    }
    
   public static Kontroler dajInstancu()
   {
     if(instanca == null)
         instanca = new Kontroler();
     return instanca;
   }
    
   public Korisnik prijaviSe(String korisnickoIme, String lozinka) throws Exception
   {
       Korisnik korisnik = new Korisnik();
       List<Korisnik> korisnici = storageKorisnik.getKorisnici();
       try
       {
            for(Korisnik k : korisnici)
            {
                if(k.getKorisnickoIme().equals(lozinka) && k.getLozinka().equals(lozinka))
                    return k;
            }
       }catch(Exception ex)
       {
            throw new Exception("Error in login method :"+ ex.getMessage());
       }
       return korisnik;
   }

    public List<Predmet> dajPredmete() {
       List<Predmet> listaPredmeta = storagePredmet.getPredmeti();
       return listaPredmeta;
    }

    public List<Profesor> dajListuProfesora() {
        List<Profesor> listaProfesora = storageProfesor.getProfesori();
        return listaProfesora;
    }

    public List<Angazovanje> dajAngazovanja() {
        List<Angazovanje> listaAngazovanja = storageAngazovanje.getAngazovanja();
        return listaAngazovanja;
    }

    public boolean proveriDuplikate(Profesor profesor, Predmet predmet, TipNastave tn, List<Angazovanje> lista) {
        for(Angazovanje angazovanje : lista)
        {
            if(angazovanje.getPredmet().equals(predmet) && angazovanje.getProfesor().equals(profesor))
                return true;
        }
        return false;
    }

    public RezultatCuvanja sacuvajSve(List<Angazovanje> lista) {
        RezultatCuvanja rc = RezultatCuvanja.Uspesan;
        List<Angazovanje> angazovanja = storageAngazovanje.getAngazovanja();
        for(Angazovanje a: lista)
        {
            if(angazovanja.contains(a))
            {
                rc = RezultatCuvanja.Duplikati;
                continue;
            }
            storageAngazovanje.dodajAngazovanje(a);
        }
        return rc;
    }

    public List<Angazovanje> dajAngazovanjaZaOdredjeniPredmet(Long predmetId) {
       List<Angazovanje> lista =  storageAngazovanje.getAngazovanja();
       List<Angazovanje> listaOdabranihAngazovanja = new ArrayList<>();
       for(Angazovanje a : lista)
       {
           if(a.getPredmet().getPredmetId().equals(predmetId))
               listaOdabranihAngazovanja.add(a);
       }
       return listaOdabranihAngazovanja;
    }

    public boolean izmeniAngazovanja(Angazovanje a, List<Angazovanje> novaLista) {
        int brojac = 0;
        boolean bezDuplikata = true;
        List<Angazovanje> postojecaAngazovanja = dajAngazovanjaZaOdredjeniPredmet(a.getPredmet().getPredmetId());
        for(Angazovanje angazovanje : novaLista)
        {
            if(postojecaAngazovanja.contains(angazovanje)){
                brojac++;
                continue;
            }
            else
            {
                storageAngazovanje.dodajAngazovanje(angazovanje);
            }
        }
        postojecaAngazovanja = dajAngazovanjaZaOdredjeniPredmet(a.getPredmet().getPredmetId());
        if(brojac == postojecaAngazovanja.size())
            bezDuplikata = false;
        
        for(Angazovanje angazovanje : postojecaAngazovanja)
        {
            if(!novaLista.contains(angazovanje))
            storageAngazovanje.obrisiAngazovanje(angazovanje);
        }
        return bezDuplikata;
    }
    
}
