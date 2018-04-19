/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author qbaudry
 */
public class Groupe {

    private String idGroup;
    private String nomGroup;
    private String identite;
    private String adresse;
    private int nbPers;
    private String nomPays;

    public Groupe(String idGroup, String nomGroup, String identite, String adresse, int nbPers, String nomPays) {
        this.idGroup = idGroup;
        this.nomGroup = nomGroup;
        this.identite = identite;
        this.adresse = adresse;
        this.nbPers = nbPers;
        this.nomPays = nomPays;
    }

    @Override
    public String toString() {
        return "Groupe{" + "idGroup=" + idGroup + ", nomGroup=" + nomGroup + ", identite=" + identite + ", adresse=" + adresse + ", nbPers=" + nbPers + ", nomPays=" + nomPays + '}';
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public String getNomGroup() {
        return nomGroup;
    }

    public void setNomGroup(String nomGroup) {
        this.nomGroup = nomGroup;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbPers() {
        return nbPers;
    }

    public void setNbPers(int nbPers) {
        this.nbPers = nbPers;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public String getHebergement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    
       
}