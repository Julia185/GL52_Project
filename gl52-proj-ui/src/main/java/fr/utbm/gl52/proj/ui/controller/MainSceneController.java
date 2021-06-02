package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;

import fr.utbm.gl52.proj.ui.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainSceneController extends AbstractController {

	GestionnaireClientController gcc = new GestionnaireClientController();
	@FXML private TextField searchClientTxtField;
	@FXML private TextField searchProductTxtField;
	@FXML private Label clientInfosLabel;
	@FXML private Label montantTtlLabel;
	
// VENTE PANEL //
	@FXML
	private void switchToGestionnaireClient() throws IOException {
		App.setRoot("GestionnaireClient");
	}

	@FXML
	@Override
	public void switchToMainScene() throws IOException {
		// TODO Auto-generated method stub
		super.switchToMainScene();
	}

	@FXML
	public void createClient() throws IOException {
		App.setRoot("GestionnaireClient");
	}

	@FXML
	public void modifyClient() throws IOException {
		
		App.setRoot("GestionnaireClient");
		/* get selected element from list client */
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
	
	@FXML
	public void changeMontantVenteValue() {
		
	}
	
	@FXML
	public void changeClientVenteInfo() {
		
	}
	
	@FXML
	public void getSearchClientVente() {
		
	}
	
	@FXML 
	public void getSearchProductVente() {
		
	}
	
	@FXML
	public void checkBoxFactureState() {
		
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
	public void switchToAjoutProduit() throws IOException {
		App.setRoot("AjoutProduit");		
	}
	
	@FXML
	public void switchToModifyProduct() {
		
	}
	@FXML
	public void switchToDeleteProduct() {
		
	}
}
