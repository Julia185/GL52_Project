package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.utbm.gl52.proj.controller.ClientController;
import fr.utbm.gl52.proj.controller.ProduitController;
import fr.utbm.gl52.proj.controller.sav.SAVController;
import fr.utbm.gl52.proj.model.Client;
import fr.utbm.gl52.proj.model.Produit;
import fr.utbm.gl52.proj.model.sav.SAV;
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
	private ProduitController produitController = new ProduitController();
	private ClientController clientController = new ClientController();
	private boolean isNew = true;

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
		this.isNew();
		super.switchToMainScene();
	}

	private void isNew() throws IOException {
		if (isNew) {
			this.newSAV();
		} else {
			this.modifySAV();
		}
	}

	private void newSAV() throws IOException {
		this.setSAV();
		if (this.clientListView.getSelectionModel().getSelectedItem() != null
				&& this.productClientListView.getSelectionModel().getSelectedItem() != null
				&& !this.numEmployeTxtField.getText().equals("")) {
			this.savController.createSAV(this.clientListView.getSelectionModel().getSelectedItem(),
					this.productClientListView.getSelectionModel().getSelectedItem(),
					this.reparationDescriptionTxtArea.getText(), this.natureReparationTxtArea.getText(),
					this.numEmployeTxtField.getText());
		}

	}

	private void modifySAV() throws IOException {
		super.switchToMainScene();
	}

	private SAV setSAV() throws IOException {
		return null;
	}

	public void setDataForUpdate(@SuppressWarnings("exports") Produit produit) {
		this.isNew = false;

	}

	@FXML
	public void setClientProduct() {
		this.productClientListView.setItems(FXCollections.observableArrayList(this.savController
				.getProductbyClient(this.clientListView.getSelectionModel().getSelectedItem().getNumCli())));
	}

	@FXML
	private void handleReparationDescription(ActionEvent event) {
	}

}
