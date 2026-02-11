package com.example;

import javafx.scene.canvas.GraphicsContext;
public class Quadrado extends Retangulo {
    double lado;

    public Quadrado(double x, double y, double lado) {
        super(x, y, lado, lado);
        this.lado = lado;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeRect(x, y, lado, lado);
    }
}
