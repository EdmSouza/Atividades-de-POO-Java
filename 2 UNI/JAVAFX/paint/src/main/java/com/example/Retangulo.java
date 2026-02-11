package com.example;

import com.Figura;

import javafx.scene.canvas.GraphicsContext;

public class Retangulo extends Figura {
    private double largura, altura;

    public Retangulo(double x, double y, double largura, double altura) {
        super(x, y);
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeRect(x, y, largura, altura);
    }
}
