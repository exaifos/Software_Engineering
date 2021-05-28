package sample;

import javax.xml.transform.Result;
import java.sql.*;

public class databaseOperation {

    private static Connection connection;
    public static Statement selectStmt = null;
    public static ResultSet result = null;
    public static String dbURL2 = "jdbc:postgresql://localhost:5432/vacanze_studio";
    public static String usermy = "sofia";
    public static String passmy = "";

    public static ResultSet Vacation_return (String query, Object selectedItem) {
        try {
            connection = DriverManager.getConnection(dbURL2, usermy, passmy);
            if (connection != null) {
                System.out.println("Connected to database successfully.");
            }

            if (selectedItem == "Durata")
                query = query + (" ORDER BY durata");
            else if (selectedItem == "Città")
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

    public static ResultSet SQL_return(String query) throws SQLException {
        try {
            connection = DriverManager.getConnection(dbURL2, usermy, passmy);
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            //result.next();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            ResultSet result=null;
            return result;
        }
    }

    public static void SQL_insert(String query) throws SQLException {
        Connection connection = null;
        Statement insertStmt = null;
        try {
            connection = DriverManager.getConnection(dbURL2, usermy, passmy);
            PreparedStatement statement = connection.prepareStatement(query);
            insertStmt = connection.createStatement();
            insertStmt.execute(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
