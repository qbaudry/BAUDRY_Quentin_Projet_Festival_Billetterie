/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GroupeDAO;
import Metier.Groupe;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import View.JFrameMenu;

/**
 *
 * @author qbaudry
 */

public class CtrlLesGroupes implements WindowListener{

    private JFrameMenu vue; // LA VUE

    public CtrlLesGroupes(JFrameMenu vue) {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        // le controleur écoute le bouton jButtonRechercher de sa vue
        // préparer l'état iniitial de la vue
        List<Groupe> lesGroupes = null;
        try {
            lesGroupes = GroupeDAO.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesGroupes - Echec de sélection des Groupes");
        }
        afficherLesGroupes(lesGroupes);
    }

    // contrôle de la vue
    /**
     * Remplir le composant JTable avec les groupes
     *
     * @param desGroupes liste des adresses à afficher
     */
    private final void afficherLesGroupes(List<Groupe> desGroupes) {
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"NOM", "NOMPAYS", "HEBERGEMENT"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[3];
        for (Groupe unGroupe : desGroupes) {
            ligneDonnees[0] = unGroupe.getNomGroup();
            ligneDonnees[1] = unGroupe.getNomPays();
            ligneDonnees[2] = unGroupe.getHebergement();
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);            
        }       
    }

    
    /**
     * Quitter l'application, après demande de confirmation
     */
    private void quitter() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "festival", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }

    // ACCESSEURS et MUTATEURS
    public JFrameMenu getVue() {
        return vue;
    }
    
    public void setVue(JFrameMenu vue) {
        this.vue = vue;
    }

    // REACTIONS EVENEMENTIELLES
    @Override
    public void windowOpened(WindowEvent e) {
    }
    
    @Override
    public void windowClosing(WindowEvent e) {        
        quitter();
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

 

}