package deplaceur;

import collisionneur.Collisionneur;
import javafx.scene.input.KeyEvent;
import modele.pieces.Morceau;
import modele.pieces.Piece;

public class DeplaceurPiece extends Deplaceur{
    public DeplaceurPiece(Collisionneur leCollisionneur) {
        super(leCollisionneur);
    }

    @Override
    public void deplacerBas(Piece p) {
        if(leCollisionneur.peutBouger(p.getListeMorceaux().get(0).getX(),p.getListeMorceaux().get(0).getY())){
            for (Morceau morceau:p.getListeMorceaux()) {
                morceau.setY(morceau.getY() + 15); // de 15 en 15 pour pas aller trop vite car height morceau = 30
//                System.out.println(morceau.getY());
            }
        }
    }

    @Override
    public void deplacerDroite(Piece p) {
        if(leCollisionneur.peutBouger(p.getListeMorceaux().get(0).getX() +21,p.getListeMorceaux().get(0).getY())){
            for (Morceau morceau:p.getListeMorceaux()) {
                morceau.setX(morceau.getX() + 21);// de 21 en 21 pour pas aller trop vite car width morceau = 42
                //System.out.println(morceau.getX());
            }
        }
    }

    @Override
    public void deplacerGauche(Piece p) {
        if(leCollisionneur.peutBouger(p.getListeMorceaux().get(0).getX()-21,p.getListeMorceaux().get(0).getY())){
            for (Morceau morceau:p.getListeMorceaux()) {
                morceau.setX(morceau.getX() - 21);// de 21 en 21 pour pas aller trop vite car width morceau = 42
            }
        }
    }

    public void descendre(Piece p){
        if(leCollisionneur.peutBouger(p.getListeMorceaux().get(0).getX(),p.getListeMorceaux().get(0).getY())){
            for (Morceau morceau:p.getListeMorceaux()) {
                morceau.setY(morceau.getY() + 15); // de 1 en 1 à 16 milliseconde pour que la descente soit fluide
                //System.out.println(morceau.getY());
            }
        }
    }

    public void faireTournerPiece(){

    }
}
