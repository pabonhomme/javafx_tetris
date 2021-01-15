package view.ObjetV;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import modele.pieces.Morceau;
import modele.pieces.Piece;

public class BatonV extends Parent{

    private void creerMorceau(double x, double y, Color color){
        MorceauV morceauV = new MorceauV(color);
        morceauV.setLayoutX(x);
        morceauV.setLayoutY(y);
        this.addMorceauV(morceauV); // ajout du morceauV au carreV
    }

    public void addMorceauV(MorceauV m){
        this.getChildren().add(m);
    }

    public BatonV(Piece piece){
        for (Morceau morceau : piece.getListeMorceaux()) {
            MorceauV morceauV = new MorceauV(piece.getCouleur());
            morceauV.layoutXProperty().bind(morceau.xProperty()); // binding des x du modele du morceau
            morceauV.layoutYProperty().bind(morceau.yProperty()); // binding des y du modele du morceau
            this.addMorceauV(morceauV); // ajout du morceauV au carreV
        }
    }

    public BatonV(double x, double y, Piece piece){
        for(int i =0; i<4; i++){
            switch (i){
                case 0:
                    this.creerMorceau(x, y, piece.getCouleur());
                    break;
                case 1:
                    this.creerMorceau(x, y-30, piece.getCouleur());
                    break;
                case 2:
                    this.creerMorceau(x, y-60, piece.getCouleur());
                    break;
                case 3:
                    this.creerMorceau(x, y-90, piece.getCouleur());
                    break;
            }
        }
    }
}
