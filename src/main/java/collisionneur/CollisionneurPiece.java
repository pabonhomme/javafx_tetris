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
    public boolean peutBougerEnBas(Piece p) {
        boolean ind = true;
        for (Morceau m : p.getListeMorceaux()) {
            System.out.println(m.getX());
            if (m.getY() >= height - 30 || m.getY() < 0) {
                return false;
            }
            if (jeu.getListeMorceauEnJeu().size() > 1) {
                for (Morceau m2 : jeu.getListeMorceauEnJeu()) {
                    if (m.getY() + 30 == m2.getY() && m.getX() == m2.getX()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean peutBougerDroite(Piece p) {
        for (Morceau m : p.getListeMorceaux()) {
            if (m.getX() + 42 >= width) {
                return false;
            }
            if (jeu.getListeMorceauEnJeu().size() > 1) {
                for (Morceau m2 : jeu.getListeMorceauEnJeu()) {
                    if (m.getY() == m2.getY() && m.getX() + 42 == m2.getX()) {
                        return false;
                    }
                    if (m.getY() == m2.getY() + 15 && m.getX() + 42 == m2.getX()) {
                        return false;
                    }
                    if (m.getY() == m2.getY() - 15 && m.getX() + 42 == m2.getX()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean peutBougerGauche(Piece p) {
        for (Morceau m : p.getListeMorceaux()) {
            if (m.getX() - 21 < 0) {
                return false;
            }
            if (jeu.getListeMorceauEnJeu().size() > 1) {
                for (Morceau m2 : jeu.getListeMorceauEnJeu()) {
                    if (m.getY() == m2.getY() && m.getX() - 42 == m2.getX()) {
                        return false;
                    }
                    if (m.getY() == m2.getY() + 15 && m.getX() - 42 == m2.getX()) {
                        return false;
                    }
                    if (m.getY() == m2.getY() - 15 && m.getX() - 42 == m2.getX()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
