package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import modele.GameManager;

import java.io.IOException;

public class ControllerFinPartie {

    GameManager gmanager = GameManager.getInstance();

    @FXML
    private void clickRejouer(){
        try {
            gmanager.chargerEcranPartie();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void clickMenu() throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            Scene scene = new Scene(root);
            gmanager.getPrimaryStage().setScene(scene);
            gmanager.getPrimaryStage().show();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @FXML
    private void clickQuitter(){
        gmanager.getPrimaryStage().close();
    }
}
