package modele.pieces;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public abstract class Piece {

    private Color couleur;
    protected ArrayList<Morceau> listeMorceaux;

    public Color getCouleur() {

        return couleur;
    }

    public void setCouleur(Color couleur) {

        this.couleur = couleur;
    }

    public ArrayList<Morceau> getListeMorceaux() {

        return listeMorceaux;
    }

    public void setListeMorceaux(ArrayList<Morceau> listeMorceaux) {

        this.listeMorceaux = listeMorceaux;
    }

    // constructeur
    public Piece(Color couleur){
        this.couleur = couleur;
        this.listeMorceaux = new ArrayList<Morceau>();
        for(int i =0; i<4; i++){
            this.listeMorceaux.add(new Morceau());
        }
    }

    @Override
    public boolean equals(Object v) { //méthode equals qui compare entre deux objets, et ensuite entre deux instances d'Utilisateurs.
        if (this == v)
            return true;
        if (v == null)
            return false;
        if(getClass() != v.getClass())
            return false;
        //comparaison
        Piece p = (Piece)v;
        ArrayList<Morceau> listeMorP = (ArrayList<Morceau>) p.getListeMorceaux().clone(); // liste auxiliaire pour tester chaque morceau
        if(!getCouleur().equals(p.getCouleur()))
            return false;
        for(Morceau m1:getListeMorceaux()){
            for (Morceau m2:listeMorP){
                if(!m1.equals(m2)){
                    return false;
                }
                listeMorP.remove(m2); // suppression du morceau en cours car quand on break on reprend au tout début de la liste
                break;
            }
        }
        return true;
    }
}
