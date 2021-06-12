package fr.utbm.gl52.proj.controller.sav;

import fr.utbm.gl52.proj.model.sav.Reparation;
import fr.utbm.gl52.proj.service.sav.ReparationService;

public class ReparationController {
	
	private ReparationService service = new ReparationService();
	
	public ReparationController() {
	}
	
	public String getNextValId() {
		return this.service.getNextValid();
	}
	
	public void insertNewReparation(Reparation reparation) {
		this.service.inserReparation(reparation);
	}

	public Reparation getById(String numRep) {
		return this.service.getById(numRep);
	}

	

}
