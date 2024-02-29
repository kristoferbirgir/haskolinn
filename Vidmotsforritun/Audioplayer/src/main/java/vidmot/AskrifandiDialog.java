package vidmot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import vinnsla.Askrifandi;
import java.util.logging.Logger;
import java.util.logging.Level;


import java.io.IOException;

public class AskrifandiDialog extends Dialog<Askrifandi> {
    private final Askrifandi askrifandi; // vinnslu tilviksbreyta
    @FXML
    private TextField nameField; // Viðmóts tilviksbreyta

    public AskrifandiDialog(Askrifandi askrifandi) {
        this.askrifandi = askrifandi;
        this.setResultConverter();
        DialogPane dialogPane = lesaDialog();
        this.setDialogPane(dialogPane);
    }

    private void setResultConverter() { // Kalla setResultConverter í Dialog klasanum með lambda falli..
        this.setResultConverter(button -> {
            if (button == ButtonType.OK) {
                askrifandi.setNafn(nameField.getText());
                return askrifandi;
            }
            return null;
        });
    }

    private DialogPane lesaDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(AskrifandiDialog.class.getResource("askrifandi-view.fxml"));
        try {
            fxmlLoader.setController(this); // Prófum að lesa fxml skrá
            return fxmlLoader.load();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(AskrifandiDialog.class.getName());
            logger.log(Level.SEVERE, "Error að loada FXML skrá", e);
            return null;
        }
    }

}

