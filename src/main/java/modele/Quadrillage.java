package main.java.modele;

import java.util.ArrayList;

public class Quadrillage {
    private int nbligne;
    private int nbcol;
    private ArrayList<Piece> listePieces;

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

    public Quadrillage(){
        nbligne=20;
        nbcol=10;
        listePieces=new ArrayList<Piece>();
    }
}
