package com.example;

import java.util.ArrayList;
import java.util.List;

import com.Figura;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private List<Figura> figuras = new ArrayList<>();
    private MaoLivre atual;

    // Tipos de figura disponíveis
    private enum TipoFigura {
        RETANGULO,
        CIRCULO,
        LINHA,
    }

    @Override
    public void start(Stage stage) {

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        /* ================= MÃO LIVRE ================= */

        canvas.setOnMousePressed(e -> {
            atual = new MaoLivre(e.getX(), e.getY());
            figuras.add(atual);
        });

        canvas.setOnMouseDragged(e -> {
            if (atual != null) {
                atual.addPonto(e.getX(), e.getY());
                redraw(gc, canvas);
            }
        });

        canvas.setOnMouseReleased(e -> atual = null);



        canvas.setOnDragOver(e -> {
            if (e.getDragboard().hasString()) {
                e.acceptTransferModes(TransferMode.COPY);
            }
            e.consume();
        });

        canvas.setOnDragDropped(e -> {
            Dragboard db = e.getDragboard();
            boolean sucesso = false;

            if (db.hasString()) {
                TipoFigura tipo = TipoFigura.valueOf(db.getString());
                Figura f = criarFigura(tipo, e.getX(), e.getY());
                figuras.add(f);
                redraw(gc, canvas);
                sucesso = true;
            }

            e.setDropCompleted(sucesso);
            e.consume();
        });

        /* ================= LAYOUT ================= */

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setLeft(criarBarraLateral());

        stage.setScene(new Scene(root));
        stage.setTitle("Paint OO");
        stage.show();
    }

    /* ================= BARRA LATERAL ================= */

    private VBox criarBarraLateral() {
        VBox barra = new VBox(10);
        barra.setPrefWidth(130);
        barra.setStyle("-fx-padding: 10; -fx-background-color: #dddddd;");

        barra.getChildren().add(criarBotaoFigura("Retângulo", TipoFigura.RETANGULO));
        barra.getChildren().add(criarBotaoFigura("Círculo", TipoFigura.CIRCULO));
        barra.getChildren().add(criarBotaoFigura("Linha", TipoFigura.LINHA));

        return barra;
    }

    private Button criarBotaoFigura(String texto, TipoFigura tipo) {
        Button btn = new Button(texto);
        btn.setMaxWidth(Double.MAX_VALUE);

        btn.setOnDragDetected(e -> {
            Dragboard db = btn.startDragAndDrop(TransferMode.COPY);
            ClipboardContent content = new ClipboardContent();
            content.putString(tipo.name());
            db.setContent(content);
            e.consume();
        });

        return btn;
    }


    private Figura criarFigura(TipoFigura tipo, double x, double y) {
        switch (tipo) {
            case RETANGULO:
                return new Retangulo(x, y, 120, 80);

            case CIRCULO:
                return new Circulo(x, y, 40);

            case LINHA:
                return new Linha(x, y, x + 100, y + 50);

            default:
                throw new IllegalArgumentException("Tipo de figura inválido");
        }
    }


    private void redraw(GraphicsContext gc, Canvas canvas) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Figura f : figuras) {
            f.draw(gc);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
