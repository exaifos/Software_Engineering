package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Vacanze {

    public static SimpleStringProperty Città = new SimpleStringProperty();
    public SimpleStringProperty DataPartenza = new SimpleStringProperty();
    public SimpleStringProperty Lingua = new SimpleStringProperty();
    public SimpleIntegerProperty Durata = new SimpleIntegerProperty();

    public Integer getDurata() {
        return Durata.get();
    }

    public static String getCittà() {
        return Città.get();
    }

    public String getLingua() {
        return Lingua.get();
    }

    public String getDataPartenza() {
        return DataPartenza.toString();
    }
}