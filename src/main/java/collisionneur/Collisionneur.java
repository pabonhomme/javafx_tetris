package collisionneur;

import javafx.beans.property.DoubleProperty;
import modele.Partie;
import modele.pieces.Piece;

public abstract class Collisionneur {
    protected final double width = 420;

    protected final double height = 600;

    protected Partie jeu;

    public void setJeu(Partie jeu) {
        this.jeu = jeu;
    }

    public abstract boolean peutBouger(double x, double y);
    public abstract boolean toucheAutrePiece(Piece p);

}
