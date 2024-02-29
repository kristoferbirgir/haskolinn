package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lagalisti {
    ObservableList<Lag> listi;

    public Lagalisti() {
        this.listi = FXCollections.observableArrayList();
    }

    /**
     * Les inn log frá skrá og býr til lista af logum
     * @param skra nafn á skrá
     * @throws IOException ef ekki tókst að lesa skrá
     */
    public void lesaLog(String skra) throws IOException{
        // lesa skrá
        String line = new String(Files.readAllBytes(Paths.get(skra)));
        String[] lina = line.split("\n");
        for (String s : lina) {
            String[] l = s.split(" ");
            Lag lag = new Lag(l[0], l[1], l[2] , l[3]);
            listi.add(lag);
        }
    }

    /**
     * Bætir við lag í listann
     * @param lag lag
     */
    public void setjaLag(Lag lag){
        listi.add(lag);
    }

    /**
     * Skilar lagi úr listanum
     * @param index index af lagi sem á að skila
     * @return lag
     */
    public Lag get(int index){
        return listi.get(index);
    }

    /**
     * Skilar listanum
     * @return listi
     */
    public ObservableList<Lag> getListi() {
        return listi;
    }
}