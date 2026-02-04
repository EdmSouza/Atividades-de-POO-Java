package com.calculatorpol;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class CalculatorPolView {
    private TextField display;
    private Button[] btns;
    private final String[] btnLabels = {
        "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "x",
        "C", "0", "Enter", "/"
    };

    // MUDANÇA: Agora aceita o Controller como parâmetro
    public void setup(Stage primaryStage, ControllerPol controller) {
        display = new TextField("0");
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setPrefHeight(50);

        btns = new Button[16];
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(5));

        // Configura as colunas para esticarem
        for (int i = 0; i < 4; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setHgrow(Priority.ALWAYS);
            colConst.setFillWidth(true);
            grid.getColumnConstraints().add(colConst);
        }

        // Loop que cria os botões
        for (int i = 0; i < 16; i++) {
           String label = btnLabels[i];
           btns[i] = new Button(label);
           btns[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
           
           // LIGAÇÃO DOS FIOS (Handlers)
           if (label.equals("C")) {
               btns[i].setOnAction(controller.limpar());
           } else if (label.equals("Enter")) { // Novo Handler para o Enter
               btns[i].setOnAction(controller.enter());
           } else if ("+-x/".contains(label)) { // Operadores
               btns[i].setOnAction(controller.operador());
           } else { // Números
               btns[i].setOnAction(controller.digito());
           }
           grid.add(btns[i], i % 4, i / 4);
       }

        BorderPane root = new BorderPane();
        root.setTop(display);
        root.setCenter(grid);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public TextField getDisplay() {
        return display;
    }
}