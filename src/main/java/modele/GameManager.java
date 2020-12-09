package modele;

import java.util.ArrayList;

public class GameManager {
    private Partie jeu;
    private Option options;
    private ArrayList<Joueur> top10Joueurs;

    public Partie getJeu() {
        return jeu;
    }

    public ArrayList<Joueur> getTop10Joueurs() {
        return top10Joueurs;
    }

    public Option getOptions() {
        return options;
    }

    public GameManager(){
    }

    public void lancerPartie(){
        jeu=new Partie();
    }
}
