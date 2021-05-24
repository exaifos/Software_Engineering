module Progetto {
    requires javafx.graphics;
    requires javafx.controls;
    requires transitive javafx.base;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens sample;
}