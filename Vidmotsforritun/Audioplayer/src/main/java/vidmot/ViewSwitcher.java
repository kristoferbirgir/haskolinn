package vidmot;

import javafx.scene.Scene;
import vinnsla.Lagalisti;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;


public class ViewSwitcher {
    private static Scene scene;

    /**
     * Frumstillum Scene
     * @param scene Scene
     */
    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    /**
     * Skiptum um Scene
     * @param view View til að byrta
     */
    public static void switchTo(View view) {
        try {
            Parent root;
            root = FXMLLoader.load(ViewSwitcher.class.getResource(view.getFxml()));
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Skiptir um Scene
     * @param view View sem á að byrta
     * @param lagalisti Lagalisti sem á að byrta
     * @param mynd myndin sem á að setja á toppinn
     */
    public static void switchTo(View view, Lagalisti lagalisti, String mynd) {
        try {
            Parent root;
            FXMLLoader loader = new FXMLLoader(ViewSwitcher.class.getResource(view.getFxml()));
            root = loader.load();
            ListiController listiController = loader.getController();
            listiController.setLagalisti(lagalisti, mynd);
            scene.setRoot(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}