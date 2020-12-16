package modele;

import java.util.ArrayList;

public class GameManager {
    private Partie jeu;
    private Option options;
    private BoucleDeJeu boucleDeJeu;
    private ArrayList<Joueur> top10Joueurs;

    public Partie getJeu() {

        return jeu;
    }

    public void setJeu(Partie jeu) {

        this.jeu = jeu;
    }

    public ArrayList<Joueur> getTop10Joueurs() {

        return top10Joueurs;
    }

    public Option getOptions() {

        return options;
    }

    public BoucleDeJeu getBoucleDeJeu() {

        return boucleDeJeu;
    }

    public GameManager(){

    }

    public void lancerPartie(){

        jeu=new Partie();
        boucleDeJeu = new BoucleDeJeu();
        
    }

    public void recupNomJoueur(String pseudo){
        jeu.setPseudoJoueur(pseudo);
    }
}
