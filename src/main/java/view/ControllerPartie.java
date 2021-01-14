package view;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import modele.GameManager;
import modele.pieces.Carre;
import modele.pieces.Piece;
import view.ObjetV.CarreV;

public class ControllerPartie {

    GameManager gmanager = GameManager.getInstance();

    // gridPane de la vue
    @FXML
    private Pane partie;

    // groupe qui contient le quadrillage
    @FXML
    private Group ecran;

    @FXML
    public void initialize() {

        for (Piece piece : gmanager.getJeu().getListePieceEnJeu()) {
            updateEcran(piece);
        }

        gmanager.getJeu().getListePieceEnJeu().addListener((ListChangeListener.Change<? extends Piece> change) -> {
                    change.next();
                    for(Piece piece: change.getAddedSubList()){
                        updateEcran(piece);
                    }
                }
        );
    }

    private void updateEcran(Piece piece) {

            if (piece instanceof Carre) {
                CarreV carreV = new CarreV(piece);
                gmanager.getJeu().setPieceCouranteV(carreV); // Pour tester la collision
                gmanager.getJeu().ajouterPieceV(carreV); // Pour tester la collision
                ecran.getChildren().add(carreV); // ajout du carreV au Group
            }
    }
}
