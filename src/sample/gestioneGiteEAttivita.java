package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class gestioneGiteEAttivita {

    private double xOffset = 0;
    private double yOffset = 0;
    private static class Delta {
        double x, y;
    }

    final Home.Delta dragDelta = new Home.Delta();
    final BooleanProperty inDrag = new SimpleBooleanProperty(false);

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
        stage.setTitle("Home");
        stage.setScene(new Scene(root1,891,745));
        stage.show();
    }
}