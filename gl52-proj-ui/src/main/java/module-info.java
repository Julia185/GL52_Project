module fr.utbm.gl52.proj.ui {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.base;

    opens fr.utbm.gl52.proj.ui to javafx.fxml;
    opens fr.utbm.gl52.proj.ui.controller to javafx.fxml;
    opens fr.utbm.gl52.proj.model to javafx.base;
    exports fr.utbm.gl52.proj.ui;
    exports fr.utbm.gl52.proj.ui.controller;
}
