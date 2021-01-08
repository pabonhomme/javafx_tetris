package modele;

import boucleur.BoucleurDeJeu;
import collisionneur.Collisionneur;
import collisionneur.CollisionneurPiece;
import createur.CreateurPiece;
import createur.CreateurPieceSimple;
import deplaceur.Deplaceur;
import deplaceur.DeplaceurPiece;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import modele.pieces.Morceau;
import modele.pieces.Piece;

import java.io.IOException;
import java.util.ArrayList;

public class GameManager implements InvalidationListener {
    private static GameManager instanceUnique;
    private Partie jeu;
    private Option options;
    private final CreateurPiece leCreateur = new CreateurPieceSimple();
    private final BoucleurDeJeu leBoucleur = new BoucleurDeJeu();
    private final Collisionneur leCollisionneur = new CollisionneurPiece();
    private final Deplaceur leDeplaceur = new DeplaceurPiece(leCollisionneur);
    private ArrayList<Joueur> top10Joueurs;
    private Stage primaryStage;

    private GameManager() {
    }

    // Méthode qui vérifie qu'il n'y ai pas d'instance de GameManager déjà créée, si non alors elle l'instancie
    public static GameManager getInstance() {
        if (instanceUnique == null) {
            instanceUnique = new GameManager();
        }
        return instanceUnique;
    }

    public Partie getJeu() {

        return jeu;
    }

    public void setJeu(Partie jeu) {

        this.jeu = jeu;
    }

    public Option getOptions() {

        return options;
    }

    public void setOptions(Option options) {

        this.options = options;
    }

    public BoucleurDeJeu getLeBoucleur() {

        return leBoucleur;
    }

    public void stopBoucleur() {
        leBoucleur.setRunning(false);
    }

    public ArrayList<Joueur> getTop10Joueurs() {

        return top10Joueurs;
    }

    public void setTop10Joueurs(ArrayList<Joueur> top10Joueurs) {

        this.top10Joueurs = top10Joueurs;
    }


    public void lancerPartie() {
        setJeu(new Partie());
        leCreateur.creerPiece(jeu);
        leCollisionneur.setJeu(jeu);
        options = new Option(50);
        leBoucleur.addListener(this);
        leBoucleur.setRunning(true);
        new Thread(leBoucleur).start();
    }

    public void recupNomJoueur(String pseudo) {

        jeu.setPseudoJoueur(pseudo);
    }


    public void chargerEcranPartie() {
        lancerPartie();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Partie.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Tetris");
            primaryStage.setWidth(650);
            primaryStage.setHeight(650);
            scene.addEventFilter(KeyEvent.KEY_PRESSED, this::touchesClavier);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // récupération du primarystage pour mettre à jour la vue
    public void setPrimaryStage(Stage pPrimaryStage) {

        primaryStage = pPrimaryStage;
    }

    public void touchesClavier(KeyEvent code) {
        switch (code.getCode()) {
            case RIGHT:
                for (Piece p : jeu.getListePieceEnJeu()) {
                    if (jeu.getPieceCourante() == p) {
                        leDeplaceur.deplacerDroite(jeu.getPieceCourante());// move piece courante
                        leDeplaceur.deplacerDroite(p);// move piece dans liste bindée
                    }
                }
                break;
            case LEFT:
                for (Piece p : jeu.getListePieceEnJeu()) {
                    if (jeu.getPieceCourante() == p) {
                        leDeplaceur.deplacerGauche(jeu.getPieceCourante());// move piece courante
                        leDeplaceur.deplacerGauche(p);// move piece dans liste bindée
                    }
                }
                break;
            case DOWN:
                for (Piece p : jeu.getListePieceEnJeu()) {
                    if (jeu.getPieceCourante() == p) {
                        leDeplaceur.deplacerBas(jeu.getPieceCourante());// move piece courante
                        leDeplaceur.deplacerBas(p);// move piece dans liste bindée
                    }
                }
                break;
            case UP:
                for (Piece p : jeu.getListePieceEnJeu()) {
                    if (jeu.getPieceCourante() == p) {
                        for (Morceau morceau : p.getListeMorceaux()) {
                            morceau.setY(morceau.getY() - 15);
                            System.out.println(morceau.getY());
                        }
                    }
                }
//                    leDeplaceur.faireTournerPiece();
                break;
            case SPACE:
                if (leBoucleur.getEstEnpause()) {
                    leBoucleur.reprendre();
                } else leBoucleur.pause();
                break;
        }
    }


    /**
     * méthode qui s'éxécute en boucle dans beep dans le boucleur
     *
     * @param observable
     */
    @Override
    public void invalidated(Observable observable) {
        boolean shouldCreatePiece = false;
        if (jeu.getListePieceEnJeu().size() == 1) {
            if (leCollisionneur.peutBouger(jeu.getPieceCourante().getListeMorceaux().get(0).getX(), jeu.getPieceCourante().getListeMorceaux().get(0).getY())) {
                leDeplaceur.descendre(jeu.getPieceCourante());// move piece courante
            } else {
                shouldCreatePiece = true;
            }
            if (shouldCreatePiece) {
                leCreateur.creerPiece(jeu);
            }
        } else {

            if (leCollisionneur.peutBouger(jeu.getPieceCourante().getListeMorceaux().get(0).getX(), jeu.getPieceCourante().getListeMorceaux().get(0).getY()) && !leCollisionneur.toucheAutrePiece()) {
                leDeplaceur.descendre(jeu.getPieceCourante());// move piece courante
            } else {
                shouldCreatePiece = true;
            }
            if (shouldCreatePiece) {
                leCreateur.creerPiece(jeu);
            }
        }

    }
}
