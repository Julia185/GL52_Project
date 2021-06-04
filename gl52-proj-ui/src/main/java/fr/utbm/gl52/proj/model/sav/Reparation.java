package fr.utbm.gl52.proj.model.sav;

import java.io.Serializable;


public class Reparation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2951661481225212439L;
	private int numRep;
	private String etatRep;

	public Reparation() {
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
