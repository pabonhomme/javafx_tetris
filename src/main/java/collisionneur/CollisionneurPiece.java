package collisionneur;

import modele.Partie;
import modele.pieces.Morceau;
import modele.pieces.Piece;
import view.ObjetV.CarreV;

public class CollisionneurPiece extends Collisionneur {

    @Override
    public boolean toucheHautEcran() {
        if (jeu.getListeMorceauEnJeu().size() > 1) {
            for (Morceau m : jeu.getListeMorceauEnJeu()) {
                    if (m.getY() == 0){
                        return true;
                    }
            }
        }
        return false;
    }

    @Override
    public boolean peutBougerEnBas() {
        boolean ind = true;
        for (Morceau m : jeu.getPieceCourante().getListeMorceaux()) {
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
    public boolean peutBougerDroite() {
        for (Morceau m : jeu.getPieceCourante().getListeMorceaux()) {
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
    public boolean peutBougerGauche() {
        for (Morceau m : jeu.getPieceCourante().getListeMorceaux()) {
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
