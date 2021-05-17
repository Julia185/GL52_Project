module org.gl52.proj.ui {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;

    opens org.gl52.proj.ui to javafx.fxml;
    exports org.gl52.proj.ui;
}
