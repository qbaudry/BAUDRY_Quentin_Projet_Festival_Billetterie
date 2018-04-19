/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestMetier;

import Metier.Groupe;
import Metier.Lieu;
import Metier.Representation;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author qbaudry
 */
public class TestRepresentation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Representation rep= null;
        Lieu lieuTest= null;
        Groupe groupeTest= null;
        
        lieuTest = new Lieu(1, "SALLE DU PANIER FLEURI", "Rue de Bonneville", 450);
        groupeTest = new Groupe("g001", "Les Joyeux Turlurons", "Général Alcazar", "Saint Sébastien sur Loire" ,25, "France");
        
        LocalDate dateRep = LocalDate.parse("2017-12-07");
        LocalTime heureDebut = LocalTime.parse("21:00");
        LocalTime heureFin = LocalTime.parse("23:30");
        int nbPlace = 100;
        
        // Test n°1 : instanciation et accesseurs
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        rep = new Representation(1, dateRep, lieuTest, groupeTest, heureDebut, heureFin, nbPlace);
        System.out.println("Etat de la representation : " + rep);
        
        // Test n°2 : mutateurs
        System.out.println("\nTest n°2 : mutateurs");
        rep.setDateRep(LocalDate.parse("2020-12-07"));
        rep.setHeureDebut(LocalTime.parse("15:00"));
        rep.setHeureFin(LocalTime.parse("18:00"));
        System.out.println("Etat de la representation : " + rep);

        // Test n°3 : association d'un groupe
        System.out.println("\nTest n°4 : association d'un groupe");
        rep.setGroupe(new Groupe("g002", "Les Joyeux Turlurons2", "Général Alcazar2", "Saint Sébastien sur Loire2" ,25, "France2"));
        System.out.println("Etat du client : " + rep);
        
        // Test n°4 : association d'un lieu
        System.out.println("\nTest n°4 : association d'un lieu");
        rep.setLieu(new Lieu(2, "SALLE DU PANIER FLEURI2", "Rue de Bonneville2", 450));
        System.out.println("Etat du client : " + rep);
        
    }
    
}
