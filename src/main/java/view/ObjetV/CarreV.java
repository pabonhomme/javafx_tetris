package view.ObjetV;

import javafx.scene.Parent;
import modele.pieces.Morceau;
import modele.pieces.Piece;

public class CarreV extends Parent {

    public void addMorceauV(MorceauV m){
        this.getChildren().add(m);
    }

    public CarreV(Piece piece){
        for (Morceau morceau : piece.getListeMorceaux()) {
            MorceauV morceauV = new MorceauV(piece.getCouleur());
            morceauV.layoutXProperty().bind(morceau.xProperty()); // binding des x du modele du morceau
            morceauV.layoutYProperty().bind(morceau.yProperty()); // binding des y du modele du morceau
            this.addMorceauV(morceauV); // ajout du morceauV au carreV
        }
        // this.getBoundsInParent().intersects() demande au prof comment utiliser ça, il m'a dit que ça permet de voir si des eléments
        // dans la vue se touchent, j'ai donc créé une liste d'éléments view dans Partie pour y avoir accès
        // c'était un peu compliqué
    }

}
