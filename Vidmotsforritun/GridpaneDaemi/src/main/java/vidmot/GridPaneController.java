package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GridPaneController {
    @FXML
    public GridPane fxGridPane;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Dæmi um GridPane");
    }

    public void onButtonClick(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        int i=GridPane.getRowIndex(b);
        int j = GridPane.getColumnIndex(b);
        System.out.println ("röð "+ i+ " og dálkur "+ j);
    }

}