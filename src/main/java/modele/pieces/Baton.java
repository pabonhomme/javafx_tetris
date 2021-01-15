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
