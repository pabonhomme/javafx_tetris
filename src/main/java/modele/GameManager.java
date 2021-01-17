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
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import modele.pieces.Morceau;
import modele.pieces.Piece;
import sauveurs.Sauveur;
import sauveurs.ser.SauveurSer;
import sauveurs.stub.Stub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class GameManager implements InvalidationListener {
    private static GameManager instanceUnique;
    private Partie jeu;
    private Option options;
    private final CreateurPiece leCreateur = new CreateurPieceSimple();
    private final Sauveur leSauveur = new SauveurSer();
    private final BoucleurDeJeu leBoucleur = new BoucleurDeJeu();
    private final Collisionneur leCollisionneur = new CollisionneurPiece();
    private final Deplaceur leDeplaceur = new DeplaceurPiece(leCollisionneur);
    private Joueur joueurEnCours = new Joueur();
    private Stage primaryStage;

    private ListProperty<Joueur> top10Joueurs = new SimpleListProperty<>();
        public ObservableList<Joueur> getTop10Joueurs(){return top10Joueurs.get();}
        public ListProperty<Joueur> top10JoueursProperty(){return top10Joueurs;}
        private void setTop10Joueurs(ObservableList<Joueur> top10Joueurs){this.top10Joueurs.set(top10Joueurs);}

    /**
     * constructeur de manager
     */
    private GameManager() {
        this.chargerDonnees();
    }

    /**
     * Méthode qui vérifie qu'il n'y ai pas d'instance de GameManager déjà créée, si non alors elle l'instancie
     * @return le game manager unique ou non
     */
    public static GameManager getInstance() {
        if (instanceUnique == null) {
            instanceUnique = new GameManager();
        }
        return instanceUnique;
    }

    /**
     * récupère la partie en cours
     * @return partie en cours
     */
    public Partie getJeu() {

        return jeu;
    }

    /**
     * set la partie en cours
     * @param jeu jeu à setter
     */
    public void setJeu(Partie jeu) {

        this.jeu = jeu;
    }

    /**
     * récupère les options du jeu
     * @return options du jeu
     */
    public Option getOptions() {

        return options;
    }

    /**
     * set les options de la partie en cours
     * @param options options de la partie en cours
     */
    public void setOptions(Option options) {

        this.options = options;
    }

    /**
     * getter du boucleur de jeu
     * @return le boucleur
     */
    public BoucleurDeJeu getLeBoucleur() {

        return leBoucleur;
    }

    /**
     * Permet de stopper le boucleur quand la partie est finie
     */
    public void stopBoucleur() {
        leBoucleur.setRunning(false);
    }

    /**
     * getter du joueur en cours
     * @return le joueur en cours de type Joueur
     */
    public Joueur getJoueurEnCours() {
        return joueurEnCours;
    }

    /**
     * setter du joueur en cours
     * @param joueurEnCours reçoie le joueur en cours de type Joueur
     */
    public void setJoueurEnCours(Joueur joueurEnCours) {
        this.joueurEnCours = joueurEnCours;
    }

    /**
     * Permet d'incrémenter le score de la partie
     */
    public void incrementerScore(){

        jeu.setScore(jeu.getScore() + 1);
    }

    /**
     * Méthode qui met à jour le top 10 en fonction du résultat d'un joueur
     */
    public void ajouterJoueurTop10(){
        Boolean ajouter = false;
        joueurEnCours.setScore(jeu.getScore()); // on donne le score final au joueur en cours
        for (Joueur joueur : top10Joueurs) { // pour chaque joueur de la liste
            if(joueur.equals(joueurEnCours)){ // si égaux
                if(joueur.getScore() < joueurEnCours.getScore()){ // si il a fait un meilleur score que précedemment
                    joueur.setScore(joueurEnCours.getScore()); // on change le score
                    break;
                }
            }
            if(joueur.getScore() < joueurEnCours.getScore()){ // si le joueur en cours a fait mieux qu'un du top 10
                ajouter = true;
                break;
            }
        }
        if(ajouter){
            getTop10Joueurs().add(joueurEnCours);
            getTop10Joueurs().remove(getTop10Joueurs().size() -2);
        }
        FXCollections.sort(top10Joueurs);
    }

    /**
     * permet de charger les données à partir d'un fichier
     */
    public void chargerDonnees(){
        ObservableList<Joueur> listeJoueurs= FXCollections.observableArrayList(leSauveur.chargerStats());
        FXCollections.sort(listeJoueurs);
        setTop10Joueurs(listeJoueurs);
    }

    /**
     * permet de sauvegarder les données dans un fichier
     */
    public void sauvegarderDonnees(){
        Collection<Joueur> listeJoueurs = new ArrayList<>();
        listeJoueurs.addAll(getTop10Joueurs());
        leSauveur.sauvegarderStats(listeJoueurs);
    }


    /**
     * instancie une partie et lance le boucleur de jeu
     */
    public void lancerPartie() {
        this.setJeu(new Partie());
        leCreateur.creerPiece(jeu);
        leCollisionneur.setJeu(jeu);
        options = new Option(50);
        leBoucleur.addListener(this);
        leBoucleur.setRunning(true);
        new Thread(leBoucleur).start();
    }

    /**
     * Lancement de la partie et chargeement de la vue partie
     * @param pseudo pseudo du joueur de type String
     */
    public void chargerEcranPartie(String pseudo) {
        lancerPartie();
        joueurEnCours.setPseudo(pseudo); // on set le pseudo du joueur reçu soit avec le textField soit parce qu'il a rejoué
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Partie.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/css/tetris.css").toExternalForm());
            scene.addEventFilter(KeyEvent.KEY_PRESSED, this::touchesClavier);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Permet de changer de scene
     * @param root scène à inserer dans la fenêtre
     */
    public void chargerFenetre(Parent root, String style){
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(style).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * récupération du primarystage pour mettre à jour la vue
     * @param pPrimaryStage fenetre voulue
     */
    public void setPrimaryStage(Stage pPrimaryStage) {

        primaryStage = pPrimaryStage;
    }

    /**
     * getter du primarySyage
     * @return primary stage
     */
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
                    leDeplaceur.faireTournerPiece(jeu.getPieceCourante());
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
                    chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml")), "/css/tetris.css");

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
            int l=jeu.peutSupprimer(); //récupère la ligne à vider
            while(l!=-1){
                //On fait une copie de la liste de morceaux en jeu
                ArrayList<Morceau> tmp = new ArrayList<>(jeu.getListeMorceauEnJeu());
                for (Morceau m : tmp) { //On regarde chaques morceaux en jeu dans la liste copiée
                    if (m.getY()==l){ //ON regarde si le morceau fait parti de la ligne à vider
                        jeu.suppMorceau(m); //On supprimer le morceau de la liste de morceaux en jeu
                        this.incrementerScore();
                    }
                }
                for(Morceau m2 : jeu.getListeMorceauEnJeu()){
                    if (m2.getY()<l){
                        m2.setY(m2.getY()+30);//On descend tout les morceaux au dessus de la ligne supprimée
                    }
                }
                l=jeu.peutSupprimer(); //On regarde s'il reste d'autres lignes à supprimer
            }
            if (leCollisionneur.toucheHautEcran()) { // si une pièce est tout en heut quand on veut créer une nouvelle
                try {
                    this.leBoucleur.setRunning(false); // on arrête le boucleur
                    this.leBoucleur.removeListener(this); // on supprime notre classe de la liste des observé de notre boucleur
                    this.chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/FinPartie.fxml")), "/css/tetris.css"); // on change de fenêtre

                } catch (IOException e) {
                    System.out.println(e);
                }
            } else {
                leCreateur.creerPiece(jeu); // si tout est ok, création d'une nouvelle pièce
            }

        }
    }


}
