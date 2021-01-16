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
import javafx.collections.ObservableList;
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
    private Joueur joueurEnCours = new Joueur();
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

    public Joueur getJoueurEnCours() {
        return joueurEnCours;
    }

    public void setJoueurEnCours(Joueur joueurEnCours) {
        this.joueurEnCours = joueurEnCours;
    }

    public void setTop10Joueurs(ArrayList<Joueur> top10Joueurs) {

        this.top10Joueurs = top10Joueurs;
    }

    public void lancerPartie() {
        this.setJeu(new Partie());
        leCreateur.creerPiece(jeu);
        leCollisionneur.setJeu(jeu);
        options = new Option(50);
        leBoucleur.addListener(this);
        leBoucleur.setRunning(true);
        new Thread(leBoucleur).start();
    }

    public void setPseudoPartie(String pseudo) {

        jeu.setPseudoJoueur(pseudo);
    }

    public void chargerEcranPartie(String pseudo) {
        lancerPartie();
        joueurEnCours.setPseudo(pseudo);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Partie.fxml"));
            Scene scene = new Scene(root);
            scene.addEventFilter(KeyEvent.KEY_PRESSED, this::touchesClavier);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // récupération du primarystage pour mettre à jour la vue
    public void setPrimaryStage(Stage pPrimaryStage) {

        primaryStage = pPrimaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void touchesClavier(KeyEvent code) {
        switch (code.getCode()) {
            case RIGHT:
                if (!leBoucleur.getEstEnpause()) {
                    for (Piece p : jeu.getListePieceEnJeu()) {
                        if (jeu.getPieceCourante() == p) {
                            leDeplaceur.deplacerDroite(jeu.getPieceCourante());// move piece courante
                            leDeplaceur.deplacerDroite(p);// move piece dans liste bindée
                        }
                    }
                }
                break;
            case LEFT:
                if (!leBoucleur.getEstEnpause()) {
                    for (Piece p : jeu.getListePieceEnJeu()) {
                        if (jeu.getPieceCourante() == p) {
                            leDeplaceur.deplacerGauche(jeu.getPieceCourante());// move piece courante
                            leDeplaceur.deplacerGauche(p);// move piece dans liste bindée
                        }
                    }
                }
                break;
            case DOWN:
                if (!leBoucleur.getEstEnpause()) {
                    for (Piece p : jeu.getListePieceEnJeu()) {
                        if (jeu.getPieceCourante() == p) {
                            leDeplaceur.deplacerBas(jeu.getPieceCourante());// move piece courante
                            leDeplaceur.deplacerBas(p);// move piece dans liste bindée
                        }
                    }
                }
                break;
            case UP:
                if (!leBoucleur.getEstEnpause()) {
                    for (Piece p : jeu.getListePieceEnJeu()) {
                        if (jeu.getPieceCourante() == p) {
                            for (Morceau morceau : p.getListeMorceaux()) {
                                morceau.setY(morceau.getY() - 15);
                                System.out.println(morceau.getY());
                            }
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
            case ESCAPE:
                try {
                    this.leBoucleur.setRunning(false);
                    this.leBoucleur.removeListener(this);
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException e) {
                    System.out.println(e);
                }
                break;
        }
    }


    /**
     * méthode qui s'éxécute en boucle dans beep dans le boucleur de jeu
     *
     * @param observable
     */
    @Override
    public void invalidated(Observable observable) {
        boolean shouldCreatePiece = false;
        if (leCollisionneur.peutBougerEnBas()) { // si peut descendre
            leDeplaceur.descendre(jeu.getPieceCourante()); // on la descend
        } else {
            shouldCreatePiece = true; // sinon elle est tout en bas et on va créer une piece
        }

        if (shouldCreatePiece) { // si on doit créer une pièce
            for (Morceau m : jeu.getPieceCourante().getListeMorceaux()) {
                jeu.ajouterMorceau(m); // ajout des morceaux de la pièce courante avant création pièce car sinon ils se comparent à eux-même dans collisionneur
            }
            ArrayList<Integer> l=jeu.peutSupprimer(); //récupère les lignes à vider
            while(!l.isEmpty()){
                ArrayList<Morceau> tmp = new ArrayList<>(); //On fait une copie de la liste de morceaux en jeu
                for (Morceau m : jeu.getListeMorceauEnJeu()) {
                    tmp.add(m);
                }
                for (Morceau m : tmp) { //On regarde chaques morceaux en jeu dans la liste copiée
                    if (m.getY()==l.get(0)){ //ON regarde si le morceau fait parti de la ligne à vider
                        jeu.suppMorceau(m); //On supprimer le morceau de la liste de morceaux en jeu
                    }
                }
                l.remove(0); //ON enlève la ligne vidée de la liste de ligne à vider
            }
            if (leCollisionneur.toucheHautEcran()) { // si une pièce est tout en heut quand on veut créer une nouvelle
                try {
                    this.leBoucleur.setRunning(false); // on arrête le boucleur
                    this.leBoucleur.removeListener(this); // on supprime notre classe de la liste des observé de notre boucleur
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/FinPartie.fxml"));
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } catch (IOException e) {
                    System.out.println(e);
                }
            } else {
                leCreateur.creerPiece(jeu); // si tout est ok, création d'une nouvelle pièce
            }

        }
    }


}
