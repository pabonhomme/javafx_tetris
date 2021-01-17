package view.ObjetV;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;



/**
 * Classe qui représente la vue d'un morceau
 */
public class MorceauV extends Parent {

    /**
     * rectancle qui modélise le carré
     */
    Rectangle rectangle;

    /**
     * constructeur
     * @param color
     */
    public MorceauV( Color color) {
        rectangle=new Rectangle();
        rectangle.setWidth(42);
        rectangle.setHeight(30);
        rectangle.setFill(color);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeType(StrokeType.INSIDE);
        this.getChildren().addAll(rectangle);
    }

}
