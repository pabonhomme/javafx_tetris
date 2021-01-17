package modele.pieces;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;

/**
 * Classe qui représente un moreceau d'une pièce
 */
public class Morceau {
    /**
     * Propriété qui contient un int
     */
    private DoubleProperty x = new SimpleDoubleProperty();

    /**
     * Retourne la valeur contenue dans la prpriété
     * @return double
     */
    public double getX(){return x.get();}

    /**
     * Renvoie la propriété
     * @return DoubleProperty
     */
    public DoubleProperty xProperty(){return x;}

    /**
     * donne une valeur à la propriété
     * @param x double
     */
    public void setX(double x){this.x.set(x);}

    /**
     * Propriété qui contient un int
     */
    private DoubleProperty y = new SimpleDoubleProperty();

    /**
     * Retourne la valeur contenue dans la prpriété
     * @return double
     */
    public double getY(){return y.get();}

    /**
     * Renvoie la propriété
     * @return DoubleProperty
     */
    public DoubleProperty yProperty(){return y;}

    /**
     * donne une valeur à la propriété
     * @param y double
     */
    public void setY(double y){this.y.set(y);}

    /**
     * couleur du morceau
     */
    private Color couleur;

    /**
     * constructeur
     * @param couleur couleur voulu, Color
     */
    public Morceau (Color couleur){
        this.couleur=couleur;
        setX(0);
        setY(0);
    }

    /**
     * deuxième constructeur
     * @param x abscisse, int
     * @param y ordonnée, int
     */
    public Morceau (int x, int y){
        setX(x);
        setY(y);
    }

    /**
     * récupère la couleur du morceau
     * @return Color
     */
    public Color getCouleur() {
        return couleur;
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
