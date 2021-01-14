package createur;

import javafx.scene.paint.Color;
import modele.Partie;
import modele.pieces.Carre;
import modele.pieces.Piece;

public class CreateurPieceSimple extends CreateurPiece {

    /**
     * Création d'une pièce aléatoirement
     * @return Piece
     */
    @Override
    public Piece choixPiece() {
        int i = alea.nextInt(6);
        switch (i) {
            case 0:
                Piece carre1 = new Carre(0, 0, Color.YELLOW);
                return carre1;
            case 1:
                Piece carre2 = new Carre(42, 0, Color.BLUE);
                return carre2;
            case 2:
                Piece carre3 = new Carre(84, 0, Color.RED);
                return carre3;
            case 3:
                Piece carre4 = new Carre(126, 0, Color.GREEN);
                return carre4;
            case 4:
                Piece carre5 = new Carre(168, 0, Color.WHITESMOKE);
                return carre5;
            case 5:
                Piece carre6 = new Carre(210, 0, Color.CYAN);
                return carre6;
            case 6:
                Piece carre7 = new Carre(252, 0, Color.DARKBLUE);
                return carre7;
        }
        return null;
    }

    //

    /**
     * ajout d'une piece aléatoirement dans la liste de piece en jeu
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
