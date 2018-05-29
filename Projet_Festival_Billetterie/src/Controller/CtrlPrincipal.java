/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.JFrameAuthentification;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 *
 * @author qbaudry
 */
public class CtrlPrincipal implements WindowListener, ActionListener {
    
    int idrep;
    
    CtrlLesRepresentations ctrlrep;
    CtrlReservation ctrlres;
    CtrlAuthentification ctrlauth;
    CtrlUpdate ctrlupdt;
    CtrlLoginBdd ctrlLogBdd;
    
    //Show: Affiche la vue
    //Hide: Cache la vue
    
    public void showRepresentation() {
        ctrlrep = new CtrlLesRepresentations(this);
        ctrlrep.getVue().setVisible(true);
    }

    public void hideRepresentation() {
        ctrlrep.getVue().setVisible(false);
    }

    //Affiche la vue d'une réservation en fonction de l'id
    public void showReservation(int id) {
        ctrlres = new CtrlReservation(id, this);
        ctrlres.getVue().setVisible(true);
    }

    public void hideReservation() {
        ctrlres.getVue().setVisible(false);
    }

    public void showAuthentification() {
        ctrlauth = new CtrlAuthentification(this);
        ctrlauth.getVue().setVisible(true);
    }

    public void hideAuthentification() {
        ctrlauth.getVue().setVisible(false);
    }

    public void showUpdate() {
        ctrlupdt = new CtrlUpdate(this);
        ctrlupdt.getVue().setVisible(true);
    }

    public void hideUpdate() {
        ctrlupdt.getVue().setVisible(false);
    }

    public void showLogDb() {
        ctrlLogBdd = new CtrlLoginBdd(this);
        ctrlLogBdd.getVue().setVisible(true);
    }

    public void hideLogDb() {
        ctrlLogBdd.getVue().setVisible(false);
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
    }
}
