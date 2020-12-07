package main.java.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import main.java.modele.GameManager;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Menu extends Vue{
    public Menu(GameManager gmanager) throws IOException {
        super(gmanager);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MaFenêtre.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    @FXML
    private void clicJouer(ActionEvent actionEvent) throws Exception{
        getGmanager().lancerPartie();
    }
}
