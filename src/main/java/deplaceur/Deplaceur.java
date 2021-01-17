package deplaceur;

import collisionneur.Collisionneur;
import javafx.scene.input.KeyEvent;
import modele.pieces.Piece;

/**
 * Classe abstraite qui contient les méthodes pour déplacer
 */
public abstract class Deplaceur {
    /**
     * variable de type collisionneur pour savoir si on peut bouger
     */
    protected Collisionneur leCollisionneur;

    /**
     * constructeur
     * @param leCollisionneur collisionneur de la partie
     */
    public Deplaceur(Collisionneur leCollisionneur){
        this.leCollisionneur = leCollisionneur;
    }

    /**
     * Déplace une pièce vers le bas
     * @param p pièce à déplacer
     */
    public abstract void deplacerBas(Piece p);

    /**
     * Déplace une pièce vers la droite
     * @param p pièce à déplacer
     */
    public abstract void deplacerDroite(Piece p);

    /**
     * Déplace une pièce vers la gauche
     * @param p pièce à déplacer
     */
    public abstract void deplacerGauche(Piece p);

    /**
     * Descend une pièce vers le bas grâce au boucleur
     * @param p pièce à déplacer
     */
    public abstract void descendre(Piece p);

    /**
     * permet de faire tourner la pièce sur elle même
     */
    public abstract void faireTournerPiece(Piece p);
}
