package com.example.zubermarcell_javafxrestclientdolgozat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateSportController extends Controller {
    @FXML
    private TextField nameField;
    @FXML
    private TextField sportField;
    @FXML
    private Spinner<Integer> ageField;
    @FXML
    private  TextField levelField;
    @FXML
    private Button updateButton;

    private Sport sport;

    public void setSport(Sport sport) {
        this.sport = sport;
        nameField.setText(this.sport.getName());
        sportField.setText(this.sport.getSport());
        ageField.getValueFactory().setValue(this.sport.getAge());
    }

    @FXML
    private void initialize() {
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200, 30);
        ageField.setValueFactory(valueFactory);
    }

    @FXML
    public void updateClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String sport = sportField.getText().trim();
        int age = ageField.getValue();
        if (name.isEmpty()) {
            warning("Name is required");
            return;
        }
        if (sport.isEmpty()) {
            warning("Sport is required");
            return;
        }
        this.sport.setName(name);
        this.sport.setSport(sport);
        this.sport.setAge(age);
        Gson converter = new Gson();
        String json = converter.toJson(this.sport);
        try {
            String url = SportApp.BASE_URL + "/" + this.sport.getId();
            Response response = RequestHandler.put(url, json);
            if (response.getResponseCode() == 200) {
                Stage stage = (Stage) this.updateButton.getScene().getWindow();
                stage.close();
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
