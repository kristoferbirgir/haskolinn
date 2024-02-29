package vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Objects;

import vinnsla.Lag;
import vinnsla.Lagalisti;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class ListiController {
    @FXML
    private ListView<Lag> fxListView;
    @FXML
    private ImageView fxValidLagMynd;
    @FXML
    private Button fxPlayPauseButton;

    @FXML
    private ImageView fxUppiMynd;

    @FXML
    private ProgressBar fxProgressBar;

    private Lagalisti listi;
    private Lag validLag;
    private MediaPlayer mediaPlayer;


    public void initialize() { // Frumstillir
        if (listi != null) {
            fxListView.setItems(listi.getListi());
        }
    }

    /**
     * lagalistinn fer í listan og myndin
     * @param lagalisti listi með lögum
     * @param mynd myndin sem fer á topp
     */
    public void setLagalisti(Lagalisti lagalisti, String mynd) {
        this.listi = lagalisti;
        Image myndin = new Image(Objects.requireNonNull(getClass().getResource(mynd)).toExternalForm());
        fxUppiMynd.setImage(myndin);
        if (listi != null) {
            fxListView.setItems(listi.getListi());
        }
    }

    private void spilaLag(Lag validLag) {
        System.out.println(validLag.getSkra());
        File file = new File(Objects.requireNonNull(getClass().getResource(validLag.getSkra())).getFile());
        System.out.println(file.toURI());
        Media media = new Media(file.toURI().toString());
        setjaPlayer(media);
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    public void onValidLag() {
        validLag = fxListView.getSelectionModel().getSelectedItem();
        System.out.println(validLag.getLagNafn());
        Image mynd = new Image(Objects.requireNonNull(getClass().getResource(validLag.getMyndSkra())).toExternalForm());
        fxValidLagMynd.setImage(mynd);
        spilaLag(validLag);
    }



    /**
     * Setur lag í mediaPlayer
     * @param media lag sem á að spila
     */
    private void setjaPlayer(Media media) {
        if(mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
            mediaPlayer.stop();
        }
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.currentTimeProperty().addListener((observable, old, newValue) ->
                fxProgressBar.setProgress(newValue.divide(Double.parseDouble(validLag.getlagLengd())).toMillis()));
        PlayPauseButton();
        setStopTime();

    }

    /**
     * Setur stopTime á mediaPlayer
     * Þegar lag klárast þá fer það í næsta lag
     */
    private void setStopTime(){
        mediaPlayer.setStopTime(mediaPlayer.getMedia().getDuration());
        mediaPlayer.setOnEndOfMedia(this::naestaLag);
    }

    /**
     * Fer í næsta lag í listanum
     */
    private void naestaLag(){
        int index = fxListView.getSelectionModel().getSelectedIndex();
        if(index < fxListView.getItems().size() - 1){
            fxListView.getSelectionModel().select(index + 1);
            onValidLag();
        }
    }

    /**
     * Tengir play/pause takka við mediaPlayer til að uppfæra mynd
     */
    private void updatePlayPauseButtonImage(MediaPlayer.Status status) {
        ImageView imageView = new ImageView();
        imageView.setFitHeight(35.0);
        imageView.setFitWidth(53.0);
        imageView.setPreserveRatio(true);

        if (status == MediaPlayer.Status.PLAYING) {
            imageView.setImage(new Image(Objects.requireNonNull(getClass().getResource("media/pause.png")).toExternalForm()));
        } else {
            imageView.setImage(new Image(Objects.requireNonNull(getClass().getResource("media/play.png")).toExternalForm()));
        }

        fxPlayPauseButton.setGraphic(imageView);
    }

    private void PlayPauseButton(){
        mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> updatePlayPauseButtonImage(newValue));
    }

    public void onHeim(){
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        ViewSwitcher.switchTo(View.HEIMA);
    }


    @FXML
    public void onPlayPause() {
        if(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
            mediaPlayer.pause();
        } else {
            mediaPlayer.play();
        }
    }
}