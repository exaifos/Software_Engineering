package sample;
import javafx.beans.property.SimpleStringProperty;

public class Activity {
    public SimpleStringProperty Nome = new SimpleStringProperty();
    public SimpleStringProperty Descrizione = new SimpleStringProperty();

    public String getNome() {
        return Nome.get();
    }

    public String getDescrizione() {
        return Descrizione.get();
    }
}
