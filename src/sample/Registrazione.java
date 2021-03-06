package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import javax.swing.*;
import java.io.IOException;

public class Registrazione extends JFrame {
    private double xOffset = 0;
    private double yOffset = 0;
    private static class Delta {
        double x, y;
    }

    final Home.Delta dragDelta = new Home.Delta();
    final BooleanProperty inDrag = new SimpleBooleanProperty(false);

    public Registrazione() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Registrazione.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();

        final double[] xOffset = {0};
        final double[] yOffset = {0};

        root1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dragDelta.x = stage.getX() - event.getScreenX();
                dragDelta.y = stage.getY() - event.getScreenY();
                xOffset[0] = event.getSceneX();
                yOffset[0] = event.getSceneY();
            }
        });

        root1.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + dragDelta.x);
                stage.setY(event.getScreenY() + dragDelta.y);
                stage.getWidth();
                stage.getHeight();
                stage.getX();
                stage.getY();
                inDrag.set(true);

            }
        });
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Home");
        stage.setScene(new Scene(root1, 891,745));
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
        // controllo che il nome utente non sia gi?? in uso
        boolean controllo = databaseOperation.Ricerca("login", user, "ragazzo");
        if (controllo == true) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(user + " ?? gi?? in uso!");
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
                    alert.setContentText("La password ?? troppo corta! Deve contenere almeno 8 caratteri di cui almeno una lettera");
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