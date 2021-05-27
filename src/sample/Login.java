package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    @FXML
    private Button Access;

    public Login(String user, String password, Button Access) {
        System.out.println("user: " + user + "\tpassword: " + password);
        if (user.isEmpty() || password.isEmpty()) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire tutti i campi");
            alertMissing.showAndWait();
        } else {
            RicercaContenuto rc = new RicercaContenuto();
            boolean contr_login = rc.Ricerca("login", user, "ragazzo");
            boolean contr_pass = rc.Ricerca("password", password, "ragazzo");
            if (contr_login == true && contr_pass == true) {
                // apertura connessione
                Connection connection = null;
                Statement selectStmt = null;
                try {
                    // Connect
                    String dbURL2 = "jdbc:postgresql://localhost:5432/vacanze_studio";
                    String usermy = "sofia";
                    String passmy = "";

                    connection = DriverManager.getConnection(dbURL2, usermy, passmy);
                    if (connection != null) {
                        System.out.println("Connected to database successfully.");
                    }

                    String query = "SELECT cf FROM ragazzo WHERE login=\'" + user + "\' AND password=\'" + password + "\';";

                    System.out.println(query);

                    selectStmt = connection.createStatement();
                    ResultSet rs = selectStmt.executeQuery(query);

                    if (rs.next()) {
                        Stage stage = (Stage) Access.getScene().getWindow();
                        stage.close();
                        new Home();
                    } else {
                        Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                        alertIncorrect.setHeaderText(null);
                        alertIncorrect.setContentText("Username o password non corretti");
                        alertIncorrect.showAndWait();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        selectStmt.close();
                        connection.close();
                    } catch (Exception es) {
                        es.printStackTrace();
                    }
                }
            } else {
                Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                alertIncorrect.setHeaderText(null);
                alertIncorrect.setContentText("Username o password non corretti");
                alertIncorrect.showAndWait();
            }
        }
    }
}