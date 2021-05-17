package org.gl52.proj.ui;

import java.io.IOException;
import javafx.fxml.FXML;

public class MainsSceneController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
