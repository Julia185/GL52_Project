package fr.utbm.gl52.proj.controller.sav.facture;

import fr.utbm.gl52.proj.model.sav.facture.Facture;
import fr.utbm.gl52.proj.service.sav.facture.FactureService;

public class FactureController {

	private FactureService service = new FactureService();

	public FactureController() {
		super();
	}
	
	public String getNextValId() {
		return this.service.getNextValId();
	}

	public void insertNewFacture(Facture facture) {
		
	}

	public Facture getById(String numFct) {
		return this.service.getById(numFct);
	}



	
}
