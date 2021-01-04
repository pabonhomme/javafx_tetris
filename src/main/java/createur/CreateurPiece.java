package createur;

import modele.Partie;
import modele.pieces.Piece;

import java.util.Random;

public abstract class CreateurPiece {
    protected Random alea = new Random();

    public abstract void creerPiece(Partie jeu);
}
