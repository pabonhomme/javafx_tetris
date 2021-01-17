package modele.pieces;

import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 * Classe abstraite qui représente une pièce
 */
public abstract class Piece {

    /**
     * couleur de la pièce
     */
    private Color couleur;

    /**
     * liste de morceaux de la liste
     */
    protected ArrayList<Morceau> listeMorceaux;

    /**
     * récupère la couleur de la pièce
     * @return Color
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * set la couleur de la pièce
     * @param couleur Color
     */
    public void setCouleur(Color couleur) {

        this.couleur = couleur;
    }

    /**
     * récupère la liste de morceaux de la pièces
     * @return la liste de morceaux
     */
    public ArrayList<Morceau> getListeMorceaux() {

        return listeMorceaux;
    }

    /**
     * set la liste de morceaux de la liste
     * @param listeMorceaux reçoit une liste de Morceaux
     */
    public void setListeMorceaux(ArrayList<Morceau> listeMorceaux) {

        this.listeMorceaux = listeMorceaux;
    }

    /**
     * constructeur Piece
     * @param couleur Color de la pièce
     */
    public Piece(Color couleur){
        this.couleur = couleur;
        this.listeMorceaux = new ArrayList<Morceau>();
        for(int i =0; i<4; i++){
            this.listeMorceaux.add(new Morceau(couleur));
        }
    }

    /**
     * Donne des coordonnées à chaque morceaux, créé en vertical
     * @param x valeur abscisse
     * @param y valeur ordonnée
     */
    public abstract void setPositionsMorceaux(int x, int y);

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
