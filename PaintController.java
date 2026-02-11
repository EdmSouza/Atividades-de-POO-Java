import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class PaintController { // Respeitando a grafia com 2 'n's

    @FXML
    private Pane canvasPane; // Certifique-se que o fx:id no Scene Builder é igual
// Certifique-se que o fx:id no Scene Builder é igual

    public PaintController(Pane canvasPane) {
        this.canvasPane = canvasPane;
    }

}