package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import modele.GameManager;
import modele.Joueur;

import java.io.IOException;

public class ControllerMenu {

    @FXML
    private ListView<modele.Joueur> top10Joueurs;

    GameManager gmanager = GameManager.getInstance();

    @FXML
    private void clickJouer() {
        try {
            gmanager.chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/Pseudo.fxml")), "/css/tetris.css");

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
        top10Joueurs.itemsProperty().bind(gmanager.top10JoueursProperty()); // binding de la liste des utilisateurs et de leurs score dans la listView

        top10Joueurs.setCellFactory((param ->
                new ListCell<Joueur>() {
                    @Override
                    protected void updateItem(Joueur j, boolean empty) {
                        super.updateItem(j, empty);
                        if(!empty){
                            String value = j.getPseudo() + "\n" + "Score : " + j.getScore();
                            setText(value);
                        }
                        else{
                            textProperty().unbind();
                            setText("");
                        }
                    }
                }
        ));

    }
}
