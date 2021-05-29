package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// qui si ricerca il parametro passato al costruttore all'interno della base di dati
public class RicercaContenuto {
    static boolean Ricerca(String attributo, String cercami, String nome_tabella) {

        // apertura connessione
        Connection connection = null;
        Statement selectStmt = null;
        try {
            // Connect
            String dbURL2 = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String pass = "123Asdf?";

            connection = DriverManager.getConnection(dbURL2, user, pass);
            if (connection != null) {
                System.out.println("Connected to database successfully.");
            }

            selectStmt = connection.createStatement();
            String query="SELECT DISTINCT " + attributo + " FROM " +nome_tabella + ";";
            ResultSet rs = selectStmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString(1));
                if (rs.getString(1).equalsIgnoreCase(cercami)) {
                    System.out.println(cercami + "è già presente!");
                    return true;
                }

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                selectStmt.close();
                //insertStmt.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
