package fr.utbm.gl52.proj.model.sav;

import java.io.Serializable;


public class Demande implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4028920286978053266L;
	
	public int numRep;
	public int numCli;
	public String natureRep;
	public String descRep;
	public int refProd;

	public Demande() {
	}

	public Demande(int numRep, int numCli, String natureRep, String descRep, int refProd) {
		super();
		this.numRep = numRep;
		this.numCli = numCli;
		this.natureRep = natureRep;
		this.descRep = descRep;
		this.refProd = refProd;
	}

	public int getNumRep() {
		return numRep;
	}

	public void setNumRep(int numRep) {
		this.numRep = numRep;
	}

	public int getNumCli() {
		return numCli;
	}

	public void setNumCli(int numCli) {
		this.numCli = numCli;
	}

	public String getNatureRep() {
		return natureRep;
	}

	public void setNatureRep(String natureRep) {
		this.natureRep = natureRep;
	}

	public String getDescRep() {
		return descRep;
	}

	public void setDescRep(String descRep) {
		this.descRep = descRep;
	}

	public int getRefProd() {
		return refProd;
	}

	public void setRefProd(int refProd) {
		this.refProd = refProd;
	}
}
