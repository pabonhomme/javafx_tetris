package createur;

import javafx.scene.paint.Color;
import modele.Partie;
import modele.pieces.Carre;
import modele.pieces.Piece;

public class CreateurPieceSimple extends CreateurPiece {

    // ajout d'une piece aléatoirement dans la liste de piece en jeu
    @Override
    public void creerPiece(Partie jeu) {
        int i = alea.nextInt(6);
        switch (i){
            case 0:
                Piece carre1 = new Carre(0, 0, Color.YELLOW);
                jeu.ajouterPiece(carre1);
                jeu.setPieceCourante(carre1);
                break;
            case 1:
                Piece carre2 = new Carre(0, 0, Color.YELLOW);
                jeu.ajouterPiece(carre2);
                jeu.setPieceCourante(carre2);
                break;
            case 2:
                Piece carre3 = new Carre(0, 0, Color.YELLOW);
                jeu.ajouterPiece(carre3);
                jeu.setPieceCourante(carre3);
                break;
            case 3:
                Piece carre4 = new Carre(0, 0, Color.YELLOW);
                jeu.ajouterPiece(carre4);
                jeu.setPieceCourante(carre4);
                break;
            case 4:
                Piece carre5 = new Carre(336, 0, Color.YELLOW);
                jeu.ajouterPiece(carre5);
                jeu.setPieceCourante(carre5);
                break;
            case 5:
                Piece carre6 = new Carre(336, 0, Color.YELLOW);
                jeu.ajouterPiece(carre6);
                jeu.setPieceCourante(carre6);
                break;
            case 6:
                Piece carre7 = new Carre(336, 0, Color.YELLOW);
                jeu.ajouterPiece(carre7);
                jeu.setPieceCourante(carre7);
        }
    }
}
