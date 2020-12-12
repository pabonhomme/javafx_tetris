package modele;

import java.util.ArrayList;

public class Quadrillage {
    private int nbligne;
    private int nbcol;
    private Piece pieceTombant;
    private ArrayList<Morceau> listeMorceaux;

    public int getNbcol() {
        return nbcol;
    }

    public int getNbligne() {
        return nbligne;
    }

    public void setNbcol(int nbcol) {
        this.nbcol = nbcol;
    }

    public void setNbligne(int nbligne) {
        this.nbligne = nbligne;
    }

    public ArrayList<Morceau> getListeMorceaux() {
        return listeMorceaux;
    }

    public Piece getPieceTombant() {
        return pieceTombant;
    }

    public void setPieceTombant(Piece pieceTombant) {
        this.pieceTombant = pieceTombant;
    }

    public Quadrillage(){
        nbligne=20;
        nbcol=10;
        listeMorceaux=new ArrayList<>();
    }
}
