package sample;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class cities {
    private StringProperty citiesName = new SimpleStringProperty();

    public cities(String citiesName) {
        this.citiesName.set(citiesName);
    }

    public String getCitiesName() {
        return citiesName.get();
    }

    public StringProperty citiesNameProperty() {
        return citiesName;
    }

    public void setCitiesName(String citiesName) {
        this.citiesName.set(citiesName);
    }

    // The ChoiceBox uses the toString() method of our object to display options in the dropdown.
    // We need to override this method to return something more helpful.
    @Override
    public String toString() {
        return citiesName.get();
    }
}