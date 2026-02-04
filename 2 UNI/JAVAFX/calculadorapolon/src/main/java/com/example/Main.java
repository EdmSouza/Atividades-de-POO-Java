package com.calculatorpol;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 1. Cria a carcaça (Visão)
        CalculatorPolView view = new CalculatorPolView();
        
        // 2. Cria o cérebro (Controladora) e passa a carcaça pra ele
        ControllerPol controller = new ControllerPol(view);
        
        // 3. Monta a tela, passando o cérebro para conectar nos botões
        // MUDANÇA AQUI: Passamos o controller como parâmetro
        view.setup(primaryStage, controller); 
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}