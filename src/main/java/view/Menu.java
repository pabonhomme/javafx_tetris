package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ColorPicker;
import modele.GameManager;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Menu extends Vue{
    public Menu(GameManager gmanager) throws IOException {
        super(gmanager);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MaFenetre.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    @FXML
    private ColorPicker colorPickerAAfficher;

    @FXML
    private void clicOnButt(ActionEvent actionEvent){
        colorPickerAAfficher.setVisible(true);
    }

    @FXML
    private void clicJouer() throws Exception{
        getGmanager().lancerPartie();

    }
}
