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
    private Joueur joueurEnCours;
    private Piece pieceCourante;
    private Piece pieceSuivante;
    private Boolean estFini;
    private ObservableList<Piece> listePieceEnJeu = FXCollections.observableArrayList();
    private ObservableList<Morceau> listeMorceauEnJeu = FXCollections.observableArrayList();

    public SimpleIntegerProperty getScore() {

        return score;
    }

    public void setScore(SimpleIntegerProperty score) {

        this.score = score;
    }

    public Joueur getJoueurEnCours() {

        return joueurEnCours;
    }

    public void setJoueurEnCours(Joueur joueurEnCours) {

        this.joueurEnCours = joueurEnCours;
    }

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
        joueurEnCours = new Joueur();
    }
    public void setPseudoJoueur(String pseudo){

        this.joueurEnCours.setPseudo(pseudo);
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

    public Piece getPieceSuivante() {

        return pieceSuivante;
    }

    public void setPieceSuivante(Piece pieceSuivante) {

        this.pieceSuivante = pieceSuivante;
    }
}
