package modele.pieces;

import javafx.scene.paint.Color;

/**
 * Classe Biais constituée de quatre carrés formant un méta-carré de 2x2, dont la rangée supérieure est glissée d'un pas vers la gauche
 */
public class Biais extends Piece{
    public Biais(int x, int y, Color couleur) {
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
        listeMorceaux.get(i+1).setX(x+1);
        listeMorceaux.get(i+1).setY(y);

        // troisème morceau bas droite
        listeMorceaux.get(i+2).setX(x+1);
        listeMorceaux.get(i+2).setY(y+1);

        // quatrième morceau haut droite
        listeMorceaux.get(i+3).setX(x+2);
        listeMorceaux.get(i+3).setY(y+1);
    }
}
