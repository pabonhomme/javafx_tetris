package modele;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modele.pieces.Morceau;
import modele.pieces.Piece;
import view.ObjetV.CarreV;

import java.util.ArrayList;

public class Partie {
    private int score;
    private Joueur joueurEnCours;
    private Piece pieceCourante;
    private CarreV pieceCouranteV;
    private Boolean estFini;
    private ObservableList<Piece> listePieceEnJeu = FXCollections.observableArrayList();
    private ObservableList<CarreV> listePieceEnJeuV = FXCollections.observableArrayList(); // liste de piece vue pr tester collision
    private ArrayList<String> listePiece;

    public int getScore() {

        return score;
    }

    public void setScore(int score) {

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
        this.score=0;
        this.estFini = false;
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

    public void ajouterPieceV(CarreV p){

        listePieceEnJeuV.add(p);
    }

    public ObservableList<CarreV> getListePieceEnJeuV() {
        return listePieceEnJeuV;
    }

    public void setListePieceEnJeuV(ObservableList<CarreV> listePieceEnJeuV) {
        this.listePieceEnJeuV = listePieceEnJeuV;
    }

    public CarreV getPieceCouranteV() {
        return pieceCouranteV;
    }

    public void setPieceCouranteV(CarreV pieceCouranteV) {
        this.pieceCouranteV = pieceCouranteV;
    }
}
