package modele;

public class Joueur {
    private String pseudo;
    private int score;

    public Joueur(){
        this.score=0;
        this.pseudo = "";
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public int getScore(){
        return score;
    }
    public String getPseudo() {
        return pseudo;
    }
}
