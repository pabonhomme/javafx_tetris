package modele;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.pieces.Morceau;
import modele.pieces.Piece;

import java.util.ArrayList;

/**
 * Classe partie qui contient les données de la partie en cours
 */
public class Partie {

    /**
     * propriété qui contient le score
     */
    private SimpleIntegerProperty score;

    /**
     * pièce en cours
     */
    private Piece pieceCourante;

    /**
     * pièce suivante
     */
    private Piece pieceSuivante;

    /**
     * Valeur Boolean, true si partie terminée
     */
    private Boolean estFini;

    /**
     * liste observable des pièces en jeu pour l'affichage
     */
    private ObservableList<Piece> listePieceEnJeu = FXCollections.observableArrayList();

    /**
     * liste observable des morceaux en jeu pour les collisions
     */
    private ObservableList<Morceau> listeMorceauEnJeu = FXCollections.observableArrayList();

    /**
     * retourne la propriété score
     * @return SimpleIntegerProperty
     */
    public SimpleIntegerProperty scoreProperty() { return score; }

    /**
     * retourne la valeur du score
     * @return int
     */
    public int getScore() { return this.score.get(); }

    /**
     * set le score en cours
     * @param x int
     */
    public void setScore(int x) { this.score.set(x); }

    /**
     * récupère la pièce courante
     * @return Piece
     */
    public Piece getPieceCourante() {

        return pieceCourante;
    }

    /**
     * set la pièce courante
     * @param pieceCourante Piece
     */
    public void setPieceCourante(Piece pieceCourante) {

        this.pieceCourante = pieceCourante;
    }

    /**
     * renvoie le statut de la partie
     * @return Boolean
     */
    public Boolean getEstFini() {

        return estFini;
    }

    /**
     * set le statut de la partie
     * @param estFini Boolean
     */
    public void setEstFini(Boolean estFini) {

        this.estFini = estFini;
    }

    /**
     * constructeur de partie
     */
    public Partie(){
        this.score=new SimpleIntegerProperty(0);
        this.estFini = false;

    }

    /**
     * récupère la liste des pièces en jeu
     * @return ObservableList
     */
    public ObservableList<Piece> getListePieceEnJeu() {

        return listePieceEnJeu;
    }

    /**
     * ajoute une pièce à la liste du serveur
     * @param p Pièce
     */
    public void ajouterPiece(Piece p){

        listePieceEnJeu.add(p);
    }

    /**
     * récupère la liste des morceaux en jeu
     * @return ObservableList<Morceau>
     */
    public ObservableList<Morceau> getListeMorceauEnJeu() {

        return listeMorceauEnJeu;
    }

    /**
     * ajoute un morceau à la liste de morceau
     * @param m Morceau
     */
    public void ajouterMorceau(Morceau m){

        listeMorceauEnJeu.add(m);
    }

    /**
     * suppression d'un morceau
     * @param m Morceau
     */
    public void suppMorceau(Morceau m){

        listeMorceauEnJeu.remove(m);
    }

    /**
     * récupère la pièce suivante
     * @return Piece
     */
    public Piece getPieceSuivante() {

        return pieceSuivante;
    }

    /**
     * set la pièce suivante
     * @param pieceSuivante Piece
     */
    public void setPieceSuivante(Piece pieceSuivante) {

        this.pieceSuivante = pieceSuivante;
    }

    /**
     * Permet de vérifier si on peut supprimer une ligne dans la vue et donc supprimer des morceaux
     * @return int, numéro de ligne à supprimer
     */
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
