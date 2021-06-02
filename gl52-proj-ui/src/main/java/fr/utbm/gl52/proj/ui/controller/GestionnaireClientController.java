package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;

//import fr.utbm.gl52.proj.controller.ClientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GestionnaireClientController extends AbstractController {

//	private ClientController clientController = new ClientController();

	@FXML
	private TextField firstNameClientTxtField;
	@FXML
	private TextField lastNameClientTxtField;
	@FXML
	private TextField phoneClientTxtField;
	@FXML
	private TextField emailClientTxtField;
	@FXML
	private TextField numClientTxtField;
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
		this.insertNewClient();
		super.switchToMainScene();
	}

	private void insertNewClient() {
		String firstName = this.firstNameClientTxtField.getText();
		String lastName = this.lastNameClientTxtField.getText();
		String phone = this.phoneClientTxtField.getText();
		String mail = this.emailClientTxtField.getText();
		String num = this.numClientTxtField.getText();
		String rue = this.rueClientTxtField.getText();
		String ville = this.villeClientTxtField.getText();
		int cp =	Integer.parseInt(this.cpClientTxtField.getText());
		String pays = this.paysClientTxtField.getText();
		
//		Client client = new Client(0, lastName,firstName,rue,ville,cp,pays); 
//		 this.clientController.insertNewClient(client);

	}

	public void modifyClient(/* Client client */) {
		//this.firstNameClientTxtField.setText(client.getNomCli());
//		this.lastNameClientTxtField.setText(client.getPrenomCli());
//		this.adresseClientTxtField.setText(client.get);
//		this.phoneClientTxtField.setText(client.get);
//		this.emailClientTxtField.setText();

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
