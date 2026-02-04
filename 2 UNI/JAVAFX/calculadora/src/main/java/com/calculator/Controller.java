package com.calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Controller {
    private CalculatorView view;
    private int result = 0;
    private char lastOperator = ' ';
    private String inStr = "0";

    public Controller(CalculatorView view) {
        this.view = view;
    }

    // 1. Handler para NÚMEROS (0-9)
    public EventHandler<ActionEvent> digito() {
        return event -> {
            // Descobre qual botão foi apertado
            Button btn = (Button) event.getSource();
            String numeroDigitado = btn.getText();

            // Lógica de concatenar (juntar) os números
            if (inStr.equals("0")) {
                inStr = numeroDigitado;
            } else {
                inStr += numeroDigitado;
            }
            
            // Atualiza a tela
            view.getDisplay().setText(inStr);
            
            // Se acabou de dar igual, reseta o resultado anterior
            if (lastOperator == '=') {
                result = 0;
                lastOperator = ' ';
            }
        };
    }

    // 2. Handler para OPERADORES (+ - x / =)
    public EventHandler<ActionEvent> operador() {
        return event -> {
            Button btn = (Button) event.getSource();
            String op = btn.getText();

            compute(); // Faz a conta do que estava pendente
            
            // Se for 'x', troca por '*' para facilitar a lógica interna
            if (op.equals("x")) lastOperator = '*';
            else lastOperator = op.charAt(0);
            
            // Reseta a string de entrada para o próximo número
            if (!op.equals("=")) {
               inStr = "0"; 
            }
        };
    }

    // 3. Handler para LIMPAR (C)
    public EventHandler<ActionEvent> limpar() {
        return event -> {
            result = 0;
            inStr = "0";
            lastOperator = ' ';
            view.getDisplay().setText("0");
        };
    }

    // Lógica da matemática
    private void compute() {
        int inNum = Integer.parseInt(inStr);
        // Nota: Removi o "inStr = 0" daqui para não bugar a lógica do visual
        
        switch (lastOperator) {
            case ' ': result = inNum; break;
            case '+': result += inNum; break;
            case '-': result -= inNum; break;
            case '*': result *= inNum; break;
            case '/': if(inNum!=0) result /= inNum; break;
            case '=': break;
        }
        
        // Atualiza a tela com o resultado
        view.getDisplay().setText(String.valueOf(result));
    }
}