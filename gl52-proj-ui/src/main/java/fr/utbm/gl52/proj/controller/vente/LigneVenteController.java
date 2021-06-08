package fr.utbm.gl52.proj.controller.vente;

import fr.utbm.gl52.proj.model.vente.LigneVente;
import fr.utbm.gl52.proj.service.vente.LigneVenteService;

public class LigneVenteController {

	private LigneVenteService service = new LigneVenteService();
	
	public LigneVenteController() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNextValId() {
		return this.service.getNextValId();		
	}

	public void insertNewLigneVente(String numVte, String refProd, String qtt) {
		LigneVente ligneVente = new LigneVente(this.getNextValId(), qtt, refProd, numVte);
		this.service.insertNewLigneVente(ligneVente);
	}

}
