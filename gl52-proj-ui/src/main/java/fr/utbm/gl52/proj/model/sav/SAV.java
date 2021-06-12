package fr.utbm.gl52.proj.model.sav;

import fr.utbm.gl52.proj.model.Client;
import fr.utbm.gl52.proj.model.sav.facture.Facture;

public class SAV {

	private Client client;
	private Demande demande;
	private Reparation reparation;
	private Facture facture;

	public SAV() {
		super();
	}

	public SAV(Client client, Demande demande, Reparation reparation, Facture facture) {
		super();
		this.client = client;
		this.demande = demande;
		this.reparation = reparation;
		this.facture = facture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public Reparation getReparation() {
		return reparation;
	}

	public void setReparation(Reparation reparation) {
		this.reparation = reparation;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	@Override
	public String toString() {
		return " " + this.client.getNomCli() + " " + this.client.getPrenomCli().substring(0, 1)
				+ this.client.getPrenomCli().substring(1).toLowerCase() + " | " + this.reparation.getEtatRep() + " | "
				+ this.demande.getNatureRep() + " | " + this.demande.getRefProd() + " | " + this.facture.getDateFct();
	}

}
