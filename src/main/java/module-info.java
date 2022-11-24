module com.example.zubermarcell_javafxrestclientdolgozat {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.example.zubermarcell_javafxrestclientdolgozat to javafx.fxml, com.google.gson;
    exports com.example.zubermarcell_javafxrestclientdolgozat;
}