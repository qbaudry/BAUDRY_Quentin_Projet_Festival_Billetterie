/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestMetier;

import Metier.Groupe;

/**
 *
 * @author qbaudry
 */
public class TestGroupe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Groupe grp;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        grp = new Groupe("g001", "Les Joyeux Turlurons", "Général Alcazar", "Saint Sébastien sur Loire" ,25, "France");
        System.out.println(grp);
        
        System.out.println("\nTest n°2 : mutateurs");
        grp.setNomGroup("Groupe folklorique");
        grp.setIdentite(null);
        grp.setAdresse("56 boulevard de la Prairie aux Ducs");
        grp.setNbPers(100);
        grp.setNomPays("Belgique");
        System.out.println(grp);
    }
    
}
