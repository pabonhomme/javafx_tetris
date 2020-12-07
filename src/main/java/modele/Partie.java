package main.java.modele;

public class Partie {
    private Quadrillage ecran;
    private int score;

    public int getScore() {
        return score;
    }

    public Quadrillage getEcran() {
        return ecran;
    }

    public void setEcran(Quadrillage ecran) {
        this.ecran = ecran;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Partie(){
        ecran=new Quadrillage();
        score=0;
    }
}
