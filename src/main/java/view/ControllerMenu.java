package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.GameManager;

import java.io.IOException;

public class ControllerMenu {

    GameManager gmanager = GameManager.getInstance();

    @FXML
    private void clickJouer() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Pseudo.fxml"));
            Scene scene = new Scene(root);
            gmanager.getPrimaryStage().setScene(scene);
            gmanager.getPrimaryStage().show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void clickQuitter() {

        gmanager.getPrimaryStage().close();
    }

    @FXML
    public void initialize() {

    }
}
