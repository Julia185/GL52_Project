module org.gl52.ptoj.UI {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.gl52.ptoj.UI to javafx.fxml;
    exports org.gl52.ptoj.UI;
}