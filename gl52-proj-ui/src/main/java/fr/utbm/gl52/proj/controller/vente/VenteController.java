package fr.utbm.gl52.proj.controller.vente;

import java.time.LocalDateTime;

import fr.utbm.gl52.proj.model.Client;
import fr.utbm.gl52.proj.model.vente.Vente;
import fr.utbm.gl52.proj.service.vente.VenteService;

public class VenteController {
	
	private VenteService service = new VenteService();

	public VenteController() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNextValId() {
		return this.service.getNextValId();		
	}

	public Vente insertNewVente(Client client, String numEmp, float mttTotal) {
		Vente vente = new Vente(this.service.getNextValId(), client.getNumCli(), numEmp, LocalDateTime.now().toString(), mttTotal+"");
		if (this.service.insertNewVente(vente)) {
			return vente;
		} else {
			return null;
		}
	}

}
