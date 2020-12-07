package main.java.modele;

public abstract class Piece {
    private int x;
    private int y;
    private Couleur couleur;

    public Couleur getCouleur() {
        return couleur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece(int x, int y, Couleur couleur){
        this.x = x;
        this.y = y;
        this.couleur = couleur;
    }
}
