package collisionneur;

import modele.Partie;
import modele.pieces.Morceau;
import modele.pieces.Piece;
import view.ObjetV.CarreV;

public class CollisionneurPiece extends Collisionneur {

    @Override
    public boolean peutBouger(double x, double y) {
        return x >= 0 && x <= width - 84 && y < height - 60; // marche pour un carré, à voir pr autres pieces
    }

    @Override
    public boolean toucheAutrePieceGauche() {

        for (Piece p : jeu.getListePieceEnJeu()) {
            if (jeu.getPieceCourante() != p) {
                if (jeu.getPieceCourante().getListeMorceaux().get(1).getX() == p.getListeMorceaux().get(0).getX()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean toucheAutrePieceDroite() {

        for (Piece p : jeu.getListePieceEnJeu()) {
            if (jeu.getPieceCourante() != p) {
                if (jeu.getPieceCourante().getListeMorceaux().get(1).getX() == p.getListeMorceaux().get(0).getX() + 84) {
                    return true;
                }
            }
        }
        return false;
    }

        @Override
    public boolean toucheAutrePieceV() {
        for (CarreV carreV : jeu.getListePieceEnJeuV()) {
            if(carreV != jeu.getPieceCouranteV()){
                if(jeu.getPieceCouranteV().getBoundsInParent().intersects(carreV.getBoundsInParent())){
                    return true;
                }
            }
        }
        return false;
    }


}
