package com.example;

import com.Figura;

import javafx.scene.canvas.GraphicsContext;

public class Circulo extends Figura {
    private double raio;

    public Circulo(double x, double y, double raio) {
        super(x, y);
        this.raio = raio;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeOval(x - raio, y - raio, raio * 2, raio * 2);
    }
}
