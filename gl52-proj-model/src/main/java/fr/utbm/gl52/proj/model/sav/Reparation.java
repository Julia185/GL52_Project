package fr.utbm.gl52.proj.model.sav;

public class Reparation {
	public int numRep;
	public String etatRep;

	public Reparation() {
		this.numRep = 1;
		this.etatRep = "Produit cassé";
	}

	public Reparation(int numRep, String etatRep) {
		super();
		this.numRep = numRep;
		this.etatRep = etatRep;
	}

	public int getNumRep() {
		return numRep;
	}

	public void setNumRep(int numRep) {
		this.numRep = numRep;
	}

	public String getEtatRep() {
		return etatRep;
	}

	public void setEtatRep(String etatRep) {
		this.etatRep = etatRep;
	}
}
