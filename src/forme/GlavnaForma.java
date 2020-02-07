/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.FormaMod;
import domen.Korisnik;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import session.Session;

/**
 *
 * @author User
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() {
        initComponents();
        setTrenutnogKorisnika();
        centrirajFormu();
        ;
        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images//pozadina.png")))));
        } catch (IOException ex) {
            Logger.getLogger(GlavnaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblPrijavljeniKorisnik = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemUnos = new javax.swing.JMenuItem();
        menuItemPretraga = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setFont(new java.awt.Font("Candara", 0, 10)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Prijavljeni korisnik:");

        jMenu1.setText("Angazovanje");

        menuItemUnos.setText("Unos");
        menuItemUnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemUnosActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemUnos);

        menuItemPretraga.setText("Pretraga");
        menuItemPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPretragaActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemPretraga);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblPrijavljeniKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPrijavljeniKorisnik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(244, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemUnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemUnosActionPerformed
        // TODO add your handling code here:
        UnosAngazovanjaForma uaf = new UnosAngazovanjaForma(null, true, FormaMod.NOVO);
        uaf.setVisible(true);
    }//GEN-LAST:event_menuItemUnosActionPerformed

    private void menuItemPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPretragaActionPerformed
        // TODO add your handling code here:
        PretragaAngazovanjaForma paf = new PretragaAngazovanjaForma(null, true);
        paf.setVisible(true);
    }//GEN-LAST:event_menuItemPretragaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblPrijavljeniKorisnik;
    private javax.swing.JMenuItem menuItemPretraga;
    private javax.swing.JMenuItem menuItemUnos;
    // End of variables declaration//GEN-END:variables

    private void setTrenutnogKorisnika() {
        Korisnik korisnik = Session.getInstance().getTrenutniKorisnik();
        lblPrijavljeniKorisnik.setText(korisnik.getIme()+" "+ korisnik.getPrezime());
    }

    private void centrirajFormu() {
        this.setLocationRelativeTo(null);
    }
}
