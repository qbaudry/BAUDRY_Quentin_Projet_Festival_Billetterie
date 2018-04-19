/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import DAO.RepresentationDAO;
import Metier.Representation;
import Properties.Reader;
import View.JFrameAuthentification;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author qbaudry
 */
public class CtrlAuthentification implements WindowListener, ActionListener {

    private JFrameAuthentification vue = new JFrameAuthentification(); // LA VUE
    private CtrlPrincipal ctrlPrinc;
    
    public CtrlAuthentification(CtrlPrincipal ctrlPrinc) {
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        
        this.vue=vue;
        this.vue.addWindowListener((WindowListener) this);
        this.vue.getjButtonValider().addActionListener((ActionListener) this);
        this.ctrlPrinc = ctrlPrinc;        
    }

    // ACCESSEURS et MUTATEURS
    public JFrameAuthentification getVue() {
        return vue;
    }

    public void setVue(JFrameAuthentification vue) {
        this.vue = vue;
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.vue.getjButtonValider())){
            try {
                String login = this.vue.getjTextFieldLogin().getText();
                String mdp = this.vue.getjPasswordFieldMdp().getText();
                
                MessageDigest mdLogin = MessageDigest.getInstance("SHA-256");
                mdLogin.update(mdp.getBytes());
                byte[] digestLogin = mdLogin.digest();
                StringBuffer sbLogin = new StringBuffer();
                for (byte b : digestLogin) {
                    sbLogin.append(String.format("%02x", b & 0xff));
                }
                
                MessageDigest mdMDP = MessageDigest.getInstance("SHA-256");
                mdMDP.update(mdp.getBytes());
                byte[] digestMDP = mdMDP.digest();
                StringBuffer sbMDP = new StringBuffer();
                for (byte b : digestMDP) {
                    sbMDP.append(String.format("%02x", b & 0xff));
                }
                
                if(Reader.readString("Authentification_login").equals(sbLogin.toString()) && Reader.readString("Authentification_login").equals(sbMDP.toString())){
                    ctrlPrinc.showRepresentation();
                    ctrlPrinc.hideAuthentification();
                }else {
                    JOptionPane.showMessageDialog(null, "Votre login et/ou MDP est incorrecte");
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CtrlAuthentification.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}