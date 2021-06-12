package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fr.utbm.gl52.proj.controller.ClientController;
import fr.utbm.gl52.proj.controller.ProduitController;
import fr.utbm.gl52.proj.controller.sav.SAVController;
import fr.utbm.gl52.proj.controller.vente.LigneVenteController;
import fr.utbm.gl52.proj.controller.vente.VenteController;
import fr.utbm.gl52.proj.model.Client;
import fr.utbm.gl52.proj.model.Produit;
import fr.utbm.gl52.proj.model.sav.Demande;
import fr.utbm.gl52.proj.model.sav.Reparation;
import fr.utbm.gl52.proj.model.sav.SAV;
import fr.utbm.gl52.proj.model.vente.Vente;
import fr.utbm.gl52.proj.ui.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainSceneController extends AbstractController implements Initializable {
	@FXML
	private ChoiceBox<String> etatReparationMenuBtn;

	// TEXTFIELD
	@FXML
	private TextField searchClientTxtField;
	@FXML
	private TextField searchProductTxtField;
	@FXML
	private TextField searchProductStockTxtField;
	@FXML
	private TextField qttSellTxtField;
	@FXML
	private TextField numEmployeTxtField;
	@FXML
	private TextField nomSavTxtField;
	@FXML
	private TextField prenomSavTxtField;
	@FXML
	private TextField telSavTxtField;
	@FXML
	private TextField mailSavTxtField;
	@FXML
	private TextField adresseSavTxtField;
	@FXML
	private TextField naturePanneTxtField;
	@FXML
	private TextArea descSavTxtArea;

	// LABEL
	@FXML
	private Label clientInfosLabel;
	@FXML
	private Label montantTtlLabel;

	// TABLE
	@FXML
	private TableView<Produit> stockTable;
	@FXML
	private TableColumn<Produit, String> numProdColumn;
	@FXML
	private TableColumn<Produit, String> desProdColumn;
	@FXML
	private TableColumn<Produit, String> qTEProdColumn;
	@FXML
	private TableColumn<Produit, String> prixHTColumn;
	@FXML
	private TableColumn<Produit, String> prixTTCColumn;
	@FXML
	private TableColumn<Produit, String> tVAColumn;

	// LISTE
	@FXML
	private ListView<Client> clientList;
	@FXML
	private ListView<Produit> productList;
	@FXML
	private ListView<Produit> sellList;
	@FXML
	private ListView<SAV> savList;

	private ClientController clientController = new ClientController();
	private ProduitController produitController = new ProduitController();
	private SAVController savController = new SAVController();
	private VenteController venteController = new VenteController();
	private LigneVenteController ligneVenteController = new LigneVenteController();

	private ObservableList<Produit> productToSellList;
	private float mttTotal;
	private SAV currentSAV;

	public MainSceneController() {
		super();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Client> clientItems = FXCollections.observableArrayList(this.clientController.getAllClient());
		ObservableList<Produit> productItems = FXCollections
				.observableArrayList(this.produitController.getAllProduit());
		ObservableList<SAV> savItems = FXCollections.observableArrayList(this.savController.getAllSav());
		this.stockTable.setItems(productItems);
		this.clientList.setItems(clientItems);
		this.productList.setItems(productItems);
		this.savList.setItems(savItems);
		this.productToSellList = FXCollections.observableArrayList();
	}

	@FXML
	private void switchToGestionnaireClient() throws IOException {
		App.setRoot("GestionnaireClient");
	}

	@FXML
	@Override
	public void switchToMainScene() throws IOException {
		super.switchToMainScene();
	}

	// VENTE PANEL //

	@FXML
	public void createClient() throws IOException {
		App.setRoot("GestionnaireClient");
	}

	@FXML
	public void modifyClient() throws IOException {

		App.setRoot("GestionnaireClient");
		GestionnaireClientController gcc = App.getFxmlLoader().getController();
		gcc.setDataForUpdate(clientList.getSelectionModel().getSelectedItem());
	}

	@FXML
	public void deleteClient() throws IOException {
		if (clientList.getSelectionModel().getSelectedItem() != null) {
			this.clientController.deleteClient(clientList.getSelectionModel().getSelectedItem());
		}
		this.initialize(null, null);
	}

	@FXML
	public void cancelSell() {
		this.productToSellList.clear();
		this.clientInfosLabel.setText("");
		this.montantTtlLabel.setText("");
		this.sellList.setItems(productToSellList);
		this.initialize(null, null);
	}

	@FXML
	public void changeMontantVenteValue() {
		String qtt = qttSellTxtField.getText();
		Produit tempProduct = productList.getSelectionModel().getSelectedItem();
		if (Integer.parseInt(qtt) < Integer.parseInt(tempProduct.getQteProd())) {
			tempProduct.setQteProd(qtt);
			this.productToSellList.add(tempProduct);
			mttTotal = mttTotal + Float.parseFloat(tempProduct.getPrixTTCProd()) * Integer.parseInt(qtt);

			this.sellList.setItems(productToSellList);
			this.montantTtlLabel.setText(mttTotal + "");
		}

		this.qttSellTxtField.clear();
	}

	@FXML
	public void selectClientVenteInfo() {
		Client client = clientList.getSelectionModel().getSelectedItem();
		String str = "%s %s\n %s";
		this.clientInfosLabel
				.setText(String.format(str, client.getNomCli(), client.getPrenomCli(), client.getAdresse()));
	}

	@FXML
	public void getSearchClientVente() {
		if (!this.searchClientTxtField.getText().equals("")) {
			this.clientList.setItems(FXCollections.observableArrayList(
					this.clientController.searchByClientName(this.searchClientTxtField.getText())));
		} else {
			this.clientList.setItems(FXCollections.observableArrayList(this.clientController.getAllClient()));
		}
	}

	@FXML
	public void getSearchProductVente() {
		if (!this.searchProductTxtField.getText().equals("")) {
			this.productList.setItems(FXCollections.observableArrayList(
					this.produitController.searchByProductNameOrRef(this.searchProductTxtField.getText())));
		} else {
			this.productList.setItems(FXCollections.observableArrayList(this.produitController.getAllProduit()));
		}
	}

	@FXML
	public void sell() {
		Vente current = this.setSell();
		if (current != null) {
			List<Produit> list = this.produitController.getAllProduit();
			for (Produit produit : productToSellList) {
				if (list.contains(produit)) {

					Integer temp = Integer.parseInt(list.get(list.indexOf(produit)).getQteProd())
							- Integer.parseInt(produit.getQteProd());
					produit.setQteProd(temp + "");
					this.setSellLine(current.getNumVte(), produit.getRefProd(), produit.getQteProd());
				}
			}

		}
		this.produitController.modifyProduitList(productToSellList);
		this.cancelSell();
	}

	private Vente setSell() {
		if (this.clientList.getSelectionModel().getSelectedItem() != null
				&& this.numEmployeTxtField.getText() != null) {
			return this.venteController.insertNewVente(this.clientList.getSelectionModel().getSelectedItem(),
					this.numEmployeTxtField.getText(), this.mttTotal);

		} else {
			return null;
		}
	}

	private void setSellLine(String numVte, String refProd, String qtt) {
		this.ligneVenteController.insertNewLigneVente(numVte, refProd, qtt);
	}

// SAV PANEL //

	@FXML
	public void createReparation() throws IOException {
		App.setRoot("GestionnaireSav");
	}

	@FXML
	public void modifyReparation() throws IOException {

		if (this.currentSAV != null) {
			Reparation updatedReparation = new Reparation(this.currentSAV.getReparation().getNumRep(),
					this.etatReparationMenuBtn.getSelectionModel().getSelectedItem());
			System.out.println(this.etatReparationMenuBtn.getSelectionModel().getSelectedItem());
			Demande updatedDemande = new Demande(this.currentSAV.getDemande().getNumRep(),
					this.currentSAV.getDemande().getNumCli(), this.naturePanneTxtField.getText(),
					this.descSavTxtArea.getText(), this.currentSAV.getDemande().getRefProd(),
					this.currentSAV.getDemande().getNumFct());
			this.savController.modifySAV(updatedReparation, updatedDemande);
			this.savList.setItems(FXCollections.observableArrayList(this.savController.getAllSav()));
		}
	}

	@FXML
	public void deleteReparation() {
		if (this.currentSAV!= null) {
			this.savController.deleteSAV(this.currentSAV.getDemande());
			this.initialize(null, null);
		}
	}

	@FXML
	public void changeSavTextFieldValues() {
		this.currentSAV = this.savList.getSelectionModel().getSelectedItem();
		this.nomSavTxtField.setText(currentSAV.getClient().getNomCli());
		this.prenomSavTxtField.setText(currentSAV.getClient().getPrenomCli());
		this.adresseSavTxtField.setText(currentSAV.getClient().getAdresse());
		this.telSavTxtField.setText(currentSAV.getClient().getTelCli());
		this.mailSavTxtField.setText(currentSAV.getClient().getMailCli());
		this.naturePanneTxtField.setText(currentSAV.getDemande().getNatureRep());
		this.descSavTxtArea.setText(currentSAV.getDemande().getDescRep());
		this.etatReparationMenuBtn.setValue(currentSAV.getReparation().getEtatRep());

	}

	@FXML
	public void savFiltre() {

	}

	@FXML
	public void SAVRecherche() {

	}


	@FXML
	public void addFactureLine() throws IOException {
		App.setRoot("GestionnaireFacture");
	}

	@FXML
	public void modifyFactureLine() throws IOException {
		App.setRoot("GestionnaireFacture");
	}

	@FXML
	public void deleteFactureLine() {

	}

// STOCK PANEL //

	@FXML
	public void createProduit() throws IOException {
		App.setRoot("GestionnaireProduit");
	}

	@FXML
	public void modifyProduit() throws IOException {

		App.setRoot("GestionnaireProduit");
		GestionProduitController gpc = App.getFxmlLoader().getController();
		gpc.setDataForUpdate(this.stockTable.getSelectionModel().getSelectedItem());
	}

	@FXML
	public void deleteProduit() throws IOException {
		this.produitController.deleteProduit(this.stockTable.getSelectionModel().getSelectedItem().getRefProd());
		this.initialize(null, null);
	}

	@FXML
	public void getSearchProductStock() {
		if (!this.searchProductTxtField.getText().equals("")) {
			this.stockTable.setItems(FXCollections.observableArrayList(
					this.produitController.searchByProductNameOrRef(this.searchProductStockTxtField.getText())));
		} else {
			this.stockTable.setItems(FXCollections.observableArrayList(this.produitController.getAllProduit()));
		}
	}
}
