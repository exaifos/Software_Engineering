package sample;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.util.*;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Vector;

public class HomeController {
    @FXML
    public TableView TabellaVacanze;
    @FXML
    public Button Exit;
    @FXML
    public Button Profilo;
    @FXML
    private ChoiceBox<Object> ChoiceBoxCatalogo;
    private ObservableList data;
    //private ObservableList<String> row;

    // gestione del ChoiceBox per la scelta delle opzioni di visualizzazione
    public void CatalogoViewerOptions(MouseEvent mouseEvent) {
        try {
            // clear table
            TabellaVacanze.getItems().clear();
            TabellaVacanze.getColumns().clear();
            // clear rows
            ObservableList<Object> viewOptions = FXCollections.observableArrayList("Durata","Luogo","Data di partenza");
            // view choicebox options
            ChoiceBoxCatalogo.setItems(viewOptions);
            // onAction event fills TableView with data
            ChoiceBoxCatalogo.setOnAction((event) -> {
                Object selectedItem = ChoiceBoxCatalogo.getValue();
                data = FXCollections.observableArrayList();
                data.clear();
                if (selectedItem != null) {
                    String query = "SELECT durata,data_partenza,città,lingua FROM vacanza_college";
                    // query result
                    ResultSet rs = databaseOperation.Vacation_return(query, selectedItem);
                    try {
                        // fill table columns
                        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                            //We are using non property style for making dynamic table
                            final int j = i;
                            TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                                    return new SimpleStringProperty(param.getValue().get(j).toString());
                                }
                            });
                            TabellaVacanze.getColumns().addAll(col);
                            System.out.println("Column [" + i + "] ");
                        }
                        while(rs.next()){
                            ObservableList<String> row = null;
                            //Iterate Row
                            row = FXCollections.observableArrayList();
                            for(int i=1 ; i<=4; i++){
                                //Iterate Column
                                row.add(rs.getString(i));
                            }
                            System.out.println("Row [1] added "+row );
                            data.add(row);
                        }
                        TabellaVacanze.setItems(data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Initialize(MouseEvent mouseEvent) {
    }


    public void handleExitClick(MouseEvent mouseEvent) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    public void handleProfile(MouseEvent mouseEvent) {
        TabellaVacanze.setVisible(false);
    }
}
