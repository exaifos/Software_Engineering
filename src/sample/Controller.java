package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.sql.*;

public class Controller {
    @FXML
    private TextField userText;
    @FXML
    private PasswordField passText;
    @FXML
    public Button Login;
    @FXML
    public Button SignIn;
    @FXML
    public Button Exit;
    @FXML
    public ChoiceBox luogoNText;

    public void handleLoginClick(ActionEvent event) {
        // dobbiamo prendere i dati di login e la password per confrontarli con la base di dati
        String user = userText.getText();
        String pass = passText.getText();
        System.out.println("user: " + user + "\tpassword: " + pass);
        if (user.isEmpty() || pass.isEmpty()) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire tutti i campi");
            alertMissing.showAndWait();
        }
        else {
            RicercaContenuto rc=new RicercaContenuto();
            boolean contr_login=rc.Ricerca("login", user, "ragazzo");
            boolean contr_pass=rc.Ricerca("password", pass, "ragazzo");
            if (contr_login==true && contr_pass==true) {
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

                    String query = "SELECT cf FROM ragazzo WHERE login=\'" +user + "\' AND password=\'" + pass + "\';";

                    System.out.println(query);

                    selectStmt = connection.createStatement();
                    ResultSet rs = selectStmt.executeQuery(query);

                    if (rs.next()) {
                        Stage stage = (Stage) Login.getScene().getWindow();
                        stage.close();
                        new PaginaPrincipaleLogin();
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

    public void handleSignUpClick(MouseEvent mouseEvent) {
        try {
            ObservableList<Object> citiesList = FXCollections.observableArrayList("Verona","Londra","Monaco");
            //String query="SELECT comune FROM codice_catasto ORDER BY comune;";
            //ResultSet scelte=databaseOperation.SQL_return(query);
            // System.out.println(scelte.getString(1));
            //    luogoNText.getItems().addAll(scelte.getString("comune"));
            luogoNText.setItems(citiesList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void handleExitClick(MouseEvent mouseEvent) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    public void handleRegistrationClick(ActionEvent actionEvent) {
    }

    public void handleSignIpClick(MouseEvent mouseEvent) {
        try {
            Stage stage = (Stage) SignIn.getScene().getWindow();
            stage.close();
            new Registrazione();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}