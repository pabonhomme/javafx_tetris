package modele;

public class Partie {
    private int score;
    private Quadrillage ecran;
    private Joueur joueurEnCours;

    public int getScore() {
        return score;
    }

    public Quadrillage getEcran() {
        return ecran;
    }

    public Joueur getJoueurEnCours() { return joueurEnCours; }

    public void setScore(int score) {
        this.score = score;
    }

    public void setEcran(Quadrillage ecran) {
        this.ecran = ecran;
    }

    public void setJoueurEnCours(Joueur joueurEnCours) { this.joueurEnCours = joueurEnCours; }

    public Partie(){
        ecran=new Quadrillage();
        score=0;
        joueurEnCours = new Joueur();
    }
}
