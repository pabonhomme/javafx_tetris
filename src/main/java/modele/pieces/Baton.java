package modele.pieces;

import javafx.scene.paint.Color;

// Elle est constituée de quatre carrés formant une ligne
public class Baton extends Piece{
    public Baton(int x, int y, Color couleur) {
        super(couleur);
        this.creationMorceaux(x, y);
    }

    // créé en vertical
    public void creationMorceaux(int x, int y){
        int i = 0;
        // premier morceau bas gauche
        listeMorceaux.get(i).setX(x);
        listeMorceaux.get(i).setY(y);

        // deuxième morceau
        listeMorceaux.get(i+1).setX(x+1);
        listeMorceaux.get(i+1).setY(y);

        // troisème morceau
        listeMorceaux.get(i+2).setX(x+2);
        listeMorceaux.get(i+2).setY(y);

        // quatrième morceau
        listeMorceaux.get(i+3).setX(x+3);
        listeMorceaux.get(i+3).setY(y);
    }
}
