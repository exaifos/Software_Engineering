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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.swing.text.html.ImageView;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        vacanze_famiglia_info.setVisible(false);
        // mostra il catalogo delle vacanze
        Scroll.setVisible(false);
        //Font font = Font.loadFont("file:rsc/sample/Glegoo-Bold.ttf", 45);
        //titolo.setFont(font);
        ChoiceBoxCatalogo.setVisible(true);
        titolo.setText("CATALOGO VACANZE");
        titolo.setVisible(true);
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
                String query = "SELECT codice, durata,data_partenza,città,lingua FROM vacanza_college";
                try {
                    // query result
                    ResultSet rs = databaseOperation.Vacation_return(query, selectedItem);
                    // put results inside of tableview
                    while(rs.next()){
                        Vacanze vacanze = new Vacanze();
                        vacanze.Codice.set(rs.getInt("codice"));
                        vacanze.Durata.set(rs.getInt("durata"));
                        System.out.println("Durata: " + rs.getInt("durata"));
                        vacanze.Lingua.set(rs.getString("lingua"));
                        System.out.println("Lingua: " + rs.getString("lingua"));
                        System.out.println("Città: " + rs.getString("città"));
                        vacanze.Città.set(rs.getString("città"));
                        // change String date format into dd-MM-yyyy
                        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat output = new SimpleDateFormat("dd-MM-yyyy");
                        String date = rs.getString("data_partenza");
                        Date dateValue = input.parse(date);
                        vacanze.DataPartenza.set(output.format(dateValue));
                        System.out.println("Durata: " + rs.getString("data_partenza"));
                        // add cm inside of data
                        data.add(vacanze);
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
        titolo.setVisible(true);
        ChoiceBoxCatalogo.setVisible(true);
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
                                        //TableRow row = getTableRow();
                                        Integer codice = vacanze.getCodice();
                                        cittàScelta = vacanze.getCittà();
                                        dataPartenzaScelta = vacanze.getDataPartenza();
                                        linguaScelta = vacanze.getLingua();
                                        durataScelta = vacanze.getDurata();
                                        codiceScelta = vacanze.getCodice();
                                        System.out.println("Città: " + vacanze.getCittà());
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

    private void showBooking() {
        TabellaVacanze.setVisible(false);
        ChoiceBoxCatalogo.setVisible(false);
        titolo.setText("PRENOTAZIONE");
        famiglia.setVisible(true);
        college.setVisible(true);
    }


    public void handleExitClick(MouseEvent mouseEvent) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    public void bookingFamiglia(MouseEvent mouseEvent) throws SQLException {
        try {
            famiglia.setVisible(false);
            college.setVisible(false);
            String query = "SELECT num_camere, nome_capo_fam, cognome_capo_fam, num_componenti, num_bagni, num_animali FROM vacanza_famiglia WHERE codice = " + codiceScelta + ";";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            Integer num_camere = rs.getInt("num_camere");
            if (num_camere >= 1) {
                vacanze_famiglia_info.setVisible(true);
                testo_preferenze.setText("E' possibile specificare il nome e l'indirizzo mail di un amico\nche soggornerà nella stessa famiglia: ");
                cittàText.setText(cittàScelta);
                durataText.setText(String.valueOf(durataScelta));
                linguaText.setText(linguaScelta);
                dataText.setText(dataPartenzaScelta);
                nomeFamigliaText.setText(rs.getString("nome_capo_fam"));
                cognomeFamigliaText.setText(rs.getString("cognome_capo_fam"));
                componentiText.setText(rs.getString("num_componenti"));
                camereText.setText(rs.getString("num_camere"));
                bagniText.setText(rs.getString("num_bagni"));
                if (Integer.parseInt(rs.getString("num_animali")) == 0) {
                    animaliText.setText("Nessun animale");
                }
                else {
                    animaliText.setText(String.valueOf(rs.getString("num_animali")));
                }
                String nomeAmico = nomeAmicoText.getText();
                String mailAmico = mailAmicoText.getText();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
            ResultSet result = null;
        }
    }

    public void bookingCollege(MouseEvent mouseEvent) throws SQLException {
        try {
            famiglia.setVisible(false);
            college.setVisible(false);

        }
        catch (Exception ex) {
                ex.printStackTrace();
                ResultSet result = null;
        }
    }
}