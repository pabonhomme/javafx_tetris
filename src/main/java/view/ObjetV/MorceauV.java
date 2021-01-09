package view.ObjetV;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.awt.*;


public class MorceauV extends Parent {

    Rectangle rectangle;

    public MorceauV( Color color) {
        rectangle=new Rectangle();
        rectangle.setWidth(42);
        rectangle.setHeight(30);
        rectangle.setFill(color);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeType(StrokeType.INSIDE);
        this.getChildren().addAll(rectangle);
    }

    public void setColorRectangle(Color c){
        rectangle.setFill(c);
    }

}
