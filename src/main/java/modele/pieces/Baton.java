package modele.pieces;

import javafx.scene.paint.Color;

/**
 * Classe baton constituée de quatre carrés formant une ligne
 */
public class Baton extends Piece{
    /**
     * constructeur
     * @param x valeur abscisse
     * @param y valeur ordonnée
     * @param couleur couleur de la pièce
     */
    public Baton(int x, int y, Color couleur) {
        super(couleur);
        this.setPositionsMorceaux(x, y);
    }



    /**
     * Donne des coordonnées à chaque morceaux, créé en vertical
     * @param x valeur abscisse
     * @param y valeur ordonnée
     */
    @Override
    public void setPositionsMorceaux(int x, int y){
        int i = 0;
        // premier morceau haut
        listeMorceaux.get(i).setX(x);
        listeMorceaux.get(i).setY(y);

        // deuxième morceau 2eme haut
        listeMorceaux.get(i+1).setX(x);
        listeMorceaux.get(i+1).setY(y+30);

        // troisème morceau 2eme bas
        listeMorceaux.get(i+2).setX(x);
        listeMorceaux.get(i+2).setY(y+60);

        // quatrième morceau bas
        listeMorceaux.get(i+3).setX(x);
        listeMorceaux.get(i+3).setY(y+90);
    }
}
