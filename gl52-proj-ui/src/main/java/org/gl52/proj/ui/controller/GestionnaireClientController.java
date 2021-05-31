package org.gl52.proj.ui.controller;

import java.io.IOException;

import org.gl52.proj.ui.App;

import javafx.fxml.FXML;

public class GestionnaireClientController extends AbstractController {

	@FXML
	@Override
	public void switchToMainScene() throws IOException {
		super.switchToMainScene();
	}
	
	@FXML
	public void switchToMainSceneValidate() throws IOException{
		App.setRoot(mainSceneScene);
	}
	
	
	public void insertNewClient() {
		String firstName = this.getFirstNameTxtField();
		String lastName = this.getLastNameTxtField();
		String adresse = this.getAdresseTxtField();
		String phone = this.getPhoneTxtField();
		String mail = this.getMailTxtField();
		
		
		//Client client = new Client(firstName,lastName, adresse, phone, mail);
		
		/* call gl52-proj ClientController */
	}

	@FXML
	private String getFirstNameTxtField() {
		return null;
	}
	
	@FXML
	private String getLastNameTxtField() {
		return null;
	}
	
	@FXML
	private String getAdresseTxtField() {
		return null;
	}
	
	@FXML
	private String getPhoneTxtField() {
		return null;
	}
	
	@FXML
	private String getMailTxtField() {
		return null;
	}
	
}
