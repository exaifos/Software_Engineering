package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class gestioneGiteEAttivita {


    public gestioneGiteEAttivita(Integer[] cod_col, Integer[] cod_fam) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gestioneGiteEAttivita.fxml"));
        Parent root1 = fxmlLoader.load();
        //Get controller of scene2
        holderController hc = fxmlLoader.getController();
        hc.transferMessageCod(cod_col, cod_fam);
        Stage stage = new Stage();
        stage.setResizable(true);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Home");
        stage.setScene(new Scene(root1,891,745));
        stage.show();
    }
}