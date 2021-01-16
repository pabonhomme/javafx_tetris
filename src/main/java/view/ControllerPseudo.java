package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.GameManager;

public class ControllerPseudo {

    GameManager gmanager = GameManager.getInstance();

    @FXML
    private TextField pseudo;

    @FXML
    private void clickJouer(){
        try {
            gmanager.chargerEcranPartie(pseudo.getText());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
