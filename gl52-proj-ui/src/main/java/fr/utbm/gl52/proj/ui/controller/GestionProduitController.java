package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;

import fr.utbm.gl52.proj.model.Produit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GestionProduitController extends AbstractController {
	
	private GestionProduitController produitController = new GestionProduitController();

	@FXML
	private TextField RefProdTxtField;
	@FXML
	private TextField DesProdTxtField;
	@FXML
	private TextField QteProdTxtField;
	@FXML
	private TextField PrixHTTxtField;
	@FXML
	private TextField PrixTTCTxtField;
	@FXML
	private TextField TVAProdTxtField;
	
	@FXML
	@Override
	public void switchToMainScene() throws IOException {
		super.switchToMainScene();
	}
	
	@FXML
	public void switchToMainSceneValidate() throws IOException {
		this.insertNewProduct();
		super.switchToMainScene();
	}

	private void insertNewProduct() throws IOException {
		String ReferenceProd = this.RefProdTxtField.getText();
		String DescriptionProduct = this.DesProdTxtField.getText();
		//int quantity = Integer.parseInt(this.QteProdTxtField.getText());
		//float prixHTT = Float.parseFloat(this.PrixHTTxtField.getText());
		//float prixTTC = Float.parseFloat(this.PrixTTCTxtField.getText());
		//float TVA = Float.parseFloat(this.TVAProdTxtField.getText());
		
		Produit produit = new Produit();
		this.produitController.insertNewProduct();
		super.switchToMainScene();
	}
	
	private void modifyProduct() throws IOException {
		String ReferenceProd = this.RefProdTxtField.getText();
		String DescriptionProduct = this.DesProdTxtField.getText();
		//int quantity = Integer.parseInt(this.QteProdTxtField.getText());
		//float prixHTT = Float.parseFloat(this.PrixHTTxtField.getText());
		//float prixTTC = Float.parseFloat(this.PrixTTCTxtField.getText());
		//float TVA = Float.parseFloat(this.TVAProdTxtField.getText());
		
		// Trouver quoi mettre pour modifier un produit déjà existant.
		this.produitController.modifyProduct();
		super.switchToMainScene();
	}
	
	private void removeProduct() {
		// TO DO.
	}
	
	@FXML
	private void handleProductReference(ActionEvent event) {
	}
	
	@FXML
	private void handleProductDescription(ActionEvent event) {
	}
	
	@FXML
	private void handleProductPrice(ActionEvent event) {
	}
	
	@FXML
	private void handleProductQuantity(ActionEvent event) {
	}
}
