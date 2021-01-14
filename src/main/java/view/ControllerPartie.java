package view;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
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

    //
    @FXML
    private BorderPane prochainePiece;


    @FXML
    public void initialize() {

        for (Piece piece : gmanager.getJeu().getListePieceEnJeu()) {
            updateEcran(piece);
            UpdatePieceSuivante(gmanager.getJeu().getPieceSuivante());
        }

        gmanager.getJeu().getListePieceEnJeu().addListener((ListChangeListener.Change<? extends Piece> change) -> {
                    change.next();
                    for(Piece piece: change.getAddedSubList()){
                        UpdatePieceSuivante(gmanager.getJeu().getPieceSuivante());
                        updateEcran(piece);
                    }
                }
        );
    }

    private void updateEcran(Piece piece) {

            if (piece instanceof Carre) {
                CarreV carreV = new CarreV(piece);
                ecran.getChildren().add(carreV); // ajout du carreV au Group
            }
    }

    private void UpdatePieceSuivante(Piece piece){
        if (piece instanceof Carre) {
            CarreV carreVSuivante = new CarreV(60, 60, piece);
            prochainePiece.getChildren().add(carreVSuivante); // ajout du carreV au BorderPane
        }
    }
}
