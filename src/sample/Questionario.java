package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;

public class Questionario {
    public SimpleStringProperty CittàQuestionario = new SimpleStringProperty();
    public SimpleStringProperty DataQuestionario = new SimpleStringProperty();
    public SimpleStringProperty TipoQuestionario = new SimpleStringProperty();
    public SimpleStringProperty FamigliaQuestionario = new SimpleStringProperty();
    public SimpleStringProperty CollegeQuestionario = new SimpleStringProperty();
    public SimpleStringProperty CommentoQuestionario = new SimpleStringProperty();
    public SimpleIntegerProperty VotoQuestionario = new SimpleIntegerProperty();
    public SimpleIntegerProperty CodiceQuestionario = new SimpleIntegerProperty();

    public String getCittàQuestionario() {
        return CittàQuestionario.get();
    }

    public String getDataQuestionario() {
        return DataQuestionario.get();
    }

    public String getTipoQuestionario() {
        return TipoQuestionario.get();
    }

    public String getFamigliaQuestionario() {
        return FamigliaQuestionario.get();
    }
    public String getCollegeQuestionario() {
        return CollegeQuestionario.get();
    }
    public String getCommentoQuestionario() {
        return CommentoQuestionario.get();
    }
    public Integer getVotoQuestionario() {
        return VotoQuestionario.get();
    }

    public Integer getCodiceQuestionario() {
        return CodiceQuestionario.get();
    }
}
