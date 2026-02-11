package com.example;

import com.Figura;

import javafx.scene.canvas.GraphicsContext;

public class Linha extends Figura {
    private double x2, y2;

    public Linha(double x1, double y1, double x2, double y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeLine(x, y, x2, y2);
    }
}