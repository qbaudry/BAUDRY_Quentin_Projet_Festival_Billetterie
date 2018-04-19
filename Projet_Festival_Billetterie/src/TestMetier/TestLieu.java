/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestMetier;

import Metier.Lieu;

/**
 *
 * @author qbaudry
 */
public class TestLieu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lieu lieu;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        lieu = new Lieu(1, "SALLE DU PANIER FLEURI", "Rue de Bonneville", 450);
        System.out.println(lieu);
        
        System.out.println("\nTest n°2 : mutateurs");
        lieu.setNomLieu("La place");
        lieu.setAdresseLieu("Nantes");
        lieu.setCapaciteAccueil(1000);
        System.out.println(lieu);
    }
    
}
