package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;

import fr.utbm.gl52.proj.controller.ProduitController;
import fr.utbm.gl52.proj.model.Produit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GestionProduitController extends AbstractController {
	
	private ProduitController produitController = new ProduitController();

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
		//this.produitController.insertNewProduct();
		super.switchToMainScene();
	}


	private void newProduct() throws IOException {
		Produit produit = this.setProduit();
		this.produitController.insertNewProduct(produit);

		super.switchToMainScene();
	}
	
	private void modifyProduct() throws IOException {
		Produit produit = this.setProduit();
		// Trouver quoi mettre pour modifier un produit déjà existant.
		this.produitController.modifyProduct(produit);
		super.switchToMainScene();
	}
	
	private void removeProduct() throws IOException {
		String referenceProd = this.RefProdTxtField.getText();
		this.produitController.eraseProduct(referenceProd);
	}

	private Produit setProduit() throws IOException {
		String referenceProd = this.RefProdTxtField.getText();
		String descriptionProduct = this.DesProdTxtField.getText();
		String quantity = this.QteProdTxtField.getText();
		String prixHTT = this.PrixHTTxtField.getText();
		String prixTTC = this.PrixTTCTxtField.getText();
		String TVA = this.TVAProdTxtField.getText();
		Produit produit = new Produit(referenceProd,descriptionProduct,quantity,prixHTT,prixTTC,TVA);
		return produit;
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
