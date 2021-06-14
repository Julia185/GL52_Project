package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.utbm.gl52.proj.controller.ClientController;
import fr.utbm.gl52.proj.controller.sav.SAVController;
import fr.utbm.gl52.proj.model.Client;
import fr.utbm.gl52.proj.model.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestionnaireSavController extends AbstractController implements Initializable {

	private SAVController savController = new SAVController();
	private ClientController clientController = new ClientController();

	@FXML
	private TextArea reparationDescriptionTxtArea;
	@FXML
	private TextArea natureReparationTxtArea;
	@FXML
	private ListView<Client> clientListView;
	@FXML
	private ListView<Produit> productClientListView;
	@FXML
	private TextField numEmployeTxtField;
	@FXML
	private TextField searchClientTxtField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Client> clientItems = FXCollections.observableArrayList(this.clientController.getAllClient());
		this.clientListView.setItems(clientItems);

	}

	@Override
	public void switchToMainScene() throws IOException {
		super.switchToMainScene();
	}

	@FXML
	public void switchToMainSceneValidate() throws IOException {
		this.newSAV();
		super.switchToMainScene();
	}


	private void newSAV() throws IOException {
		if (this.clientListView.getSelectionModel().getSelectedItem() != null
				&& this.productClientListView.getSelectionModel().getSelectedItem() != null
				&& !this.numEmployeTxtField.getText().equals("")) {
			this.savController.createSAV(this.clientListView.getSelectionModel().getSelectedItem(),
					this.productClientListView.getSelectionModel().getSelectedItem(),
					this.reparationDescriptionTxtArea.getText(), this.natureReparationTxtArea.getText(),
					this.numEmployeTxtField.getText());
		}

	}


	public void setClientProduct() {
		this.productClientListView.setItems(FXCollections.observableArrayList(this.savController
				.getProductbyClient(this.clientListView.getSelectionModel().getSelectedItem().getNumCli())));
	}
	
	@FXML
	public void getSearchClientVente() {
		if (!this.searchClientTxtField.getText().equals("")) {
			this.clientListView.setItems(FXCollections.observableArrayList(
					this.clientController.searchByClientName(this.searchClientTxtField.getText())));
		} else {
			this.clientListView.setItems(FXCollections.observableArrayList(this.clientController.getAllClient()));
		}
	}

	@FXML
	private void handleReparationDescription(ActionEvent event) {
	}
	@FXML
	private void handleReparationNature(ActionEvent event) {
	}
	@FXML
	private void handleReparationNumEmployee(ActionEvent event) {
	}

}
