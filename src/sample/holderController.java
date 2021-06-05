package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;

public class holderController {
    @FXML
    public Text titolo;
    public ImageView worldmap;
    public Button nuoveVacanze;
    public Button Exit;
    public ScrollPane scroll;
    public String CF;
    public String utente;
    public Text nomeLogin;
    public Button Avanti;
    public Button newFamiglia;
    public Button newCollege;
    public Pane pannello1;
    public Pane pannello2;
    public Pane pannello3;
    public Pane pannello4;
    public TextField destinazioneText;
    public DatePicker dataPText;
    public TextField durataText;
    public TextField linguaText;
    public TextField college1;
    public TextField indirizzo1;
    public TextField college2;
    public TextField indirizzo2;
    public TextField college3;
    public TextField indirizzo3;
    public TextField college4;
    public TextField indirizzo4;
    public Pane pannello5;
    public Pane pannello6;
    public Pane pannello7;
    public Pane pannello8;
    public TextField nomeFamText1;
    public TextField cognomeText1;
    public TextField dispText1;
    public TextField compText1;
    public TextField distText1;
    public TextField bagniText1;
    public TextField animaliText1;
    public TextField nomeFamText2;
    public TextField cognomeText2;
    public TextField dispText2;
    public TextField compText2;
    public TextField distText2;
    public TextField bagniText2;
    public TextField animaliText2;
    public TextField nomeFamText3;
    public TextField cognomeText3;
    public TextField dispText3;
    public TextField compText3;
    public TextField distText3;
    public TextField bagniText3;
    public TextField animaliText3;
    public TextField nomeFamText4;
    public TextField cognomeText4;
    public TextField dispText4;
    public TextField compText4;
    public TextField distText4;
    public TextField bagniText4;
    public TextField animaliText4;
    public Button Save;
    public TextField ospiti1;
    public TextField ospiti2;
    public TextField ospiti3;
    public TextField ospiti4;


    public void handleExitClick(MouseEvent mouseEvent) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    public void visualizeNewVacation(ActionEvent actionEvent) {
        worldmap.setVisible(false);
        scroll.setVisible(true);
        titolo.setText("Gestione Nuove Vacanze");

    }

    public void visualizeVotes(ActionEvent actionEvent) {
    }


    public void transferMessage(String message1, String message2) {
        //Display the message
        CF = message1;
        utente = message2;
    }


    private int index2 = 1;

