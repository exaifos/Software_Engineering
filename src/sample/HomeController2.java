package sample;
;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.ResultSet;


public class HomeController2 {
    @FXML
    public TableView TabellaVacanze;
    @FXML
    public Button Exit;
    @FXML
    public Button Profilo;
    @FXML
    private ChoiceBox<Object> ChoiceBoxCatalogo;
    private ObservableList<Vacanze> data;
    @FXML
    private TableColumn<Vacanze, Integer> colDurata;
    @FXML
    private TableColumn<Vacanze, String> colData;
    @FXML
    private TableColumn<Vacanze, String> colCittà;
    @FXML
    private TableColumn<Vacanze, String> colLingua;
    @FXML
    private TableColumn<Vacanze, String> colBottone;
    @FXML
    private Text titolo;


    public void showBooking(ActionEvent mouseEvent) {
        // mostra il profilo
        TabellaVacanze.setVisible(false);
        ChoiceBoxCatalogo.setVisible(false);
        titolo.setText("PRENOTAZIONE");
    }

    // TableView data visualization
    public void buildData(Object selectedItem) {
        try {
            // clear table
            TabellaVacanze.getItems().clear();
            // clear columns
            TabellaVacanze.getColumns().clear();
            data = FXCollections.observableArrayList();
            // clear data
            data.clear();
            if (selectedItem != null) {
                String query = "SELECT durata,data_partenza,città,lingua FROM vacanza_college";
                try {
                    // query result
                    ResultSet rs = databaseOperation.Vacation_return(query, selectedItem);
                    // put results inside of tableview
                    while(rs.next()){
                        Vacanze cm = new Vacanze();
                        cm.Durata.set(rs.getInt("durata"));
                        System.out.println("Durata: " + rs.getInt("durata"));
                        cm.Lingua.set(rs.getString("lingua"));
                        System.out.println("Durata: " + rs.getString("lingua"));
                        cm.Città.set(rs.getString("città"));
                        System.out.println("Durata: " + rs.getString("città"));
                        cm.DataPartenza.set(rs.getString("data_partenza"));
                        System.out.println("Durata: " + rs.getString("data_partenza"));
                        // add cm inside of data
                        data.add(cm);
                    }
                    // add data inside of tableview
                    TabellaVacanze.setVisible(true);

                    TabellaVacanze.setItems(data);
                    TabellaVacanze.getColumns().addAll(colCittà,colData,colLingua,colDurata,colBottone);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  ChoiceBox TableView initialization
    @FXML
    public void Initialize(MouseEvent mouseEvent) {
        assert TabellaVacanze != null : "fx:id=\"TabellaVacanze\" was not injected: check your FXML file 'Home.fxml'.";
        // setCellValueFactory for each column
        colCittà.setCellValueFactory(
                new PropertyValueFactory<Vacanze,String>("Città"));
        colCittà.setText("Città");
        colData.setCellValueFactory(
                new PropertyValueFactory<Vacanze,String>("DataPartenza"));
        colData.setText("Data di partenza");
        colLingua.setCellValueFactory(
                new PropertyValueFactory<Vacanze,String>("Lingua"));
        colLingua.setText("Lingua");
        colDurata.setCellValueFactory(
                new PropertyValueFactory<Vacanze,Integer>("Durata"));
        colDurata.setText("Durata");
        /*colBottone.setCellValueFactory(
                new PropertyValueFactory<Vacanze,String>("Scelta"));*/
        Callback<TableColumn<Vacanze, String>, TableCell<Vacanze, String>> cellFactory
                = //
                new Callback<TableColumn<Vacanze, String>, TableCell<Vacanze, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Vacanze, String> param) {
                        final TableCell<Vacanze, String> cell = new TableCell<Vacanze, String>() {

                            final Button btn = new Button("Prenota");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        // get data from tableview row
                                        // Vacanze vacanze = getTableView().getItems().get(getIndex());
                                        //System.out.println("Città: " + vacanze.getCittà() + " Data di partenza: " + vacanze.getDataPartenza() + " Lingua: " + vacanze.getLingua() + " Durata " + vacanze.getDurata());
                                        showBooking();
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        colBottone.setCellFactory(cellFactory);
        colBottone.setText("Prenota");
        ObservableList<Object> viewOptions = FXCollections.observableArrayList("Durata","Luogo","Data di partenza");
        // view choicebox options
        ChoiceBoxCatalogo.setItems(viewOptions);
        // handle choicebox selection on mouse click
        ChoiceBoxCatalogo.setOnAction((event) -> {
            Object selectedItem = ChoiceBoxCatalogo.getValue();
            try {
                buildData(selectedItem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public void handleExitClick(MouseEvent mouseEvent) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    public void handleProfile(MouseEvent mouseEvent) {
        TabellaVacanze.setVisible(false);
    }
}