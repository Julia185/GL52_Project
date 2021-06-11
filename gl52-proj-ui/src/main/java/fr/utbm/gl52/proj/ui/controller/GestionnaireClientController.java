package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.utbm.gl52.proj.controller.ClientController;
import fr.utbm.gl52.proj.model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class GestionnaireClientController extends AbstractController implements Initializable{

	private ClientController clientController = new ClientController();
	
	
	@FXML
	private TextField idClientTxtField;
	@FXML
	private TextField firstNameClientTxtField;
	@FXML
	private TextField lastNameClientTxtField;
	@FXML
	private TextField phoneClientTxtField;
	@FXML
	private TextField emailClientTxtField;
	@FXML
	private TextField numRueClientTxtField;
	@FXML
	private TextField rueClientTxtField;
	@FXML
	private TextField villeClientTxtField;
	@FXML
	private TextField cpClientTxtField;
	@FXML
	private TextField paysClientTxtField;

	private boolean isNew = true;


	private String id;

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
			this.newClient();
		} else {
			this.modifyClient();
		}
	}

	private void newClient() throws IOException {
		Client client = this.setClient(this.clientController.getNextValId());
		this.clientController.insertNewClient(client);
		super.switchToMainScene();
	}

	private void modifyClient() throws IOException {
		Client client = this.setClient(this.id);
		this.clientController.modifyClient(client);
		super.switchToMainScene();
	}

	private Client setClient(String id) {
		
		String firstName = this.firstNameClientTxtField.getText();
		String lastName = this.lastNameClientTxtField.getText();
		String phone = this.phoneClientTxtField.getText();
		String mail = this.emailClientTxtField.getText();
		String numRue = this.numRueClientTxtField.getText();
		String rue = this.rueClientTxtField.getText();
		String ville = this.villeClientTxtField.getText();
		String cp = this.cpClientTxtField.getText();
		String pays = this.paysClientTxtField.getText();
		Client client = new Client(id, lastName, firstName, phone, mail, numRue + " " + rue, ville, cp, pays);
		return client;
	}
	
	
	public void setDataForUpdate(@SuppressWarnings("exports") Client client) {	
		String numRue;
		String rue;
		if (client.getRueCli().matches("^[0-9].*$")) {
			numRue = client.getRueCli().substring(0, client.getRueCli().trim().indexOf(" "));
			rue = client.getRueCli().substring(client.getRueCli().trim().indexOf(" "));
		} else {
			numRue = "";
			rue = client.getRueCli();
		}
		this.id =client.getNumCli();
		this.firstNameClientTxtField.setText(client.getPrenomCli());
		this.lastNameClientTxtField.setText(client.getNomCli());
		this.phoneClientTxtField.setText(client.getTelCli());
		this.emailClientTxtField.setText(client.getMailCli());
		this.numRueClientTxtField.setText(numRue);
		this.rueClientTxtField.setText(rue);
		this.villeClientTxtField.setText(client.getVilleCli());
		this.cpClientTxtField.setText(client.getCpCli());
		this.paysClientTxtField.setText(client.getPaysCli());
		this.isNew = false;
		
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
