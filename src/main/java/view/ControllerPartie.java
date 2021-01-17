package view;

import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;
import modele.GameManager;
import modele.pieces.Baton;
import modele.pieces.Carre;
import modele.pieces.Morceau;
import modele.pieces.Piece;
import view.ObjetV.BatonV;
import view.ObjetV.CarreV;
import view.ObjetV.MorceauV;

public class ControllerPartie {

    GameManager gmanager = GameManager.getInstance();


    // groupe qui contient le quadrillage
    @FXML
    private Group ecran;

    //
    @FXML
    private BorderPane prochainePiece;

    @FXML
    private Label scoreJoueur;


    @FXML
    public void initialize() {

        Bindings.bindBidirectional(scoreJoueur.textProperty(), gmanager.getJeu().scoreProperty(), new NumberStringConverter()); // binding du score

        for (Piece piece : gmanager.getJeu().getListePieceEnJeu()) {
            updateEcran(piece);
            UpdatePieceSuivante(gmanager.getJeu().getPieceSuivante());
        }

        gmanager.getJeu().getListePieceEnJeu().addListener((ListChangeListener.Change<? extends Piece> change) -> {
                    change.next();
                    for (Piece piece : change.getAddedSubList()) {
                        UpdatePieceSuivante(gmanager.getJeu().getPieceSuivante());
                        updateEcran(piece);
                    }
                }
        );
        gmanager.getJeu().getListeMorceauEnJeu().addListener((ListChangeListener.Change<? extends Morceau> change) -> {
                    change.next();
                    for (Morceau m : change.getRemoved()) {
                        updateEcran(m);
                    }
                }
        );
    }

    private void updateEcran(Morceau m) {
        MorceauV morceauV = new MorceauV(m.getCouleur());
        morceauV.layoutXProperty().bind(m.xProperty());
        morceauV.layoutYProperty().bind(m.yProperty());
        Node mv2 = new MorceauV(m.getCouleur());
        for (Node mv : ecran.getChildren()) {
            if (mv.getLayoutY() == morceauV.getLayoutY() && mv.getLayoutX() == morceauV.getLayoutX()) {
                mv2 = mv;
            }
        }
        if (ecran.getChildren().contains(mv2))
            ecran.getChildren().remove(mv2);
    }

    private void updateEcran(Piece piece) {
        for (Morceau morceau : piece.getListeMorceaux()) {
            MorceauV morceauV = new MorceauV(piece.getCouleur());
            morceauV.layoutXProperty().bind(morceau.xProperty()); // binding des x du modele du morceau
            morceauV.layoutYProperty().bind(morceau.yProperty());
            ecran.getChildren().add(morceauV);
        }
    }

    private void UpdatePieceSuivante(Piece piece) {
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
