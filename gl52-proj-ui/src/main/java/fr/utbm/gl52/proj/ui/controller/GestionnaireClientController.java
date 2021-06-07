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

	private Client client = new Client();

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
		// Trouver quoi mettre pour modifier un client déjà existant.
		this.clientController.modifyClient(client);
		super.switchToMainScene();
	}

	private Client setClient() {
		String firstName = this.firstNameClientTxtField.getText();
		String lastName = this.lastNameClientTxtField.getText();
		String phone = this.phoneClientTxtField.getText();
		String mail = this.emailClientTxtField.getText();
		String num = this.rueClientTxtField.getText();
		String rue = this.rueClientTxtField.getText();
		String ville = this.villeClientTxtField.getText();
		String cp = this.cpClientTxtField.getText();
		String pays = this.paysClientTxtField.getText();
		Client client = new Client("", lastName, firstName, phone, mail, num + " " + rue, ville, cp, pays);
		return client;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("j'initialise|"+this.client);

//		this.firstNameClientTxtField.setText(client.getPrenomCli());
//		this.lastNameClientTxtField.setText(client.getNomCli());
//		this.phoneClientTxtField.setText(client.getTelCli());
//		this.emailClientTxtField.setText(client.getMailCli());
//		this.numRueClientTxtField.setText(client.getRueCli().substring(0, client.getRueCli().trim().indexOf(" ")));
//		this.rueClientTxtField.setText(client.getRueCli().substring(client.getRueCli().trim().indexOf(" ")));
//		this.villeClientTxtField.setText(client.getVilleCli());
//		this.cpClientTxtField.setText(client.getCpCli());
//		this.paysClientTxtField.setText(client.getPaysCli());
	}
	
	public void setDateForUpdate(Client client) {		
		System.out.println("Je set ");
		this.client = client;
		System.out.println(this.client);
		
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
