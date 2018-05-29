/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.JFrameReservation;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import Metier.Representation;
import DAO.RepresentationDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author tguyot
 */
public class CtrlReservation implements WindowListener, MouseListener, ActionListener {

    JFrameReservation vue = new JFrameReservation();
    Representation rep;
    private CtrlPrincipal ctrlPrinc;

    public CtrlReservation(int id, CtrlPrincipal ctrlPrinc) {
        this.ctrlPrinc = ctrlPrinc;
        //Sélectionne les données d'une représentation
        rep = RepresentationDAO.selectOne(id);
        //Affiche les données de la représentation
        vue.getjTextFieldGroupe().setText(rep.getGroupe().getNomGroup());
        vue.getjTextFieldLieu().setText(rep.getLieu().getNomLieu());
        vue.getjTextFieldDate().setText(rep.getDateRep().toString());
        vue.getjTextFieldHeureDebut().setText(rep.getHeureDebut().toString());
        vue.getjTextFieldHeureFin().setText(rep.getHeureFin().toString());
        vue.getjTextFieldNbPlaceTotal().setText(Integer.toString(rep.getLieu().getCapaciteAccueil()));
        vue.getjTextFieldNbPlaceDispo().setText(Integer.toString(rep.getNbPlace()));
        //Combobox du nombre de place souhaité en fonction des places restantes
        vue.getjComboBoxNbPlaceSouhaite().removeAllItems();
        for (int i = 1; i <= rep.getNbPlace(); i++) {
            vue.getjComboBoxNbPlaceSouhaite().addItem(Integer.toString(i));
        }
        vue.getjButtonReserver().addActionListener(this);
        vue.getJButtonBack().addActionListener(this);
    }

    public JFrameReservation getVue() {
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
        //Si le bouton réserver est actionné
        if (e.getSource() == vue.getjButtonReserver()) {
            //Calcul du nouveau nombre de place (nbPlace initial - nbPlace sélectionné dans la ComboBox)
            int nbplace = rep.getNbPlace() - Integer.parseInt(vue.getjComboBoxNbPlaceSouhaite().getSelectedItem().toString());
            //Insertion du nouveau nombre de place pour la Représentaion
            RepresentationDAO.updateNbPlace(rep.getIdRep(), nbplace);
            JOptionPane.showMessageDialog(vue,
                    "Commande réussie. \nIl reste " + nbplace + " place(s).",
                    "Reservation",
                    JOptionPane.PLAIN_MESSAGE);
            ctrlPrinc.showRepresentation();
            vue.setVisible(false);
        }
        //Si le bouton quitter est actionné
        if (e.getSource() == vue.getJButtonBack()) {
            ctrlPrinc.showRepresentation();
            vue.setVisible(false);
        }
    }
}
