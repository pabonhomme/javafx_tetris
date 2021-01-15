package view;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import modele.GameManager;
import modele.pieces.Baton;
import modele.pieces.Carre;
import modele.pieces.Piece;
import view.ObjetV.BatonV;
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
            ecran.getChildren().add(carreV);
        }
        if (piece instanceof Baton) {
            BatonV batonV = new BatonV(piece);
            ecran.getChildren().add(batonV); // ajout du carreV au Group
        }
    }

    private void UpdatePieceSuivante(Piece piece){
        if (!prochainePiece.getChildren().isEmpty())
            prochainePiece.getChildren().clear();
        if (piece instanceof Carre) {
            CarreV carreVSuivante = new CarreV(60, 90, piece);
            prochainePiece.getChildren().add(carreVSuivante); // ajout du carreV au BorderPane
        }
        if (piece instanceof Baton) {
            BatonV batonVSuivante = new BatonV(60, 150, piece);
            prochainePiece.getChildren().add(batonVSuivante); // ajout du carreV au BorderPane
        }
    }
}
