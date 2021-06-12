package fr.utbm.gl52.proj.controller.sav;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.utbm.gl52.proj.controller.ClientController;
import fr.utbm.gl52.proj.controller.ProduitController;
import fr.utbm.gl52.proj.controller.sav.facture.FactureController;
import fr.utbm.gl52.proj.model.Client;
import fr.utbm.gl52.proj.model.Produit;
import fr.utbm.gl52.proj.model.sav.Demande;
import fr.utbm.gl52.proj.model.sav.Reparation;
import fr.utbm.gl52.proj.model.sav.SAV;
import fr.utbm.gl52.proj.model.sav.facture.Facture;


public class SAVController {

	private ClientController clientController = new ClientController();
	private DemandeController demandeController = new DemandeController();
	private FactureController factureConrtoller = new FactureController();
	private ReparationController reparationController = new ReparationController();
	private ProduitController produitController  = new ProduitController();
	
	public List<SAV> getAllSav() {
		List<SAV> savList = new ArrayList<SAV>();
		for (Demande dmd : this.demandeController.getAllDemande()) {
			SAV newSav = new SAV();
			newSav.setDemande(dmd);
			newSav.setClient(this.clientController.getById(dmd.getNumCli()));
			newSav.setReparation(this.reparationController.getById(dmd.getNumRep()));
			newSav.setFacture(this.factureConrtoller.getById(dmd.getNumFct()));
			savList.add(newSav);
		}
		System.out.println(savList.size());
		return savList ;
	}
	
	
	public List<Produit> getProductbyClient(String numCli){
		return this.produitController.getProductbyClient(numCli);
	}
	
	public void createSAV(Client client, Produit produit , String descRep, String natureRep, String numEmp) {
		Reparation reparation = new Reparation(this.reparationController.getNextValId(), "Non Commencé");
		this.reparationController.insertNewReparation(reparation);
		Facture facture = new Facture(this.factureConrtoller.getNextValId(), LocalDate.now().toString(), numEmp); 
		this.factureConrtoller.insertNewFacture(facture);
		Demande dmd = new Demande(reparation.getNumRep(), client.getNumCli(), natureRep, descRep, produit.getRefProd(),facture.getNumFct());
		this.demandeController.insertNewDemande(dmd);
	}

}
