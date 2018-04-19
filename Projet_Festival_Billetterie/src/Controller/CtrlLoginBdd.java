/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.JFrameAuthentification;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import DAO.UtilisateurDAO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author tguyot
 */
public class CtrlLoginBdd implements WindowListener, MouseListener, ActionListener, KeyListener {

    JFrameAuthentification vue = new JFrameAuthentification();
    private CtrlPrincipal ctrlPrin;

    public CtrlLoginBdd(CtrlPrincipal ctrlPrin) {
        this.ctrlPrin = ctrlPrin;
        vue.getjButtonValider().addActionListener(this);
        vue.getjTextFieldLogin().addKeyListener(this);
        vue.getjPasswordFieldMdp().addKeyListener(this);
        vue.getjButtonValider().setEnabled(false);
        vue.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public JFrameAuthentification getVue() {
        return vue;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vue.getjButtonValider()) {
            testUsrPswd();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (vue.getjTextFieldLogin().getText().length() == 0 || vue.getjPasswordFieldMdp().getPassword().length == 0) {
            vue.getjButtonValider().setEnabled(false);
        } else {
            vue.getjButtonValider().setEnabled(true);
            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                testUsrPswd();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void testUsrPswd() {
        if (UtilisateurDAO.LogIn(vue.getjTextFieldLogin().getText(), String.valueOf(vue.getjPasswordFieldMdp().getPassword()))) {
            ctrlPrin.showUpdate();
            ctrlPrin.hideLogDb();
        } else {
            JOptionPane.showMessageDialog(null, "Identifiants invalide.");
        }
    }
}
