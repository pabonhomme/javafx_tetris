package modele.pieces;

import javafx.scene.paint.Color;

/**
 * Classe Te constituée de trois carrés en ligne et d'un quatrième carré sous le centre
 */
public class Te extends Piece{

    /**
     * constructeur
     * @param x valeur abscisse
     * @param y valeur ordonnée
     * @param couleur couleur de la pièce
     */
    public Te(int x, int y, Color couleur) {
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
        // premier morceau bas gauche
        listeMorceaux.get(i).setX(x);
        listeMorceaux.get(i).setY(y);

        // deuxième morceau haut gauche
        listeMorceaux.get(i+1).setX(x+42);
        listeMorceaux.get(i+1).setY(y);

        // troisème morceau bas droite
        listeMorceaux.get(i+2).setX(x+84);
        listeMorceaux.get(i+2).setY(y);

        // quatrième morceau haut droite
        listeMorceaux.get(i+3).setX(x+42);
        listeMorceaux.get(i+3).setY(y+30);
    }
}
