package modele.pieces;

// Elle est constituée de trois carrés en ligne et d'un quatrième carré sous le côté droit
public class Gamma extends Piece{
    public Gamma(int x, int y, Couleur couleur) {
        super(couleur);
        this.creationMorceaux(x, y);
    }

    public void creationMorceaux(int x, int y){
        int i = 0;
        // premier morceau bas gauche
        listeMorceaux.get(i).setX(x);
        listeMorceaux.get(i).setY(y);

        // deuxième morceau haut gauche
        listeMorceaux.get(i+1).setX(x+1);
        listeMorceaux.get(i+1).setY(y);

        // troisème morceau bas droite
        listeMorceaux.get(i+2).setX(x+2);
        listeMorceaux.get(i+2).setY(y);

        // quatrième morceau haut droite
        listeMorceaux.get(i+3).setX(x);
        listeMorceaux.get(i+3).setY(y+1);
    }
}
