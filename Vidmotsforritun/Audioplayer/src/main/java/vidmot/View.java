package vidmot;

public enum View {
    HEIMA("heima-view.fxml"),
    LAGALISTI("listi-view.fxml");


    // ASKRIFANDI("askrifandi-view.fxml");

    private final String fxml;

    /**
     * Hér er fxml skrá frumstillt
     * @param fxml skrá
     */
    View(String fxml) {
        this.fxml = fxml;
    }

    /**
     * Hér skilum við fxml skrá
     * @return fxml skrá
     */
    public String getFxml() {
        return fxml;
    }
}

