package modele;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.pieces.Morceau;
import modele.pieces.Piece;
import view.ObjetV.CarreV;

import java.util.ArrayList;

public class Partie {
    private SimpleIntegerProperty score;

    private Piece pieceCourante;
    private Piece pieceSuivante;
    private Boolean estFini;
    private ObservableList<Piece> listePieceEnJeu = FXCollections.observableArrayList();
    private ObservableList<Morceau> listeMorceauEnJeu = FXCollections.observableArrayList();

    public SimpleIntegerProperty scoreProperty() { return score; }
    public int getScore() { return this.score.get(); }
    public void setScore(int x) { this.score.set(x); }


    public Piece getPieceCourante() {

        return pieceCourante;
    }

    public void setPieceCourante(Piece pieceCourante) {

        this.pieceCourante = pieceCourante;
    }

    public Boolean getEstFini() {

        return estFini;
    }

    public void setEstFini(Boolean estFini) {

        this.estFini = estFini;
    }

    public Partie(){
        this.score=new SimpleIntegerProperty(0);
        this.estFini = false;

    }

    public ObservableList<Piece> getListePieceEnJeu() {

        return listePieceEnJeu;
    }

    public void ajouterPiece(Piece p){

        listePieceEnJeu.add(p);
    }
  public ObservableList<Morceau> getListeMorceauEnJeu() {

        return listeMorceauEnJeu;
    }

    public void ajouterMorceau(Morceau m){

        listeMorceauEnJeu.add(m);
    }
    public void suppMorceau(Morceau m){

        listeMorceauEnJeu.remove(m);
    }

    public Piece getPieceSuivante() {

        return pieceSuivante;
    }

    public void setPieceSuivante(Piece pieceSuivante) {

        this.pieceSuivante = pieceSuivante;
    }

    public int  peutSupprimer(){ //retourner les lignes remplie de morceaux à supprimer
        ArrayList<Integer> ligne= new ArrayList<>(20);
        //ArrayList<Integer> ret= new ArrayList<>();
        for (int i=0; i<20;i++){
            ligne.add(0);
        }
        for (Morceau m : this.getListeMorceauEnJeu()) {
            if (m.getY()==570)
                ligne.set(0,ligne.get(0)+1);
            else if (m.getY()==540)
                ligne.set(1,ligne.get(1)+1);
            else if (m.getY()==510)
                ligne.set(2,ligne.get(2)+1);
            else if (m.getY()==480)
                ligne.set(3,ligne.get(3)+1);
            else if (m.getY()==450)
                ligne.set(4,ligne.get(4)+1);
            else if (m.getY()==420)
                ligne.set(5,ligne.get(5)+1);
            else if (m.getY()==390)
                ligne.set(6,ligne.get(6)+1);
            else if (m.getY()==360)
                ligne.set(7,ligne.get(7)+1);
            else if (m.getY()==330)
                ligne.set(8,ligne.get(8)+1);
            else if (m.getY()==300)
                ligne.set(9,ligne.get(9)+1);
            else if (m.getY()==270)
                ligne.set(10,ligne.get(10)+1);
            else if (m.getY()==240)
                ligne.set(11,ligne.get(11)+1);
            else if (m.getY()==210)
                ligne.set(12,ligne.get(12)+1);
            else if (m.getY()==180)
                ligne.set(13,ligne.get(13)+1);
            else if (m.getY()==150)
                ligne.set(14,ligne.get(14)+1);
            else if (m.getY()==120)
                ligne.set(15,ligne.get(15)+1);
            else if (m.getY()==90)
                ligne.set(16,ligne.get(16)+1);
            else if (m.getY()==60)
                ligne.set(17,ligne.get(17)+1);
            else if (m.getY()==30)
                ligne.set(18,ligne.get(18)+1);
            else
                ligne.set(19,ligne.get(19)+1);
        }
        for (int i=0; i<20;i++){
            if (ligne.get(i)==10){
                if (i==19)
                    return 0;
                else if (i==18)
                    return 30;
                else if (i==17)
                    return 60;
                else if (i==16)
                    return 90;
                else if (i==15)
                    return 120;
                else if (i==14)
                    return 150;
                else if (i==13)
                    return 180;
                else if (i==12)
                    return 210;
                else if (i==11)
                    return 240;
                else if (i==10)
                    return 270;
                else if (i==9)
                    return 300;
                else if (i==8)
                    return 330;
                else if (i==7)
                    return 360;
                else if (i==6)
                    return 390;
                else if (i==5)
                    return 420;
                else if (i==4)
                    return 450;
                else if (i==3)
                    return 480;
                else if (i==2)
                    return 510;
                else if (i==1)
                    return 540;
                else if (i==0)
                    return 570;
            }
        }
        return -1;
    }
}
