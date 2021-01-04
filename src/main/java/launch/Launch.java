package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.GameManager;

import java.io.IOException;

public class Launch extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            GameManager.getInstance().setPrimaryStage(primaryStage);
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Menu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Tetris");
            primaryStage.setWidth(650);
            primaryStage.setHeight(650);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    @Override
    public void stop() throws Exception {
        GameManager.getInstance().stopBoucleur();
        super.stop();
    }
}
