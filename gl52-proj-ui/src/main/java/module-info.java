module org.gl52.proj.ui {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.gl52.proj.ui to javafx.fxml;
    exports org.gl52.proj.ui;
}
