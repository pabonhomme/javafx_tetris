package view;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modele.pieces.Carre;


public class PartieV extends Parent {
    Region quadrillage;
    MorceauV mor;
    CarreV carr;

    public PartieV(){
        mor=new MorceauV(168,30);
        carr=new CarreV(42,360);
        quadrillage=new Region();
        quadrillage.setStyle("-fx-border-style: solid; -fx-border-color: black;");
        quadrillage.setPrefWidth(420);
        quadrillage.setPrefHeight(600);
        this.getChildren().addAll(quadrillage,mor,carr);
    }
}
