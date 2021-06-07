package fr.utbm.gl52.proj.model.sav;

import java.io.Serializable;


public class Reparation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2951661481225212439L;
	private String numRep;
	private String etatRep;

	
	public Reparation(String numRep, String etatRep) {
		super();
		this.numRep = numRep;
		this.etatRep = etatRep;
	}

	public String getNumRep() {
		return numRep;
	}

	public void setNumRep(String numRep) {
		this.numRep = numRep;
	}

	public String getEtatRep() {
		return etatRep;
	}

	public void setEtatRep(String etatRep) {
		this.etatRep = etatRep;
	}
}
