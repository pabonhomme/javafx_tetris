package view;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MorceauV extends Parent {

    Rectangle rectangle;

    public MorceauV() {
        rectangle=new Rectangle();
        rectangle.setX(20);
        rectangle.setY(20);
        rectangle.setWidth(10);
        rectangle.setHeight(10);
        rectangle.setFill(Color.RED);
        this.getChildren().addAll(rectangle);
    }

}
