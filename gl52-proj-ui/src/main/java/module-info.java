module fr.utbm.gl52.proj.ui {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;

    opens fr.utbm.gl52.proj.ui to javafx.fxml;
    opens fr.utbm.gl52.proj.ui.controller to javafx.fxml;
    exports fr.utbm.gl52.proj.ui;
    exports fr.utbm.gl52.proj.ui.controller;
}
