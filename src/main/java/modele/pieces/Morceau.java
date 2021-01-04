package modele.pieces;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Morceau {
    private DoubleProperty x = new SimpleDoubleProperty();
        public double getX(){return x.get();}
        public DoubleProperty xProperty(){return x;}
        public void setX(double x){this.x.set(x);}

    private DoubleProperty y = new SimpleDoubleProperty();
        public double getY(){return y.get();}
        public DoubleProperty yProperty(){return y;}
        public void setY(double y){this.y.set(y);}


    public Morceau (){
        setX(0);
        setY(0);
    }
    public Morceau (int x, int y){
        setX(x);
        setY(y);
    }

    @Override
    public boolean equals(Object v) { //méthode equals qui compare entre deux objets, et ensuite entre deux instances d'Utilisateurs.
        if (this == v)
            return true;
        if (v == null)
            return false;
        if(getClass() != v.getClass())
            return false;
        //comparaison
        Morceau m = (Morceau)v;
        if(getX() != m.getX())
            return false;
        return getY() == m.getY();
    }
}
