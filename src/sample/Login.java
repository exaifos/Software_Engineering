package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
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
            boolean contr_login = databaseOperation.Ricerca("login", user, "ragazzo");
            boolean contr_pass = databaseOperation.Ricerca("password", password, "ragazzo");
            boolean contr_login2 = databaseOperation.Ricerca("login", user, "responsabile");
            boolean contr_pass2 = databaseOperation.Ricerca("password", password, "responsabile");
            if (contr_login == true && contr_pass == true) {
                // apertura connessione
                try {
                    String query = "SELECT cf FROM ragazzo WHERE login ILIKE \'" + user + "\' AND password LIKE \'" + password + "\';";
                    ResultSet rs = databaseOperation.SQL_return(query);
                    //System.out.println("RESULT SET: " + rs.getString(1) + "RESULT SET NEXT: " + rs.next());
                    if (rs.next()) {
                        String CF = rs.getString(1);
                        System.out.println(rs.getString(1));
                        Stage stage = (Stage) Access.getScene().getWindow();
                        stage.close();
                        new Home(CF, user);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (contr_login2 == true && contr_pass2 == true) {
                // apertura connessione
                try {
                    String query = "SELECT cf FROM responsabile WHERE login ILIKE \'" + user + "\' AND password LIKE \'" + password + "\';";
                    ResultSet rs = databaseOperation.SQL_return(query);
                    //System.out.println("RESULT SET: " + rs.getString(1) + "RESULT SET NEXT: " + rs.next());
                    if (rs.next()) {
                        String CF=rs.getString(1);
                        System.out.println(rs.getString(1));
                        Stage stage = (Stage) Access.getScene().getWindow();
                        stage.close();
                        new Titolare(CF, user);

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                alertIncorrect.setHeaderText(null);
                alertIncorrect.setContentText("Username o password non corretti");
                alertIncorrect.showAndWait();
            }
        }
    }

    public Login() {

    }
}