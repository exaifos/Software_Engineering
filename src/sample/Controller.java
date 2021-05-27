package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;

public class Controller {
    @FXML
    public Button Avanti;
    public ChoiceBox sessoText;
    @FXML
    private TextField userText;
    @FXML
    private PasswordField passText;
    @FXML
    private PasswordField pass2Text;
    @FXML
    public Button Access;
    @FXML
    public Button SignIn;
    @FXML
    public Button Exit;
    @FXML
    public ChoiceBox<Object> luogoNText;
    @FXML
    public TextField filterText;
    public String order;
    public String dataN;
    public String luogoN;
    public Button Nuovo;
    @FXML
    public Button Login;
    @FXML
    public Button Start;
    @FXML
    public DatePicker dataNText;
    @FXML
    private TextField CFText;
    @FXML
    private TextField nomeText;
    @FXML
    private TextField cognomeText;
    @FXML
    private TextField telText;
    @FXML
    private TextField emailText;
    @FXML
    private TextField nomeGenText;
    @FXML
    private TextField cognomeGenText;
    @FXML
    private TextField emailGenText;
    @FXML
    private TextField telGenText;
    @FXML
    private TextArea allergeniText;
    @FXML
    private TextArea precauzioniText;
    @FXML
    private TextArea hobbyText;

    private String nome;
    private String cognome;
    private String user;
    private String pass;
    private String pass2;
    private String email;
    private String sesso;
    private String nomeGen;
    private String cognomeGen;
    private String emailGen;
    private String telGen;
    private String tel;
    private String precauzioni;
    private String allergeni;
    private String hobby;
    private String cf;

    public void handleLoginClick(ActionEvent event) {
        // dobbiamo prendere i dati di login e la password per confrontarli con la base di dati
        String user = userText.getText();
        String pass = passText.getText();
        new Login(user,pass, Access);
    }

    public void filterClick(ActionEvent mouseEvent) {
        try {
            order=filterText.getText();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void dataChoice(ActionEvent mouseEvent) {
        try {
            dataN= dataNText.getValue().toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void handleSignUpClick(MouseEvent mouseEvent) {
        try {
            if (order==null)
                order="VER";
            String query="SELECT comune FROM codice_catasto WHERE comune ILIKE '" + order +"%' ORDER BY comune;";
            ResultSet scelte=databaseOperation.SQL_return(query);
            // System.out.println(scelte.getString(1));
            //    luogoNText.getItems().addAll(scelte.getString("comune"));
            ObservableList<Object> citiesList = FXCollections.observableArrayList();
            while (scelte.next()) {
                citiesList.add(scelte.getString(1));
            }
            luogoNText.setItems(citiesList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void handleExitClick(MouseEvent mouseEvent) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    public void handleRegistrationClick(ActionEvent actionEvent) {

    }

    public void handleRegistrationClick3(MouseEvent actionEvent) {

    }
    public void handleRegistrationClick2(MouseEvent actionEvent) throws SQLException {
        user = userText.getText();
        pass = passText.getText();
        pass2 = pass2Text.getText();
        nome = nomeText.getText();
        cognome = cognomeText.getText();
        email = emailText.getText();
        sesso = sessoText.getValue().toString();
        nomeGen = nomeGenText.getText();
        cognomeGen = cognomeGenText.getText();
        emailGen = emailGenText.getText();
        telGen = telGenText.getText();
        luogoN = luogoNText.getValue().toString();
        dataN= dataNText.getValue().toString();
        tel = telText.getText();
        allergeni = allergeniText.getText();
        precauzioni = allergeniText.getText();
        hobby = hobbyText.getText();
        // controlli
        System.out.println("luogoN: " + luogoN + "\tdataN: " + dataN + "sesso: "+ sesso);
        ZoneId zone = ZoneId.of("Europe/Rome");
        LocalDate today = LocalDate.now(zone);

        // || dataN.isEmpty() || luogoN.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty() || sesso.isEmpty() || nomeGen.isEmpty() || cognomeGen.isEmpty() || emailGen.isEmpty() || telGen.isEmpty()
        if (user.isEmpty() || pass.isEmpty() || pass2.isEmpty() || nome.isEmpty()  ||  luogoN.equals("") || sesso.equals("") || cognome.isEmpty() || email.isEmpty() || nomeGen.isEmpty() || cognomeGen.isEmpty() || emailGen.isEmpty() || telGen.isEmpty()) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire tutti i campi");
            alertMissing.showAndWait();
        } else {
            if (!pass.equals(pass2)) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Le password non corrispondono!");
                alertMissing.showAndWait();
            }
            else  if (!(pass.length()>=8 && pass.matches(".*[a-zA-Z]+.*")))  {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Password non sicura, deve contenere almeno un carattere ed essere lunga almeno 8 caratteri!");
                alertMissing.showAndWait();
            }
            else if (!isValid(email) || !isValid(emailGen)) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Le email non sono valide!");
                alertMissing.showAndWait();
            }
            else if (today.isBefore(dataNText.getValue()) || today.isEqual(dataNText.getValue())) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Data non valida!");
                alertMissing.showAndWait();
            }
            else if (RicercaContenuto.Ricerca("login", user,"ragazzo")) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("User già presente!");
                alertMissing.showAndWait();
            }
        }
        // calcolo CF
        String catasto;
        String queryCat = "SELECT DISTINCT catasto FROM codice_catasto WHERE comune ILIKE  '" + luogoN + "';";
        ResultSet catast = databaseOperation.SQL_return(queryCat);
        catast.next();
        catasto=catast.getString(1);
        cf = calcoloCodiceFiscale.CF_automatico(nome,cognome,catasto,dataN,sesso);
        CFText.setText(cf);
        // inserimento in database
        String query = ("INSERT INTO ragazzo (cf, password, nome, cognome, sesso, data_nascita, luogo_nascita, email, login, telefono, nome_allergene, precauzioni, hobby) " + "VALUES ('" + cf + "', '" + pass + "', '" + nome + "', '" + cognome + "', '" + sesso + "', '" + dataN + "', '" + luogoN + "', '" + email + "', '" + user + "', '" + tel + "', '" + allergeni + "', '" + precauzioni + "', '" + hobby + "');");
        String query2 = ("INSERT INTO genitore (nome, cognome, telefono, email) " + "VALUES ('" + nomeGen + "', '" + cognomeGen + "', '" + telGen + "', '" + emailGen + "');");
        String query3 = ("INSERT INTO tutore (cf, nome_genitore, cognome_genitore, telefono_genitore) " + "VALUES ('" + cf + "', '" + nomeGen + "', '" + cognomeGen + "', '" + telGen + "');");

        databaseOperation.SQL_insert(query);
        databaseOperation.SQL_insert(query2);
        databaseOperation.SQL_insert(query3);
    }

    public void handleSignIpClick(MouseEvent mouseEvent) {
        try {
            Stage stage = (Stage) SignIn.getScene().getWindow();
            stage.close();
            new Registrazione();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void nuovo(MouseEvent mouseEvent){
        try {
            new PaginaPrincipaleLogin();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}