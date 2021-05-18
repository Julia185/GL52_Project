package org.gl52.proj.ui.controller;

import java.io.IOException;

import org.gl52.proj.ui.App;

import javafx.fxml.FXML;

public class MainSceneController extends AbstractController {

// VENTE PANEL //
	@FXML
	private void switchToGestionnaireClient() throws IOException {
		App.setRoot("GestionnaireClient");
	}

	@FXML
	@Override
	public void switchToMainSceneScene() throws IOException {
		// TODO Auto-generated method stub
		super.switchToMainSceneScene();
	}

	@FXML
	public void createClient() throws IOException {
		App.setRoot("GestionnaireClient");
		/* call ClientController create methode */
	}

	@FXML
	public void modifyClient() throws IOException {
		App.setRoot("GestionnaireClient");
		/* get selected element from list client */
		/* call ClientController modify methode */
	}

	@FXML
	public void deleteClient() throws IOException {
		/* get selected element from list client */
		/* call ClientController delete methode */
	}

	@FXML
	public void scanner() {
		/* simulate scan ? */
	}

	@FXML
	public void cancelSell() {
		/* clear all field */
	}

// SAV PANEL //

	@FXML
	public void createReparation() {
		
	}
	@FXML
	public void modifiyReparation() {
		
	}
	@FXML
	public void deleteReparation() {
		
	}
	@FXML
	public void savFiltre() {

	}
	@FXML
	public void SAVRecherche() {

	}
	@FXML
	public void validerReparation() {
		
	}
	@FXML
	public void addFactureLine() {
		
	}
	@FXML
	public void modifyFactureLine() {
		
	}
	@FXML
	public void deleteFactureLine() {
		
	}
// STOCK PANEL //

	@FXML
	public void switchToCreateProduct() {
		
	}
	
	@FXML
	public void switchToModifyProduct() {
		
	}
	@FXML
	public void switchToDeleteProduct() {
		
	}
	
}
