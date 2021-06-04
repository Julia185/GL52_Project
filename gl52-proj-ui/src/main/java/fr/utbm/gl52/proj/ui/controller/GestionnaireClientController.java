package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;

import fr.utbm.gl52.proj.controller.ClientController;
import fr.utbm.gl52.proj.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GestionnaireClientController extends AbstractController {

	private ClientController clientController = new ClientController();

	@FXML
	private TextField numClientTxtField;
	@FXML
	private TextField firstNameClientTxtField;
	@FXML
	private TextField lastNameClientTxtField;
	@FXML
	private TextField phoneClientTxtField;
	@FXML
	private TextField emailClientTxtField;
	@FXML
	private TextField rueClientTxtField;
	@FXML
	private TextField villeClientTxtField;
	@FXML
	private TextField cpClientTxtField;
	@FXML
	private TextField paysClientTxtField;

	@FXML
	@Override
	public void switchToMainScene() throws IOException {
		super.switchToMainScene();
	}

	@FXML
	public void switchToMainSceneValidate() throws IOException {
		this.newClient();
		super.switchToMainScene();
	}

	private void newClient() throws IOException {
		Client client = this.setClient();
		this.clientController.insertNewClient(client);
		super.switchToMainScene();
	}
	
	private void modifyClient() throws IOException {
		Client client = this.setClient();
		// Trouver quoi mettre pour modifier un produit déjà existant.
		this.clientController.modifyClient(client);
		super.switchToMainScene();
	}

	private void removeClient() throws IOException {
		String num = this.numClientTxtField.getText();
		this.clientController.eraseClient(num);
	}

	private Client setClient() {
		String num = this.numClientTxtField.getText();
		String firstName = this.firstNameClientTxtField.getText();
		String lastName = this.lastNameClientTxtField.getText();
		String phone = this.phoneClientTxtField.getText();
		String mail = this.emailClientTxtField.getText();
		String rue = this.rueClientTxtField.getText();
		String ville = this.villeClientTxtField.getText();
		String cp = this.cpClientTxtField.getText();
		String pays = this.paysClientTxtField.getText();
		Client client = new Client(num, lastName,firstName,phone,mail,rue,ville,cp,pays); 
		return client;
	}

	@FXML
	private void handleClientFirstName(ActionEvent event) {
	}

	@FXML
	private void handleClientLastName(ActionEvent event) {
	}

	@FXML
	private void handleClientAdresse(ActionEvent event) {
	}

	@FXML
	private void handleClientPhone(ActionEvent event) {
	}

	@FXML
	private void handleClientnum(ActionEvent event) {
	}
	@FXML
	private void handleClientRue(ActionEvent event) {
	}
	@FXML
	private void handleClientVille(ActionEvent event) {
	}
	@FXML
	private void handleClientCp(ActionEvent event) {
	}
	@FXML
	private void handleClientPays(ActionEvent event) {
	}
	@FXML
	private void handleClientEmail(ActionEvent event) {
	}

}
