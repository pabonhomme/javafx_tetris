package view;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import modele.GameManager;

import java.io.IOException;

public class ControllerFinPartie {

    GameManager gmanager = GameManager.getInstance();

    @FXML
    private Label pseudoAafficher;
    @FXML
    private Label scoreFinal;


    @FXML
    public void initialize(){
        pseudoAafficher.setText("Bien joué lolipop");
        Bindings.bindBidirectional(scoreFinal.textProperty(),gmanager.getJeu().getScore(), new NumberStringConverter());
    }

    @FXML
    private void clickRejouer(){
        try {
            gmanager.chargerEcranPartie(gmanager.getJoueurEnCours().getPseudo()); // si rejouer alors même joueur donc on renvoie le même pseudo
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void clickMenu() throws IOException {
        try {
            gmanager.getJoueurEnCours().setPseudo(""); // si on va sur le menu alors pseudo réinitialisé
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
