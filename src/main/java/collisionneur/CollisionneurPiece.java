package collisionneur;

import modele.Partie;
import modele.pieces.Morceau;
import modele.pieces.Piece;

public class CollisionneurPiece extends Collisionneur {

    @Override
    public boolean peutBouger(double x, double y) {
        return x >= 0 && x <= width - 84 && y < height - 60; // marche pour un carré, à voir pr autres pieces
    }

    @Override
    public boolean toucheAutrePiece(Piece p) {

        for (Morceau m : p.getListeMorceaux()) {
            if (jeu.getPieceCourante().getListeMorceaux().get(2).getY() == m.getY()) {
                return true;
            }
        }
        return false;
    }
}
