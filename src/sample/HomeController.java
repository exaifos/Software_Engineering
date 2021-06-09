package sample;

/*
        nomeLogin.setX(45.0);
        nomeLogin.setY(343.0);
        nomeLogin.prefWidth(147.0);
        nomeLogin.setFont(Font.font ("Tahoma", 18));
 */

import javafx.beans.property.SimpleStringProperty;
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
    private ObservableList<Gita> data_gita;
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
    public Integer num_ospitabili;
    public Label testo_preferenze;
    public ScrollPane vacanze_famiglia_info;
    public ScrollPane vacanze_college_info;
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
    public TextField cittàTextCollege;
    public TextField durataTextCollege;
    public TextField linguaTextCollege;
    public TextField dataTextCollege;
    public TextField nomeCollege;
    public TextField indirizzoCollege;
    public ChoiceBox ChoicePagamento;
    public ChoiceBox roomChoice;
    public ObservableList<Object> paymentOptions = FXCollections.observableArrayList("Carta di credito", "Bonifico bancario");
    public Object selectedPayment;
    public Object selectedRoom;
    public String nomeAmico;
    public String mailAmico;
    public Label testo_preferenze_college;
    public ChoiceBox ChoicePagamentoCollege;



    public void showProfile(ActionEvent mouseEvent) {
        // mostra il profilo
        testoScelta.setVisible(false);
        college.setVisible(false);
        famiglia.setVisible(false);
        vacanze_college_info.setVisible(false);
        vacanze_famiglia_info.setVisible(false);
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
        vacanze_college_info.setVisible(false);
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
        vacanze_college_info.setVisible(false);
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
                if (scelta == "vacanza_famiglia") {
                    vacanze.Famiglia.set(capitalize(rs.getString("cognome_capo_fam")));
                }
                // add row inside of data
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
        // set column with buttons for each row
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
                                        codiceScelta = null;
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
            titolo.setText("DETTAGLI VACANZA:");
            ChoiceBoxCatalogo.setVisible(false);
            vacanze_college_info.setVisible(false);
            String query = "SELECT num_camere, nome_capo_fam, cognome_capo_fam, num_componenti, num_bagni, num_animali, num_ospitabili FROM vacanza_famiglia WHERE codice = " + codiceScelta + ";";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            num_ospitabili = rs.getInt("num_ospitabili");
            System.out.println("Ospitabili: " + num_ospitabili);
            if (num_ospitabili >= 1) {
                vacanze_famiglia_info.setVisible(true);
                testo_preferenze.setText("E' possibile specificare il nome e l'indirizzo mail di\nun amico che soggornerà nella stessa famiglia: ");
                cittàText.setText(capitalize(cittàScelta));
                if (durataScelta > 1) {
                    durataText.setText(durataScelta + " settimane");
                }
                else {
                    durataText.setText(durataScelta + " settimana");
                }
                linguaText.setText(capitalize(linguaScelta));
                dataText.setText(dataPartenzaScelta);
                nomeFamigliaText.setText(capitalize(rs.getString("nome_capo_fam")));
                cognomeFamigliaText.setText(capitalize(rs.getString("cognome_capo_fam")));
                if (Integer.parseInt(rs.getString("num_componenti")) == 1) {
                    componentiText.setText(rs.getString("num_componenti") + " componente");
                } else {
                    componentiText.setText(rs.getString("num_componenti") + " componenti");
                }
                if (Integer.parseInt(rs.getString("num_camere")) == 1) {
                    camereText.setText(rs.getString("num_camere") + " camera");
                } else {
                    camereText.setText(rs.getString("num_camere") + " camere");
                }
                if (Integer.parseInt(rs.getString("num_bagni")) == 1) {
                    bagniText.setText(rs.getString("num_bagni") + " bagno");
                } else {
                    bagniText.setText(rs.getString("num_bagni") + " bagni");
                }
                if (Integer.parseInt(rs.getString("num_animali")) == 0) {
                    animaliText.setText("Nessun animale");
                }
                else if (Integer.parseInt(rs.getString("num_animali")) == 1) {
                    animaliText.setText(rs.getString("num_animali") + " animale");
                }
                else if (Integer.parseInt(rs.getString("num_animali")) > 1) {
                        animaliText.setText(rs.getString("num_animali") + " animali");
                }
                nomeAmico = nomeAmicoText.getText();
                mailAmico = mailAmicoText.getText();

                // view Gite
                assert tabellaGite != null : "fx:id=\"tabellaGite\" was not injected: check your FXML file 'Home.fxml'.";
                // setCellValueFactory for each column
                colDestinazione.setCellValueFactory(new PropertyValueFactory<Gita,String>("Destinazione"));
                colDestinazione.setText("Destinazione");
                colDestinazione.setStyle("-fx-alignment: CENTER;");
                colCosto.setCellValueFactory(new PropertyValueFactory<Gita,Integer>("Costo"));
                colCosto.setText("Prezzo");
                colCosto.setStyle("-fx-alignment: CENTER;");
                colOre.setCellValueFactory(new PropertyValueFactory<Gita,Integer>("Ore"));
                colOre.setText("Ore");
                colOre.setStyle("-fx-alignment: CENTER;");
                //colDescrizione.setCellValueFactory(new PropertyValueFactory<Gita,String>("Descrizione"));
                colDescrizione.setText("Descrizione");
                // setCellFactory for text wrapping
                colDescrizione.setCellFactory(tc -> {
                    colDescrizione.setCellValueFactory(new PropertyValueFactory<Gita,String>("Descrizione"));
                    TableCell<Gita, String> cell = new TableCell<>();
                    Text text = new Text();
                    cell.setGraphic(text);
                    cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                    text.wrappingWidthProperty().bind(colDescrizione.widthProperty());
                    text.textProperty().bind(cell.itemProperty());
                    return cell ;
                });
                query = "SELECT * FROM gita, pianificazione_famiglia WHERE id_vacanza = " + codiceScelta + "AND id_gita = id;";
                rs = databaseOperation.SQL_return(query);
                // clear table
                tabellaGite.getColumns().clear();
                data_gita = FXCollections.observableArrayList();
                // clear data
                data_gita.clear();
                while(rs.next()) {
                    Gita gita = new Gita();
                    gita.Costo.set(rs.getString("costo") + "€");
                    System.out.println("Costo: " + rs.getInt("costo"));
                    gita.Descrizione.set(rs.getString("descrizione"));
                    gita.Destinazione.set(rs.getString("destinazione"));
                    gita.Ore.set(rs.getInt("num_ore"));
                    data_gita.add(gita);
                }
                tabellaGite.setItems(data_gita);
                tabellaGite.getColumns().addAll(colDestinazione,colDescrizione,colOre,colCosto);
                ObservableList<Object> paymentOptions = FXCollections.observableArrayList("Carta di credito", "Bonifico bancario");
                ChoicePagamento.setItems(paymentOptions);
            }
            else {
                Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                alertIncorrect.setHeaderText(null);
                alertIncorrect.setContentText("Ci dispiace, non ci sono più posti disponibili in questa famiglia.");
                alertIncorrect.showAndWait();
                query = "SELECT codice, durata,data_partenza,città,lingua,cognome_capo_fam FROM " + scelta;
                titolo.setText("CATALOGO");
                ChoiceBoxCatalogo.setVisible(true);
                // query result
                rs = databaseOperation.Vacation_return(query,"");
                // clear rows
                TabellaVacanze.getItems().clear();
                // clear columns
                TabellaVacanze.getColumns().clear();
                // put results inside of tableview
                data = FillTableVacanze(rs);
                // add data inside of tableview
                TabellaVacanze.setItems(data);
                TabellaVacanze.setVisible(true);
                TabellaVacanze.getColumns().addAll(colCittà, colData, colLingua, colDurata, colFamiglia, colBottone);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            ResultSet result = null;
        }
    }

    public void CreateBookingFamiglia(MouseEvent mouseEvent) throws SQLException {
        try {
            if (selectedPayment != null) {
                String query = "SELECT * FROM ragazzo WHERE CF='" + CF + "';";
                ResultSet rs = databaseOperation.SQL_return(query);
                rs.next();
                String cf = rs.getString("cf");
                query = "INSERT INTO prenotazione_famiglia (\"CF_ragazzo\", codice_vacanza, nome_compagno, email_compagno) VALUES ('" + cf + "', '" + codiceScelta + "', '" + nomeAmico + "', '" + mailAmico + "');";
                databaseOperation.SQL_insert(query);
                //Integer new_ospitabili = num_ospitabili - 1;
                query = "UPDATE vacanza_famiglia SET num_ospitabili='" + (num_ospitabili - 1) + "' WHERE codice='" + codiceScelta + "';";
                databaseOperation.SQL_insert(query);
                /*
                TODO: creazione del pagamento
                 */
            } else {
                Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                alertIncorrect.setHeaderText(null);
                alertIncorrect.setContentText("Nessun metodo di pagamento selezionato.");
                alertIncorrect.showAndWait();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void bookingCollege() throws SQLException {
        try {
            TabellaVacanze.setVisible(false);
            famiglia.setVisible(false);
            college.setVisible(false);
            titolo.setText("DETTAGLI VACANZA:");
            ChoiceBoxCatalogo.setVisible(false);
            String query = "SELECT città, lingua, nome_college, indirizzo_college, data_partenza, durata FROM vacanza_college WHERE codice = " + codiceScelta + ";";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            cittàTextCollege.setText(capitalize(cittàScelta));
            if (durataScelta > 1) {
                durataTextCollege.setText(durataScelta + " settimane");
            }
            else {
                durataTextCollege.setText(durataScelta + " settimana");
            }
            linguaTextCollege.setText(capitalize(linguaScelta));
            dataTextCollege.setText(dataPartenzaScelta);
            nomeCollege.setText(capitalize(rs.getString("nome_college")));
            indirizzoCollege.setText(capitalize(rs.getString("indirizzo_college")));
            vacanze_college_info.setVisible(true);
            testo_preferenze_college.setText("E' possibile esprimere\nuna preferenza\nsul tipo di camera:");
            ObservableList<Object> roomOptions = FXCollections.observableArrayList("Camera singola", "Camera condivisa");
            roomChoice.setItems(roomOptions);
            ChoicePagamentoCollege.setItems(paymentOptions);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void InitializePagamento(MouseEvent mouseEvent) {
        ChoicePagamento.setOnAction((event) -> {
            selectedPayment = null;
            selectedPayment = ChoicePagamento.getValue();
        });
    }

    public void InitializeRoom(MouseEvent mouseEvent) {
        roomChoice.setOnAction(((event) -> {
            selectedRoom = null;
            selectedRoom = roomChoice.getValue();
        }));
    }

    public void CreateBookingCollege(MouseEvent mouseEvent) throws SQLException {
        if (selectedPayment != null) {
            if (selectedRoom != null) {
                try {
                    String query = "SELECT * FROM ragazzo WHERE CF='" + CF + "';";
                    ResultSet rs = databaseOperation.SQL_return(query);
                    rs.next();
                    String cf = rs.getString("cf");
                    String nomeCompagno = null;
                    query = "INSERT INTO prenotazione_college (\"CF_ragazzo\", codice_vacanza, tipo_camera, nome_compagno) VALUES ('" + cf + "', '" + codiceScelta + "', '" + String.valueOf(selectedRoom) + "', '" + nomeCompagno + "');";
                    databaseOperation.SQL_insert(query);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                /*
                TODO: visualizzazione finestra di avvenuta prenotazione, creazione del pagamento
                 */
            }
            else {
                Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                alertIncorrect.setHeaderText(null);
                alertIncorrect.setContentText("Non è stata impostata alcuna preferenza sulla camera");
                alertIncorrect.showAndWait();
            }
        }
        else {
            Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
            alertIncorrect.setHeaderText(null);
            alertIncorrect.setContentText("Nessun metodo di pagamento selezionato.");
            alertIncorrect.showAndWait();
        }
    }

    public void InitializePagamentoCollege(MouseEvent mouseEvent) {
        ChoicePagamentoCollege.setOnAction((event) -> {
            selectedPayment = null;
            selectedPayment = ChoicePagamentoCollege.getValue();
        });
    }
}