package main.java.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import main.java.modele.GameManager;

public abstract class Vue extends BorderPane {
    private GameManager gmanager;

    public GameManager getGmanager() {
        return gmanager;
    }

    public Vue(GameManager gmanager){
        this.gmanager=gmanager;
    }
}
