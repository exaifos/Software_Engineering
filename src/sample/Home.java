package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.EventHandler;

import java.io.IOException;
import java.sql.SQLException;


public class Home {
    private double xOffset = 0;
    private double yOffset = 0;
    static class Delta {
        double x, y;
    }

    final Delta dragDelta = new Delta();
    final BooleanProperty inDrag = new SimpleBooleanProperty(false);

    @FXML
    public Text nomeLogin;
    public Home(String CF, String nome_user) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root1 = fxmlLoader.load();

        //Get controller of scene2
        HomeController hc = fxmlLoader.getController();
        //Pass whatever data you want. You can have multiple method calls here
        hc.transferMessage(CF, nome_user);

        Stage stage = new Stage();
        stage.setResizable(true);
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
        hc.nomeLogin.setText(nome_user);
        Scene scene = new Scene(root1,891,745);
        scene.getStylesheets().add(getClass().getResource("tableempty.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
}
