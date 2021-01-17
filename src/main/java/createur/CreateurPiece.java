package createur;

import modele.Partie;
import modele.pieces.Piece;

import java.util.Random;

/**
 * Classe abstraite qui contient les méthodes pour créer des pièces
 */
public abstract class CreateurPiece {
    /**
     * Random pour générer une pièce aléatoirement
     */
    protected Random alea = new Random();

    /**
     * permet de créer une pièce aléatoirement
     * @return Piece
     */
    public abstract Piece choixPiece();

    /**
     * création de la pièce courante et de la pièce suivante
     * @param jeu partie en cours
     */
    public abstract void creerPiece(Partie jeu);
}
