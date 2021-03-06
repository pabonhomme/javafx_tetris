package modele.pieces;

import javafx.scene.paint.Color;

/**
 * Classe Carre constituée de quatre carrés formant un méta-carré de 2x2
 */
public class Carre extends Piece{

    /**
     * constructeur
     * @param x valeur abscisse
     * @param y valeur ordonnée
     * @param couleur couleur de la pièce
     */
    public Carre(int x, int y, Color couleur) {
        super(couleur);
        this.setPositionsMorceaux(x, y);
    }

    /**
     * Donne des coordonnées à chaque morceaux
     * @param x valeur abscisse
     * @param y valeur ordonnée
     */
    @Override
    public void setPositionsMorceaux(int x, int y){
        int i = 0;
        // premier morceau haut gauche
        listeMorceaux.get(i).setX(x);
        listeMorceaux.get(i).setY(y);

        // deuxième morceau bas gauche
        listeMorceaux.get(i+1).setX(x);
        listeMorceaux.get(i+1).setY(y+30);

        // troisième morceau haut droite
        listeMorceaux.get(i+2).setX(x+42);
        listeMorceaux.get(i+2).setY(y);

        // quatrième morceau bas droite
        listeMorceaux.get(i+3).setX(x+42);
        listeMorceaux.get(i+3).setY(y+30);
    }

}
