package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private TextField userText;
    public PasswordField passText;
    public Button SignIn;
    public Button Start;
    public Button Exit;
    public Button Access;


    public void handleLoginClick(ActionEvent event) {
        // dobbiamo prendere i dati di login e la password per confrontarli con la base di dati
        if (userText.getText() == null || userText.getText().trim().isEmpty() || passText.getText() == null || passText.getText().trim().isEmpty()) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire tutti i campi");
            alertMissing.showAndWait();
        }
        else {
            String user = userText.getText();
            String pass = passText.getText();
            new Login(user, pass, Access);
        }
    }

    public void handleExitClick(MouseEvent mouseEvent) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
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

    public void nuovo(MouseEvent mouseEvent){
        try {
            new PaginaPrincipaleLogin();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}