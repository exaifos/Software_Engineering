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
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class HomeController {
    public TableView TabellaVacanze;
    public Button Exit;
    public Button Profilo;
    @FXML
    private ChoiceBox<Object> ChoiceBoxCatalogo;
    private ObservableList<Vacanze> data;
    private ObservableList<Gita> data_gita;
    private ObservableList<Gita> data_gita_college;
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
    public TableView tabellaGiteCollege;
    public TableColumn colDestinazione;
    public TableColumn colDestinazioneCollege;
    public TableColumn colOre;
    public TableColumn colOreCollege;
    public TableColumn colCosto;
    public TableColumn colCostoCollege;
    public TableColumn colDescrizione;
    public TableColumn colDescrizioneCollege;
    public TableColumn colFamiglia = new TableColumn<Vacanze, String>();
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
    public SimpleDateFormat output = new SimpleDateFormat("dd-MM-yyyy");
    public SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
    public Date todayDate = new Date();
    public Integer num_ospitabili;
    public Label testo_preferenze;
    public String cf_compagno;
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
    public ObservableList<Object> paymentOptions;
    public Object selectedPayment;
    public Object selectedRoom;
    public String nomeAmico;
    public String mailAmico;
    public Label testo_preferenze_college;
    public ChoiceBox ChoicePagamentoCollege;
    boolean compagno = false;
    // attività
    private ObservableList<Activity> data_activity;
    public TableView tabellaAttività;
    public TableColumn colNomeAttività;
    public TableColumn colDescrizioneAttività;
    // pagamento
    private ObservableList<Pagamento> data_payment;
    public TableView TabellaPagamenti;
    public TableColumn colCityPagamento;
    public TableColumn colDurataPagamento;
    public TableColumn colPrezzoPagamento;
    public TableColumn colTipoPagamento;
    public TableColumn colStatusPagamento;
    public TableColumn colVacanzaPagamento;
    // conferma
    public ScrollPane confirmation;
    public Label nomeConferma;
    public TextField nomeConfermaText;
    public Label nomeCompagnoConferma;
    public TextField nomeCompagnoConfermaText;
    // certificati
    private ObservableList<Level> data_certificate;
    public TableView TabellaCertificati;
    public TableColumn colNomeLivello;
    public TableColumn colLinguaLivello;
    public TableColumn colDataLivello;
    // questionari
    public String TipoQuestionario;
    public Integer CodiceQuestionario;
    public TableColumn<Questionario, String> colBottoneQuestionario;
    private ObservableList<Questionario> data_questionario;
    public TableView TabellaQuestionari;
    public TableView TabellaQuestionariCompilati;
    public Text titoloQuestionari;
    public TableColumn colCittàQuestionarioCompilato;
    public TableColumn colDataQuestionarioCompilato;
    public TableColumn colVotoQuestionarioCompilato;
    public TableColumn colCommentoQuestionarioCompilato;
    public TableColumn colTipoQuestionarioCompilato;
    public TableColumn colCittàQuestionario;
    public TableColumn colDataQuestionario;
    public TableColumn colTipoQuestionario;
    public String tipo_vacanza;
    public ScrollPane InfoQuestionarioCollege;
    public TextField cittàTextQuestionarioCollege;
    public TextField durataTextQuestionarioCollege;
    public TextField linguaTextQuestionarioCollege;
    public TextField dataTextQuestionarioCollege;
    public TextField nomeCollegeQuestionarioCollege;
    public TextField indirizzoCollegeQuestionario;
    public ChoiceBox VotoQuestionarioCollege;
    public TextField commentoQuestionarioCollege;
    public Object selectedGrade;
    public ScrollPane InfoQuestionarioFamiglia;
    public TextField cittàTextQuestionarioFamiglia;
    public TextField durataTextQuestionarioFamiglia;
    public TextField linguaTextQuestionarioFamiglia;
    public TextField dataTextQuestionarioFamiglia;
    public TextField nomeFamigliaQuestionario;
    public TextField cognomeFamigliaQuestionario;
    public TextField commentoQuestionarioFamiglia;
    public ChoiceBox VotoQuestionarioFamiglia;
    public Label metodoPagamentoFamiglia;
    public Label metodoPagamentoCollege;
    // visualizzazione vacanze
    public Label TipoCameraCollege;
    public TextField TipoCameraCollegeText;
    public Label NomeCompagnoCollege;
    public TextField NomeCompagnoCollegeText;
    public Button PrenotaFamiglia;
    public Button PrenotaCollege;
    public Button TornaCatalogoFamiglia;
    public Button TornaCatalogoCollege;
    public Label TestoFiltro;
    public Label TestoFiltro2;
    public TableView TabellaVacanzeView;
    public TableColumn colCittàVacanze;
    public TableColumn colLinguaVacanze;
    public TableColumn colDurataVacanze;
    public TableColumn colDataVacanze;
    public TableColumn colFamigliaVacanze = new TableColumn<Vacanze, String>();
    public TableColumn colEffettuataVacanza;
    public TableColumn<Vacanze, String> colBottoneVacanza;
    public ObservableList<Vacanze> dataViewVacanza;
    public ChoiceBox ChoiceTipoVisualizzazione;
    public ChoiceBox ChoiceDestinazione;
    Object selectedViewType;
    Object selectedDestinazione;
    ObservableList<Object> destinazioni = FXCollections.observableArrayList();

    public void showProfile(ActionEvent mouseEvent) {
        // mostra il profilo
        testoScelta.setVisible(false);
        college.setVisible(false);
        famiglia.setVisible(false);
        vacanze_college_info.setVisible(false);
        vacanze_famiglia_info.setVisible(false);
        TabellaVacanze.setVisible(false);
        TabellaPagamenti.setVisible(false);
        ChoiceBoxCatalogo.setVisible(false);
        confirmation.setVisible(false);
        TabellaQuestionari.setVisible(false);
        TabellaCertificati.setVisible(false);
        InfoQuestionarioCollege.setVisible(false);
        InfoQuestionarioFamiglia.setVisible(false);
        TabellaQuestionariCompilati.setVisible(false);
        titoloQuestionari.setVisible(false);
        TabellaVacanzeView.setVisible(false);
        ChoiceTipoVisualizzazione.setVisible(false);
        ChoiceDestinazione.setVisible(false);
        TestoFiltro.setVisible(false);
        TestoFiltro2.setVisible(false);
        titolo.setVisible(true);
        Scroll.setVisible(true);
        titolo.setText("AREA RISERVATA");
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

            String query1 = "SELECT G.nome, G.cognome, G.email, G.telefono\n" + "FROM Genitore G JOIN Tutore T ON (T.nome_genitore=G.nome AND T.cognome_genitore=G.cognome AND T.telefono_genitore=G.telefono) WHERE CF='" + CF + "';";
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
        CF = message1;
        utente = message2;
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
        password = passText.getText();
        password2 = passText2.getText();
        emailNew = emailText.getText();
        telNew = telText.getText();
        allergeniNew = allergeniText.getText();
        hobbyNew = hobbyText.getText();
        precauzioniNew = precauzioniText.getText();
        emailGenTextNew = emailGenText.getText();
        if (!password.equals(password2)) {
            Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
            alertIncorrect.setHeaderText(null);
            alertIncorrect.setContentText("Le password non corrispondono!");
            alertIncorrect.showAndWait();
        } else {
            if (!(password.length() >= 8 && password.matches(".*[a-zA-Z]+.*"))) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Password non sicura, deve contenere almeno un carattere ed essere lunga almeno 8 caratteri!");
                alertMissing.showAndWait();
            } else if (!Controller.isValid(emailNew) || !Controller.isValid(emailGenTextNew)) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Le email non sono valide!");
                alertMissing.showAndWait();
            } else {
                try {
                    String query = "UPDATE ragazzo SET email='" + emailNew + "', telefono='" + telNew + "', nome_allergene='" + allergeniNew + "', precauzioni='" + precauzioniNew + "', password='" + password + "' WHERE CF='" + CF + "';";
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
        TabellaQuestionari.setVisible(false);
        vacanze_famiglia_info.setVisible(false);
        vacanze_college_info.setVisible(false);
        TabellaPagamenti.setVisible(false);
        TabellaVacanze.setVisible(false);
        ChoiceBoxCatalogo.setVisible(false);
        confirmation.setVisible(false);
        TabellaCertificati.setVisible(false);
        InfoQuestionarioCollege.setVisible(false);
        InfoQuestionarioFamiglia.setVisible(false);
        TabellaQuestionariCompilati.setVisible(false);
        titoloQuestionari.setVisible(false);
        TabellaVacanzeView.setVisible(false);
        ChoiceTipoVisualizzazione.setVisible(false);
        ChoiceDestinazione.setVisible(false);
        TestoFiltro.setVisible(false);
        TestoFiltro2.setVisible(false);
        scelta = null;
        famiglia.setVisible(true);
        college.setVisible(true);
        titolo.setText("PRENOTAZIONE");
        titolo.setVisible(true);
        famiglia.setOnAction(event -> {
            scelta = "vacanza_famiglia";
        });
        college.setOnAction(event -> {
            scelta = "vacanza_college";
        });
    }

    public void setTableVisible(MouseEvent mouseEvent) throws SQLException {
        TableColumns();
        testoScelta.setVisible(false);
        college.setVisible(false);
        famiglia.setVisible(false);
        worldmap.setVisible(false);
        vacanze_college_info.setVisible(false);
        vacanze_famiglia_info.setVisible(false);
        Scroll.setVisible(false);
        TabellaPagamenti.setVisible(false);
        confirmation.setVisible(false);
        TabellaCertificati.setVisible(false);
        TabellaQuestionari.setVisible(false);
        InfoQuestionarioCollege.setVisible(false);
        InfoQuestionarioFamiglia.setVisible(false);
        TabellaQuestionariCompilati.setVisible(false);
        titoloQuestionari.setVisible(false);
        TabellaVacanzeView.setVisible(false);
        ChoiceTipoVisualizzazione.setVisible(false);
        ChoiceDestinazione.setVisible(false);
        TestoFiltro.setVisible(false);
        TestoFiltro2.setVisible(false);
        ChoiceBoxCatalogo.setVisible(true);
        ObservableList<Object> viewOptions = FXCollections.observableArrayList("Durata", "Città", "Data di partenza");
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
            query = "SELECT prenotazione_famiglia.\"CF_ragazzo\" AS cf_compagno, prenotazione_famiglia.codice_vacanza AS codice_vacanza FROM prenotazione_famiglia, ragazzo WHERE ragazzo.cf = '" + CF + "' AND prenotazione_famiglia.status = 'false' AND ragazzo.nome = prenotazione_famiglia.nome_compagno AND ragazzo.email = prenotazione_famiglia.email_compagno;";
            try {
                ResultSet rs = databaseOperation.SQL_return(query);
                if (rs.next() == true) {
                    TabellaVacanze.setVisible(false);
                    Alert alertIncorrect = new Alert(Alert.AlertType.INFORMATION);
                    alertIncorrect.setHeaderText(null);
                    alertIncorrect.setContentText("Stiamo tenendo un posto in famiglia per te!");
                    alertIncorrect.showAndWait();
                    titolo.setText("DETTAGLI VACANZA:");
                    famiglia.setVisible(false);
                    college.setVisible(false);
                    ChoiceBoxCatalogo.setVisible(false);
                    codiceScelta = rs.getInt("codice_vacanza");
                    String query_vacanza = "SELECT * from vacanza_famiglia WHERE codice = '" + codiceScelta + "';";
                    ResultSet rs_vacanza = databaseOperation.SQL_return(query_vacanza);
                    rs_vacanza.next();
                    // get scrollpane back to the top
                    vacanze_famiglia_info.setVvalue(vacanze_famiglia_info.getVmin());
                    vacanze_famiglia_info.setVisible(true);
                    cittàText.setText(capitalize(rs_vacanza.getString("città")));
                    if (rs_vacanza.getInt("durata") > 1) {
                        durataText.setText(rs_vacanza.getInt("durata") + " settimane");
                    } else {
                        durataText.setText(rs_vacanza.getInt("durata") + " settimana");
                    }
                    linguaText.setText(capitalize(rs_vacanza.getString("lingua")));
                    dataText.setText(rs_vacanza.getString("data_partenza"));
                    nomeFamigliaText.setText(capitalize(rs_vacanza.getString("nome_capo_fam")));
                    cognomeFamigliaText.setText(capitalize(rs_vacanza.getString("cognome_capo_fam")));
                    if (Integer.parseInt(rs_vacanza.getString("num_componenti")) == 1) {
                        componentiText.setText(rs_vacanza.getString("num_componenti") + " componente");
                    } else {
                        componentiText.setText(rs_vacanza.getString("num_componenti") + " componenti");
                    }
                    if (Integer.parseInt(rs_vacanza.getString("num_camere")) == 1) {
                        camereText.setText(rs_vacanza.getString("num_camere") + " camera");
                    } else {
                        camereText.setText(rs_vacanza.getString("num_camere") + " camere");
                    }
                    if (Integer.parseInt(rs_vacanza.getString("num_bagni")) == 1) {
                        bagniText.setText(rs_vacanza.getString("num_bagni") + " bagno");
                    } else {
                        bagniText.setText(rs_vacanza.getString("num_bagni") + " bagni");
                    }
                    if (Integer.parseInt(rs_vacanza.getString("num_animali")) == 0) {
                        animaliText.setText("Nessun animale");
                    } else if (Integer.parseInt(rs_vacanza.getString("num_animali")) == 1) {
                        animaliText.setText(rs_vacanza.getString("num_animali") + " animale");
                    } else if (Integer.parseInt(rs_vacanza.getString("num_animali")) > 1) {
                        animaliText.setText(rs_vacanza.getString("num_animali") + " animali");
                    }
                    cf_compagno = rs.getString("cf_compagno");
                    String query_compagno = "SELECT nome, email FROM ragazzo WHERE cf = '" + cf_compagno + "';";
                    ResultSet rs_compagno = databaseOperation.SQL_return(query_compagno);
                    rs_compagno.next();
                    testo_preferenze.setText("E' possibile specificare il nome e l'indirizzo mail di\nun amico che soggornerà nella stessa famiglia: ");
                    nomeAmicoText.setEditable(false);
                    nomeAmicoText.setText(rs_compagno.getString("nome"));
                    mailAmicoText.setEditable(false);
                    mailAmicoText.setText(rs_compagno.getString("email"));
                    // view Gite
                    assert tabellaGite != null : "fx:id=\"tabellaGite\" was not injected: check your FXML file 'Home.fxml'.";
                    // setCellValueFactory for each column
                    colDestinazione.setCellValueFactory(new PropertyValueFactory<Gita, String>("Destinazione"));
                    colDestinazione.setText("Destinazione");
                    colDestinazione.setStyle("-fx-alignment: CENTER;");
                    colCosto.setCellValueFactory(new PropertyValueFactory<Gita, Integer>("Costo"));
                    colCosto.setText("Prezzo");
                    colCosto.setStyle("-fx-alignment: CENTER;");
                    colOre.setCellValueFactory(new PropertyValueFactory<Gita, Integer>("Ore"));
                    colOre.setText("Ore");
                    colOre.setStyle("-fx-alignment: CENTER;");
                    //colDescrizione.setCellValueFactory(new PropertyValueFactory<Gita,String>("Descrizione"));
                    colDescrizione.setText("Descrizione");
                    colDescrizione.setStyle("-fx-alignment: CENTER;");
                    // setCellFactory for text wrapping
                    colDescrizione.setCellFactory(tc -> {
                        colDescrizione.setCellValueFactory(new PropertyValueFactory<Gita, String>("Descrizione"));
                        TableCell<Gita, String> cell = new TableCell<>();
                        Text text = new Text();
                        cell.setGraphic(text);
                        cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                        text.wrappingWidthProperty().bind(colDescrizione.widthProperty());
                        text.textProperty().bind(cell.itemProperty());
                        return cell;
                    });
                    query = "SELECT * FROM gita, pianificazione_famiglia WHERE id_vacanza = " + codiceScelta + "AND id_gita = id;";
                    rs = databaseOperation.SQL_return(query);
                    // clear table
                    tabellaGite.getColumns().clear();
                    tabellaGite.setPlaceholder(new Label("Ci dispiace, non è prevista alcuna gita per questa vacanza."));
                    data_gita = FXCollections.observableArrayList();
                    // clear data
                    data_gita.clear();
                    while (rs.next()) {
                        Gita gita = new Gita();
                        gita.Costo.set(rs.getString("costo") + "€");
                        gita.Descrizione.set(capitalize(rs.getString("descrizione")));
                        gita.Destinazione.set(rs.getString("destinazione"));
                        gita.Ore.set(rs.getInt("num_ore"));
                        data_gita.add(gita);
                    }
                    tabellaGite.setItems(data_gita);
                    tabellaGite.getColumns().addAll(colDestinazione, colDescrizione, colOre, colCosto);
                    ObservableList<Object> paymentOptions = FXCollections.observableArrayList("Carta di credito", "Bonifico bancario");
                    ChoicePagamento.setItems(paymentOptions);
                    compagno = true;
                }
                else {
                    query = "SELECT codice, durata,data_partenza,città,lingua,cognome_capo_fam FROM " + scelta;
                    try {
                        // query result
                        rs = databaseOperation.Vacation_return(query, "");
                        // put results inside of tableview
                        data = FillTableVacanze(rs);
                        // add data inside of tableview
                        TabellaVacanze.setItems(data);
                        TabellaVacanze.setVisible(true);
                        TabellaVacanze.getColumns().addAll(colCittà, colData, colLingua, colDurata, colFamiglia, colBottone);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            query = "SELECT codice, durata,data_partenza,città,lingua FROM " + scelta;
            try {
                // query result
                ResultSet rs = databaseOperation.Vacation_return(query, "");
                // put results inside of tableview
                data = FillTableVacanze(rs);
                // add data inside of tableview
                TabellaVacanze.setItems(data);
                TabellaVacanze.setVisible(true);
                TabellaVacanze.getColumns().addAll(colCittà, colData, colLingua, colDurata, colBottone);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
                } else {
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
                    } else {
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
            //String dateCheck_query = "SELECT * FROM " + scelta + ";";
            String todayString = input.format(todayDate);
            System.out.println("Data: " + todayString);
            todayDate = input.parse(todayString);
            while (rs.next()) {
                Vacanze vacanze = new Vacanze();
                String date = rs.getString("data_partenza");
                Date dateValue = input.parse(date);
                // check if data_partenza is after today
                if (input.parse(date).after(todayDate)) {
                    System.out.println("Data di partenza: " + dateValue + " Data di oggi: " + todayDate);
                    vacanze.Codice.set(rs.getInt("codice"));
                    vacanze.Durata.set(rs.getInt("durata"));
                    vacanze.Lingua.set(capitalize(rs.getString("lingua")));
                    vacanze.Città.set((capitalize(rs.getString("città"))));
                    vacanze.DataPartenza.set(output.format(dateValue));
                    if (scelta == "vacanza_famiglia") {
                        vacanze.Famiglia.set(capitalize(rs.getString("cognome_capo_fam")));
                    }
                    // add row inside of data
                    data.add(vacanze);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void TableColumns() {
        assert TabellaVacanze != null : "fx:id=\"TabellaVacanze\" was not injected: check your FXML file 'Home.fxml'.";
        // setCellValueFactory for each column
        colCittà.setCellValueFactory(new PropertyValueFactory<Vacanze, String>("Città"));
        colCittà.setText("Città");
        colCittà.setStyle("-fx-alignment: CENTER;");
        colLingua.setCellValueFactory(new PropertyValueFactory<Vacanze, String>("Lingua"));
        colLingua.setText("Lingua");
        colLingua.setStyle("-fx-alignment: CENTER;");
        colDurata.setCellValueFactory(new PropertyValueFactory<Vacanze, Integer>("Durata"));
        colDurata.setText("Durata");
        colDurata.setStyle("-fx-alignment: CENTER;");
        colData.setCellValueFactory(new PropertyValueFactory<Vacanze, String>("DataPartenza"));
        colData.setText("Data di partenza");
        colData.setStyle("-fx-alignment: CENTER;");
        if (scelta == "vacanza_famiglia") {
            colFamiglia.setCellValueFactory(new PropertyValueFactory<Vacanze, String>("Famiglia"));
            colFamiglia.setEditable(false);
            colFamiglia.setSortable(false);
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
                                        try {
                                            if (scelta == "vacanza_famiglia") {
                                                showFamiglia();
                                            } else {
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

    public void showFamiglia() throws SQLException {
        try {
            TabellaVacanze.setVisible(false);
            famiglia.setVisible(false);
            college.setVisible(false);
            titolo.setText("DETTAGLI VACANZA:");
            ChoiceBoxCatalogo.setVisible(false);
            // get scrollpane back to the top
            vacanze_famiglia_info.setVvalue(vacanze_famiglia_info.getVmin());
            nomeAmicoText.clear();
            mailAmicoText.clear();
            String query = "SELECT num_camere, nome_capo_fam, cognome_capo_fam, num_componenti, num_bagni, num_animali, num_ospitabili FROM vacanza_famiglia WHERE codice = " + codiceScelta + ";";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            num_ospitabili = rs.getInt("num_ospitabili");
            if (num_ospitabili >= 1) {
                vacanze_famiglia_info.setVisible(true);
                testo_preferenze.setText("E' possibile specificare il nome e l'indirizzo mail di\nun amico che soggornerà nella stessa famiglia: ");
                cittàText.setText(capitalize(cittàScelta));
                if (durataScelta > 1) {
                    durataText.setText(durataScelta + " settimane");
                } else {
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
                } else if (Integer.parseInt(rs.getString("num_animali")) == 1) {
                    animaliText.setText(rs.getString("num_animali") + " animale");
                } else if (Integer.parseInt(rs.getString("num_animali")) > 1) {
                    animaliText.setText(rs.getString("num_animali") + " animali");
                }
                nomeAmicoText.setEditable(true);
                mailAmicoText.setEditable(true);
                nomeAmico = nomeAmicoText.getText();
                mailAmico = mailAmicoText.getText();
                // view Gite
                assert tabellaGite != null : "fx:id=\"tabellaGite\" was not injected: check your FXML file 'Home.fxml'.";
                // setCellValueFactory for each column
                colDestinazione.setCellValueFactory(new PropertyValueFactory<Gita, String>("Destinazione"));
                colDestinazione.setText("Destinazione");
                colDestinazione.setStyle("-fx-alignment: CENTER;");
                colCosto.setCellValueFactory(new PropertyValueFactory<Gita, Integer>("Costo"));
                colCosto.setText("Prezzo");
                colCosto.setStyle("-fx-alignment: CENTER;");
                colOre.setCellValueFactory(new PropertyValueFactory<Gita, Integer>("Ore"));
                colOre.setText("Ore");
                colOre.setStyle("-fx-alignment: CENTER;");
                //colDescrizione.setCellValueFactory(new PropertyValueFactory<Gita,String>("Descrizione"));
                colDescrizione.setText("Descrizione");
                colDescrizione.setStyle("-fx-alignment: CENTER;");
                // setCellFactory for text wrapping
                colDescrizione.setCellFactory(tc -> {
                    colDescrizione.setCellValueFactory(new PropertyValueFactory<Gita, String>("Descrizione"));
                    TableCell<Gita, String> cell = new TableCell<>();
                    Text text = new Text();
                    cell.setGraphic(text);
                    cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                    text.wrappingWidthProperty().bind(colDescrizione.widthProperty());
                    text.textProperty().bind(cell.itemProperty());
                    return cell;
                });
                query = "SELECT * FROM gita, pianificazione_famiglia WHERE id_vacanza = " + codiceScelta + "AND id_gita = id;";
                rs = databaseOperation.SQL_return(query);
                // clear table
                tabellaGite.getColumns().clear();
                tabellaGite.setPlaceholder(new Label("Ci dispiace, non è prevista alcuna gita per questa vacanza."));
                data_gita = FXCollections.observableArrayList();
                // clear data
                data_gita.clear();
                while (rs.next()) {
                    Gita gita = new Gita();
                    gita.Costo.set(rs.getString("costo") + "€");
                    gita.Descrizione.set(capitalize(rs.getString("descrizione")));
                    gita.Destinazione.set(rs.getString("destinazione"));
                    gita.Ore.set(rs.getInt("num_ore"));
                    data_gita.add(gita);
                }
                tabellaGite.setItems(data_gita);
                tabellaGite.getColumns().addAll(colDestinazione, colDescrizione, colOre, colCosto);
                ObservableList<Object> paymentOptions = FXCollections.observableArrayList("Carta di credito", "Bonifico bancario");
                ChoicePagamento.setItems(paymentOptions);
            } else {
                Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                alertIncorrect.setHeaderText(null);
                alertIncorrect.setContentText("Ci dispiace, non ci sono più posti disponibili in questa famiglia.");
                alertIncorrect.showAndWait();
                query = "SELECT codice, durata,data_partenza,città,lingua,cognome_capo_fam FROM " + scelta;
                titolo.setText("CATALOGO");
                titolo.setVisible(true);
                ChoiceBoxCatalogo.setVisible(true);
                // query result
                rs = databaseOperation.Vacation_return(query, "");
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
        } catch (Exception ex) {
            ex.printStackTrace();
            ResultSet result = null;
        }
    }

    public void BookingFamigliaDetails(MouseEvent mouseEvent) throws SQLException {
        try {
            if (selectedPayment != null) {
                PrenotaFamiglia.setVisible(true);
                if (nomeAmicoText.getText().trim().isEmpty()) {
                    if (mailAmicoText.getText().trim().isEmpty()) {
                        nomeAmico = null;
                        mailAmico = null;
                        BookingFamiglia(1);
                    } else if (!mailAmicoText.getText().trim().isEmpty()) {
                        Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                        alertIncorrect.setHeaderText(null);
                        alertIncorrect.setContentText("Per favore, inserire il nome dell'amico.");
                        alertIncorrect.showAndWait();
                    }
                } else if (!nomeAmicoText.getText().trim().isEmpty()) {
                    // se manca l'indirizzo mail ma c'è il nome
                    if (mailAmicoText.getText().trim().isEmpty()) {
                        Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                        alertIncorrect.setHeaderText(null);
                        alertIncorrect.setContentText("Per favore, inserire l'indirizzo mail dell'amico.");
                        alertIncorrect.showAndWait();
                    } else if (!mailAmicoText.getText().trim().isEmpty()) {
                        nomeAmico = nomeAmicoText.getText();
                        mailAmico = mailAmicoText.getText();
                        String query = "SELECT * FROM ragazzo WHERE nome = '" + nomeAmico + "' AND email = '" + mailAmico + "';";
                        ResultSet rs = databaseOperation.SQL_return(query);
                        // se non sto finendo la completando la prenotazione dell'altro
                        if (compagno == false) {
                            // se l'utente è presente nel sistema
                            if (rs.next()) {
                                if (num_ospitabili >= 2) {
                                    BookingFamiglia(2);
                                } else {
                                    Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                                    alertIncorrect.setHeaderText(null);
                                    alertIncorrect.setContentText("Ci dispiace, c'è posto per una sola persona in questa famiglia.");
                                    alertIncorrect.showAndWait();
                                }
                            }
                            else {
                                Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                                alertIncorrect.setHeaderText(null);
                                alertIncorrect.setContentText("Il nome o la mail del compagno non risultano nel sistema.\nEffettuare la registrazione!");
                                alertIncorrect.showAndWait();
                            }
                        }
                        else {
                            BookingFamiglia(0);
                        }
                    }
                }
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

    public void BookingFamiglia(Integer type) throws SQLException {
        try {
            String query = "SELECT * FROM ragazzo WHERE CF='" + CF + "';";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            String cf = rs.getString("cf");
            String check_query = "SELECT \"CF_ragazzo\" FROM prenotazione_famiglia WHERE \"CF_ragazzo\" ILIKE '" + cf + "' AND \"codice_vacanza\" =" + codiceScelta + ";";
            ResultSet check_rs = databaseOperation.SQL_return(check_query);
            // if cf is already present in the same codiceScelta in prentoazione_famiglia
            if (check_rs.next()) {
                Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                alertIncorrect.setHeaderText(null);
                alertIncorrect.setContentText("L'utente risulta già prenotato per questa vacanza.");
                alertIncorrect.showAndWait();
            }
            else {
                query = "INSERT INTO prenotazione_famiglia (\"CF_ragazzo\", codice_vacanza, nome_compagno, email_compagno) VALUES ('" + cf + "', '" + codiceScelta + "', '" + nomeAmico + "', '" + mailAmico + "');";
                databaseOperation.SQL_insert(query);
                query = "INSERT INTO questionario_famiglia (\"CF_ragazzo\", codice_vacanza_famiglia) VALUES ('" + cf + "', '" + codiceScelta + "');";
                databaseOperation.SQL_insert(query);
                Integer new_ospitabili;
                // se è stato inserito un compagno
                if (type == 2) {
                    new_ospitabili = num_ospitabili - 2;
                    query = "UPDATE vacanza_famiglia SET num_ospitabili='" + new_ospitabili + "' WHERE codice='" + codiceScelta + "';";
                    databaseOperation.SQL_insert(query);
                }
                else if (type == 1) {
                    new_ospitabili = num_ospitabili - 1;
                    query = "UPDATE vacanza_famiglia SET num_ospitabili='" + new_ospitabili + "' WHERE codice='" + codiceScelta + "';";
                    databaseOperation.SQL_insert(query);
                }
                else if (type == 0) {
                    // dobbiamo porre lo status a true
                    query = "UPDATE prenotazione_famiglia SET status = 'true' WHERE \"CF_ragazzo\" = '" + cf + "' AND codice_vacanza = '" + codiceScelta + "';";
                    databaseOperation.SQL_insert(query);
                    query = "UPDATE prenotazione_famiglia SET status = 'true' WHERE \"CF_ragazzo\" = '" + cf_compagno + "' AND codice_vacanza = '" + codiceScelta + "';";
                    databaseOperation.SQL_insert(query);

                }
                // pagamento
                metodoPagamentoFamiglia.setVisible(true);
                query = "INSERT INTO pagamento_famiglia (\"CF_ragazzo\", codice_vacanza_famiglia, \"tipo_pagamento \") VALUES ('" + cf + "', '" + codiceScelta + "', '" + selectedPayment + "');";
                databaseOperation.SQL_insert(query);
                Alert alertIncorrect = new Alert(Alert.AlertType.INFORMATION);
                alertIncorrect.setHeaderText(null);
                alertIncorrect.setContentText("Prenotazione effettuata!");
                alertIncorrect.showAndWait();
                String tipo_vacanza = "famiglia";
                showConfirmation(tipo_vacanza);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void bookingCollege() throws SQLException {
        try {
            TabellaVacanze.setVisible(false);
            famiglia.setVisible(false);
            college.setVisible(false);
            titolo.setVisible(true);
            titolo.setText("DETTAGLI VACANZA:");
            ChoiceBoxCatalogo.setVisible(false);
            PrenotaCollege.setVisible(true);
            metodoPagamentoCollege.setVisible(true);
            testo_preferenze_college.setVisible(true);
            String query = "SELECT città, lingua, nome_college, indirizzo_college, data_partenza, durata FROM vacanza_college WHERE codice = " + codiceScelta + ";";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            cittàTextCollege.setText(capitalize(cittàScelta));
            if (durataScelta > 1) {
                durataTextCollege.setText(durataScelta + " settimane");
            } else {
                durataTextCollege.setText(durataScelta + " settimana");
            }
            linguaTextCollege.setText(capitalize(linguaScelta));
            dataTextCollege.setText(dataPartenzaScelta);
            nomeCollege.setText(capitalize(rs.getString("nome_college")));
            indirizzoCollege.setText(capitalize(rs.getString("indirizzo_college")));
            TipoCameraCollegeText.setVisible(false);
            TipoCameraCollege.setVisible(false);
            NomeCompagnoCollege.setVisible(false);
            NomeCompagnoCollegeText.setVisible(false);
            vacanze_college_info.setVisible(true);
            vacanze_college_info.setVvalue(vacanze_college_info.getVmin());
            roomChoice.setVisible(true);
            ChoicePagamentoCollege.setVisible(true);
            TornaCatalogoCollege.setVisible(true);
            // view attività
            assert tabellaAttività != null : "fx:id=\"tabellaAttività\" was not injected: check your FXML file 'Home.fxml'.";
            // setCellValueFactory for each column
            colNomeAttività.setText("Nome dell'attività");
            colNomeAttività.setStyle("-fx-alignment: JUSTIFY;");
            colDescrizioneAttività.setText("Descrizione dell'attività");
            colDescrizioneAttività.setStyle("-fx-alignment: JUSTIFY;");
            // setCellFactory for text wrapping
            colNomeAttività.setCellFactory(tc -> {
                colNomeAttività.setCellValueFactory(new PropertyValueFactory<Activity, String>("Nome"));
                TableCell<Activity, String> cell = new TableCell<>();
                Text text = new Text();
                cell.setGraphic(text);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(colNomeAttività.widthProperty());
                text.textProperty().bind(cell.itemProperty());
                return cell;
            });
            colDescrizioneAttività.setCellFactory(tc -> {
                colDescrizioneAttività.setCellValueFactory(new PropertyValueFactory<Activity, String>("Descrizione"));
                TableCell<Activity, String> cell = new TableCell<>();
                Text text = new Text();
                cell.setGraphic(text);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(colDescrizioneAttività.widthProperty());
                text.textProperty().bind(cell.itemProperty());
                return cell;
            });
            query = "SELECT * FROM proposta_college WHERE codice_college = " + codiceScelta + ";";
            rs = databaseOperation.SQL_return(query);
            // clear table
            tabellaAttività.getColumns().clear();
            tabellaAttività.setPlaceholder(new Label("Ci dispiace, non sono previste attività per questa vacanza."));
            data_activity = FXCollections.observableArrayList();
            // clear data
            data_activity.clear();
            while (rs.next()) {
                Activity activity = new Activity();
                activity.Nome.set(capitalize(rs.getString("nome_attivita")));
                activity.Descrizione.set(capitalize(rs.getString("descrizione_attivita")));
                data_activity.add(activity);
            }
            tabellaAttività.setItems(data_activity);
            tabellaAttività.getColumns().addAll(colNomeAttività, colDescrizioneAttività);
            // view Gite
            assert tabellaGiteCollege != null : "fx:id=\"tabellaGite\" was not injected: check your FXML file 'Home.fxml'.";
            // setCellValueFactory for each column
            colDestinazioneCollege.setCellValueFactory(new PropertyValueFactory<Gita, String>("Destinazione"));
            colDestinazioneCollege.setText("Destinazione");
            colDestinazioneCollege.setStyle("-fx-alignment: CENTER;");
            colCostoCollege.setCellValueFactory(new PropertyValueFactory<Gita, Integer>("Costo"));
            colCostoCollege.setText("Prezzo");
            colCostoCollege.setStyle("-fx-alignment: CENTER;");
            colOreCollege.setCellValueFactory(new PropertyValueFactory<Gita, Integer>("Ore"));
            colOreCollege.setText("Ore");
            colOreCollege.setStyle("-fx-alignment: CENTER;");
            //colDescrizione.setCellValueFactory(new PropertyValueFactory<Gita,String>("Descrizione"));
            colDescrizioneCollege.setText("Descrizione");
            // setCellFactory for text wrapping
            colDescrizioneCollege.setCellFactory(tc -> {
                colDescrizioneCollege.setCellValueFactory(new PropertyValueFactory<Gita, String>("Descrizione"));
                TableCell<Gita, String> cell = new TableCell<>();
                Text text = new Text();
                cell.setGraphic(text);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(colDescrizioneCollege.widthProperty());
                text.textProperty().bind(cell.itemProperty());
                return cell;
            });
            query = "SELECT * FROM gita, pianificazione_famiglia WHERE id_vacanza = " + codiceScelta + "AND id_gita = id;";
            rs = databaseOperation.SQL_return(query);
            // clear table
            tabellaGiteCollege.setPlaceholder(new Label("Ci dispiace, non è prevista alcuna gita per questa vacanza."));
            tabellaGiteCollege.getColumns().clear();
            data_gita_college = FXCollections.observableArrayList();
            // clear data
            data_gita_college.clear();
            while (rs.next()) {
                Gita gita = new Gita();
                gita.Costo.set(rs.getString("costo") + "€");
                gita.Descrizione.set(rs.getString("descrizione"));
                gita.Destinazione.set(rs.getString("destinazione"));
                gita.Ore.set(rs.getInt("num_ore"));
                data_gita_college.add(gita);
            }
            tabellaGiteCollege.setItems(data_gita_college);
            tabellaGiteCollege.getColumns().addAll(colDestinazioneCollege, colDescrizioneCollege, colOreCollege, colCostoCollege);
            testo_preferenze_college.setText("Esprimere la preferenza\n sul tipo di camera:");
            ObservableList<Object> roomOptions = FXCollections.observableArrayList("Camera singola", "Camera condivisa");
            roomChoice.setItems(roomOptions);
            paymentOptions = FXCollections.observableArrayList("Carta di credito", "Bonifico bancario");
            ChoicePagamentoCollege.setItems(paymentOptions);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void InitializePagamento(MouseEvent mouseEvent) {
        ChoicePagamento.setOnAction((event) -> {
            selectedPayment = null;
            selectedPayment = ChoicePagamento.getValue();
        });
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
                    String check_query = "SELECT \"CF_ragazzo\" FROM prenotazione_college WHERE \"CF_ragazzo\" ILIKE '" + cf + "' AND \"codice_vacanza\" =" + codiceScelta + ";";
                    ResultSet check_rs = databaseOperation.SQL_return(check_query);
                    // if cf is already present in the same codiceScelta in prenotazione_college
                    if (check_rs.next()) {
                        Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                        alertIncorrect.setHeaderText(null);
                        alertIncorrect.setContentText("L'utente risulta già prenotato per questa vacanza.");
                        alertIncorrect.showAndWait();
                    } else {
                        query = "INSERT INTO prenotazione_college (\"CF_ragazzo\", codice_vacanza, tipo_camera, nome_compagno) VALUES ('" + cf + "', '" + codiceScelta + "', '" + String.valueOf(selectedRoom) + "', '" + nomeCompagno + "');";
                        databaseOperation.SQL_insert(query);
                        query = "INSERT INTO questionario_college (\"CF_ragazzo\", codice_vacanza_college) VALUES ('" + cf + "', '" + codiceScelta + "');";
                        databaseOperation.SQL_insert(query);
                        // pagamento
                        query = "INSERT INTO pagamento_college (\"CF_ragazzo\", codice_vacanza_college, tipo_pagamento) VALUES ('" + cf + "', '" + codiceScelta + "', '" + selectedPayment + "');";
                        databaseOperation.SQL_insert(query);
                        Alert alertIncorrect = new Alert(Alert.AlertType.INFORMATION);
                        alertIncorrect.setHeaderText(null);
                        alertIncorrect.setContentText("Prenotazione effettuata!");
                        alertIncorrect.showAndWait();
                        String tipo_vacanza = "college";
                        showConfirmation(tipo_vacanza);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
                alertIncorrect.setHeaderText(null);
                alertIncorrect.setContentText("Non è stata impostata alcuna preferenza sulla camera");
                alertIncorrect.showAndWait();
            }
        } else {
            Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
            alertIncorrect.setHeaderText(null);
            alertIncorrect.setContentText("Nessun metodo di pagamento selezionato.");
            alertIncorrect.showAndWait();
        }
    }

    private void showConfirmation(String tipo_vacanza) throws SQLException {
        vacanze_college_info.setVisible(false);
        vacanze_famiglia_info.setVisible(false);
        titolo.setText("CONFERMA:");
        confirmation.setVisible(true);
        if (tipo_vacanza == "college") {
            String query = "SELECT * FROM prenotazione_college WHERE codice_vacanza = '" + codiceScelta + "' AND \"CF_ragazzo\" = '" + CF + "';";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            if (rs.getString("tipo_camera").equals("Camera condivisa")) {
                query = "SELECT \"CF_ragazzo\" as cf_compagno FROM prenotazione_college WHERE codice_vacanza = '" + codiceScelta + "' AND tipo_camera = 'Camera condivisa' AND status = false AND \"CF_ragazzo\" <> '" + CF + "';";
                rs = databaseOperation.SQL_return(query);
                // se c'è un altro ragazzo che vuole la camera condivisa per quella vacanza e non ha ancora un compagno
                if (rs.next()){
                    String cf_compagno = rs.getString("cf_compagno");
                    String query_nome_compagno = "SELECT nome FROM ragazzo WHERE cf = '" + cf_compagno + "';";
                    ResultSet rs_nome_compagno = databaseOperation.SQL_return(query_nome_compagno);
                    rs_nome_compagno.next();
                    String nomeCompagno = rs_nome_compagno.getString("nome");
                    nomeCompagnoConferma.setText("Nome del compagno:");
                    nomeCompagnoConfermaText.setText(nomeCompagno);
                    String query_nome = "SELECT nome FROM ragazzo WHERE cf = '" + CF + "';";
                    ResultSet rs_nome = databaseOperation.SQL_return(query_nome);
                    rs_nome.next();
                    String nome = rs_nome.getString("nome");
                    // update status and nome
                    query = "UPDATE prenotazione_college SET status = true, nome_compagno = '" + nomeCompagno + "' WHERE \"CF_ragazzo\" = '" + CF + "' AND codice_vacanza = '" + codiceScelta + "';";
                    databaseOperation.SQL_insert(query);
                    query = "UPDATE prenotazione_college SET status = true, nome_compagno = '" + nome +  "' WHERE \"CF_ragazzo\" = '" + cf_compagno + "' AND codice_vacanza = '" + codiceScelta + "';";
                    databaseOperation.SQL_insert(query);
                }
                else {
                    nomeCompagnoConferma.setText("Nome del compagno:");
                    nomeCompagnoConfermaText.setText("Compagno non ancora assegnato.");
                }
            }
            else {
                nomeCompagnoConferma.setText("Nome del compagno:");
                nomeCompagnoConfermaText.setText("Nessun compagno.");
            }
            query = "SELECT * FROM vacanza_college WHERE codice = '" + codiceScelta + "';";
            rs = databaseOperation.SQL_return(query);
            rs.next();
            nomeConferma.setText("Nome del college:");
            nomeConfermaText.setText(rs.getString("nome_college"));
        }
        else if (tipo_vacanza == "famiglia") {
            String query = "SELECT * FROM prenotazione_famiglia WHERE codice_vacanza = '" + codiceScelta + "' AND \"CF_ragazzo\" = '" + CF + "';";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            if (!rs.getString("nome_compagno").equals("null")) {
                nomeCompagnoConferma.setText("Nome del compagno:");
                nomeCompagnoConfermaText.setText(rs.getString("nome_compagno"));
            }
            else {
                query = "SELECT * FROM prenotazione_famiglia WHERE codice_vacanza = '" + codiceScelta + "' AND \"CF_ragazzo\" <> '" + CF + "' AND status = 'false';";
                rs = databaseOperation.SQL_return(query);
                if (rs.next()) {
                    cf_compagno = rs.getString("CF_ragazzo");
                    String query2 = "SELECT * FROM ragazzo WHERE cf = '" + cf_compagno + "';";
                    ResultSet rs2 = databaseOperation.SQL_return(query2);
                    rs2.next();
                    String query3 = "UPDATE prenotazione_famiglia SET status = true, nome_compagno = '" + rs2.getString("nome") + "', email_compagno = '" + rs2.getString("email") + "' WHERE \"CF_ragazzo\" = '" + CF + "' AND codice_vacanza = '" + codiceScelta + "';";
                    databaseOperation.SQL_insert(query3);
                    nomeCompagnoConferma.setText("Nome del compagno:");
                    nomeCompagnoConfermaText.setText(rs2.getString("nome"));
                    String query_nome = "SELECT nome, email FROM ragazzo WHERE cf = '" + CF + "';";
                    ResultSet rs_nome = databaseOperation.SQL_return(query_nome);
                    rs_nome.next();
                    String nome = rs_nome.getString("nome");
                    query3 = "UPDATE prenotazione_famiglia SET status = true, nome_compagno = '" + nome +  "' , email_compagno = '" + rs_nome.getString("email") + "' WHERE \"CF_ragazzo\" = '" + cf_compagno + "' AND codice_vacanza = '" + codiceScelta + "';";
                    databaseOperation.SQL_insert(query3);
                }
                else {
                    nomeCompagnoConferma.setText("Nome del compagno:");
                    nomeCompagnoConfermaText.setText("Nessuna preferenza");
                }
            }
            nomeConferma.setText("Cognome della famiglia:");
            query = "SELECT * FROM vacanza_famiglia WHERE codice = '" + codiceScelta + "';";
            rs = databaseOperation.SQL_return(query);
            rs.next();
            nomeConfermaText.setText(rs.getString("cognome_capo_fam"));
        }

    }

    public void InitializePagamentoCollege(MouseEvent mouseEvent) {
        ChoicePagamentoCollege.setOnAction((event) -> {
            selectedPayment = null;
            selectedPayment = ChoicePagamentoCollege.getValue();
        });
    }

    public void InitializeRoom(MouseEvent mouseEvent) {
        roomChoice.setOnAction(((event) -> {
            selectedRoom = null;
            selectedRoom = roomChoice.getValue();
        }));
    }

    public void showPayments(ActionEvent actionEvent) throws SQLException {
        try {
            worldmap.setVisible(false);
            testoScelta.setVisible(false);
            college.setVisible(false);
            famiglia.setVisible(false);
            TabellaQuestionari.setVisible(false);
            vacanze_college_info.setVisible(false);
            vacanze_famiglia_info.setVisible(false);
            TabellaVacanze.setVisible(false);
            ChoiceBoxCatalogo.setVisible(false);
            confirmation.setVisible(false);
            Scroll.setVisible(false);
            TabellaCertificati.setVisible(false);
            InfoQuestionarioCollege.setVisible(false);
            InfoQuestionarioFamiglia.setVisible(false);
            TabellaQuestionariCompilati.setVisible(false);
            titoloQuestionari.setVisible(false);
            TabellaVacanzeView.setVisible(false);
            ChoiceTipoVisualizzazione.setVisible(false);
            ChoiceDestinazione.setVisible(false);
            TestoFiltro.setVisible(false);
            TestoFiltro2.setVisible(false);
            titolo.setText("PAGAMENTI:");
            titolo.setVisible(true);
            TabellaPagamenti.setVisible(true);
            // view Gite
            assert TabellaPagamenti != null : "fx:id=\"TabellaPagamenti\" was not injected: check your FXML file 'Home.fxml'.";
            // setCellValueFactory for each column
            colCityPagamento.setCellValueFactory(new PropertyValueFactory<Pagamento, String>("CityPagamento"));
            colCityPagamento.setText("Città");
            colCityPagamento.setStyle("-fx-alignment: CENTER;");
            colDurataPagamento.setCellValueFactory(new PropertyValueFactory<Pagamento, String>("DurataPagamento"));
            colDurataPagamento.setText("Durata");
            colDurataPagamento.setStyle("-fx-alignment: CENTER;");
            colPrezzoPagamento.setCellValueFactory(new PropertyValueFactory<Pagamento, String>("PrezzoPagamento"));
            colPrezzoPagamento.setText("Prezzo");
            colPrezzoPagamento.setStyle("-fx-alignment: CENTER;");
            colTipoPagamento.setCellValueFactory(new PropertyValueFactory<Pagamento, String>("TipoPagamento"));
            colTipoPagamento.setText("Tipo di pagamento");
            colTipoPagamento.setStyle("-fx-alignment: CENTER;");
            colStatusPagamento.setCellValueFactory(new PropertyValueFactory<Pagamento, String>("StatusPagamento"));
            colStatusPagamento.setText("Stato");
            colStatusPagamento.setStyle("-fx-alignment: CENTER;");
            colVacanzaPagamento.setCellValueFactory(new PropertyValueFactory<Pagamento, String>("VacanzaPagamento"));
            colVacanzaPagamento.setText("Tipo di vacanza");
            colVacanzaPagamento.setStyle("-fx-alignment: CENTER;");
            // clear table
            TabellaPagamenti.setPlaceholder(new Label("Non è presente alcun pagamento."));
            TabellaPagamenti.getColumns().clear();
            data_payment = FXCollections.observableArrayList();
            // clear data
            data_payment.clear();
            String query = "SELECT vacanza_college.città, vacanza_college.durata, pagamento_college.status, pagamento_college.tipo_pagamento AS pagamento FROM vacanza_college, pagamento_college, prenotazione_college, ragazzo WHERE pagamento_college.codice_vacanza_college = vacanza_college.codice AND vacanza_college.codice = prenotazione_college.codice_vacanza AND ragazzo.cf = '" + CF + "' AND ragazzo.cf = pagamento_college.\"CF_ragazzo\" AND prenotazione_college.\"CF_ragazzo\" = ragazzo.cf;";
            ResultSet rs = databaseOperation.SQL_return(query);
            String type = "College";
            TabellaPagamenti.setItems(FillTabellaPagamenti(rs, type));
            query = "SELECT vacanza_famiglia.città, vacanza_famiglia.durata, pagamento_famiglia.status, pagamento_famiglia.\"tipo_pagamento \" AS pagamento FROM vacanza_famiglia, pagamento_famiglia, prenotazione_famiglia, ragazzo WHERE pagamento_famiglia.codice_vacanza_famiglia = vacanza_famiglia.codice AND vacanza_famiglia.codice = prenotazione_famiglia.codice_vacanza AND ragazzo.cf = '" + CF + "' AND ragazzo.cf = pagamento_famiglia.\"CF_ragazzo\" AND prenotazione_famiglia.\"CF_ragazzo\" = ragazzo.cf;";
            rs = databaseOperation.SQL_return(query);
            type = "Famiglia";
            TabellaPagamenti.setItems(FillTabellaPagamenti(rs, type));
            TabellaPagamenti.getColumns().addAll(colCityPagamento, colDurataPagamento, colTipoPagamento, colVacanzaPagamento, colStatusPagamento);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public ObservableList<Pagamento> FillTabellaPagamenti(ResultSet rs, String type) throws SQLException {
        try {
            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.CityPagamento.set(rs.getString("città"));
                if (Integer.parseInt(rs.getString("durata")) > 1) {
                    pagamento.DurataPagamento.set(rs.getString("durata") + " settimane");
                }
                else {
                    pagamento.DurataPagamento.set(rs.getString("durata") + " settimana");
                }
                pagamento.TipoPagamento.set(rs.getString("pagamento"));
                pagamento.VacanzaPagamento.set(type);
                if (!rs.getBoolean("status")) {
                    pagamento.StatusPagamento.set("Da pagare");
                }
                else if (rs.getBoolean("status")) {
                    pagamento.StatusPagamento.set("Pagato");
                }
                data_payment.add(pagamento);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return data_payment;
    }

    // certificato: al termine del viaggio ogni ragazzo riceve un certificato che specifica il livello
    // raggiunto (ad esempio B2, C1) nella lingua straniera studiata durante la vacanza
    public void viewCertificati() throws SQLException {
        try {
            worldmap.setVisible(false);
            testoScelta.setVisible(false);
            college.setVisible(false);
            famiglia.setVisible(false);
            TabellaQuestionari.setVisible(false);
            vacanze_college_info.setVisible(false);
            vacanze_famiglia_info.setVisible(false);
            TabellaVacanze.setVisible(false);
            ChoiceBoxCatalogo.setVisible(false);
            confirmation.setVisible(false);
            Scroll.setVisible(false);
            InfoQuestionarioCollege.setVisible(false);
            InfoQuestionarioFamiglia.setVisible(false);
            TabellaPagamenti.setVisible(false);
            TabellaQuestionariCompilati.setVisible(false);
            titoloQuestionari.setVisible(false);
            TabellaVacanzeView.setVisible(false);
            ChoiceTipoVisualizzazione.setVisible(false);
            ChoiceDestinazione.setVisible(false);
            TestoFiltro.setVisible(false);
            TestoFiltro2.setVisible(false);
            titolo.setText("CERTIFICATI:");
            titolo.setVisible(true);
            colNomeLivello.setCellValueFactory(new PropertyValueFactory<Level, String>("NomeLivello"));
            colNomeLivello.setText("Livello");
            colNomeLivello.setStyle("-fx-alignment: CENTER;");
            colLinguaLivello.setCellValueFactory(new PropertyValueFactory<Level, String>("LinguaLivello"));
            colLinguaLivello.setText("Lingua");
            colLinguaLivello.setStyle("-fx-alignment: CENTER;");
            colDataLivello.setCellValueFactory(new PropertyValueFactory<Level, String>("DataLivello"));
            colDataLivello.setText("Data di conseguimento");
            colDataLivello.setStyle("-fx-alignment: CENTER;");
            TabellaCertificati.getColumns().clear();
            data_certificate = FXCollections.observableArrayList();
            data_certificate.clear();
            String todayString = input.format(todayDate);
            todayDate = input.parse(todayString);
            String query = "SELECT vacanza_famiglia.data_partenza AS data_partenza, vacanza_famiglia.durata AS durata, vacanza_famiglia.lingua AS lingua, vacanza_famiglia.codice AS codice FROM vacanza_famiglia, prenotazione_famiglia, ragazzo WHERE vacanza_famiglia.codice = prenotazione_famiglia.codice_vacanza AND ragazzo.cf = '" + CF + "' AND ragazzo.cf = prenotazione_famiglia.\"CF_ragazzo\";";
            ResultSet rs = databaseOperation.SQL_return(query);
            // famiglia
            viewCertificateTable(rs);
            // college
            query = "SELECT vacanza_college.data_partenza AS data_partenza, vacanza_college.durata, vacanza_college.lingua AS lingua, vacanza_college.codice AS codice FROM vacanza_college, prenotazione_college, ragazzo WHERE vacanza_college.codice = prenotazione_college.codice_vacanza AND ragazzo.cf = '" + CF + "' AND ragazzo.cf = prenotazione_college.\"CF_ragazzo\";";
            rs = databaseOperation.SQL_return(query);
            viewCertificateTable(rs);
            TabellaCertificati.setItems(data_certificate);
            TabellaCertificati.getColumns().addAll(colNomeLivello, colLinguaLivello, colDataLivello);
            TabellaCertificati.setVisible(true);
            TabellaCertificati.setPlaceholder(new Label("L'utente non ha ancora ricevuto certificati."));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void viewCertificateTable(ResultSet rs) throws SQLException, ParseException {
        while (rs.next()) {
            System.out.println("Codice vacanza: " + rs.getString("codice"));
            String vacation_date = rs.getString("data_partenza");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(input.parse(vacation_date));
            Integer durata = rs.getInt("durata");
            calendar.add(Calendar.WEEK_OF_YEAR, durata);
            Date VacationplusDurata = calendar.getTime();
            // se la vacanza è già terminata ritorna le vacanze college e famiglia già terminate
            System.out.println("Data di oggi: " + todayDate + " Data di inizio vacanza: " + vacation_date + " Durata: " + durata + " Data fine vacanza: " + VacationplusDurata);
            if (VacationplusDurata.before(todayDate)) {
                // se un certificato con questa lingua ancora non esiste in conseguimento
                Calendar calendar_vacanza = Calendar.getInstance();
                calendar_vacanza.setTime(rs.getDate("data_partenza"));
                calendar_vacanza.add(Calendar.WEEK_OF_YEAR, rs.getInt("durata"));
                Date dataFineVacanza = calendar_vacanza.getTime();
                String lingua = Character.toLowerCase(rs.getString("lingua").charAt(0)) + rs.getString("lingua").substring(1);
                String query_cerca = "SELECT * FROM conseguimento WHERE \"CF_ragazzo\" = '" + CF + "' AND lingua = '" + lingua + "';";
                ResultSet rs_cerca = databaseOperation.SQL_return(query_cerca);
                if (!rs_cerca.next()) {
                    String query_livello = "SELECT nome_livello FROM livello WHERE lingua = '" + lingua + "' ORDER BY random();";
                    ResultSet rs_livello = databaseOperation.SQL_return(query_livello);
                    rs_livello.next();
                    String query_inserisci = "INSERT INTO conseguimento (\"CF_ragazzo\", lingua, nome_livello, data_conseguimento) VALUES ('" + CF + "', '" + lingua + "', '" + rs_livello.getString("nome_livello") + "', '" + dataFineVacanza + "');";
                    databaseOperation.SQL_insert(query_inserisci);
                }
                query_cerca = "SELECT * FROM conseguimento WHERE \"CF_ragazzo\" = '" + CF + "' AND lingua = '" + lingua + "' AND data_conseguimento = '" + dataFineVacanza  +"';";
                rs_cerca = databaseOperation.SQL_return(query_cerca);
                while(rs_cerca.next()) {
                    Level livello = new Level();
                    livello.LinguaLivello.set(rs_cerca.getString("lingua"));
                    livello.NomeLivello.set(rs_cerca.getString("nome_livello"));
                    livello.DataLivello.set(output.format(dataFineVacanza));
                    data_certificate.add(livello);
                }
            }
        }
    }

    public void showQuestionari(ActionEvent actionEvent) throws SQLException {
        worldmap.setVisible(false);
        testoScelta.setVisible(false);
        college.setVisible(false);
        famiglia.setVisible(false);
        vacanze_college_info.setVisible(false);
        vacanze_famiglia_info.setVisible(false);
        TabellaVacanze.setVisible(false);
        ChoiceBoxCatalogo.setVisible(false);
        confirmation.setVisible(false);
        Scroll.setVisible(false);
        InfoQuestionarioCollege.setVisible(false);
        InfoQuestionarioFamiglia.setVisible(false);
        TabellaPagamenti.setVisible(false);
        TabellaCertificati.setVisible(false);
        TabellaVacanzeView.setVisible(false);
        ChoiceTipoVisualizzazione.setVisible(false);
        ChoiceDestinazione.setVisible(false);
        TestoFiltro.setVisible(false);
        TestoFiltro2.setVisible(false);
        titolo.setText("QUESTIONARI DA COMPILARE:");
        titoloQuestionari.setVisible(true);
        titolo.setVisible(true);
        assert TabellaQuestionari != null : "fx:id=\"TabellaQuestionari\" was not injected: check your FXML file 'Home.fxml'.";
        colCittàQuestionario.setCellValueFactory(new PropertyValueFactory<Questionario, String>("CittàQuestionario"));
        colCittàQuestionario.setText("Città");
        colCittàQuestionario.setStyle("-fx-alignment: CENTER;");
        colDataQuestionario.setCellValueFactory(new PropertyValueFactory<Questionario, String>("DataQuestionario"));
        colDataQuestionario.setText("Data di partenza");
        colDataQuestionario.setStyle("-fx-alignment: CENTER;");
        colTipoQuestionario.setCellValueFactory(new PropertyValueFactory<Questionario, String>("TipoQuestionario"));
        colTipoQuestionario.setText("Tipo");
        colTipoQuestionario.setStyle("-fx-alignment: CENTER;");
        // set column with buttons for each row
        Callback<TableColumn<Questionario, String>, TableCell<Questionario, String>> cellFactory
                = //
                new Callback<TableColumn<Questionario, String>, TableCell<Questionario, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Questionario, String> param) {
                        final TableCell<Questionario, String> cell = new TableCell<Questionario, String>() {

                            final Button btn = new Button("Compila");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        Questionario questionario = getTableView().getItems().get(getIndex());
                                        String CittàQuestionario = questionario.getCittàQuestionario();
                                        String DataQuestionario = questionario.getDataQuestionario();
                                        CodiceQuestionario = questionario.getCodiceQuestionario();
                                        TipoQuestionario = questionario.getTipoQuestionario();
                                        try {
                                            CompilaQuestionario(CittàQuestionario,DataQuestionario);
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
        colBottoneQuestionario.setStyle("-fx-alignment: CENTER;");
        colBottoneQuestionario.setCellFactory(cellFactory);
        colBottoneQuestionario.setText("Visualizza");
        // clear table
        TabellaQuestionari.setPlaceholder(new Label("Non è presente alcun questionario da compilare."));
        TabellaQuestionari.getColumns().clear();
        data_questionario = FXCollections.observableArrayList();
        // clear data
        data_questionario.clear();
        try {
            tipo_vacanza = null;
            // famiglia
            String query = "SELECT codice_vacanza_famiglia AS codice_vacanza FROM questionario_famiglia WHERE \"CF_ragazzo\" = '" + CF + "' AND status = false;";
            tipo_vacanza = "famiglia";
            ResultSet rs = databaseOperation.SQL_return(query);
            TabellaQuestionari.setItems(FillQuestionario(rs, tipo_vacanza));
            // college
            query = "SELECT codice_vacanza_college AS codice_vacanza FROM questionario_college WHERE \"CF_ragazzo\" = '" + CF + "' AND status = false;";
            rs = databaseOperation.SQL_return(query);
            tipo_vacanza = "college";
            TabellaQuestionari.setItems(FillQuestionario(rs, tipo_vacanza));
            TabellaQuestionari.getColumns().addAll(colCittàQuestionario, colDataQuestionario, colTipoQuestionario, colBottoneQuestionario);
            TabellaQuestionari.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        // questionari compilati
        assert TabellaQuestionariCompilati != null : "fx:id=\"TabellaQuestionariCompilati\" was not injected: check your FXML file 'Home.fxml'.";
        colCittàQuestionarioCompilato.setCellValueFactory(new PropertyValueFactory<Questionario, String>("CittàQuestionario"));
        colCittàQuestionarioCompilato.setText("Città");
        colCittàQuestionarioCompilato.setStyle("-fx-alignment: CENTER;");
        colDataQuestionarioCompilato.setCellValueFactory(new PropertyValueFactory<Questionario, String>("DataQuestionario"));
        colDataQuestionarioCompilato.setText("Data di partenza");
        colDataQuestionarioCompilato.setStyle("-fx-alignment: CENTER;");
        colTipoQuestionarioCompilato.setCellValueFactory(new PropertyValueFactory<Questionario, String>("TipoQuestionario"));
        colTipoQuestionarioCompilato.setText("Tipo");
        colTipoQuestionarioCompilato.setStyle("-fx-alignment: CENTER;");
        colVotoQuestionarioCompilato.setCellValueFactory(new PropertyValueFactory<Questionario, String>("VotoQuestionario"));
        colVotoQuestionarioCompilato.setText("Voto");
        colVotoQuestionarioCompilato.setStyle("-fx-alignment: CENTER;");
        colCommentoQuestionarioCompilato.setCellFactory(tc -> {
            colCommentoQuestionarioCompilato.setCellValueFactory(new PropertyValueFactory<Questionario, String>("CommentoQuestionario"));
            TableCell<Questionario, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(colCommentoQuestionarioCompilato.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        });
        colCommentoQuestionarioCompilato.setText("Commento");
        // clear table
        TabellaQuestionariCompilati.setPlaceholder(new Label("Non è presente alcun questionario compilato."));
        TabellaQuestionariCompilati.getColumns().clear();
        data_questionario = FXCollections.observableArrayList();
        // clear data
        data_questionario.clear();
        try {
            tipo_vacanza = null;
            // famiglia
            String query = "SELECT * FROM questionario_famiglia WHERE \"CF_ragazzo\" = '" + CF + "' AND status = true;";
            tipo_vacanza = "famiglia";
            ResultSet rs = databaseOperation.SQL_return(query);
            TabellaQuestionariCompilati.setItems(FillQuestionarioCompilato(rs, tipo_vacanza));
            // college
            query = "SELECT * FROM questionario_college WHERE \"CF_ragazzo\" = '" + CF + "' AND status = true;";
            rs = databaseOperation.SQL_return(query);
            tipo_vacanza = "college";
            TabellaQuestionariCompilati.setItems(FillQuestionarioCompilato(rs, tipo_vacanza));
            TabellaQuestionariCompilati.getColumns().addAll(colCittàQuestionarioCompilato, colDataQuestionarioCompilato, colTipoQuestionarioCompilato, colVotoQuestionarioCompilato, colCommentoQuestionarioCompilato);
            TabellaQuestionariCompilati.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public ObservableList<Questionario> FillQuestionario(ResultSet rs, String tipo_vacanza) throws SQLException {
        try {
            String todayString = input.format(todayDate);
            todayDate = input.parse(todayString);
            while(rs.next()) {
                Integer codice_vacanza = rs.getInt("codice_vacanza");
                String query = "SELECT * FROM vacanza_" + tipo_vacanza + " WHERE codice = '" + codice_vacanza + "';";
                ResultSet rs_vacanza = databaseOperation.SQL_return(query);
                rs_vacanza.next();
                Questionario questionario = new Questionario();
                questionario.CittàQuestionario.set(capitalize(rs_vacanza.getString("città")));
                questionario.DataQuestionario.set(output.format(rs_vacanza.getDate("data_partenza")));
                String vacation_date = rs_vacanza.getString("data_partenza");
                questionario.TipoQuestionario.set(capitalize(tipo_vacanza));
                questionario.CodiceQuestionario.set(codice_vacanza);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(input.parse(vacation_date));
                Integer durata = rs_vacanza.getInt("durata");
                calendar.add(Calendar.WEEK_OF_YEAR, durata);
                Date VacationplusDurata = calendar.getTime();
                System.out.println("Data di oggi: " + todayDate + " Data di partenza: " + vacation_date + " Durata: " + durata + " Data fine: " + VacationplusDurata);
                if (VacationplusDurata.before(todayDate)) {
                    data_questionario.add(questionario);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return data_questionario;
    }

    public ObservableList<Questionario> FillQuestionarioCompilato(ResultSet rs, String tipo_vacanza) throws SQLException {
        try {
            String todayString = input.format(todayDate);
            todayDate = input.parse(todayString);
            while(rs.next()) {
                Integer codice_vacanza = rs.getInt("codice_vacanza_" + tipo_vacanza);
                String query = "SELECT * FROM vacanza_" + tipo_vacanza + " WHERE codice = '" + codice_vacanza + "';";
                ResultSet rs_vacanza = databaseOperation.SQL_return(query);
                rs_vacanza.next();
                Questionario questionario = new Questionario();
                questionario.CittàQuestionario.set(capitalize(rs_vacanza.getString("città")));
                questionario.DataQuestionario.set(output.format(rs_vacanza.getDate("data_partenza")));
                questionario.TipoQuestionario.set(capitalize(tipo_vacanza));
                questionario.VotoQuestionario.set(rs.getInt("voto"));
                if (rs.getString("commento").equals("<null>")) {
                    questionario.CommentoQuestionario.set("Nessun commento");
                }
                else {
                    questionario.CommentoQuestionario.set(rs.getString("commento"));
                }
                data_questionario.add(questionario);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return data_questionario;
    }

    private void CompilaQuestionario(String cittàQuestionario, String dataQuestionario) throws SQLException {
        TabellaQuestionari.setVisible(false);
        ObservableList<Object> voto = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        TabellaQuestionariCompilati.setVisible(false);
        titoloQuestionari.setVisible(false);
        try {
            if (TipoQuestionario.equals("Famiglia")) {
                VotoQuestionarioFamiglia.setItems(voto);
                InfoQuestionarioFamiglia.setVisible(true);
                String query = "SELECT * FROM vacanza_famiglia WHERE codice = '" + CodiceQuestionario + "';";
                ResultSet rs = databaseOperation.SQL_return(query);
                while (rs.next()) {
                    nomeFamigliaQuestionario.setText(rs.getString("nome_capo_fam"));
                    cognomeFamigliaQuestionario.setText(rs.getString("cognome_capo_fam"));
                    linguaTextQuestionarioFamiglia.setText(capitalize(rs.getString("lingua")));
                    linguaTextQuestionarioCollege.setText(capitalize(rs.getString("lingua")));
                    if (rs.getInt("durata") > 1) {
                        durataTextQuestionarioFamiglia.setText(rs.getInt("durata") + " settimane");
                    } else {
                        durataTextQuestionarioFamiglia.setText(rs.getInt("durata") + " settimana");
                    }
                }
                InfoQuestionarioFamiglia.setVisible(true);
                cittàTextQuestionarioFamiglia.setText(cittàQuestionario);
                dataTextQuestionarioFamiglia.setText(dataQuestionario);
            } else if (TipoQuestionario.equals("College")) {
                VotoQuestionarioCollege.setItems(voto);
                InfoQuestionarioCollege.setVisible(true);
                String query = "SELECT * FROM vacanza_college WHERE codice = '" + CodiceQuestionario + "';";
                ResultSet rs = databaseOperation.SQL_return(query);
                while (rs.next()) {
                    nomeCollegeQuestionarioCollege.setText(rs.getString("nome_college"));
                    indirizzoCollegeQuestionario.setText(rs.getString("indirizzo_college"));
                    linguaTextQuestionarioCollege.setText(rs.getString("lingua"));
                    if (rs.getInt("durata") > 1) {
                        durataTextQuestionarioCollege.setText(rs.getInt("durata") + " settimane");
                    } else {
                        durataTextQuestionarioCollege.setText(rs.getInt("durata") + " settimana");
                    }
                }
                InfoQuestionarioCollege.setVisible(true);
                cittàTextQuestionarioCollege.setText(cittàQuestionario);
                dataTextQuestionarioCollege.setText(dataQuestionario);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void CompilaButton(MouseEvent mouseEvent) throws SQLException {
        if (selectedGrade == null) {
            Alert alertIncorrect = new Alert(Alert.AlertType.ERROR);
            alertIncorrect.setHeaderText(null);
            alertIncorrect.setContentText("Inserire il voto.");
            alertIncorrect.showAndWait();
        }
        else {
            // ho inserito sia voto che commento
            String commento = null;
            if (TipoQuestionario.equals("College")) {
                commento = commentoQuestionarioCollege.getText();
            }
            else if (TipoQuestionario.equals("Famiglia")) {
                commento = commentoQuestionarioFamiglia.getText();
            }
            if (commento != null) {
                String query = "UPDATE questionario_" + Character.toLowerCase(TipoQuestionario.charAt(0)) + TipoQuestionario.substring(1) + " SET voto='" + selectedGrade + "', commento = '" + commento + "', status = true WHERE codice_vacanza_" + Character.toLowerCase(TipoQuestionario.charAt(0)) + TipoQuestionario.substring(1) + "='" + CodiceQuestionario + "' AND \"CF_ragazzo\" = '" + CF + "';";
                try {
                    databaseOperation.SQL_insert(query);
                    Alert alertIncorrect = new Alert(Alert.AlertType.INFORMATION);
                    alertIncorrect.setHeaderText(null);
                    alertIncorrect.setContentText("Questionario compilato!");
                    alertIncorrect.showAndWait();
                    InfoQuestionarioFamiglia.setVisible(false);
                    InfoQuestionarioCollege.setVisible(false);
                    titolo.setVisible(false);
                    worldmap.setVisible(true);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
            else {
                String query = "UPDATE questionario_" + Character.toLowerCase(TipoQuestionario.charAt(0)) + TipoQuestionario.substring(1) + " SET voto='" + selectedGrade + "', status = true WHERE codice_vacanza_" + Character.toLowerCase(TipoQuestionario.charAt(0)) + TipoQuestionario.substring(1) + "='" + CodiceQuestionario + "' AND \"CF_ragazzo\" = '" + CF + "';";
                try {
                    databaseOperation.SQL_insert(query);
                    Alert alertIncorrect = new Alert(Alert.AlertType.INFORMATION);
                    alertIncorrect.setHeaderText(null);
                    alertIncorrect.setContentText("Questionario compilato!");
                    alertIncorrect.showAndWait();
                    InfoQuestionarioFamiglia.setVisible(false);
                    InfoQuestionarioCollege.setVisible(false);
                    titolo.setVisible(false);
                    worldmap.setVisible(true);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public void InitializeVoto(MouseEvent mouseEvent) {
        System.out.println("TIPO: " + TipoQuestionario);
        //if (TipoQuestionario == ("College")) {
            VotoQuestionarioCollege.setOnAction((event) -> {
                System.out.println("Questionario College, sono nell'if");
                selectedGrade = null;
                selectedGrade = VotoQuestionarioCollege.getValue();
            });
        //}
        //else if (TipoQuestionario == ("Famiglia")) {
            VotoQuestionarioFamiglia.setOnAction((event) -> {
                System.out.println("Questionario Famiglia, sono nell'if");
                selectedGrade = null;
                selectedGrade = VotoQuestionarioFamiglia.getValue();
            });
        //}
    }

    public void showVacations(ActionEvent actionEvent) throws SQLException {
        worldmap.setVisible(false);
        testoScelta.setVisible(false);
        college.setVisible(false);
        famiglia.setVisible(false);
        vacanze_college_info.setVisible(false);
        vacanze_famiglia_info.setVisible(false);
        TabellaVacanze.setVisible(false);
        ChoiceBoxCatalogo.setVisible(false);
        confirmation.setVisible(false);
        Scroll.setVisible(false);
        titolo.setVisible(true);
        InfoQuestionarioCollege.setVisible(false);
        InfoQuestionarioFamiglia.setVisible(false);
        TabellaPagamenti.setVisible(false);
        TabellaCertificati.setVisible(false);
        TabellaVacanzeView.setVisible(false);
        ChoiceTipoVisualizzazione.setVisible(false);
        ChoiceDestinazione.setVisible(false);
        TestoFiltro.setVisible(false);
        TestoFiltro2.setVisible(false);
        titoloQuestionari.setVisible(false);
        TabellaQuestionari.setVisible(false);
        TabellaQuestionariCompilati.setVisible(false);
        //TabellaVacanzeView.setVisible(true);
        ObservableList<Object> viewOptions = FXCollections.observableArrayList("Famiglia", "College");
        ChoiceTipoVisualizzazione.setItems(viewOptions);
        ChoiceTipoVisualizzazione.setVisible(true);
        titolo.setText("VACANZE");
        TestoFiltro.setVisible(true);
    }

    private ObservableList<Vacanze> FillTableViewVacanze(ResultSet rs, Object selectedViewType) throws Exception {
        try {
            String todayString = input.format(todayDate);
            todayDate = input.parse(todayString);
            while (rs.next()) {
                Vacanze vacanze = new Vacanze();
                String date = rs.getString("data_partenza");
                Date dateValue = input.parse(date);
                System.out.println("Data di partenza: " + dateValue + " Data di oggi: " + todayDate);
                vacanze.Codice.set(rs.getInt("codice"));
                vacanze.Durata.set(rs.getInt("durata"));
                vacanze.Lingua.set(capitalize(rs.getString("lingua")));
                vacanze.Città.set((capitalize(rs.getString("città"))));
                vacanze.DataPartenza.set(output.format(dateValue));
                if (selectedViewType.equals("Famiglia")) {
                    vacanze.Famiglia.set(capitalize(rs.getString("cognome_capo_fam")));
                }
                // check if data_partenza is after today
                if (input.parse(date).after(todayDate)) {
                    vacanze.Effettuata.set(("NO"));
                }
                else {
                    vacanze.Effettuata.set(("SI"));
                }
                dataViewVacanza.add(vacanze);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return dataViewVacanza;
    }

    public void TableColumnsViewVacations(Object selectedViewType) {
        System.out.println("QUI");
        assert TabellaVacanzeView != null : "fx:id=\"TabellaVacanzeView\" was not injected: check your FXML file 'Home.fxml'.";
        // setCellValueFactory for each column
        colCittàVacanze.setCellValueFactory(new PropertyValueFactory<Vacanze, String>("Città"));
        colCittàVacanze.setText("Città");
        colCittàVacanze.setStyle("-fx-alignment: CENTER;");
        colLinguaVacanze.setCellValueFactory(new PropertyValueFactory<Vacanze, String>("Lingua"));
        colLinguaVacanze.setText("Lingua");
        colLinguaVacanze.setStyle("-fx-alignment: CENTER;");
        colDurataVacanze.setCellValueFactory(new PropertyValueFactory<Vacanze, Integer>("Durata"));
        colDurataVacanze.setText("Durata");
        colDurataVacanze.setStyle("-fx-alignment: CENTER;");
        colDataVacanze.setCellValueFactory(new PropertyValueFactory<Vacanze, String>("DataPartenza"));
        colDataVacanze.setText("Data di partenza");
        colDataVacanze.setStyle("-fx-alignment: CENTER;");
        colEffettuataVacanza.setCellValueFactory(new PropertyValueFactory<Vacanze, String>("Effettuata"));
        colEffettuataVacanza.setText("Effettuata");
        colEffettuataVacanza.setStyle("-fx-alignment: CENTER;");
        if (selectedViewType == "Famiglia") {
            colFamigliaVacanze.setCellValueFactory(new PropertyValueFactory<Vacanze, String>("Famiglia"));
            colFamigliaVacanze.setEditable(false);
            colFamigliaVacanze.setSortable(false);
            colFamigliaVacanze.setText("Famiglia");
            colFamigliaVacanze.setStyle("-fx-alignment: CENTER;");
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
                                        Vacanze vacanze = getTableView().getItems().get(getIndex());
                                        Integer codiceSceltaVacanza = vacanze.getCodice();
                                        if (selectedViewType == "Famiglia") {
                                            try {
                                                ViewInfoBookedFamiglia(codiceSceltaVacanza);
                                            } catch (Exception ex) {
                                                System.out.println(ex);
                                            }
                                        }
                                        else if (selectedViewType == "College") {
                                            try {
                                                ViewInfoBookedCollege(codiceSceltaVacanza);
                                            }
                                            catch (Exception ex) {
                                                System.out.println(ex);
                                            }
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
        colBottoneVacanza.setStyle("-fx-alignment: CENTER;");
        colBottoneVacanza.setCellFactory(cellFactory);
        colBottoneVacanza.setText("Visualizza");
    }

    private void ViewInfoBookedCollege(Integer codiceSceltaVacanza) throws Exception {
        vacanze_college_info.setVisible(true);
        PrenotaCollege.setVisible(false);
        TornaCatalogoCollege.setVisible(false);
        ChoiceTipoVisualizzazione.setVisible(false);
        ChoiceDestinazione.setVisible(false);
        TestoFiltro.setVisible(false);
        TestoFiltro2.setVisible(false);
        metodoPagamentoCollege.setVisible(false);
        titolo.setText("DETTAGLI VACANZA:");
        TabellaVacanzeView.setVisible(false);
        try {
            String query = "SELECT città, lingua, nome_college, indirizzo_college, data_partenza, durata FROM vacanza_college WHERE codice = " + codiceSceltaVacanza + ";";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            cittàTextCollege.setText(capitalize(rs.getString("città")));
            if (rs.getInt("durata") > 1) {
                durataTextCollege.setText(rs.getString("durata") + " settimane");
            } else {
                durataTextCollege.setText(rs.getString("durata") + " settimana");
            }
            linguaTextCollege.setText(capitalize(rs.getString("lingua")));
            dataTextCollege.setText(rs.getString("data_partenza"));
            nomeCollege.setText(capitalize(rs.getString("nome_college")));
            indirizzoCollege.setText(capitalize(rs.getString("indirizzo_college")));
            roomChoice.setVisible(false);
            query = "SELECT nome_compagno, tipo_camera FROM prenotazione_college WHERE codice_vacanza = '" + codiceSceltaVacanza + "' AND \"CF_ragazzo\" = '" + CF + "';";
            rs = databaseOperation.SQL_return(query);
            rs.next();
            String nomeCompagno = rs.getString("nome_compagno");
            String tipoCamera = rs.getString("tipo_camera");
            TipoCameraCollege.setVisible(true);
            TipoCameraCollegeText.setVisible(true);
            TipoCameraCollegeText.setText(tipoCamera);
            NomeCompagnoCollege.setVisible(true);
            NomeCompagnoCollegeText.setVisible(true);
            if (nomeCompagno.equals("null")) {
                NomeCompagnoCollegeText.setText("Nessun compagno");
            }
            else {
                NomeCompagnoCollegeText.setText(nomeCompagno);
            }
            testo_preferenze.setText("Dati del compagno: ");
            nomeAmicoText.setEditable(false);
            mailAmicoText.setEditable(false);
            vacanze_college_info.setVisible(true);
            vacanze_college_info.setVvalue(vacanze_college_info.getVmin());
            // view attività
            assert tabellaAttività != null : "fx:id=\"tabellaAttività\" was not injected: check your FXML file 'Home.fxml'.";
            // setCellValueFactory for each column
            colNomeAttività.setText("Nome dell'attività");
            colNomeAttività.setStyle("-fx-alignment: JUSTIFY;");
            colDescrizioneAttività.setText("Descrizione dell'attività");
            colDescrizioneAttività.setStyle("-fx-alignment: JUSTIFY;");
            // setCellFactory for text wrapping
            colNomeAttività.setCellFactory(tc -> {
                colNomeAttività.setCellValueFactory(new PropertyValueFactory<Activity, String>("Nome"));
                TableCell<Activity, String> cell = new TableCell<>();
                Text text = new Text();
                cell.setGraphic(text);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(colNomeAttività.widthProperty());
                text.textProperty().bind(cell.itemProperty());
                return cell;
            });
            colDescrizioneAttività.setCellFactory(tc -> {
                colDescrizioneAttività.setCellValueFactory(new PropertyValueFactory<Activity, String>("Descrizione"));
                TableCell<Activity, String> cell = new TableCell<>();
                Text text = new Text();
                cell.setGraphic(text);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(colDescrizioneAttività.widthProperty());
                text.textProperty().bind(cell.itemProperty());
                return cell;
            });
            query = "SELECT * FROM proposta_college WHERE codice_college = " + codiceSceltaVacanza + ";";
            rs = databaseOperation.SQL_return(query);
            // clear table
            tabellaAttività.getColumns().clear();
            tabellaAttività.setPlaceholder(new Label("Ci dispiace, non sono previste attività per questa vacanza."));
            data_activity = FXCollections.observableArrayList();
            // clear data
            data_activity.clear();
            while (rs.next()) {
                Activity activity = new Activity();
                activity.Nome.set(capitalize(rs.getString("nome_attivita")));
                activity.Descrizione.set(capitalize(rs.getString("descrizione_attivita")));
                data_activity.add(activity);
            }
            tabellaAttività.setItems(data_activity);
            tabellaAttività.getColumns().addAll(colNomeAttività, colDescrizioneAttività);
            // view Gite
            assert tabellaGiteCollege != null : "fx:id=\"tabellaGite\" was not injected: check your FXML file 'Home.fxml'.";
            // setCellValueFactory for each column
            colDestinazioneCollege.setCellValueFactory(new PropertyValueFactory<Gita, String>("Destinazione"));
            colDestinazioneCollege.setText("Destinazione");
            colDestinazioneCollege.setStyle("-fx-alignment: CENTER;");
            colCostoCollege.setCellValueFactory(new PropertyValueFactory<Gita, Integer>("Costo"));
            colCostoCollege.setText("Prezzo");
            colCostoCollege.setStyle("-fx-alignment: CENTER;");
            colOreCollege.setCellValueFactory(new PropertyValueFactory<Gita, Integer>("Ore"));
            colOreCollege.setText("Ore");
            colOreCollege.setStyle("-fx-alignment: CENTER;");
            //colDescrizione.setCellValueFactory(new PropertyValueFactory<Gita,String>("Descrizione"));
            colDescrizioneCollege.setText("Descrizione");
            // setCellFactory for text wrapping
            colDescrizioneCollege.setCellFactory(tc -> {
                colDescrizioneCollege.setCellValueFactory(new PropertyValueFactory<Gita, String>("Descrizione"));
                TableCell<Gita, String> cell = new TableCell<>();
                Text text = new Text();
                cell.setGraphic(text);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(colDescrizioneCollege.widthProperty());
                text.textProperty().bind(cell.itemProperty());
                return cell;
            });
            query = "SELECT * FROM gita, pianificazione_famiglia WHERE id_vacanza = " + codiceSceltaVacanza + "AND id_gita = id;";
            rs = databaseOperation.SQL_return(query);
            // clear table
            tabellaGiteCollege.setPlaceholder(new Label("Ci dispiace, non è prevista alcuna gita per questa vacanza."));
            tabellaGiteCollege.getColumns().clear();
            data_gita_college = FXCollections.observableArrayList();
            // clear data
            data_gita_college.clear();
            while (rs.next()) {
                Gita gita = new Gita();
                gita.Costo.set(rs.getString("costo") + "€");
                gita.Descrizione.set(rs.getString("descrizione"));
                gita.Destinazione.set(rs.getString("destinazione"));
                gita.Ore.set(rs.getInt("num_ore"));
                data_gita_college.add(gita);
            }
            tabellaGiteCollege.setItems(data_gita_college);
            tabellaGiteCollege.getColumns().addAll(colDestinazioneCollege, colDescrizioneCollege, colOreCollege, colCostoCollege);
            testo_preferenze_college.setVisible(false);
            roomChoice.setVisible(false);
            ChoicePagamentoCollege.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void ViewInfoBookedFamiglia(Integer codiceSceltaVacanza) throws SQLException {
        vacanze_famiglia_info.setVisible(true);
        PrenotaFamiglia.setVisible(false);
        TornaCatalogoFamiglia.setVisible(false);
        ChoiceTipoVisualizzazione.setVisible(false);
        ChoiceDestinazione.setVisible(false);
        TestoFiltro.setVisible(false);
        TestoFiltro2.setVisible(false);
        metodoPagamentoFamiglia.setVisible(false);
        titolo.setText("DETTAGLI VACANZA:");
        TabellaVacanzeView.setVisible(false);
        try {
            String query_vacanza = "SELECT * from vacanza_famiglia WHERE codice = '" + codiceSceltaVacanza + "';";
            ResultSet rs_vacanza = databaseOperation.SQL_return(query_vacanza);
            rs_vacanza.next();
            // get scrollpane back to the top
            vacanze_famiglia_info.setVvalue(vacanze_famiglia_info.getVmin());
            vacanze_famiglia_info.setVisible(true);
            cittàText.setText(capitalize(rs_vacanza.getString("città")));
            if (rs_vacanza.getInt("durata") > 1) {
                durataText.setText(rs_vacanza.getInt("durata") + " settimane");
            } else {
                durataText.setText(rs_vacanza.getInt("durata") + " settimana");
            }
            linguaText.setText(capitalize(rs_vacanza.getString("lingua")));
            dataText.setText(rs_vacanza.getString("data_partenza"));
            nomeFamigliaText.setText(capitalize(rs_vacanza.getString("nome_capo_fam")));
            cognomeFamigliaText.setText(capitalize(rs_vacanza.getString("cognome_capo_fam")));
            if (Integer.parseInt(rs_vacanza.getString("num_componenti")) == 1) {
                componentiText.setText(rs_vacanza.getString("num_componenti") + " componente");
            } else {
                componentiText.setText(rs_vacanza.getString("num_componenti") + " componenti");
            }
            if (Integer.parseInt(rs_vacanza.getString("num_camere")) == 1) {
                camereText.setText(rs_vacanza.getString("num_camere") + " camera");
            } else {
                camereText.setText(rs_vacanza.getString("num_camere") + " camere");
            }
            if (Integer.parseInt(rs_vacanza.getString("num_bagni")) == 1) {
                bagniText.setText(rs_vacanza.getString("num_bagni") + " bagno");
            } else {
                bagniText.setText(rs_vacanza.getString("num_bagni") + " bagni");
            }
            if (Integer.parseInt(rs_vacanza.getString("num_animali")) == 0) {
                animaliText.setText("Nessun animale");
            } else if (Integer.parseInt(rs_vacanza.getString("num_animali")) == 1) {
                animaliText.setText(rs_vacanza.getString("num_animali") + " animale");
            } else if (Integer.parseInt(rs_vacanza.getString("num_animali")) > 1) {
                animaliText.setText(rs_vacanza.getString("num_animali") + " animali");
            }
            String query = "SELECT nome_compagno, email_compagno FROM prenotazione_famiglia WHERE codice_vacanza = '" + codiceSceltaVacanza + "' AND \"CF_ragazzo\" = '" + CF + "';";
            ResultSet rs = databaseOperation.SQL_return(query);
            rs.next();
            testo_preferenze.setText("Dati del compagno: ");
            nomeAmicoText.setEditable(false);
            nomeAmicoText.setText(rs.getString("nome_compagno"));
            mailAmicoText.setEditable(false);
            mailAmicoText.setText(rs.getString("email_compagno"));
            // view Gite
            assert tabellaGite != null : "fx:id=\"tabellaGite\" was not injected: check your FXML file 'Home.fxml'.";
            // setCellValueFactory for each column
            colDestinazione.setCellValueFactory(new PropertyValueFactory<Gita, String>("Destinazione"));
            colDestinazione.setText("Destinazione");
            colDestinazione.setStyle("-fx-alignment: CENTER;");
            colCosto.setCellValueFactory(new PropertyValueFactory<Gita, Integer>("Costo"));
            colCosto.setText("Prezzo");
            colCosto.setStyle("-fx-alignment: CENTER;");
            colOre.setCellValueFactory(new PropertyValueFactory<Gita, Integer>("Ore"));
            colOre.setText("Ore");
            colOre.setStyle("-fx-alignment: CENTER;");
            colDescrizione.setText("Descrizione");
            colDescrizione.setStyle("-fx-alignment: CENTER;");
            // setCellFactory for text wrapping
            colDescrizione.setCellFactory(tc -> {
                colDescrizione.setCellValueFactory(new PropertyValueFactory<Gita, String>("Descrizione"));
                TableCell<Gita, String> cell = new TableCell<>();
                Text text = new Text();
                cell.setGraphic(text);
                cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
                text.wrappingWidthProperty().bind(colDescrizione.widthProperty());
                text.textProperty().bind(cell.itemProperty());
                return cell;
            });
            query = "SELECT * FROM gita, pianificazione_famiglia WHERE id_vacanza = " + codiceSceltaVacanza + "AND id_gita = id;";
            rs = databaseOperation.SQL_return(query);
            // clear table
            tabellaGite.getColumns().clear();
            tabellaGite.setPlaceholder(new Label("Ci dispiace, non è prevista alcuna gita per questa vacanza."));
            data_gita = FXCollections.observableArrayList();
            // clear data
            data_gita.clear();
            while (rs.next()) {
                Gita gita = new Gita();
                gita.Costo.set(rs.getString("costo") + "€");
                gita.Descrizione.set(capitalize(rs.getString("descrizione")));
                gita.Destinazione.set(rs.getString("destinazione"));
                gita.Ore.set(rs.getInt("num_ore"));
                data_gita.add(gita);
            }
            tabellaGite.setItems(data_gita);
            tabellaGite.getColumns().addAll(colDestinazione, colDescrizione, colOre, colCosto);
            ChoicePagamento.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private void showVacations2(Object destinazione) {
        // clear columns
        TabellaVacanzeView.getColumns().clear();
        dataViewVacanza = FXCollections.observableArrayList();
        // clear data
        dataViewVacanza.clear();
        TableColumnsViewVacations(selectedViewType);
        System.out.println(selectedViewType);
        ChoiceDestinazione.setVisible(true);
        String query;
        destinazioni.clear();
        if (selectedViewType == "Famiglia") {
            query = "SELECT vacanza_famiglia.codice, vacanza_famiglia.durata, vacanza_famiglia.data_partenza, vacanza_famiglia.città, vacanza_famiglia.lingua, vacanza_famiglia.cognome_capo_fam FROM vacanza_famiglia, prenotazione_famiglia WHERE vacanza_famiglia.codice = prenotazione_famiglia.codice_vacanza AND \"CF_ragazzo\" = '" + CF + "';";
        } else {
            query = "SELECT vacanza_college.codice, vacanza_college.durata, vacanza_college.data_partenza, vacanza_college.città, vacanza_college.lingua FROM vacanza_college, prenotazione_college WHERE vacanza_college.codice = prenotazione_college.codice_vacanza AND \"CF_ragazzo\" = '" + CF + "';";
        }
            try {
                // query result
                ResultSet rs = databaseOperation.SQL_return(query);
                while (rs.next()) {
                    destinazioni.add(rs.getString("città"));
                }
                ChoiceDestinazione.setVisible(true);
                TestoFiltro2.setVisible(true);
                ChoiceDestinazione.setItems(destinazioni);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        if (selectedViewType == "Famiglia") {
            query = "SELECT vacanza_famiglia.codice, vacanza_famiglia.durata, vacanza_famiglia.data_partenza, vacanza_famiglia.città, vacanza_famiglia.lingua, vacanza_famiglia.cognome_capo_fam FROM vacanza_famiglia, prenotazione_famiglia WHERE vacanza_famiglia.codice = prenotazione_famiglia.codice_vacanza AND \"CF_ragazzo\" = '" + CF + "'" + destinazione + ";";
        } else {
            query = "SELECT vacanza_college.codice, vacanza_college.durata, vacanza_college.data_partenza, vacanza_college.città, vacanza_college.lingua FROM vacanza_college, prenotazione_college WHERE vacanza_college.codice = prenotazione_college.codice_vacanza AND \"CF_ragazzo\" = '" + CF + "'" +  destinazione + ";";
        }
        try {
            ResultSet rs = databaseOperation.SQL_return(query);
            // put results inside of tableview
            dataViewVacanza = FillTableViewVacanze(rs,selectedViewType);
            // add data inside of tableview
            TabellaVacanzeView.setVisible(true);
            TabellaVacanzeView.setItems(dataViewVacanza);
            if (selectedViewType == "Famiglia") {
                TabellaVacanzeView.getColumns().addAll(colCittàVacanze, colDataVacanze, colLinguaVacanze, colDurataVacanze, colFamigliaVacanze, colEffettuataVacanza, colBottoneVacanza);
            } else {
                TabellaVacanzeView.getColumns().addAll(colCittàVacanze, colDataVacanze, colLinguaVacanze, colDurataVacanze, colEffettuataVacanza, colBottoneVacanza);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InitializeTipoVacanzaView(MouseEvent mouseEvent) throws Exception {
        ChoiceTipoVisualizzazione.setOnAction((event) -> {
            selectedViewType = ChoiceTipoVisualizzazione.getValue();
            if (selectedViewType != null) {
                try {
                    showVacations2("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void InitializeDestinazione(MouseEvent mouseEvent) throws SQLException {
            ChoiceDestinazione.setOnAction((event) -> {
                selectedDestinazione = ChoiceDestinazione.getValue();
                if (selectedDestinazione != null) {
                    try {
                        showVacations2("AND città = '" + selectedDestinazione + "'");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}