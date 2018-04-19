package TestDAO;

import java.sql.*;
import java.util.List;
import DAO.LieuDAO;
import DAO.Jdbc;
import Metier.Lieu;
import Properties.Reader;

/**
 *
 * @author btssio
 */
public class TestLieuDAO{

    public static void main(String[] args) {

        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectOne(1);
            System.out.println("Test1 effectué : sélection unique\n");
            test2_SelectAll();
            System.out.println("Test2 effectué : sélection multiple\n");

        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de pilote JDBC : " + e);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                System.err.println("Erreur de fermeture de la connexion JDBC : " + e);
            }
        }

    }

    /**
     * Vérifie qu'une connexion peut être ouverte sur le SGBD
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void test0_Connexion() throws ClassNotFoundException, SQLException {
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql://", "localhost/", Reader.readString("database"), Reader.readString("login"), Reader.readString("mdp"));
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Affiche un lieu d'après son identifiant
     * @param idLieu
     * @throws SQLException
     */
    public static void test1_SelectOne(int idLieu) throws SQLException {
        Lieu ceLieu = LieuDAO.selectOne(idLieu);
        System.out.println("Lieu d'identifiant : "+idLieu+" : "+ceLieu.toString());
    }

    /**
     * Affiche tous les lieus
     * @throws SQLException
     */
    public static void test2_SelectAll() throws SQLException {
        List<Lieu> desLieus = LieuDAO.selectAll();
        System.out.println("Les lieus lus : "+desLieus.toString());
    }

}

