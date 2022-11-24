package com.example.zubermarcell_javafxrestclientdolgozat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class CreateSportController extends Controller {
    @FXML
    private TextField nameField;
    @FXML
    private TextField sportField;
    @FXML
    private Spinner<Integer> ageField;
    @FXML
    private  TextField levelField;
    @FXML
    private Button submitButton;

    @FXML
    private void initialize() {
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200, 30);
        ageField.setValueFactory(valueFactory);
    }

    @FXML
    public void submitClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String sport = sportField.getText().trim();
        String level = levelField.getText().trim();
        int age = ageField.getValue();
        if (name.isEmpty()) {
            warning("Name is required");
            return;
        }
        if (sport.isEmpty()) {
            warning("Sport is required");
            return;
        }
        if (level.isEmpty()) {
            warning("Level is required");
            return;
        }
        Sport newSport = new Sport(0, name, sport, age, level);
        Gson converter = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = converter.toJson(newSport);
        try {
            Response response = RequestHandler.post(SportApp.BASE_URL, json);
            if (response.getResponseCode() == 201) {
                warning("Sport added!");
                nameField.setText("");
                sportField.setText("");
                ageField.getValueFactory().setValue(30);
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
