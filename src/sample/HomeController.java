package sample;

/*
        nomeLogin.setX(45.0);
        nomeLogin.setY(343.0);
        nomeLogin.prefWidth(147.0);
        nomeLogin.setFont(Font.font ("Tahoma", 18));
 */

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
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HomeController {
    public TableView TabellaVacanze;
    public Button Exit;
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
    public TableView tabellaGite;
    public TableColumn colDestinazione;
    public TableColumn colOre;
    public TableColumn colCosto;
    public TableColumn colDescrizione;
    public TableColumn colFamiglia = new TableColumn<Vacanze,String>();
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
    public Button famiglia;
    public Button college;
    public String cittàScelta;
    public String dataPartenzaScelta;
    public String linguaScelta;
    public Integer durataScelta;
    public Integer codiceScelta;
    private String password;
    private String password2;
    private String emailNew;
    private String telNew;
    private String allergeniNew;
    private String hobbyNew;
    private String precauzioniNew;
    private String emailGenTextNew;
    public Label testoScelta;
    public ImageView worldmap;
    public String scelta;
    // prenotazione
    public Label testo_preferenze;
    public ScrollPane vacanze_famiglia_info;
    public TextField cittàText;
    public TextField durataText;
    public TextField linguaText;
    public TextField dataText;
    public TextField nomeFamigliaText;
    public TextField cognomeFamigliaText;
    public TextField componentiText;
    public TextField camereText;
    public TextField bagniText;
    public TextField animaliText;
    public TextField nomeAmicoText;
    public TextField mailAmicoText;

    public void showProfile(ActionEvent mouseEvent) {
        // mostra il profilo
        testoScelta.setVisible(false);
        college.setVisible(false);
        famiglia.setVisible(false);
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
        nomeLogin.setStyle("-fx-alignment: CENTER;");
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

    public void setButtonVisible(ActionEvent actionEvent) {
        testoScelta.setVisible(true);
        worldmap.setVisible(false);
        Scroll.setVisible(false);
        vacanze_famiglia_info.setVisible(false);
        TabellaVacanze.setVisible(false);
        ChoiceBoxCatalogo.setVisible(false);
        scelta = null;
        famiglia.setVisible(true);
        college.setVisible(true);
        titolo.setText("PRENOTAZIONE");
        famiglia.setOnAction(event -> {
            System.out.println("Famiglia");
            scelta = "vacanza_famiglia";
        });
        college.setOnAction(event -> {
            scelta = "vacanza_college";
        });
    }

    public void setTableVisible(MouseEvent mouseEvent) {
        TableColumns();
        testoScelta.setVisible(false);
        college.setVisible(false);
        famiglia.setVisible(false);
        worldmap.setVisible(false);
        vacanze_famiglia_info.setVisible(false);
        Scroll.setVisible(false);
        //Font font = Font.loadFont("file:rsc/sample/Glegoo-Bold.ttf", 45);
        //titolo.setFont(font);
        ChoiceBoxCatalogo.setVisible(true);
        ObservableList<Object> viewOptions = FXCollections.observableArrayList("Durata","Città","Data di partenza");
        // view choicebox options
        ChoiceBoxCatalogo.setItems(viewOptions);
        titolo.setText("CATALOGO VACANZE");
        titolo.setVisible(true);
        TabellaVacanze.getItems().clear();
        // clear columns
        TabellaVacanze.getColumns().clear();
        data = FXCollections.observableArrayList();
        // clear data
        data.clear();
        String query;
        if (scelta == "vacanza_famiglia") {
            query = "SELECT codice, durata,data_partenza,città,lingua,cognome_capo_fam FROM " + scelta;
        }
        else {
            query = "SELECT codice, durata,data_partenza,città,lingua FROM " + scelta;
        }
        try {
            // query result
            ResultSet rs = databaseOperation.Vacation_return(query,"");
            // put results inside of tableview
            data = FillTableVacanze(rs);
            // add data inside of tableview
            TabellaVacanze.setItems(data);
            TabellaVacanze.setVisible(true);
            if (scelta == "vacanza_famiglia") {
                TabellaVacanze.getColumns().addAll(colCittà, colData, colLingua, colDurata, colFamiglia, colBottone);
            } else {
                TabellaVacanze.getColumns().addAll(colCittà, colData, colLingua, colDurata, colBottone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TableView data visualization
    public void buildData(Object selectedItem) {
        try {
            TableColumns();
            testoScelta.setVisible(false);
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
                String query;
                if (scelta == "vacanza_famiglia") {
                    query = "SELECT codice, durata,data_partenza,città,lingua,cognome_capo_fam FROM " + scelta;
                }
                else {
                    query = "SELECT codice, durata,data_partenza,città,lingua FROM " + scelta;
                }
                try {
                    // query result
                    ResultSet rs = databaseOperation.Vacation_return(query, selectedItem);
                    // put results inside of tableview
                    data = FillTableVacanze(rs);
                    // add data inside of tableview
                    TabellaVacanze.setVisible(true);
                    TabellaVacanze.setItems(data);
                    if (scelta == "vacanza_famiglia") {
                        TabellaVacanze.getColumns().addAll(colCittà, colData, colLingua, colDurata, colFamiglia, colBottone);
                    }
                    else {
                        TabellaVacanze.getColumns().addAll(colCittà, colData, colLingua, colDurata, colBottone);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Vacanze> FillTableVacanze(ResultSet rs) throws SQLException {
        try {
            while (rs.next()) {
                Vacanze vacanze = new Vacanze();
                vacanze.Codice.set(rs.getInt("codice"));
                vacanze.Durata.set(rs.getInt("durata"));
                vacanze.Lingua.set(capitalize(rs.getString("lingua")));
                vacanze.Città.set((capitalize(rs.getString("città"))));
                // change String date format into dd-MM-yyyy
                SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat output = new SimpleDateFormat("dd-MM-yyyy");
                String date = rs.getString("data_partenza");
                Date dateValue = input.parse(date);
                vacanze.DataPartenza.set(output.format(dateValue));
                System.out.println("Durata: " + rs.getString("data_partenza"));
                if (scelta == "vacanza_famiglia") {
                    vacanze.Famiglia.set(capitalize(rs.getString("cognome_capo_fam")));
                }
                // add cm inside of data
                data.add(vacanze);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void TableColumns() {
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
        if (scelta == "vacanza_famiglia") {
            colFamiglia.setCellValueFactory(new PropertyValueFactory<Vacanze,String>("Famiglia"));
            colFamiglia.setText("Famiglia");
            colFamiglia.setStyle("-fx-alignment: CENTER;");
        }
        // set colum with buttons for each row
        Callback<TableColumn<Vacanze, String>, TableCell<Vacanze, String>> cellFactory
                = //
                new Callback<TableColumn<Vacanze, String>, TableCell<Vacanze, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Vacanze, String> param) {
                        final TableCell<Vacanze, String> cell = new TableCell<Vacanze, String>() {

                            final Button btn = new Button("Visualizza");

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
                                        //TableRow row = getTableRow();
                                        Integer codice = vacanze.getCodice();
                                        cittàScelta = vacanze.getCittà();
                                        dataPartenzaScelta = vacanze.getDataPartenza();
                                        linguaScelta = vacanze.getLingua();
                                        durataScelta = vacanze.getDurata();
                                        codiceScelta = vacanze.getCodice();
                                        System.out.println("Città: " + vacanze.getCittà());
                                        try {
                                            if(scelta == "vacanza_famiglia") {
                                                bookingFamiglia();
                                            }
                                            else {
                                                bookingCollege();
                                            }
                                        } catch (SQLException throwables) {
                                            throwables.printStackTrace();
                                        }
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
        colBottone.setText("Visualizza");
    }

    //  ChoiceBox TableView initialization
    @FXML
    public void Initialize(MouseEvent mouseEvent) {
        testoScelta.setVisible(false);
        titolo.setVisible(true);
        ChoiceBoxCatalogo.setVisible(true);
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

    public String capitalize(String str) {
        String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
        return cap;
    }

    public void bookingFamiglia() throws SQLException {
        try {
            TabellaVacanze.setVisible(false);
            famiglia.setVisible(false);
            college.setVisible(false);
            System.out.println("CODICE SCELTA: " + codiceScelta);
            String query = "SELECT num_camere, nome_capo_fam, cognome_capo_fam, num_componenti, num_bagni, num_animali FROM vacanza_famiglia WHERE codice = " + codiceScelta + ";";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            Integer num_camere = rs.getInt("num_camere");
            if (num_camere >= 1) {
                vacanze_famiglia_info.setVisible(true);
                testo_preferenze.setText("E' possibile specificare il nome e l'indirizzo mail di un amico\nche soggornerà nella stessa famiglia: ");
                cittàText.setText(capitalize(cittàScelta));
                if (durataScelta > 1) {
                    durataText.setText(String.valueOf(durataScelta) + " settimane");
                }
                else {
                    durataText.setText(String.valueOf(durataScelta) + " settimana");
                }
                linguaText.setText(capitalize(linguaScelta));
                dataText.setText(dataPartenzaScelta);
                nomeFamigliaText.setText(capitalize(rs.getString("nome_capo_fam")));
                cognomeFamigliaText.setText(capitalize(rs.getString("cognome_capo_fam")));
                componentiText.setText(rs.getString("num_componenti"));
                camereText.setText(rs.getString("num_camere"));
                bagniText.setText(rs.getString("num_bagni"));
                if (Integer.parseInt(rs.getString("num_animali")) == 0) {
                    animaliText.setText("Nessun animale");
                }
                else {
                    if (rs.getString("num_animali") == "1") {
                        animaliText.setText(String.valueOf(rs.getString("num_animali")) + " animale");
                    }
                    else {
                        animaliText.setText(String.valueOf(rs.getString("num_animali") + " animali"));
                    }
                }
                String nomeAmico = nomeAmicoText.getText();
                String mailAmico = mailAmicoText.getText();
                // gite
                assert tabellaGite != null : "fx:id=\"tabellaGite\" was not injected: check your FXML file 'Home.fxml'.";
                // setCellValueFactory for each column
                colDestinazione.setCellValueFactory(new PropertyValueFactory<Gita,String>("Destinazione"));
                colDestinazione.setText("Destinazione");
                colCosto.setCellValueFactory(new PropertyValueFactory<Gita,Integer>("Costo"));
                colCosto.setText("Prezzo");
                colCosto.setStyle("-fx-alignment: CENTER;");
                colOre.setCellValueFactory(new PropertyValueFactory<Gita,Integer>("Ore"));
                colOre.setText("Ore");
                colOre.setStyle("-fx-alignment: CENTER;");
                colDescrizione.setCellValueFactory(new PropertyValueFactory<Gita,String>("Descrizione"));
                colDescrizione.setText("Descrizione");
            }
            else {
                Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                alertIncorrect.setHeaderText(null);
                alertIncorrect.setContentText("Ci dispiace, non ci sono più posti disponibili in questa famiglia.");
                alertIncorrect.showAndWait();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            ResultSet result = null;
        }
    }

    public void bookingCollege() throws SQLException {
        try {
            TabellaVacanze.setVisible(false);
            famiglia.setVisible(false);
            college.setVisible(false);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            ResultSet result = null;
        }
    }
}