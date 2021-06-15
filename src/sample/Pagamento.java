package sample;

import javafx.beans.property.SimpleStringProperty;

public class Pagamento {
    public SimpleStringProperty CityPagamento = new SimpleStringProperty();
    public SimpleStringProperty DurataPagamento = new SimpleStringProperty();
    public SimpleStringProperty PrezzoPagamento = new SimpleStringProperty();
    public SimpleStringProperty TipoPagamento = new SimpleStringProperty();
    public SimpleStringProperty StatusPagamento = new SimpleStringProperty();
    public SimpleStringProperty VacanzaPagamento = new SimpleStringProperty();

    public String getCityPagamento() {
        return CityPagamento.get();
    }

    public String getDurataPagamento() {
        return DurataPagamento.get();
    }

    public String getPrezzoPagamento() {
        return PrezzoPagamento.get();
    }

    public String getTipoPagamento() {
        return TipoPagamento.get();
    }

    public String getStatusPagamento() {
        return StatusPagamento.get();
    }

    public String getVacanzaPagamento() {
        return VacanzaPagamento.get();
    }
}