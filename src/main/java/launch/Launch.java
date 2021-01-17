package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modele.GameManager;

import java.io.IOException;

public class Launch extends Application {

    GameManager gmanager = GameManager.getInstance();

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            GameManager.getInstance().setPrimaryStage(primaryStage);
            primaryStage.setTitle("Tetris");
            primaryStage.getIcons().add(new Image("/img/icone.png")); // ajout d'une icone
            primaryStage.setWidth(650);
            primaryStage.setHeight(650);
            primaryStage.setResizable(false);
            primaryStage.setOnCloseRequest((__)->{ // quand la fenêtre se ferme alors on sauvegarde les données
                GameManager.getInstance().sauvegarderDonnees();
            });
            gmanager.chargerFenetre(FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml")), "/css/tetris.css");

        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    @Override
    public void stop() throws Exception {
        GameManager.getInstance().stopBoucleur();
    }
}
