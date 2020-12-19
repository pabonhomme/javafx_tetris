package view;

import javafx.scene.Parent;
import javafx.scene.paint.Color;

public class CarreV extends Parent {
    MorceauV mor1;
    MorceauV mor2;
    MorceauV mor3;
    MorceauV mor4;

    public CarreV(double x, double y){
        mor1=new MorceauV(x,y);
        mor1.setColorRectangle(Color.BLUE);
        mor2=new MorceauV(x+42,y);
        mor2.setColorRectangle(Color.BLUE);
        mor3=new MorceauV(x,y-30);
        mor3.setColorRectangle(Color.BLUE);
        mor4=new MorceauV(x+42,y-30);
        mor4.setColorRectangle(Color.BLUE);
        this.getChildren().addAll(mor1,mor2,mor3,mor4);
    }
}
