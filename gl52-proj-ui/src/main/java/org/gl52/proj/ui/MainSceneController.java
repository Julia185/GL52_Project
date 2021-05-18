package org.gl52.proj.ui;

import java.io.IOException;

import javafx.fxml.FXML;

public class MainSceneController {

	@FXML
    private void switchToGestionnaireClient() throws IOException {
        App.setRoot("GestionnaireClient");
    }
	
}
