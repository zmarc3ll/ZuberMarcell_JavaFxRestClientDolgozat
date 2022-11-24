module com.example.zubermarcell_javafxrestclientdolgozat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zubermarcell_javafxrestclientdolgozat to javafx.fxml;
    exports com.example.zubermarcell_javafxrestclientdolgozat;
}