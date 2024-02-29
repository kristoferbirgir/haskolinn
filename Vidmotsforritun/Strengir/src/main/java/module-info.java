module hi.verkefni2.vidmot {
    requires javafx.controls;
    requires javafx.fxml;


    opens hi.verkefni2.vidmot to javafx.fxml;
    exports hi.verkefni2.vidmot;
}