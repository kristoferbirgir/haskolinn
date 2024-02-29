package vidmot;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class PlayerApplication extends Application {
    @Override
    public void start(Stage stage) {
        var scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.HEIMA);
        stage.setScene(scene);
        stage.setTitle("Audio Player");
        stage.setWidth(700);
        stage.setHeight(400);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
