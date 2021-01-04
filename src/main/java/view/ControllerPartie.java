package view;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import modele.GameManager;
import modele.pieces.Carre;
import modele.pieces.Morceau;
import modele.pieces.Piece;
import view.ObjetV.CarreV;
import view.ObjetV.MorceauV;

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
                CarreV carreV = new CarreV();
                for (Morceau morceau : piece.getListeMorceaux()) {
                    MorceauV morceauV = new MorceauV(piece.getCouleur());
                    morceauV.layoutXProperty().bind(morceau.xProperty()); // binding des x du modele du morceau
                    morceauV.layoutYProperty().bind(morceau.yProperty()); // binding des y du modele du morceau
                    carreV.addMorceauV(morceauV); // ajout du morceauV au carreV
                }
                ecran.getChildren().add(carreV); // ajout du carreV au Group
            }

    }
}
