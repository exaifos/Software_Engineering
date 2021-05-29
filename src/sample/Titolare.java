package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Titolare {

    @FXML
    public Text nomeLogin;
    public Titolare(String CF, String nome_user) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("titolarePage.fxml"));
        Parent root1 = fxmlLoader.load();
        //Get controller of scene2
        holderController hc = fxmlLoader.getController();
        //Pass whatever data you want. You can have multiple method calls here
        hc.transferMessage(CF, nome_user);

        Stage stage = new Stage();
        stage.setResizable(true);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Home");
        hc.nomeLogin.setText(nome_user);
        stage.setScene(new Scene(root1,891,745));
        stage.show();
    }
}
