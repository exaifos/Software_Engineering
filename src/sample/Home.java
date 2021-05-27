package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.text.html.ListView;
import java.io.IOException;


public class Home {

    public Home() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setResizable(true);
        //stage.setFullScreen(true);
        //stage.setFullScreenExitHint("");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Home");
        stage.setScene(new Scene(root1,891,745));
        stage.show();
    }
}
