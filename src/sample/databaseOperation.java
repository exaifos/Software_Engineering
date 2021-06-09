package sample;

import javax.xml.transform.Result;
import java.sql.*;

public class databaseOperation {

    public static String url = "jdbc:postgresql://localhost:5432/postgres";
    public static String userName = "postgres";
    public static String password = "123Asdf?";
    public static Connection connection;
    public static Statement selectStmt;
    public static Statement insertStmt;
    public static ResultSet result;

    public static boolean is_empty(String tabella) throws SQLException {
        try {
            String query="SELECT COUNT(*) FROM "+tabella + ";";
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            result.next();
            if (result.getString(1).equals("0"))
                return false;
            else
                return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static ResultSet SQL_return(String query) throws SQLException {
        // apertura connessione
        connection = null;
        selectStmt = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            //result.next();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            result=null;
            return result;
        }
    }

    public static void SQL_insert(String query) throws SQLException {
        connection = null;
        insertStmt = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            PreparedStatement statement = connection.prepareStatement(query);
            insertStmt = connection.createStatement();
            insertStmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ResultSet Vacation_return (String query, Object selectedItem) {
        connection = null;
        selectStmt = null;
        result = null;
        try {
            // Connect
            connection = DriverManager.getConnection(url, userName, password);
            if (connection != null) {
                System.out.println("Connected to database successfully.");
            }

            if (selectedItem == "Durata")
                query = query + (" ORDER BY durata");
            else if (selectedItem == "Luogo")
                query = query + (" ORDER BY città");
            else if (selectedItem == "Data di partenza")
                query = query + (" ORDER BY data_partenza");

            System.out.println(query);
            selectStmt = connection.createStatement();
            result = selectStmt.executeQuery(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

     public static boolean Ricerca(String attributo, String cercami, String nome_tabella) {

        // apertura connessione
        connection = null;
        selectStmt = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
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
