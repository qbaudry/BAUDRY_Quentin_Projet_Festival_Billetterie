/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Metier.Groupe;
import java.util.List;

/**
 *
 * @author ttnguyen
 */
public class GroupeDAO  {
    
    
    /**
    * Extraction d'un groupe, sur son identifiant
    * @param idGroupe identifiant
    * @return objet Groupe
    * @throws SQLException 
    */
    public static Groupe selectOne(String idGroupe) throws SQLException {
        Groupe unGroupe = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, idGroupe);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String id = rs.getString("ID");
            String nom = rs.getString("NOM");
            String identite = rs.getString("IDENTITERESPONSABLE");
            String adresse = rs.getString("ADRESSEPOSTALE");
            int nbPers = rs.getInt("NOMBREPERSONNES");
            String nomPays = rs.getString("NOMPAYS");
            
            unGroupe = new Groupe(id, nom, identite, adresse, nbPers, nomPays);
        }
        return unGroupe;
    }
    
        /**
     * Extraction de tous les groupes
     * @return collection de groupes
     * @throws SQLException 
     */
    public static List<Groupe> selectAll() throws SQLException {
        List<Groupe> lesGroupes = new ArrayList<Groupe>();
        Groupe unGroupe;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("ID");
            String nom = rs.getString("NOM");
            String identite = rs.getString("IDENTITERESPONSABLE");
            String adresse = rs.getString("ADRESSEPOSTALE");
            int nbPers = rs.getInt("NOMBREPERSONNES");
            String nomPays = rs.getString("NOMPAYS");
            unGroupe = new Groupe(id, nom, identite, adresse, nbPers, nomPays);
            lesGroupes.add(unGroupe);
        }
        return lesGroupes;
    }
    

        public static int update(String idGroupe, Groupe unGroupe) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE GROUPE SET ID = ? , NOM = ?,IDENTITERESPONSABLE = ? , ADRESSEPOSTALE = ? , NOMBREPERSONNES = ? , NOMPAYS = ? ";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, idGroupe);
        pstmt.setString(2, unGroupe.getNomGroup());
        pstmt.setString(3, unGroupe.getIdentite());
        pstmt.setString(4, unGroupe.getAdresse());
        pstmt.setInt(5, unGroupe.getNbPers());
        pstmt.setString(6, unGroupe.getNomPays());
        nb = pstmt.executeUpdate();
        return nb;
    }
}
