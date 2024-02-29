package vinnsla;


public class Stykki {
    private String styleClass;
    private int tala;



    // Smiður sem tekur inn nafn á myndinni (styleClass) og töluna
    public Stykki(String styleClass) {
        this.styleClass = styleClass;
        this.tala = tala;
    }

    // Getters og setters
    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public int getTala() {
        return tala;
    }

    public void setTala(int tala) {
        this.tala = tala;
    }
}
