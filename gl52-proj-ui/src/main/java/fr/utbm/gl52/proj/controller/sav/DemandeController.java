package fr.utbm.gl52.proj.controller.sav;

import java.util.List;

import fr.utbm.gl52.proj.model.sav.Demande;
import fr.utbm.gl52.proj.service.sav.DemandeService;

public class DemandeController {
	
	private DemandeService service = new DemandeService();

	public DemandeController() {
		// TODO Auto-generated constructor stub
	}
		
	public List<Demande> getAllDemande() {
		return this.service.getAllDemande();
	}

	public void insertNewDemande(Demande demande) {
		this.service.insertDemande(demande);
	}

	public void modifyDemande(Demande demande) {
		this.service.updateDemande(demande);
	}


	public void deleteDemande(Demande demande) {
		this.service.deleteDemande(demande);
		
	}
}
