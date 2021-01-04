package console;

import javafx.scene.paint.Color;
import modele.pieces.Carre;
import modele.pieces.Morceau;
import modele.pieces.Piece;

public class Test {
    public static void main(String[] args){
        Piece carre1 = new Carre(20, 320, Color.BLUE);
        Piece carre2 = new Carre(20, 320, Color.BLUE);
        Piece carre3 = new Carre(300, 360, Color.BLUE);

        if(carre1.equals(carre3)){
            System.out.println("égauuux");
        }
        else System.out.println("pas égauuuuux");

        for(Morceau m: carre3.getListeMorceaux()){
            System.out.println(m);
        }
    }
}
