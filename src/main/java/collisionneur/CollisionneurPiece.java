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
    public boolean toucheAutrePiece() {

        for (Piece p : jeu.getListePieceEnJeu()) {
            if(jeu.getPieceCourante() != p){
                if (jeu.getPieceCourante().getListeMorceaux().get(1).getY() + 30 == p.getListeMorceaux().get(0).getY() && jeu.getPieceCourante().getListeMorceaux().get(1).getX() != p.getListeMorceaux().get(0).getX()) {
                    return true;
                }
            }
        }
        return false;
    }
}
