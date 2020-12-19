package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.GameManager;

import java.io.IOException;

public class ControllerMenu {

    GameManager gmanager = GameManager.getInstance();

    @FXML
    private void clickJouer(){
        try {
            gmanager.chargerEcranPartie();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    public void initialize() {

    }
}
