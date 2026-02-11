package com.example;

import java.io.IOException;

import javafx.fxml.FXML;

public class PaintsetController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("layout");
    }
}
