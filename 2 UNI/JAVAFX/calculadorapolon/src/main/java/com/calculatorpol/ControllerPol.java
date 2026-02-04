package com.calculatorpol;

import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button; // Importante: Importar a classe de Pilha

public class ControllerPol {
    private CalculatorPolView view;
    
    // A estrutura de dados mágica
    private Stack<Double> pilha = new Stack<>();
    
    // Controle para saber se devo limpar a tela ao digitar um novo número
    private boolean novoNumero = true;

    public ControllerPol(CalculatorPolView view) {
        this.view = view;
    }

    // 1. DÍGITOS (0-9)
    public EventHandler<ActionEvent> digito() {
        return event -> {
            String digito = ((Button) event.getSource()).getText();
            String textoAtual = view.getDisplay().getText();

            // Se for para começar um número novo (ex: logo após dar Enter), limpa
            if (novoNumero) {
                view.getDisplay().setText(digito);
                novoNumero = false;
            } else {
                view.getDisplay().setText(textoAtual + digito);
            }
        };
    }

    // 2. O BOTÃO ENTER (Empilha)
    public EventHandler<ActionEvent> enter() {
        return event -> {
            try {
                // Pega o número da tela
                String texto = view.getDisplay().getText();
                double valor = Double.parseDouble(texto);
                
                // Joga no topo da pilha
                pilha.push(valor);
                
                // Avisa que o próximo dígito deve limpar a tela
                novoNumero = true;
                
                //Piscar a tela ou limpar para indicar que foi salvo
                view.getDisplay().setText(""); 
            } catch (NumberFormatException e) {
                view.getDisplay().setText("Erro");
            }
        };
    }

    // 3. OPERADORES (Desempilha 2 e Calcula)
    public EventHandler<ActionEvent> operador() {
        return event -> {
            // Só podemos calcular se tivermos pelo menos 2 números na pilha
            if (pilha.size() < 2) {
                return; // Ignora se não tiver números suficientes
            }

            // O último a entrar é o 'b' (segundo operando)
            double b = pilha.pop(); 
            double a = pilha.pop(); 
            double resultado = 0;

            String op = ((Button) event.getSource()).getText();
            
            switch (op) {
                case "+": resultado = a + b; break;
                case "-": resultado = a - b; break;
                case "x": resultado = a * b; break;
                case "/": resultado = a / b; break;
            }

            // Empilha o resultado de volta (para contas futuras)
            pilha.push(resultado);
            
            // Mostra o resultado
            view.getDisplay().setText(String.valueOf(resultado));
            novoNumero = true;
        };
    }

    // 4. LIMPAR (C)
    public EventHandler<ActionEvent> limpar() {
        return event -> {
            pilha.clear(); // Esvazia a pilha toda
            view.getDisplay().setText("0");
            novoNumero = true;
        };
    }
}