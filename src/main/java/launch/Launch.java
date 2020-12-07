package main.java.launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.java.modele.GameManager;
import main.java.view.Menu;

import java.io.IOException;

public class Launch extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/MaFenêtre.fxml"));
        try {
            GameManager gameManager = new GameManager();
            Parent root = new Menu(gameManager);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
