package view;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.awt.*;


public class MorceauV extends Parent {

    Rectangle rectangle;

    public MorceauV(double x, double y) {
        rectangle=new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(42);
        rectangle.setHeight(30);
        rectangle.setFill(Color.RED);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeType(StrokeType.INSIDE);
        this.getChildren().addAll(rectangle);
    }

    public void setColorRectangle(Color c){
        rectangle.setFill(c);
    }

}
