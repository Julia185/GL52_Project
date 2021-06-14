package fr.utbm.gl52.proj.controller.sav.facture;

import fr.utbm.gl52.proj.model.sav.facture.LigneFacture;
import fr.utbm.gl52.proj.service.sav.facture.LigneFactureService;

public class LigneFactureController {
	
	LigneFactureService service = new LigneFactureService();

	public LigneFactureController() {
		super();
	}
	
	public String getNextValId() {
		return this.service.getNextValId();
	}
	
	public void insertNewLigneFacture(LigneFacture ligneFacture) {
		this.service.insertNewLigneFacture(ligneFacture);
	}
	
	public LigneFacture getById(String idLigneFct) {
		return this.service.getById(idLigneFct);
	}
	
	public void updateLigneFacture(LigneFacture ligneFacture) {
		this.service.updateLigneFacture(ligneFacture);
	}
	
	public LigneFacture getByIdFct(String numFct) {
		return this.service.getByIdFct(numFct);
	}
	
	public void deleteLigneFactureByFactureId(String numFct) {
		this.service.deleteLigneFactureByFactureId(numFct);
	}
	
	public void deleteLigneFactureById(String idLigneFct) {
		this.service.deleteLigneFactureById(idLigneFct);
	}

}
