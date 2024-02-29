package vidmot;

import vinnsla.Askrifandi;
import vinnsla.Lagalistar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import java.util.Optional;

public class PlayerController {

    Lagalistar lagalistar = new Lagalistar();
    Askrifandi askrifandi = new Askrifandi();

    @FXML
    private Label fxStatus;
    private final String[] myndir = new String[4];


    public void initialize() {
        fxStatus.setText("Ekki skráður inn");
        myndir[0] = "media/.png";
        myndir[1] = "media/.png";
        myndir[2] = "media/.png";
        myndir[3] = "media/.png";
    }

    public void onLogin() {
        AskrifandiDialog dialog = new AskrifandiDialog(askrifandi);
        Optional<Askrifandi> result = dialog.showAndWait();
        result.ifPresent(value -> fxStatus.setText(" " + value));
    }


    public void onVeljaLista(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        int i = GridPane.getColumnIndex(button);
        ViewSwitcher.switchTo(View.LAGALISTI, lagalistar.get(i), myndir[i]);
    }
}
