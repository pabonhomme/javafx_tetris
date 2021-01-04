package deplaceur;

import collisionneur.Collisionneur;
import javafx.scene.input.KeyEvent;
import modele.pieces.Piece;

public abstract class Deplaceur {
    protected Collisionneur leCollisionneur;

    public Deplaceur(Collisionneur leCollisionneur){
        this.leCollisionneur = leCollisionneur;
    }

    public abstract void deplacerBas(Piece p);
    public abstract void deplacerDroite(Piece p);
    public abstract void deplacerGauche(Piece p);
    public abstract void descendre(Piece p);
    public abstract void faireTournerPiece();
}
