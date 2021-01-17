package view;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.converter.NumberStringConverter;
import modele.GameManager;
import modele.Joueur;

import java.io.IOException;

public class ControllerFinPartie {

    GameManager gmanager = GameManager.getInstance();

    @FXML
    private Label pseudoAafficher;
    @FXML
    private Label scoreFinal;
    @FXML
    private ListView<modele.Joueur> top10Joueurs;


    @FXML
    public void initialize(){
        gmanager.ajouterJoueurTop10();
        pseudoAafficher.setText("Bien joué " + gmanager.getJoueurEnCours().getPseudo()); // on bind le pseudo du joueur
        Bindings.bindBidirectional(scoreFinal.textProperty(),gmanager.getJeu().scoreProperty(), new NumberStringConverter()); // on bind le score du joueur

        top10Joueurs.itemsProperty().bind(gmanager.top10JoueursProperty()); // binding de la liste des utilisateurs et de leurs score dans la listView

        top10Joueurs.setCellFactory((param ->
                new ListCell<Joueur>() {
                    @Override
                    protected void updateItem(Joueur j, boolean empty) {
                        super.updateItem(j, empty);
                        if(!empty){
                            String value = j.getPseudo() + "\n" + "Score : " + j.getScore(); // si la cellule n'est pas vide on remplit avec le texte associé
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
            gmanager.chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml")), "/css/tetris.css");

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @FXML
    private void clickQuitter(){

        gmanager.getPrimaryStage().close();
    }
}
