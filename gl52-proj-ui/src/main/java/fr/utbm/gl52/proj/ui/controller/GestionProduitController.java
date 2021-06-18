package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.utbm.gl52.proj.controller.ProduitController;
import fr.utbm.gl52.proj.controller.stock.EntreeStockController;
import fr.utbm.gl52.proj.model.Produit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class GestionProduitController extends AbstractController implements Initializable {

	private ProduitController produitController = new ProduitController();
	private EntreeStockController entreeStockController = new EntreeStockController();

	@FXML
	private TextField refProdTxtField;
	@FXML
	private TextField desProdTxtField;
	@FXML
	private TextField qteProdTxtField;
	@FXML
	private TextField prixHTTxtField;
	@FXML
	private TextField prixTTCTxtField;
	@FXML
	private TextField tVAProdTxtField;

	private boolean isNew = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	@Override
	public void switchToMainScene() throws IOException {
		super.switchToMainScene();
	}

	@FXML
	public void switchToMainSceneValidate() throws IOException {

		this.isNew();
		super.switchToMainScene();
	}

	private void isNew() throws IOException {
		if (isNew) {
				this.newProduit();
		} else {
			this.modifyProduit();
		}
	}

	private void newProduit() throws IOException {
		Produit produit = this.setProduit();
		this.produitController.insertNewProduit(produit);
		this.entreeStockController.insertNewEntree(produit);
		super.switchToMainScene();
	}

	private void modifyProduit() throws IOException {
		Produit produit = this.setProduit();
		this.produitController.modifyProduit(produit);
		this.entreeStockController.insertNewEntree(produit);
		super.switchToMainScene();
	}

	private Produit setProduit() throws IOException {
		String referenceProd = this.refProdTxtField.getText();
		String descriptionProduct = this.desProdTxtField.getText();
		String quantity = this.qteProdTxtField.getText();
		String prixHTT = this.prixHTTxtField.getText();
		String prixTTC = this.prixTTCTxtField.getText();
		String TVA = this.tVAProdTxtField.getText();
		Produit produit = new Produit(referenceProd, descriptionProduct, quantity, prixHTT, prixTTC, TVA);
		return produit;
	}

	public void setDataForUpdate(@SuppressWarnings("exports") Produit produit) {
		this.refProdTxtField.setText(produit.getRefProd());
		this.desProdTxtField.setText(produit.getDesProd());
		this.prixHTTxtField.setText(produit.getPrixHTProd());
		this.prixTTCTxtField.setText(produit.getPrixTTCProd());
		this.qteProdTxtField.setText(produit.getQteProd());
		this.tVAProdTxtField.setText(produit.getTVAProd());
		this.isNew = false;

	}

	@FXML
	private void handleProductReference(ActionEvent event) {
	}

	@FXML
	private void handleProductDescription(ActionEvent event) {
	}

	@FXML
	private void handleProductHTPrice(ActionEvent event) {
	}

	@FXML
	private void handleProductTTCPrice(ActionEvent event) {
	}

	@FXML
	private void handleProductQuantity(ActionEvent event) {
	}

	@FXML
	void handleProductTVA(ActionEvent event) {

	}
}
