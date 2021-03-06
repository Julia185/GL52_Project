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
		this.service.insertReparation(reparation);
	}

	public Reparation getById(String numRep) {
		return this.service.getById(numRep);
	}

	public void modifyReparation(Reparation reparation) {
		this.service.updateReparation(reparation);
	}

	public void deleteReparation(String numRep) {
		this.service.deleteReparation( numRep);
	}

	

}
