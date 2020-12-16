package modele;

import modele.pieces.Morceau;

import java.util.ArrayList;

public class Partie {
    private int score;
    private Joueur joueurEnCours;
    private Boolean estFini;
    private ArrayList<Morceau> listePieceEnJeu;
    private ArrayList<String> listePiece;

    public int getScore() {

        return score;
    }

    public void setScore(int score) {

        this.score = score;
    }

    public Joueur getJoueurEnCours() {

        return joueurEnCours;
    }

    public Boolean getEstFini() {

        return estFini;
    }

    public Partie(){
        this.score=0;
        this.estFini = false;
        joueurEnCours = new Joueur();
    }
    public void setPseudoJoueur(String pseudo){
        this.joueurEnCours.setPseudo(pseudo);
    }
}
