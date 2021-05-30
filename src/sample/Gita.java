package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Gita {

        public SimpleStringProperty Destinazione = new SimpleStringProperty();
        public SimpleStringProperty Descrizione = new SimpleStringProperty();
        public SimpleIntegerProperty Costo = new SimpleIntegerProperty();
        public SimpleIntegerProperty Ore = new SimpleIntegerProperty();

        public String getDestinazione() {
            return Destinazione.get();
        }

        public String getDescrizione() {
            return Descrizione.get();
        }

        public Integer getCosto() {
            return Costo.get();
        }

        public Integer getOre() {
            return Ore.get();
        }

}
