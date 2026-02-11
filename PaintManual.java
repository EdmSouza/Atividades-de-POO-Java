import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class PaintManual extends Application {

    // Variáveis para guardar a posição anterior do mouse (para desenhar linhas suaves)
    private double lastX, lastY;

    @Override
    public void start(Stage primaryStage) {
        // 1. Criar o Painel (a nossa "folha" de desenho)
        Pane root = new Pane();
        root.setStyle("-fx-background-color: white;"); // Fundo branco

        // 2. Evento: Quando clicar (abaixar o mouse), guarda a posição inicial
        root.setOnMousePressed(e -> {
            lastX = e.getX();
            lastY = e.getY();
        });

        // 3. Evento: Quando arrastar o mouse, desenha uma linha do ponto anterior até o atual
        root.setOnMouseDragged(e -> {
            // Cria uma linha preta
            Line linha = new Line(lastX, lastY, e.getX(), e.getY());
            linha.setStroke(Color.BLACK);
            linha.setStrokeWidth(3.0); // Espessura do pincel
            
            // Adiciona a linha na tela
            root.getChildren().add(linha);

            // Atualiza a posição "anterior" para a próxima rodada do loop
            lastX = e.getX();
            lastY = e.getY();
        });

        // 4. Configuração da Janela (Stage)
        Scene scene = new Scene(root, 800, 600); // Tamanho 800x600
        primaryStage.setTitle("Paint Manual - Sem FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}