package modele.pieces;

// Elle est constituée de quatre carrés formant un méta-carré de 2x2
public class Carre extends Piece{
    public Carre(int x, int y,Couleur couleur) {
        super(couleur);
        this.creationMorceaux(x, y);
    }

    public void creationMorceaux(int x, int y){
        int i = 0;
        // premier morceau bas gauche
        listeMorceaux.get(i).setX(x);
        listeMorceaux.get(i).setY(y);

        // deuxième morceau haut gauche
        listeMorceaux.get(i+1).setX(x);
        listeMorceaux.get(i+1).setY(y+1);

        // troisème morceau bas droite
        listeMorceaux.get(i+2).setX(x+1);
        listeMorceaux.get(i+2).setY(y);

        // quatrième morceau haut droite
        listeMorceaux.get(i+3).setX(x+1);
        listeMorceaux.get(i+3).setY(y+1);
    }

}
