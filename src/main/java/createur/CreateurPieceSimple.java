package createur;

import javafx.scene.paint.Color;
import modele.Partie;
import modele.pieces.Baton;
import modele.pieces.Carre;
import modele.pieces.Piece;
import modele.pieces.Te;

/**
 * classe instanciable qui permet de créer des pièces
 */
public class CreateurPieceSimple extends CreateurPiece {

    /**
     * Création d'une pièce aléatoirement
     * @return Piece
     */
    @Override
    public Piece choixPiece() {
        int i = alea.nextInt(7);
        switch (i) {
            case 0:
                Piece carre1 = new Carre(0, 0, Color.YELLOW);
                return carre1;
            case 1:
                Piece carre2 = new Carre(42, 0, Color.BLUE);
                return carre2;
            case 2:
                Piece carre3 = new Te(84, 0, Color.RED);
                return carre3;
            case 3:
                Piece carre4 = new Te(126, 0, Color.GREEN);
                return carre4;
            case 4:
                Piece baton1 = new Baton(168, 0, Color.GRAY);
                return baton1;
            case 5:
                Piece baton2 = new Baton(210, 0, Color.CYAN);
                return baton2;
            case 6:
                Piece baton3 = new Baton(252, 0, Color.DARKBLUE);
                return baton3;
        }
        return null;
    }

    /**
     * création de la pièce courante et de la pièce suivante
     * @param jeu partie en cours
     */
    @Override
    public void creerPiece(Partie jeu) {
        if (jeu.getListePieceEnJeu().isEmpty()) {
            Piece piece = choixPiece();
            Piece pieceSuivante = choixPiece();
            jeu.ajouterPiece(piece);
            jeu.setPieceCourante(piece);
            jeu.setPieceSuivante(pieceSuivante);
        } else {
            jeu.setPieceCourante(jeu.getPieceSuivante());
            Piece pieceSuivante = choixPiece();
            jeu.setPieceSuivante(pieceSuivante);
            jeu.ajouterPiece(jeu.getPieceCourante());
        }
    }
}
