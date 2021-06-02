package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GestionProduitController extends AbstractController {

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

	private void insertNewProduct() {
		String ReferenceProd = this.RefProdTxtField.getText();
		String DescriptionProduct = this.DesProdTxtField.getText();
		int quantity = Integer.parseInt(this.QteProdTxtField.getText());
		float prixHTT = Float.parseFloat(this.PrixHTTxtField.getText());
		float prixTTC = Float.parseFloat(this.PrixTTCTxtField.getText());
		float TVA = Float.parseFloat(this.TVAProdTxtField.getText());
		
		//Produit produit = new Produit(ReferenceProd, DescriptionProduct, quantity, prixHTT, prixTTC, TVA);
		//this.produitController.insertNewProduct(produit);
	}
}
