package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
        CF=message1;
        utente=message2;
    }


    private int index2=1;
    public void newFamilyVacation(ActionEvent actionEvent) {
        if (index2==1) {
            pannello5.setVisible(true);
            index2++;
        } else if (index2==2) {
            if (nomeFamText1.getText()==null || nomeFamText1.getText().trim().isEmpty() || cognomeText1.getText()==null || cognomeText1.getText().trim().isEmpty() || compText1.getText()==null || compText1.getText().trim().isEmpty() || dispText1.getText()==null || dispText1.getText().trim().isEmpty() || distText1.getText()==null || distText1.getText().trim().isEmpty() || bagniText1.getText()==null || bagniText1.getText().trim().isEmpty() || animaliText1.getText()==null || animaliText1.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire prima i dati della prima famiglia");
                alertMissing.showAndWait();
            } else {
                pannello6.setVisible(true);
                index2++;
            }
        } else if (index2==3) {
            if (nomeFamText2.getText()==null || nomeFamText2.getText().trim().isEmpty() || cognomeText2.getText()==null || cognomeText2.getText().trim().isEmpty() || compText2.getText()==null || compText2.getText().trim().isEmpty() || dispText2.getText()==null || dispText2.getText().trim().isEmpty() || distText2.getText()==null || distText2.getText().trim().isEmpty() || bagniText2.getText()==null || bagniText2.getText().trim().isEmpty() || animaliText2.getText()==null || animaliText2.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire prima i dati della seconda famiglia");
                alertMissing.showAndWait();
            } else {
                pannello7.setVisible(true);
                index2++;
            }
        } else if (index2==4){
            if (nomeFamText3.getText()==null || nomeFamText3.getText().trim().isEmpty() || cognomeText3.getText()==null || cognomeText3.getText().trim().isEmpty() || compText3.getText()==null || compText3.getText().trim().isEmpty() || dispText3.getText()==null || dispText3.getText().trim().isEmpty() || distText3.getText()==null || distText3.getText().trim().isEmpty() || bagniText3.getText()==null || bagniText3.getText().trim().isEmpty() || animaliText3.getText()==null || animaliText3.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire prima i dati della terza famiglia");
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

    private int index=1;
    public void newCollegeVacation(ActionEvent actionEvent) {
        if (index==1) {
            pannello1.setVisible(true);
            index++;
        } else if (index==2) {
            if (college1.getText() == null || college1.getText().trim().isEmpty() || indirizzo1.getText() == null || indirizzo1.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire prima i dati del primo college");
                alertMissing.showAndWait();
            } else {
                pannello2.setVisible(true);
                index++;
            }
        } else if (index==3) {
            if (college2.getText() == null || college2.getText().trim().isEmpty() || indirizzo2.getText() == null || indirizzo2.getText().trim().isEmpty()) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Riempire prima i dati del secondo college");
                alertMissing.showAndWait();
            } else {
                pannello3.setVisible(true);
                index++;
            }
        } else if (index==4) {
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
        if (destinazioneText.getText() == null || destinazioneText.getText().trim().isEmpty() || linguaText.getText() == null || linguaText.getText().trim().isEmpty() || durataText.getText() == null || durataText.getText().trim().isEmpty() || dataPText.getValue() == null){
            Alert alertMissing = new Alert(Alert.AlertType.ERROR);
            alertMissing.setHeaderText(null);
            alertMissing.setContentText("Inserire tutti i parametri!");
            alertMissing.showAndWait();
        }
        else {
            if (today.isAfter(dataPText.getValue())) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Data non valida!");
                alertMissing.showAndWait();
            }
            else if (!durataText.getText().matches("[0-9]+")) {
                Alert alertMissing = new Alert(Alert.AlertType.ERROR);
                alertMissing.setHeaderText(null);
                alertMissing.setContentText("Durata non valida!");
                alertMissing.showAndWait();
            }
            else {
                newCollege.setVisible(true);
                newFamiglia.setVisible(true);
                Save.setVisible(true);
            }
        }
    }

    public void SaveVacations(ActionEvent actionEvent) {
        String dest = destinazioneText.getText();
        String data = dataPText.getValue().toString();
        String lingua = linguaText.getText();
        Integer durata = Integer.parseInt(durataText.getText());
        if (pannello1.isVisible()) {
            String college = college1.getText();
            String indirizzo = indirizzo1.getText();
            // trovo il codice dell'ultima vacanza inserita
            String query="SELECT max(codice) FROM vacanza_college;";
            try {
                ResultSet rs = databaseOperation.SQL_return(query);
                rs.next();
                String temp = rs.getString(1);
                Integer cod = Integer.parseInt(temp);
                cod = cod + 1;
                String query2= "INSERT INTO vacanza_college(codice, data_partenza, città, lingua, nome_college, indirizzo_college, durata) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + college + "', '" + indirizzo + "', '" + durata + "');";
                databaseOperation.SQL_insert(query2);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (pannello2.isVisible()) {
            String college = college2.getText();
            String indirizzo = indirizzo2.getText();
            // trovo il codice dell'ultima vacanza inserita
            String query="SELECT max(codice) FROM vacanza_college;";
            try {
                ResultSet rs = databaseOperation.SQL_return(query);
                rs.next();
                String temp = rs.getString(1);
                Integer cod = Integer.parseInt(temp);
                cod = cod + 1;
                String query2= "INSERT INTO vacanza_college(codice, data_partenza, città, lingua, nome_college, indirizzo_college, durata) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + college + "', '" + indirizzo + "', '" + durata + "');";
                databaseOperation.SQL_insert(query2);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (pannello3.isVisible()) {
            String college = college3.getText();
            String indirizzo = indirizzo3.getText();
            // trovo il codice dell'ultima vacanza inserita
            String query="SELECT max(codice) FROM vacanza_college;";
            try {
                ResultSet rs = databaseOperation.SQL_return(query);
                rs.next();
                String temp = rs.getString(1);
                Integer cod = Integer.parseInt(temp);
                cod = cod + 1;
                String query2= "INSERT INTO vacanza_college(codice, data_partenza, città, lingua, nome_college, indirizzo_college, durata) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + college + "', '" + indirizzo + "', '" + durata + "');";
                databaseOperation.SQL_insert(query2);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (pannello4.isVisible()) {
            String college = college4.getText();
            String indirizzo = indirizzo4.getText();
            // trovo il codice dell'ultima vacanza inserita
            String query="SELECT max(codice) FROM vacanza_college;";
            try {
                ResultSet rs = databaseOperation.SQL_return(query);
                rs.next();
                String temp = rs.getString(1);
                Integer cod = Integer.parseInt(temp);
                cod = cod + 1;
                String query2= "INSERT INTO vacanza_college(codice, data_partenza, città, lingua, nome_college, indirizzo_college, durata) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + college + "', '" + indirizzo + "', '" + durata + "');";
                databaseOperation.SQL_insert(query2);
            } catch (Exception ex) {
                ex.printStackTrace();
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
            String query="SELECT max(codice) FROM vacanza_famiglia;";
            try {
                ResultSet rs = databaseOperation.SQL_return(query);
                rs.next();
                String temp = rs.getString(1);
                Integer cod = Integer.parseInt(temp);
                cod = cod + 1;
                String query2 = "INSERT INTO vacanza_famiglia (codice, data_partenza, città, lingua, durata, cognome_capo_fam, nome_capo_fam,  distanza_città, num_camere, num_componenti, num_bagni, num_animali, num_ospitabili) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + durata + "', '" + cognFam + "', '" + nomeFam + "', '" + dist + "', " + n_cam + ", "+ n_comp + ", " + bagni + ", " + anim + ", " + osp  +");";
                databaseOperation.SQL_insert(query2);
            } catch (Exception ex) {
                ex.printStackTrace();
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
            String query="SELECT max(codice) FROM vacanza_famiglia;";
            try {
                ResultSet rs = databaseOperation.SQL_return(query);
                rs.next();
                String temp = rs.getString(1);
                Integer cod = Integer.parseInt(temp);
                cod = cod + 1;
                String query2 = "INSERT INTO vacanza_famiglia (codice, data_partenza, città, lingua, durata, cognome_capo_fam, nome_capo_fam,  distanza_città, num_camere, num_componenti, num_bagni, num_animali, num_ospitabili) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + durata + "', '" + cognFam + "', '" + nomeFam + "', '" + dist + "', " + n_cam + ", "+ n_comp + ", " + bagni + ", " + anim + ", " + osp  +");";
                databaseOperation.SQL_insert(query2);
            } catch (Exception ex) {
                ex.printStackTrace();
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
            String query="SELECT max(codice) FROM vacanza_famiglia;";
            try {
                ResultSet rs = databaseOperation.SQL_return(query);
                rs.next();
                String temp = rs.getString(1);
                Integer cod = Integer.parseInt(temp);
                cod = cod + 1;
                String query2 = "INSERT INTO vacanza_famiglia (codice, data_partenza, città, lingua, durata, cognome_capo_fam, nome_capo_fam,  distanza_città, num_camere, num_componenti, num_bagni, num_animali, num_ospitabili) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + durata + "', '" + cognFam + "', '" + nomeFam + "', '" + dist + "', " + n_cam + ", "+ n_comp + ", " + bagni + ", " + anim + ", " + osp  +");";
                databaseOperation.SQL_insert(query2);
            } catch (Exception ex) {
                ex.printStackTrace();
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
            String query="SELECT max(codice) FROM vacanza_famiglia;";
            try {
                ResultSet rs = databaseOperation.SQL_return(query);
                rs.next();
                String temp = rs.getString(1);
                Integer cod = Integer.parseInt(temp);
                cod = cod + 1;
                String query2 = "INSERT INTO vacanza_famiglia (codice, data_partenza, città, lingua, durata, cognome_capo_fam, nome_capo_fam,  distanza_città, num_camere, num_componenti, num_bagni, num_animali, num_ospitabili) VALUES (" + cod + ", '" + data + "', '" + dest + "', '" + lingua + "', '" + durata + "', '" + cognFam + "', '" + nomeFam + "', '" + dist + "', " + n_cam + ", "+ n_comp + ", " + bagni + ", " + anim + ", " + osp  +");";
                databaseOperation.SQL_insert(query2);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
