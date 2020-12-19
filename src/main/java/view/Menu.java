package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ColorPicker;
import modele.GameManager;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Menu{

    GameManager gmanager = GameManager.getInstance();

    @FXML
    private ColorPicker colorPickerAAfficher;

    @FXML
    private void clicOnButt(){

        colorPickerAAfficher.setVisible(true);
        gmanager.chargerEcranPartie();
    }

    @FXML
    private void clicJouer() throws Exception{

    }

    @FXML
    public void initialize() {

    }
}
