package collisionneur;

import modele.pieces.Morceau;

/**
 * classe fille de Collisionneur
 * Permet de savoir si des pièces peuvent bouger dans notre écran
 */
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
