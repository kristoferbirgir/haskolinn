package vidmot;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import vinnsla.Kubbur;
import vinnsla.Stykki;

public class KubburController {
    private Kubbur kubbur;


    //hlutur þar sem þú slærð inn tölu
    @FXML
    private TextField fxTala;

    //hlutur fyrir borðið
    @FXML
    private GridPane fxBord;

    //Heldur utan um stig
    @FXML
    private Label stiginLabel;

    // Heldur utan um leikur í gangi/ekki
    @FXML
    private Label statusLabel;


    public void onNyTala(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) { //Kíkir hvort enter sé ýtt þegar stimplar inn tölu
            String number = fxTala.getText(); // Sækir tölu sem sett var inn
            System.out.println("The number entered is: " + number); //Prentar hana á console
            fxBord.setDisable(false);
            ObservableList<Node> buttons = fxBord.getChildren();
            for (int i = 0; i < buttons.size() - 1; i++) {
                Button b = (Button) buttons.get(i);
                if (!b.isDisabled()) {
                    clearButtonImage(b);
                    b.setDisable(false);
                }
            }
        }
    }

    public void clearButtonImage(Button button) {
        button.getStyleClass().clear();
    }


    // Búið virkar


    // Aðferð sem er kallað á þegar ýtt er á button
    public void onSetjaStykki(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        int row = GridPane.getRowIndex(button) != null ? GridPane.getRowIndex(button) : 0; // Sækir row
        int column = GridPane.getColumnIndex(button) != null ? GridPane.getColumnIndex(button) : 0; // Sækir column
        Stykki stykki = kubbur.getBordStykki(row, column);
        Stykki radadStykki = kubbur.getRadadStykki();
        if (stykki.equals(radadStykki)) { //Skoðar ef réttur hnappur sem er ýtt er á.
            button.setDisable(true); //Disable hnapp ef réttur
            kubbur.updateStigin(); // Uppfæra stig í leik
            kubbur.incrementCorrectGuesses(); //
            button.getStyleClass().add("correct-guess"); // Setjum hér CSS klasa til að breyta ef rétt
            if (kubbur.getCorrectGuesses() == kubbur.getNumberOfCells()) {
            }
        } else {
            button.getStyleClass().add("incorrect-guess");
        }
    }


    public void initialize() {
        kubbur = new Kubbur(3, 3); //Byrjum leik með 3x3 grid.
        kubbur.fillTalaStykki(); // Fyllum borð með tölum.
        kubbur.randomizeBord(); // Randommize tölur á borðið.
        stiginLabel.textProperty().bind(kubbur.scoreProperty().asString()); // Setur score
        StringBinding gameStatusBinding = Bindings.createStringBinding(() -> {
            if (kubbur.getCorrectGuesses() < kubbur.getNumberOfCells()) {
                return "Leikur í gangi"; //Heldur áfram þar til er búið að giska á alla button rétta
            } else {
                return "Leik lokið"; // Setur þetta ef búið að giska alla button rétta.
            }
        }, kubbur.correctGuessesProperty());
        statusLabel.textProperty().bind(gameStatusBinding);
    }


    private void setjaMynd(Stykki stykki, Button b) {
        b.getStyleClass().clear();
        b.getStyleClass().add(stykki.getStyleClass());
    }


    public Button getButtonByCoordinates(int i, int j) {
        ObservableList<Node> children = fxBord.getChildren();
        for (Node node : children) {
            if (GridPane.getRowIndex(node) == i && GridPane.getColumnIndex(node) == j && node instanceof Button) {
                return (Button) node;
            }
        }
        return null;
    }

}