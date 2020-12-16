package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modele.GameManager;
import view.Menu;

import java.io.IOException;

public class Launch extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/MaFenetre.fxml"));
        try {
            GameManager gameManager = new GameManager();
            Parent root = new Menu(gameManager);
            //Parent root = FXMLLoader.load(getClass().getResource("/fxml/MaFenetre.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Tetris");
            primaryStage.setWidth(600);
            primaryStage.setHeight(500);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
