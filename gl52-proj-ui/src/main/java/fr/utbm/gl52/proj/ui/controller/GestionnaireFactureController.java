package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;

import fr.utbm.gl52.proj.controller.sav.facture.LigneFactureController;
import fr.utbm.gl52.proj.model.sav.facture.LigneFacture;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestionnaireFactureController extends AbstractController {
	
	private LigneFactureController ligneFactureController = new LigneFactureController();
	@FXML
	private TextArea desRepTxtField ;
	@FXML
	private TextField prixRepTxtField;
	
	private boolean isNew = true;

	private String id;
	private String numFct;
	
	@FXML
	@Override
	public void switchToMainScene() throws IOException {
		super.switchToMainScene();
	}
	
	@FXML
	public void switchToMainSceneValidate() throws IOException {
		if (!this.checkTextFieldIsNull()) {
			this.isNew();
			super.switchToMainScene();
		}
	}

	private boolean checkTextFieldIsNull() {
		return this.desRepTxtField.getSelectedText().isEmpty() &&
				this.prixRepTxtField.getSelectedText().isEmpty() ;
	}

	private void isNew() throws IOException {
		if (isNew) {
			this.newLigneFacture();
		} else {
			this.modifyLigneFacture();
		}
	}

	private void newLigneFacture() throws IOException {
		LigneFacture ligneFacture = this.setLigneFacture(this.ligneFactureController.getNextValId());
		this.ligneFactureController.insertNewLigneFacture(ligneFacture);
		super.switchToMainScene();
	}

	private void modifyLigneFacture() throws IOException {
		LigneFacture ligneFacture = this.setLigneFacture(this.id);
		this.ligneFactureController.updateLigneFacture(ligneFacture);
	}

	private LigneFacture setLigneFacture(String id) {
		
		String mttLigneFct = this.prixRepTxtField.getText();
		String desLignefct = this.desRepTxtField.getText();
		LigneFacture ligneFacture = new LigneFacture(id,this.numFct, mttLigneFct, desLignefct);
		return ligneFacture;
	}
	
	public void setNumFct(String numFct) {
		this.numFct= numFct;
		
	}
	
	public void setDataForUpdate(@SuppressWarnings("exports") LigneFacture ligneFacture) {	
		
		this.id =ligneFacture.getIdLigneFct();
		this.desRepTxtField.setText( ligneFacture.getDesLigneFct());
		this.prixRepTxtField.setText(ligneFacture.getMttLigneFct());
		this.isNew = false;
		
	}
	
	
	@FXML
	private void handleDesRepTxtField(ActionEvent event) {
	}
	@FXML
	private void handlePrixRepTxtField(ActionEvent event) {
	}
	
}