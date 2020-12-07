package main.java.modele;

public class GameManager {
    private Partie jeu;

    public Partie getJeu() {
        return jeu;
    }

    public GameManager(){
    }

    public void lancerPartie(){
        jeu=new Partie();
    }
}
