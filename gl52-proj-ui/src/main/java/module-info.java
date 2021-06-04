module fr.utbm.gl52.proj.ui {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.persistence;

    opens fr.utbm.gl52.proj.ui to javafx.fxml,java.persistence;
    opens fr.utbm.gl52.proj.ui.controller to javafx.fxml,java.persistence;
    exports fr.utbm.gl52.proj.ui;
    exports fr.utbm.gl52.proj.ui.controller;
}
