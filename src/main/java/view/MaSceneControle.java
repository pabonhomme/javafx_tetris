package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MaSceneControle {
    @FXML
    private GridPane grille;

    @FXML
    private Button butt;

    @FXML
    private Label labelAAfficher;

    @FXML
    private ColorPicker colorPickerAAfficher;

    @FXML
    private void clicOnButt(){
        colorPickerAAfficher.setVisible(true);
    }
}
