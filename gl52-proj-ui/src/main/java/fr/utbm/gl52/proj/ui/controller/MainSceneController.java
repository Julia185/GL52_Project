package fr.utbm.gl52.proj.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.utbm.gl52.proj.controller.ClientController;
import fr.utbm.gl52.proj.controller.ProduitController;
import fr.utbm.gl52.proj.model.Client;
import fr.utbm.gl52.proj.model.Produit;
import fr.utbm.gl52.proj.ui.App;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainSceneController extends AbstractController implements Initializable {

	@FXML
	private TextField searchClientTxtField;
	@FXML
	private TextField searchProductTxtField;
	@FXML
	private Label clientInfosLabel;
	@FXML
	private Label montantTtlLabel;
	// STOCK
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

	@FXML
	private ListView<Client> clientList;
	@FXML
	private ListView<Produit> productList;

	private ClientController clientController = new ClientController();
	private ProduitController produitController = new ProduitController();

	public MainSceneController() {
		super();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Client> clientItems = FXCollections.observableArrayList(this.clientController.getAllClient());
		ObservableList<Produit> productItems = FXCollections.observableArrayList(this.produitController.getAllProduit());
		this.clientList.setItems(clientItems);
		this.productList.setItems(productItems);
	}

	// VENTE PANEL //
	@FXML
	private void switchToGestionnaireClient() throws IOException {
		App.setRoot("GestionnaireClient");
	}

	@FXML
	@Override
	public void switchToMainScene() throws IOException {
		// TODO Auto-generated method stub
		super.switchToMainScene();
	}

	@FXML
	public void createClient() throws IOException {
		App.setRoot("GestionnaireClient");
	}

	@FXML
	public void modifyClient() throws IOException {
		GestionnaireClientController gcc = new GestionnaireClientController();
		gcc.setDateForUpdate( clientList.getSelectionModel().getSelectedItem());
		App.setRoot("GestionnaireClient");
		/* get selected element from list client */
	}

	@FXML
	public void deleteClient() throws IOException {
		/* get selected element from list client */
		/* call ClientController delete methode */
	}

	@FXML
	public void scanner() {
		/* simulate scan ? */
	}

	@FXML
	public void cancelSell() {
		/* clear all field */
	}

	@FXML
	public void changeMontantVenteValue() {

	}

	@FXML
	public void selectClientVenteInfo() {
		Client client = clientList.getSelectionModel().getSelectedItem();
		String str = "%s %s\n %s";
		this.clientInfosLabel.setText(String.format(str, client.getNomCli(), client.getPrenomCli(),client.getAdresse()));
	}

	@FXML
	public void getSearchClientVente() {

	}

	@FXML
	public void getSearchProductVente() {

	}

	@FXML
	public void checkBoxFactureState() {

	}

// SAV PANEL //
    
	@FXML
	public void createReparation() {

	}

	@FXML
	public void modifiyReparation() {

	}

	@FXML
	public void deleteReparation() {

	}

	@FXML
	public void savFiltre() {

	}

	@FXML
	public void SAVRecherche() {

	}

	@FXML
	public void validerReparation() {

	}

	@FXML
	public void addFactureLine() {

	}

	@FXML
	public void modifyFactureLine() {

	}

	@FXML
	public void deleteFactureLine() {

	}
	
// STOCK PANEL //
	
	@FXML
	public void showNumProd() {
//		Produit produit = productList.getSelectionModel().getSelectedItem();
//		NumProdColumn.setCellValueFactory(Produit -> {
//			SimpleObjectProperty<String> property = new SimpleObjectProperty<String>();
//			property.setValue(Produit.getValue().getRefProd());
//			return property;
//			});
		
//		numProdColumn.setCellValueFactory(Produit -> Produit.getValue().getRefProd());
		
		PropertyValueFactory<Produit, String> refProd = new PropertyValueFactory<>("refProd");
		numProdColumn.setCellValueFactory(refProd);
	}
	
	@FXML
	public void showDesProd() {
		desProdColumn.setCellValueFactory(Produit -> Produit.getValue().desProdProperty());
	}
	
	@FXML
	public void showQteProd() {
		qTEProdColumn.setCellValueFactory(Produit -> Produit.getValue().qteProdProperty());
	}
	
	@FXML
	public void showPrixHTProd() {
		prixHTColumn.setCellValueFactory(Produit -> Produit.getValue().prixHTProdProperty());
	}
	
	@FXML
	public void showPrixTTCProd() {
		prixTTCColumn.setCellValueFactory(Produit -> Produit.getValue().prixTTCProdProperty());
	}
	
	@FXML
	public void showTVAProd() {
		tVAColumn.setCellValueFactory(Produit -> Produit.getValue().tvaProdProperty());
	}
	

	@FXML
	public void switchToAddProduct() throws IOException {
		App.setRoot("GestionnaireProduit");
	}

	@FXML
	public void switchToModifyProduct() throws IOException {
		App.setRoot("GestionnaireProduit");
	}

	@FXML
	public void switchToDeleteProduct() throws IOException {
		App.setRoot("GestionnaireProduit");
	}
}
