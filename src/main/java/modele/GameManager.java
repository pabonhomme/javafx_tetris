package modele;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MorceauV;

import java.util.ArrayList;

public class GameManager {
    private static  GameManager instanceUnique;
    private Partie jeu;
    private Option options;
    private BoucleDeJeu boucleDeJeu;
    private ArrayList<Joueur> top10Joueurs;
    private Stage primaryStage;

    private GameManager(){
    }

    // Méthode qui vérifie qu'il n'y ai pas d'instance de GameManager déjà créée, si non alors elle l'instancie
    public static GameManager getInstance(){
        if(instanceUnique == null){
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

    public ArrayList<Joueur> getTop10Joueurs() {

        return top10Joueurs;
    }

    public void setTop10Joueurs(ArrayList<Joueur> top10Joueurs) {
        this.top10Joueurs = top10Joueurs;
    }

    public Option getOptions() {

        return options;
    }

    public BoucleDeJeu getBoucleDeJeu() {

        return boucleDeJeu;
    }



    public void lancerPartie(){

        jeu=new Partie();
        options = new Option(50);
        boucleDeJeu = new BoucleDeJeu();
    }

    public void recupNomJoueur(String pseudo){
        jeu.setPseudoJoueur(pseudo);
    }


    public void chargerEcranPartie() {
        Group root = new Group();
        root.getChildren().add(new MorceauV());
        Scene sceneGame = new Scene(root);
        primaryStage.setScene(sceneGame);
    }

    public void setPrimaryStage(Stage pPrimaryStage) {
        primaryStage = pPrimaryStage;
    }
}
