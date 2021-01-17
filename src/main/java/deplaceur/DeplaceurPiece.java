package deplaceur;

import collisionneur.Collisionneur;
import javafx.scene.input.KeyEvent;
import modele.pieces.Morceau;
import modele.pieces.Piece;

public class DeplaceurPiece extends Deplaceur{

    /**
     * constructeur
     * @param leCollisionneur collisionneur de la partie
     */
    public DeplaceurPiece(Collisionneur leCollisionneur) {
        super(leCollisionneur);
    }

    /**
     * Déplace une pièce vers le bas
     * @param p pièce à déplacer
     */
    @Override
    public void deplacerBas(Piece p) {
        if(leCollisionneur.peutBougerEnBas()){
            for (Morceau morceau:p.getListeMorceaux()) {
                morceau.setY(morceau.getY() + 7.5); // de 15 en 15 pour pas aller trop vite car height morceau = 30
            }
        }
    }

    /**
     * Déplace une pièce vers la droite
     * @param p pièce à déplacer
     */
    @Override
    public void deplacerDroite(Piece p) {
        if(leCollisionneur.peutBougerDroite()){
            for (Morceau morceau:p.getListeMorceaux()) {
                morceau.setX(morceau.getX() + 21);// de 21 en 21 pour pas aller trop vite car width morceau = 42
            }
        }
    }

    /**
     * Déplace une pièce vers la gauche
     * @param p pièce à déplacer
     */
    @Override
    public void deplacerGauche(Piece p) {
        if(leCollisionneur.peutBougerGauche()){
            for (Morceau morceau:p.getListeMorceaux()) {
                morceau.setX(morceau.getX() - 21);// de 21 en 21 pour pas aller trop vite car width morceau = 42
            }
        }
    }

    /**
     * Descend une pièce vers le bas grâce au boucleur
     * @param p pièce à déplacer
     */
    @Override
    public void descendre(Piece p){
        for (Morceau morceau:p.getListeMorceaux()) {
            morceau.setY(morceau.getY() + 15); // de 1 en 1 à 16 milliseconde pour que la descente soit fluide
        }
    }

    /**
     * permet de faire tourner la pièce sur elle même
     */
    @Override
    public void faireTournerPiece(Piece p){

    }
}
