/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatesa
 * and open the template in the editor.
 */

import DAO.Jdbc;
import View.*;
import Controller.*;
import Properties.Reader;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import DAO.UtilisateurDAO;

/**
 *
 * @author qbaudry
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "btssio", "btssio");
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql://", "localhost/", Reader.readString("BDD_name"), Reader.readString("BDD_login"), Reader.readString("BDD_mdp"));
        try {
            Jdbc.getInstance().connecter();
            CtrlPrincipal ctrlPrcp = new CtrlPrincipal();
            ctrlPrcp.showAuthentification();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }
    }
}
