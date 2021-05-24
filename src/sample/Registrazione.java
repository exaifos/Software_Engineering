package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.stage.*;
import javax.swing.*;
import java.io.IOException;

public class Registrazione extends JFrame {

    public Registrazione() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Registrazione.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Home");
        stage.setScene(new Scene(root1));
        stage.show();

    }

    public void dbInsertion() {
        //String user = userText.getText();
        String user = "";
        //String pass = passText.getText();
        String pass = "";
        //String pass2 = pass2Text.getText();
        String pass2 = "";
        //System.out.println("user: " + user + "\tpassword: " + pass + "\tpassword2: " + pass2);
        // controllo che il nome utente non sia già in uso
        RicercaContenuto rc = new RicercaContenuto();
        boolean controllo = rc.Ricerca("login", user, "ragazzo");
        if (controllo == true) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(user + " è già in uso!");
            alert.showAndWait();
        }
        else{
            // controllo che le password siano uguali
            if (pass.equals(pass2)) {
                if (pass.length()>=8 && pass.matches(".*[a-zA-Z]+.*"))  {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sei ufficialmente a bordo!");
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("La password è troppo corta! Deve contenere almeno 8 caratteri di cui almeno una lettera");
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Le password non corrispondono, riprova!");
            }
        }
    }
}