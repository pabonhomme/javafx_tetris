package modele;

public class Morceau {
    private int x;
    private int y;

    public Morceau (){
        x = 0;
        y = 0;
    }
    public Morceau (int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
