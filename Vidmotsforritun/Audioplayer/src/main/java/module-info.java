module vidmot.audioplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.logging;

    opens vidmot to javafx.fxml;
    exports vidmot;
}
