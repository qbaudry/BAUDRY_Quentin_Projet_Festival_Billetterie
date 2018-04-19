package TestDAO;

import java.sql.*;
import java.util.List;
import DAO.GroupeDAO;
import DAO.Jdbc;
import Metier.Groupe;
import Properties.Reader;
/**
 *
 * @author btssio
 */
public class TestGroupeDAO{

    public static void main(String[] args) {

        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectOne("g001");
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
//        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "btssio", "btssio");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Affiche une groupe d'après son identifiant
     * @param idGroup
     * @throws SQLException
     */
    public static void test1_SelectOne(String idGroup) throws SQLException {
        Groupe ceGroupe = GroupeDAO.selectOne(idGroup);
        System.out.println("Groupe d'identifiant : "+idGroup+" : "+ceGroupe.toString());
    }

    /**
     * Affiche tous les groupes
     * @throws SQLException
     */
    public static void test2_SelectAll() throws SQLException {
        List<Groupe> desGroupes = GroupeDAO.selectAll();
        System.out.println("Les groupes lus : "+desGroupes.toString());
    }

}

