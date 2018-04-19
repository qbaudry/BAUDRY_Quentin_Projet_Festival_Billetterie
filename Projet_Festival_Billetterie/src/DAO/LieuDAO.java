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
import Metier.Lieu;
import java.util.List;

/**
 *
 * @author ttnguyen
 */
public class LieuDAO  {
    
    
    /**
    * Extraction d'un lieu, sur son identifiant
    * @param idLieu identifiant
    * @return objet Lieu
    * @throws SQLException 
    */
    public static Lieu selectOne(int idLieu) throws SQLException {
        Lieu unLieu = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Lieu WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idLieu);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID");
            String nom = rs.getString("NOM");
            String adresse = rs.getString("ADR");
            int capacite = rs.getInt("CAPACITE");

            unLieu = new Lieu(id, nom, adresse, capacite);
        }
        return unLieu;
    }
    
        /**
     * Extraction de tous les lieux
     * @return collection de lieux
     * @throws SQLException 
     */
    public static List<Lieu> selectAll() throws SQLException {
        List<Lieu> lesLieus = new ArrayList<Lieu>();
        Lieu unLieu;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Lieu";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String nom = rs.getString("NOM");
            String adresse = rs.getString("ADR");
            int capacite = rs.getInt("CAPACITE");

            unLieu = new Lieu(id, nom, adresse, capacite);
            lesLieus.add(unLieu);
        }
        return lesLieus;
    }
    

        public static int update(int idLieu, Lieu unLieu) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE Lieu SET ID = ? , NOM = ?,ADR = ? , ADRESSEPOSTALE = ? , CAPACITE = ? ";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idLieu);
        pstmt.setString(2, unLieu.getNomLieu());
        pstmt.setString(3, unLieu.getAdresseLieu());
        pstmt.setInt(4, unLieu.getCapaciteAccueil());

        nb = pstmt.executeUpdate();
        return nb;
    }
}
