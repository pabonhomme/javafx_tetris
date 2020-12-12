package modele;

import java.util.ArrayList;

public abstract class Piece {

    private Couleur couleur;
    protected ArrayList<Morceau> listeMorceaux;

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public ArrayList<Morceau> getListeMorceaux() {
        return listeMorceaux;
    }

    public void setListeMorceaux(ArrayList<Morceau> listeMorceaux) {
        this.listeMorceaux = listeMorceaux;
    }

    // Ici franchement j'aurai fait un attribut "typePiece" et un switch case en fonction du nom de l'attribut (gamma, carre, etc)
    // et genre on crée la piece en fonction d'un enum typePiece par exemple
    // et le switch case il rempli les coordonnées de chaque morceau
    // ducoup j'ai fait de la maniere prévue de base dans les constructeurs de chaque piece mais reflechit à mon switch mdr
    public Piece(Couleur couleur){
        this.couleur = couleur;
        this.listeMorceaux = new ArrayList<Morceau>();
        for(int i =0; i<4; i++){
            this.listeMorceaux.add(new Morceau());
        }
    }

    public void bouger(String direction){
        switch (direction) {
            case "bas":
                for (Morceau morceau:listeMorceaux) {
                    morceau.setY(morceau.getY() - 1);
                }
                break;
            case "droite":
                for (Morceau morceau:listeMorceaux) {
                    morceau.setX(morceau.getX() + 1);
                }
                break;
            case "gauche":
                for (Morceau morceau:listeMorceaux) {
                    morceau.setX(morceau.getX() - 1);
                }
                break;
            default:
                break;
        }
    }

    public void faireTournerPiece(){

    }
}
