module org.gl52.proj.ui {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.gl52.proj.ui to javafx.fxml;
    opens org.gl52.proj.ui.controller to javafx.fxml;
    exports org.gl52.proj.ui;
    exports org.gl52.proj.ui.controller;
}