    public void newFamilyVacation(ActionEvent actionEvent) {
        if (pannello1.isVisible() && (college1.getText() == null || college1.getText().trim().isEmpty() || indirizzo1.getText() == null || indirizzo1.getText().trim().isEmpty())) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire prima i dati del primo college");
            alertMissing.showAndWait();
        } else if (pannello2.isVisible() && (college2.getText() == null || college2.getText().trim().isEmpty() || indirizzo2.getText() == null || indirizzo2.getText().trim().isEmpty())) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire prima i dati del secondo college");
            alertMissing.showAndWait();
        } else if (pannello3.isVisible() && (college3.getText() == null || college3.getText().trim().isEmpty() || indirizzo3.getText() == null || indirizzo3.getText().trim().isEmpty())) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire prima i dati del terzo college");
            alertMissing.showAndWait();
        } else if (pannello4.isVisible() && (college4.getText() == null || college4.getText().trim().isEmpty() || indirizzo4.getText() == null || indirizzo4.getText().trim().isEmpty())) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire prima i dati del quarto college");
            alertMissing.showAndWait();
        } else if (index2 == 1) {
            pannello5.setVisible(true);
            index2++;
        } else if (index2 == 2) {
            if (nomeFamText1.getText() == null || nomeFamText1.getText().trim().isEmpty() || ospiti1.getText() == null || ospiti1.getText().trim().isEmpty() || cognomeText1.getText() == null || cognomeText1.getText().trim().isEmpty() || compText1.getText() == null || compText1.getText().trim().isEmpty() || dispText1.getText() == null || dispText1.getText().trim().isEmpty() || distText1.getText() == null || distText1.getText().trim().isEmpty() || bagniText1.getText() == null || bagniText1.getText().trim().isEmpty() || animaliText1.getText() == null || animaliText1.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire prima i dati della prima famiglia");
                alertMissing.showAndWait();
            } else if (!compText1.getText().matches("[0-9]+") || !ospiti1.getText().matches("[0-9]+") || !dispText1.getText().matches("[0-9]+") || !distText1.getText().matches("[0-9]+") || !bagniText1.getText().matches("[0-9]+") || !animaliText1.getText().matches("[0-9]+")) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riguardare i parametri numerici!");
                alertMissing.showAndWait();
            } else {
                pannello6.setVisible(true);
                index2++;
            }
        } else if (index2 == 3) {
            if (nomeFamText2.getText() == null || nomeFamText2.getText().trim().isEmpty() || ospiti2.getText() == null || ospiti2.getText().trim().isEmpty() || cognomeText2.getText() == null || cognomeText2.getText().trim().isEmpty() || compText2.getText() == null || compText2.getText().trim().isEmpty() || dispText2.getText() == null || dispText2.getText().trim().isEmpty() || distText2.getText() == null || distText2.getText().trim().isEmpty() || bagniText2.getText() == null || bagniText2.getText().trim().isEmpty() || animaliText2.getText() == null || animaliText2.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire prima i dati della seconda famiglia");
                alertMissing.showAndWait();
            } else if (!compText2.getText().matches("[0-9]+") || !ospiti2.getText().matches("[0-9]+") || !dispText2.getText().matches("[0-9]+") || !distText2.getText().matches("[0-9]+") || !bagniText2.getText().matches("[0-9]+") || !animaliText2.getText().matches("[0-9]+")) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riguardare i parametri numerici!");
                alertMissing.showAndWait();
            } else {
                pannello7.setVisible(true);
                index2++;
            }
        } else if (index2 == 4) {
            if (nomeFamText3.getText() == null || nomeFamText3.getText().trim().isEmpty() || ospiti3.getText() == null || ospiti3.getText().trim().isEmpty() || cognomeText3.getText() == null || cognomeText3.getText().trim().isEmpty() || compText3.getText() == null || compText3.getText().trim().isEmpty() || dispText3.getText() == null || dispText3.getText().trim().isEmpty() || distText3.getText() == null || distText3.getText().trim().isEmpty() || bagniText3.getText() == null || bagniText3.getText().trim().isEmpty() || animaliText3.getText() == null || animaliText3.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire prima i dati della terza famiglia");
                alertMissing.showAndWait();
            } else if (!compText3.getText().matches("[0-9]+") || !ospiti3.getText().matches("[0-9]+") || !dispText3.getText().matches("[0-9]+") || !distText3.getText().matches("[0-9]+") || !bagniText3.getText().matches("[0-9]+") || !animaliText3.getText().matches("[0-9]+")) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riguardare i parametri numerici!");
                alertMissing.showAndWait();
            } else {
                pannello8.setVisible(true);
                index2++;
            }
        } else {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Non si possono aggiungere più di 4 vacanze in famiglia");
            alertMissing.showAndWait();
            index2++;
        }
    }

    private int index = 1;

    public void newCollegeVacation(ActionEvent actionEvent) {
        if (pannello5.isVisible() && (nomeFamText1.getText() == null || nomeFamText1.getText().trim().isEmpty() || ospiti1.getText() == null || ospiti1.getText().trim().isEmpty() || cognomeText1.getText() == null || cognomeText1.getText().trim().isEmpty() || compText1.getText() == null || compText1.getText().trim().isEmpty() || dispText1.getText() == null || dispText1.getText().trim().isEmpty() || distText1.getText() == null || distText1.getText().trim().isEmpty() || bagniText1.getText() == null || bagniText1.getText().trim().isEmpty() || animaliText1.getText() == null || animaliText1.getText().trim().isEmpty())) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire prima i dati relativi alla famiglia numero 1");
            alertMissing.showAndWait();
        } else if (pannello6.isVisible() && (nomeFamText2.getText() == null || nomeFamText2.getText().trim().isEmpty() || ospiti2.getText() == null || ospiti2.getText().trim().isEmpty() || cognomeText2.getText() == null || cognomeText2.getText().trim().isEmpty() || compText2.getText() == null || compText2.getText().trim().isEmpty() || dispText2.getText() == null || dispText2.getText().trim().isEmpty() || distText2.getText() == null || distText2.getText().trim().isEmpty() || bagniText2.getText() == null || bagniText2.getText().trim().isEmpty() || animaliText2.getText() == null || animaliText2.getText().trim().isEmpty())) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire prima i dati relativi alla famiglia numero 2");
            alertMissing.showAndWait();
        } else if (pannello7.isVisible() && (nomeFamText3.getText() == null || nomeFamText3.getText().trim().isEmpty() || ospiti3.getText() == null || ospiti3.getText().trim().isEmpty() || cognomeText3.getText() == null || cognomeText3.getText().trim().isEmpty() || compText3.getText() == null || compText3.getText().trim().isEmpty() || dispText3.getText() == null || dispText3.getText().trim().isEmpty() || distText3.getText() == null || distText3.getText().trim().isEmpty() || bagniText3.getText() == null || bagniText3.getText().trim().isEmpty() || animaliText3.getText() == null || animaliText3.getText().trim().isEmpty())) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire prima i dati relativi alla famiglia numero 3");
            alertMissing.showAndWait();
        } else if (pannello8.isVisible() && (nomeFamText4.getText() == null || nomeFamText4.getText().trim().isEmpty() || ospiti4.getText() == null || ospiti4.getText().trim().isEmpty() || cognomeText4.getText() == null || cognomeText4.getText().trim().isEmpty() || compText4.getText() == null || compText4.getText().trim().isEmpty() || dispText4.getText() == null || dispText4.getText().trim().isEmpty() || distText4.getText() == null || distText4.getText().trim().isEmpty() || bagniText4.getText() == null || bagniText4.getText().trim().isEmpty() || animaliText4.getText() == null || animaliText4.getText().trim().isEmpty())) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Riempire prima i dati relativi alla famiglia numero 4");
            alertMissing.showAndWait();
        } else if (index == 1) {
            pannello1.setVisible(true);
            index++;
        } else if (index == 2) {
            if (college1.getText() == null || college1.getText().trim().isEmpty() || indirizzo1.getText() == null || indirizzo1.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire prima i dati del primo college");
                alertMissing.showAndWait();
            } else {
                pannello2.setVisible(true);
                index++;
            }
        } else if (index == 3) {
            if (college2.getText() == null || college2.getText().trim().isEmpty() || indirizzo2.getText() == null || indirizzo2.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire prima i dati del secondo college");
                alertMissing.showAndWait();
            } else {
                pannello3.setVisible(true);
                index++;
            }
        } else if (index == 4) {
            if (college3.getText() == null || college3.getText().trim().isEmpty() || indirizzo3.getText() == null || indirizzo3.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire prima i dati del terzo college");
                alertMissing.showAndWait();
            } else {
                pannello4.setVisible(true);
                index++;
            }
        } else {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Non si possono aggiungere più di 4 vacanze in un college");
            alertMissing.showAndWait();
            index++;
        }
    }

    public void AvantiClick(ActionEvent actionEvent) {
        ZoneId zone = ZoneId.of("Europe/Rome");
        LocalDate today = LocalDate.now(zone);
        if (destinazioneText.getText() == null || destinazioneText.getText().trim().isEmpty() || linguaText.getText() == null || linguaText.getText().trim().isEmpty() || durataText.getText() == null || durataText.getText().trim().isEmpty() || dataPText.getValue() == null) {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Inserire tutti i parametri!");
            alertMissing.showAndWait();
        } else {
            if (today.isAfter(dataPText.getValue())) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Data non valida!");
                alertMissing.showAndWait();
            } else if (!durataText.getText().matches("[0-9]+")) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Durata non valida!");
                alertMissing.showAndWait();
            } else {
                newCollege.setVisible(true);
                newFamiglia.setVisible(true);
                Save.setVisible(true);
            }
        }
    }

    Integer max_code;
    public Integer[] cod_col=new Integer[4];
    public Integer i_col=0;
    public Integer[] cod_fam=new Integer[4];
    public Integer i_fam=0;

    public void SaveVacations(ActionEvent actionEvent) throws IOException {
        String dest = destinazioneText.getText();
        String data = dataPText.getValue().toString();
        String lingua = linguaText.getText();
        Integer durata = Integer.parseInt(durataText.getText());
        String query3 = "SELECT max(id_inserimento) FROM vacanza_college;";
        try {
            ResultSet rs = databaseOperation.SQL_return(query3);
            rs.next();
            String temp = rs.getString(1);
            max_code = Integer.parseInt(temp);
            max_code = max_code + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (index > 1 && index2 > 1) {
            if (pannello1.isVisible()) {
                String college = college1.getText();
                String indirizzo = indirizzo1.getText();
                // trovo il codice dell'ultima vacanza inserita
                String query = "SELECT max(codice) FROM vacanza_college;";
                try {
                    ResultSet rs = databaseOperation.SQL_return(query);
                    rs.next();
                    String temp = rs.getString(1);
                    Integer cod = Integer.parseInt(temp);
                    cod = cod + 1;
                    String query2 = "INSERT INTO vacanza_college(codice, data_partenza, città, lingua, nome_college, indirizzo_college, durata, id_inserimento) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + college + "', '" + indirizzo + "', '" + durata + "', " + max_code + ");";
                    System.out.println(query2);
                    databaseOperation.SQL_insert(query2);
                    cod_col[i_col]=cod;
                    i_col++;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                    alertMissing.setHeaderText(null);
                    alertMissing.setContentText("Impossibile aggiungere la vacanza");
                    alertMissing.showAndWait();
                }
            }
            if (pannello2.isVisible()) {
                String college = college2.getText();
                String indirizzo = indirizzo2.getText();
                // trovo il codice dell'ultima vacanza inserita
                String query = "SELECT max(codice) FROM vacanza_college;";
                try {
                    ResultSet rs = databaseOperation.SQL_return(query);
                    rs.next();
                    String temp = rs.getString(1);
                    Integer cod = Integer.parseInt(temp);
                    cod = cod + 1;
                    String query2 = "INSERT INTO vacanza_college(codice, data_partenza, città, lingua, nome_college, indirizzo_college, durata, id_inserimento) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + college + "', '" + indirizzo + "', '" + durata + "', " + max_code + ");";
                    System.out.println(query2);
                    databaseOperation.SQL_insert(query2);
                    cod_col[i_col]=cod;
                    i_col++;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                    alertMissing.setHeaderText(null);
                    alertMissing.setContentText("Impossibile aggiungere la vacanza");
                    alertMissing.showAndWait();
                }
            }
            if (pannello3.isVisible()) {
                String college = college3.getText();
                String indirizzo = indirizzo3.getText();
                // trovo il codice dell'ultima vacanza inserita
                String query = "SELECT max(codice) FROM vacanza_college;";
                try {
                    ResultSet rs = databaseOperation.SQL_return(query);
                    rs.next();
                    String temp = rs.getString(1);
                    Integer cod = Integer.parseInt(temp);
                    cod = cod + 1;
                    String query2 = "INSERT INTO vacanza_college(codice, data_partenza, città, lingua, nome_college, indirizzo_college, durata, id_inserimento) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + college + "', '" + indirizzo + "', '" + durata + "', " + max_code + ");";
                    System.out.println(query2);
                    databaseOperation.SQL_insert(query2);
                    cod_col[i_col]=cod;
                    i_col++;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                    alertMissing.setHeaderText(null);
                    alertMissing.setContentText("Impossibile aggiungere la vacanza");
                    alertMissing.showAndWait();
                }
            }
            if (pannello4.isVisible()) {
                String college = college4.getText();
                String indirizzo = indirizzo4.getText();
                // trovo il codice dell'ultima vacanza inserita
                String query = "SELECT max(codice) FROM vacanza_college;";
                try {
                    ResultSet rs = databaseOperation.SQL_return(query);
                    rs.next();
                    String temp = rs.getString(1);
                    Integer cod = Integer.parseInt(temp);
                    cod = cod + 1;
                    String query2 = "INSERT INTO vacanza_college(codice, data_partenza, città, lingua, nome_college, indirizzo_college, durata, id_inserimento) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + college + "', '" + indirizzo + "', '" + durata + "', " + max_code + ");";
                    System.out.println(query2);
                    databaseOperation.SQL_insert(query2);
                    cod_col[i_col]=cod;
                    i_col++;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                    alertMissing.setHeaderText(null);
                    alertMissing.setContentText("Impossibile aggiungere la vacanza");
                    alertMissing.showAndWait();
                }
            }
            if (pannello5.isVisible()) {
                String nomeFam = nomeFamText1.getText();
                String cognFam = cognomeText1.getText();
                String n_cam = dispText1.getText();
                String n_comp = compText1.getText();
                String dist = distText1.getText();
                String anim = animaliText1.getText();
                String bagni = bagniText1.getText();
                String osp = ospiti1.getText();
                // trovo il codice dell'ultima vacanza inserita
                String query = "SELECT max(codice) FROM vacanza_famiglia;";
                try {
                    ResultSet rs = databaseOperation.SQL_return(query);
                    rs.next();
                    String temp = rs.getString(1);
                    Integer cod = Integer.parseInt(temp);
                    cod = cod + 1;
                    String query2 = "INSERT INTO vacanza_famiglia (codice, data_partenza, città, lingua, durata, cognome_capo_fam, nome_capo_fam,  distanza_città, num_camere, num_componenti, num_bagni, num_animali, num_ospitabili, id_inserimento) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + durata + "', '" + cognFam + "', '" + nomeFam + "', '" + dist + "', " + n_cam + ", " + n_comp + ", " + bagni + ", " + anim + ", " + osp + ", " + max_code + ");";
                    databaseOperation.SQL_insert(query2);
                    cod_fam[i_fam]=cod;
                    i_fam++;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                    alertMissing.setHeaderText(null);
                    alertMissing.setContentText("Impossibile aggiungere la vacanza");
                    alertMissing.showAndWait();
                }
            }
            if (pannello6.isVisible()) {
                String nomeFam = nomeFamText2.getText();
                String cognFam = cognomeText2.getText();
                String n_cam = dispText2.getText();
                String n_comp = compText2.getText();
                String dist = distText2.getText();
                String anim = animaliText2.getText();
                String bagni = bagniText2.getText();
                String osp = ospiti2.getText();
                // trovo il codice dell'ultima vacanza inserita
                String query = "SELECT max(codice) FROM vacanza_famiglia;";
                try {
                    ResultSet rs = databaseOperation.SQL_return(query);
                    rs.next();
                    String temp = rs.getString(1);
                    Integer cod = Integer.parseInt(temp);
                    cod = cod + 1;
                    String query2 = "INSERT INTO vacanza_famiglia (codice, data_partenza, città, lingua, durata, cognome_capo_fam, nome_capo_fam,  distanza_città, num_camere, num_componenti, num_bagni, num_animali, num_ospitabili, id_inserimento) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + durata + "', '" + cognFam + "', '" + nomeFam + "', '" + dist + "', " + n_cam + ", " + n_comp + ", " + bagni + ", " + anim + ", " + osp + ", " + max_code + ");";
                    databaseOperation.SQL_insert(query2);
                    cod_fam[i_fam]=cod;
                    i_fam++;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                    alertMissing.setHeaderText(null);
                    alertMissing.setContentText("Impossibile aggiungere la vacanza");
                    alertMissing.showAndWait();
                }
            }
            if (pannello7.isVisible()) {
                String nomeFam = nomeFamText3.getText();
                String cognFam = cognomeText3.getText();
                String n_cam = dispText3.getText();
                String n_comp = compText3.getText();
                String dist = distText3.getText();
                String anim = animaliText3.getText();
                String bagni = bagniText3.getText();
                String osp = ospiti3.getText();
                // trovo il codice dell'ultima vacanza inserita
                String query = "SELECT max(codice) FROM vacanza_famiglia;";
                try {
                    ResultSet rs = databaseOperation.SQL_return(query);
                    rs.next();
                    String temp = rs.getString(1);
                    Integer cod = Integer.parseInt(temp);
                    cod = cod + 1;
                    String query2 = "INSERT INTO vacanza_famiglia (codice, data_partenza, città, lingua, durata, cognome_capo_fam, nome_capo_fam,  distanza_città, num_camere, num_componenti, num_bagni, num_animali, num_ospitabili, id_inserimento) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + durata + "', '" + cognFam + "', '" + nomeFam + "', '" + dist + "', " + n_cam + ", " + n_comp + ", " + bagni + ", " + anim + ", " + osp + ", " + max_code + ");";
                    databaseOperation.SQL_insert(query2);
                    cod_fam[i_fam]=cod;
                    i_fam++;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                    alertMissing.setHeaderText(null);
                    alertMissing.setContentText("Impossibile aggiungere la vacanza");
                    alertMissing.showAndWait();
                }
            }
            if (pannello8.isVisible()) {
                String nomeFam = nomeFamText4.getText();
                String cognFam = cognomeText4.getText();
                String n_cam = dispText4.getText();
                String n_comp = compText4.getText();
                String dist = distText4.getText();
                String anim = animaliText4.getText();
                String bagni = bagniText4.getText();
                String osp = ospiti4.getText();
                // trovo il codice dell'ultima vacanza inserita
                String query = "SELECT max(codice) FROM vacanza_famiglia;";
                try {
                    ResultSet rs = databaseOperation.SQL_return(query);
                    rs.next();
                    String temp = rs.getString(1);
                    Integer cod = Integer.parseInt(temp);
                    cod = cod + 1;
                    String query2 = "INSERT INTO vacanza_famiglia (codice, data_partenza, città, lingua, durata, cognome_capo_fam, nome_capo_fam,  distanza_città, num_camere, num_componenti, num_bagni, num_animali, num_ospitabili, id_inserimento) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + durata + "', '" + cognFam + "', '" + nomeFam + "', '" + dist + "', " + n_cam + ", " + n_comp + ", " + bagni + ", " + anim + ", " + osp + ", " + max_code + ");";
                    databaseOperation.SQL_insert(query2);
                    cod_fam[i_fam]=cod;
                    i_fam++;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                    alertMissing.setHeaderText(null);
                    alertMissing.setContentText("Impossibile aggiungere la vacanza");
                    alertMissing.showAndWait();
                }
            }
            new gestioneGiteEAttivita(cod_col, cod_fam);
        } else {
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Bisogna inserire almeno una vacanza in college e una in famiglia!");
            alertMissing.showAndWait();
        }
    }

    @FXML
    public ScrollPane scroll2;
    public Pane pannelloGite;
    public Pane pannelloScroll;

    private Integer int_x = 14;
    private Integer int_y = 14;
    private Integer h = 25;
    private Integer w = 329;
    private Integer h_panel = 250;
    private Integer w_panel = 810;
    private int conto = 0;
    private TextField codiceText;
    private TextField destText;
    private TextArea descText;
    private TextField costoText;
    private TextField numOreText;

    private boolean c = true;

    public void newTrip(MouseEvent mouseEvent) {
        conto++;
        c=true;
        if (conto > 1) {
            if (codiceText.getText() == null || codiceText.getText().trim().isEmpty() || destText.getText() == null || destText.getText().trim().isEmpty() || descText.getText() == null || descText.getText().trim().isEmpty() || costoText.getText() == null || costoText.getText().trim().isEmpty() || numOreText.getText() == null || numOreText.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire tutti i campi!");
                alertMissing.showAndWait();
                c = false;
            } else {
                if (!codiceText.getText().matches("[0-9]+") || !costoText.getText().matches("^\\d+\\.\\d+") || !numOreText.getText().matches("[0-9]+")) {
                    Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                    alertMissing.setHeaderText(null);
                    alertMissing.setContentText("Ricontrollare i parametri numerici!");
                    alertMissing.showAndWait();
                    c = false;
                } else {
                    String codice = codiceText.getText();
                    String dest = destText.getText();
                    String desc = descText.getText();
                    String costo = costoText.getText();
                    String numOre = numOreText.getText();
                    // controllo che il codice esista già, in caso riempio automaticamente i box
                    Boolean controllo = databaseOperation.Ricerca("id", codice, "gita");
                    if (controllo == true && codiceText.isEditable()) {
                        Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                        alertMissing.setHeaderText(null);
                        alertMissing.setContentText("codice già presente!");
                        alertMissing.showAndWait();
                        String query = "SELECT * FROM gita WHERE id=" + codice + ";";
                        try {
                            ResultSet rs = databaseOperation.SQL_return(query);
                            rs.next();
                            codiceText.setEditable(false);
                            descText.setText(rs.getString(2));
                            descText.setEditable(false);
                            destText.setText(rs.getString(3));
                            destText.setEditable(false);
                            costoText.setText(rs.getString(4));
                            costoText.setEditable(false);
                            numOreText.setText(rs.getString(5));
                            numOreText.setEditable(false);
                            if (cod_col[0]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[0] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[1]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[1] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[2]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[2] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[3]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[3] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[0]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_col[0] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[1]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_col[1] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[2]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_col[2] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[3]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_col[3] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Alert alertMissing2 = new Alert(Alert.AlertType.ERROR);
                            alertMissing2.setHeaderText(null);
                            alertMissing2.setContentText("impossibile collegarsi al database");
                            alertMissing2.showAndWait();
                            c=false;
                        }
                    } else {
                        try {
                            String query2="INSERT INTO gita(id, descrizione, destinazione, costo, num_ore) VALUES ("+codice+", '"+desc+"', '"+ dest+"', "+ costo + ", "+ numOre+");";
                            databaseOperation.SQL_insert(query2);
                            if (cod_col[0]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[0] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[1]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[1] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[2]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[2] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[3]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[3] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[0]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_fam[0] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[1]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_fam[1] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[2]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_fam[2] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[3]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_fam[3] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                        }catch (Exception e) {
                            e.printStackTrace();
                            Alert alertMissing2 = new Alert(Alert.AlertType.ERROR);
                            alertMissing2.setHeaderText(null);
                            alertMissing2.setContentText("impossibile collegarsi al database");
                            alertMissing2.showAndWait();
                            c=false;
                        }
                    }
                }
            }
        }
        if (c) {
            Label codice = new Label();
            codice.setText(conto + ") Codice della gita:");
            codice.setLayoutX(int_x - 4);
            codice.setLayoutY(int_y);
            codiceText = new TextField();
            codiceText.setLayoutX(int_x + 142);
            codiceText.setLayoutY(int_y);
            codiceText.prefHeight(h);
            codiceText.prefWidth(w);

            int_y = int_y + 30;
            Label destinazione = new Label();
            destinazione.setText("Destinazione:");
            destinazione.setLayoutX(int_x);
            destinazione.setLayoutY(int_y);
            destText = new TextField();
            destText.setLayoutX(int_x + 142);
            destText.setLayoutY(int_y);
            destText.prefHeight(h);
            destText.prefWidth(w);

            int_y = int_y + 30;
            Label descrizione = new Label();
            descrizione.setText("Descrizione:");
            descrizione.setLayoutX(int_x);
            descrizione.setLayoutY(int_y);
            descText = new TextArea();
            descText.setLayoutX(int_x + 142);
            descText.setLayoutY(int_y);
            descText.prefHeight(h);
            descText.setPrefWidth(545);
            descText.setPrefHeight(180);

            int_y = int_y + 200;
            Label costo = new Label();
            costo.setText("Costo:");
            costo.setLayoutX(int_x);
            costo.setLayoutY(int_y);
            costoText = new TextField();
            costoText.setLayoutX(int_x + 142);
            costoText.setLayoutY(int_y);
            costoText.prefHeight(h);
            costoText.prefWidth(w - 200);

            Label numOre = new Label();
            numOre.setText("Numero di ore:");
            numOre.setLayoutX(int_x + 362);
            numOre.setLayoutY(int_y);
            numOreText = new TextField();
            numOreText.setLayoutX(int_x + 362 + 180);
            numOreText.setLayoutY(int_y);
            numOreText.prefHeight(h);
            numOreText.prefWidth(w - 200);

            pannelloScroll.setLayoutY(34.0);
            pannelloScroll.setPrefHeight(h_panel);
            pannelloScroll.setPrefWidth(w_panel);
            pannelloScroll.getChildren().addAll(descrizione, codice, destinazione, costo, numOre, codiceText, destText, descText, costoText, numOreText);

            scroll2.setContent(pannelloScroll);

      /*  scroll2.setFitToHeight(true);
        scroll2.setFitToWidth(true);*/

            //scroll2.fitToHeightProperty().set(true);

            int_y = int_y + 30;
            h_panel = h_panel + 350;
        }
    }

    public void transferMessageCod(Integer[] codici_col, Integer[] codici_fam) {
        cod_col[0]=codici_col[0];
        cod_col[1]=codici_col[1];
        cod_col[2]=codici_col[2];
        cod_col[3]=codici_col[3];
        cod_fam[0]=codici_fam[0];
        cod_fam[1]=codici_fam[1];
        cod_fam[2]=codici_fam[2];
        cod_fam[3]=codici_fam[3];
    }


    public void gestioneAttivitaCollege(MouseEvent mouseEvent) {
        // salvo ultima modifica
            if (codiceText.getText() == null || codiceText.getText().trim().isEmpty() || destText.getText() == null || destText.getText().trim().isEmpty() || descText.getText() == null || descText.getText().trim().isEmpty() || costoText.getText() == null || costoText.getText().trim().isEmpty() || numOreText.getText() == null || numOreText.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire tutti i campi!");
                alertMissing.showAndWait();
                c = false;
            } else {
                if (!codiceText.getText().matches("[0-9]+") || !costoText.getText().matches("^\\d+\\.\\d+") || !numOreText.getText().matches("[0-9]+")) {
                    Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                    alertMissing.setHeaderText(null);
                    alertMissing.setContentText("Ricontrollare i parametri numerici!");
                    alertMissing.showAndWait();
                    c = false;
                } else {
                    String codice = codiceText.getText();
                    String dest = destText.getText();
                    String desc = descText.getText();
                    String costo = costoText.getText();
                    String numOre = numOreText.getText();
                    // controllo che il codice esista già, in caso riempio automaticamente i box
                    Boolean controllo = databaseOperation.Ricerca("id", codice, "gita");
                    if (controllo == true && codiceText.isEditable()) {
                        Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                        alertMissing.setHeaderText(null);
                        alertMissing.setContentText("codice già presente!");
                        alertMissing.showAndWait();
                        String query = "SELECT * FROM gita WHERE id=" + codice + ";";
                        try {
                            ResultSet rs = databaseOperation.SQL_return(query);
                            rs.next();
                            codiceText.setEditable(false);
                            descText.setText(rs.getString(2));
                            descText.setEditable(false);
                            destText.setText(rs.getString(3));
                            destText.setEditable(false);
                            costoText.setText(rs.getString(4));
                            costoText.setEditable(false);
                            numOreText.setText(rs.getString(5));
                            numOreText.setEditable(false);
                            if (cod_col[0]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[0] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[1]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[1] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[2]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[2] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[3]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[3] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[0]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_col[0] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[1]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_col[1] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[2]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_col[2] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[3]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_col[3] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Alert alertMissing2 = new Alert(Alert.AlertType.ERROR);
                            alertMissing2.setHeaderText(null);
                            alertMissing2.setContentText("impossibile collegarsi al database");
                            alertMissing2.showAndWait();
                        }
                    } else {
                        try {
                            String query2="INSERT INTO gita(id, descrizione, destinazione, costo, num_ore) VALUES ("+codice+", '"+desc+"', '"+ dest+"', "+ costo + ", "+ numOre+");";
                            databaseOperation.SQL_insert(query2);
                            if (cod_col[0]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[0] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[1]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[1] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[2]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[2] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_col[3]!=null) {
                                String query3="INSERT INTO pianificazione_college(id_vacanza, id_gita) VALUES ("+cod_col[3] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[0]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_fam[0] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[1]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_fam[1] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[2]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_fam[2] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                            if (cod_fam[3]!=null) {
                                String query3="INSERT INTO pianificazione_famiglia(id_vacanza, id_gita) VALUES ("+cod_fam[3] + ", "+codice+");";
                                System.out.println(query3);
                                databaseOperation.SQL_insert(query3);
                            }
                        }catch (Exception e) {
                            e.printStackTrace();
                            Alert alertMissing2 = new Alert(Alert.AlertType.ERROR);
                            alertMissing2.setHeaderText(null);
                            alertMissing2.setContentText("impossibile collegarsi al database");
                            alertMissing2.showAndWait();
                        }
                    }
                }
            }
        scroll2.setContent(null);
        pannelloScroll.getChildren().clear();
        int i=0;
        String[] nome_college=new String[4];
        ObservableList<Object> list = FXCollections.observableArrayList();
        while (cod_col[i]!=null) {
            String query="SELECT nome_college FROM vacanza_college WHERE codice="+cod_col[i]+";";
            try {
                ResultSet rs = databaseOperation.SQL_return(query);
                rs.next();
                nome_college[i] = rs.getString(1);
                list.add(nome_college[i]);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                Alert alertMissing2 = new Alert(Alert.AlertType.ERROR);
                alertMissing2.setHeaderText(null);
                alertMissing2.setContentText("impossibile collegarsi al database");
                alertMissing2.showAndWait();
            }
        }
        Label scegli_college=new Label();
        scegli_college.setText("Scegliere il college:");
        scegli_college.setLayoutX(80);
        scegli_college.setLayoutY(24);

        ChoiceBox college_choice=new ChoiceBox();
        college_choice.setItems(list);
        college_choice.setLayoutX(200);
        college_choice.setLayoutY(24);
        college_choice.prefHeight(27.0);
        college_choice.prefWidth(185.0);

        pannelloScroll.setLayoutY(34.0);
        pannelloScroll.setPrefHeight(h_panel);
        pannelloScroll.setPrefWidth(w_panel);
        pannelloScroll.getChildren().addAll(scegli_college, college_choice);
        scroll2.setContent(pannelloScroll);
    }
}