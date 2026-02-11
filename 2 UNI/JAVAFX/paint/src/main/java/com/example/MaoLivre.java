package com.example;

import java.util.ArrayList;
import java.util.List;

import com.Figura;

import javafx.scene.canvas.GraphicsContext;

public class MaoLivre extends Figura {
    private List<Double> pontos = new ArrayList<>();

    public MaoLivre(double x, double y) {
        super(x, y);
        pontos.add(x);
        pontos.add(y);
    }

    public void addPonto(double x, double y) {
        pontos.add(x);
        pontos.add(y);
    }

    @Override
    public void draw(GraphicsContext gc) {
        for (int i = 2; i < pontos.size(); i += 2) {
            gc.strokeLine(
                pontos.get(i - 2), pontos.get(i - 1),
                pontos.get(i), pontos.get(i + 1)
            );
        }
    }
}
