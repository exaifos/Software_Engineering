package sample;

import javafx.beans.property.*;

public class Level {
    public SimpleStringProperty NomeLivello = new SimpleStringProperty();
    public SimpleStringProperty LinguaLivello = new SimpleStringProperty();
    public SimpleStringProperty DataLivello = new SimpleStringProperty();

    public String getNomeLivello() {
        return NomeLivello.get();
    }

    public String getLinguaLivello() {
        return LinguaLivello.get();
    }

    public String getDataLivello() {
        return DataLivello.get();
    }
}
