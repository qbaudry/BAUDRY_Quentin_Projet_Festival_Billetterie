/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Properties.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author tguyot
 */
public class UtilisateurDAO {

    public static boolean LogIn(String log, String pswd) {
        String login = DigestUtils.sha256Hex(log);
        String passwrd = DigestUtils.sha256Hex(pswd);
        ResultSet rs = null;
        //Connexion à la BDD distante avec l'URL
        try (Connection conn = DriverManager.getConnection(Reader.readString("BDD_url"), Reader.readString("BDD_login"), Reader.readString("BDD_mdp"));
                Statement stmt = conn.createStatement();) {
            //Vérification de la présence de l'utilisateur dans la BDD distante
            String qry = "SELECT * FROM `Utilisateur` WHERE `Login` LIKE \"" + login + "\"AND `Password` LIKE \"" + passwrd + "\" ";
            rs = stmt.executeQuery(qry);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            throw new java.lang.Error("Failed To Execute Statement: \n\r" + e);
        }
        return false;
    }
}
