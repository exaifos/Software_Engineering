package sample;

import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HomeController {
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
    public Label nomeUtente;
    @FXML
    public TextField nomeUtenteText;
    @FXML
    public Text titolo;
    public ScrollPane Scroll;
    public Label cognomeUtente;
    public TextField passText;
    public TextField emailText;
    public Label pass2;
    public TextField passText2;
    public TextField telText;
    public TextField loginText;
    public TextArea allergeniText;
    public TextArea precauzioniText;
    public TextField cognomeUtenteText;
    public TextArea hobbyText;
    public TextField dataNText;
    public TextField luogoNText;
    public TextField sessoText;
    public TextField cognomeGenText;
    public TextField emailGenText;
    public TextField nomeGenText;
    public TextField telGenText;
    public TextField CFText;
    public Text nomeLogin;
    public Button Save;
    public Button Return;
    private TableColumn lingua;
    private String CF;
    private String utente;

    private String password;
    private String password2;
    private String emailNew;
    private String telNew;
    private String allergeniNew;
    private String hobbyNew;
    private String precauzioniNew;
    private String emailGenTextNew;


    public void showProfile(ActionEvent mouseEvent) {
        // mostra il profilo
        TabellaVacanze.setVisible(false);
        ChoiceBoxCatalogo.setVisible(false);
        Scroll.setVisible(true);
        titolo.setText("AREA RISERVATA");
        try {
            String query="SELECT * FROM ragazzo WHERE CF='" + CF + "';";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            nomeUtenteText.setText(rs.getString(3));
            cognomeUtenteText.setText(rs.getString(4));
            emailText.setText(rs.getString(5));
            loginText.setText(rs.getString(6));
            telText.setText(rs.getString(7));
            allergeniText.setText(rs.getString(8));
            precauzioniText.setText(rs.getString(9));
            passText.setText(rs.getString(2));
            CFText.setText(rs.getString(1));
            hobbyText.setText(rs.getString(10));
            dataNText.setText(rs.getString(11));
            luogoNText.setText(rs.getString(12));
            sessoText.setText(rs.getString(13));

            String query1="SELECT G.nome, G.cognome, G.email, G.telefono\n" +
                    "FROM Genitore G JOIN Tutore T ON (T.nome_genitore=G.nome AND T.cognome_genitore=G.cognome AND T.telefono_genitore=G.telefono) WHERE CF='" + CF + "';";
            ResultSet rs1 = databaseOperation.SQL_return(query1);
            rs1.next();
            nomeGenText.setText(rs1.getString(1));
            cognomeGenText.setText(rs1.getString(2));
            emailGenText.setText(rs1.getString(3));
            telGenText.setText(rs1.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        nomeUtenteText.setVisible(true);
        System.out.println(CF);
    }

    public void setTableVisible(ActionEvent mouseEvent) {
        // mostra il catalogo delle vacanze
        TabellaVacanze.setVisible(true);
        Scroll.setVisible(false);
        ChoiceBoxCatalogo.setVisible(true);
        titolo.setText("CATALOGO VACANZE");
    }

    public void transferMessage(String message1, String message2) {
        //Display the message
        CF=message1;
        utente=message2;
    }

    public void modify(MouseEvent mouseEvent) {
        pass2.setVisible(true);
        passText2.setVisible(true);
        passText2.setEditable(true);
        passText.setStyle("-fx-background-color: #FFFFFF;");
        passText.setEditable(true);
        emailText.setStyle("-fx-background-color: #FFFFFF;");
        emailText.setEditable(true);
        telText.setStyle("-fx-background-color: #FFFFFF;");
        telText.setEditable(true);
        allergeniText.setEditable(true);
        allergeniText.setStyle("-fx-control-inner-background:#FFFFFF;");
        hobbyText.setStyle("-fx-control-inner-background:#FFFFFF;");
        hobbyText.setEditable(true);
        precauzioniText.setStyle("-fx-control-inner-background:#FFFFFF;");
        precauzioniText.setEditable(true);
        emailGenText.setStyle("-fx-background-color: #FFFFFF;");
        emailGenText.setEditable(true);
        Save.setVisible(true);
        Return.setVisible(true);

    }

    public void newValues(ActionEvent mouseEvent) {

    }

    public void setName(MouseEvent mouseEvent) {
        nomeLogin.setText(utente);
    }

    public void returnBack(ActionEvent mouseEvent) {
        pass2.setVisible(false);
        passText2.setVisible(false);
        passText.setStyle("-fx-background-color: #ead3ca;");
        passText2.setEditable(false);
        passText.setEditable(false);
        emailText.setStyle("-fx-background-color: #ead3ca;");
        emailText.setEditable(false);
        telText.setStyle("-fx-background-color: #ead3ca;");
        telText.setEditable(false);
        allergeniText.setEditable(false);
        allergeniText.setStyle("-fx-control-inner-background:#ead3ca;");
        hobbyText.setStyle("-fx-control-inner-background:#ead3ca;");
        hobbyText.setEditable(false);
        precauzioniText.setStyle("-fx-control-inner-background:#ead3ca;");
        precauzioniText.setEditable(false);
        emailGenText.setStyle("-fx-background-color: #ead3ca;");
        emailGenText.setEditable(false);
        Save.setVisible(false);
        Return.setVisible(false);
        try {
            String query = "SELECT * FROM ragazzo WHERE CF='" + CF + "';";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            nomeUtenteText.setText(rs.getString(3));
            cognomeUtenteText.setText(rs.getString(4));
            emailText.setText(rs.getString(5));
            loginText.setText(rs.getString(6));
            telText.setText(rs.getString(7));
            allergeniText.setText(rs.getString(8));
            precauzioniText.setText(rs.getString(9));
            passText.setText(rs.getString(2));
            CFText.setText(rs.getString(1));
            hobbyText.setText(rs.getString(10));
            dataNText.setText(rs.getString(11));
            luogoNText.setText(rs.getString(12));
            sessoText.setText(rs.getString(13));

            String query1 = "SELECT G.nome, G.cognome, G.email, G.telefono\n" +
                    "FROM Genitore G JOIN Tutore T ON (T.nome_genitore=G.nome AND T.cognome_genitore=G.cognome AND T.telefono_genitore=G.telefono) WHERE CF='" + CF + "';";
            ResultSet rs1 = databaseOperation.SQL_return(query1);
            rs1.next();
            nomeGenText.setText(rs1.getString(1));
            cognomeGenText.setText(rs1.getString(2));
            emailGenText.setText(rs1.getString(3));
            telGenText.setText(rs1.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveModify(ActionEvent actionEvent) {
        // presa dei parametri
        password=passText.getText();
        password2=passText2.getText();
        emailNew=emailText.getText();
        telNew=telText.getText();
        allergeniNew=allergeniText.getText();
        hobbyNew=hobbyText.getText();
        precauzioniNew=precauzioniText.getText();
        emailGenTextNew=emailGenText.getText();
        if (!password.equals(password2)) {
            Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
            alertIncorrect.setHeaderText(null);
            alertIncorrect.setContentText("Le password non corrispondono!");
            alertIncorrect.showAndWait();
        }
        else {
            if (!(password.length()>=8 && password.matches(".*[a-zA-Z]+.*")))  {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Password non sicura, deve contenere almeno un carattere ed essere lunga almeno 8 caratteri!");
                alertMissing.showAndWait();
            }
            else if (!Controller.isValid(emailNew) || !Controller.isValid(emailGenTextNew)) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Le email non sono valide!");
                alertMissing.showAndWait();
            }
            else {
                try {
                    String query = "UPDATE ragazzo SET email='" + emailNew + "', telefono='" + telNew + "', nome_allergene='" + allergeniNew + "', precauzioni='" + precauzioniNew + "', password='" + password +"' WHERE CF='" + CF + "';";
                    databaseOperation.SQL_insert(query);
                    String query2 = "SELECT nome_genitore, cognome_genitore, telefono_genitore FROM tutore WHERE cf='" + CF + "';";
                    ResultSet rs = databaseOperation.SQL_return(query2);
                    rs.next();
                    String nome_gen = rs.getString(1);
                    String cognome_gen = rs.getString(2);
                    String tel_gen = rs.getString(3);
                    String query3 = "UPDATE genitore SET email='" + emailGenTextNew + "' WHERE nome='" + nome_gen + "'AND cognome='" + cognome_gen + "'AND telefono='" + tel_gen + "';";
                    databaseOperation.SQL_insert(query3);
                } catch (Exception a) {
                    a.printStackTrace();
                }
                pass2.setVisible(false);
                passText2.setVisible(false);
                passText.setStyle("-fx-background-color: #ead3ca;");
                passText.setEditable(false);
                emailText.setStyle("-fx-background-color: #ead3ca;");
                emailText.setEditable(false);
                telText.setStyle("-fx-background-color: #ead3ca;");
                telText.setEditable(false);
                allergeniText.setEditable(false);
                allergeniText.setStyle("-fx-control-inner-background:#ead3ca;");
                hobbyText.setStyle("-fx-control-inner-background:#ead3ca;");
                hobbyText.setEditable(false);
                precauzioniText.setStyle("-fx-control-inner-background:#ead3ca;");
                precauzioniText.setEditable(false);
                emailGenText.setStyle("-fx-background-color: #ead3ca;");
                emailGenText.setEditable(false);
                Save.setVisible(false);
                Return.setVisible(false);
                try {
                    String query = "SELECT * FROM ragazzo WHERE CF='" + CF + "';";
                    ResultSet rs = databaseOperation.SQL_return(query);
                    rs.next();
                    nomeUtenteText.setText(rs.getString(3));
                    cognomeUtenteText.setText(rs.getString(4));
                    emailText.setText(rs.getString(5));
                    loginText.setText(rs.getString(6));
                    telText.setText(rs.getString(7));
                    allergeniText.setText(rs.getString(8));
                    precauzioniText.setText(rs.getString(9));
                    passText.setText(rs.getString(2));
                    CFText.setText(rs.getString(1));
                    hobbyText.setText(rs.getString(10));
                    dataNText.setText(rs.getString(11));
                    luogoNText.setText(rs.getString(12));
                    sessoText.setText(rs.getString(13));

                    String query1 = "SELECT G.nome, G.cognome, G.email, G.telefono\n" +
                            "FROM Genitore G JOIN Tutore T ON (T.nome_genitore=G.nome AND T.cognome_genitore=G.cognome AND T.telefono_genitore=G.telefono) WHERE CF='" + CF + "';";
                    ResultSet rs1 = databaseOperation.SQL_return(query1);
                    rs1.next();
                    nomeGenText.setText(rs1.getString(1));
                    cognomeGenText.setText(rs1.getString(2));
                    emailGenText.setText(rs1.getString(3));
                    telGenText.setText(rs1.getString(4));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void showBooking(String città) {
        // mostra il profilo
        TabellaVacanze.setVisible(false);
        ChoiceBoxCatalogo.setVisible(false);
        titolo.setText("PRENOTAZIONE");
    }

    // TableView data visualization
    public void buildData(Object selectedItem) {
        try {
            // hide table
            TabellaVacanze.setVisible(false);
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
                        System.out.println("Lingua: " + rs.getString("lingua"));
                        System.out.println("Città: " + rs.getString("città"));
                        cm.Città.set(rs.getString("città"));
                        // change String date format into dd-MM-yyyy
                        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat output = new SimpleDateFormat("dd-MM-yyyy");
                        String date = rs.getString("data_partenza");
                        Date dateValue = input.parse(date);
                        cm.DataPartenza.set(output.format(dateValue));
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
        colCittà.setCellValueFactory(new PropertyValueFactory<Vacanze,String>("Città"));
        colCittà.setText("Città");
        colCittà.setStyle("-fx-alignment: CENTER;");
        colLingua.setCellValueFactory(new PropertyValueFactory<Vacanze,String>("Lingua"));
        colLingua.setText("Lingua");
        colLingua.setStyle("-fx-alignment: CENTER;");
        colDurata.setCellValueFactory(new PropertyValueFactory<Vacanze,Integer>("Durata"));
        colDurata.setText("Durata");
        colDurata.setStyle("-fx-alignment: CENTER;");
        colData.setCellValueFactory(new PropertyValueFactory<Vacanze,String>("DataPartenza"));
        colData.setText("Data di partenza");
        colData.setStyle("-fx-alignment: CENTER;");
        // set colum with buttons for each row
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
                                        Vacanze vacanze = getTableView().getItems().get(getIndex());
                                        //String città = Vacanze.getCittà();
                                        //System.out.println("Città: " + vacanze.getCittà() + " Data di partenza: " + vacanze.getDataPartenza() + " Lingua: " + vacanze.getLingua() + " Durata " + vacanze.getDurata());
                                        //showBooking(città);
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        colBottone.setStyle("-fx-alignment: CENTER;");
        colBottone.setCellFactory(cellFactory);
        colBottone.setText("Prenota");
        ObservableList<Object> viewOptions = FXCollections.observableArrayList("Durata","Città","Data di partenza");
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
}