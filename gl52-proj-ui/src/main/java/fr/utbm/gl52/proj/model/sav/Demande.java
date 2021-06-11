package fr.utbm.gl52.proj.model.sav;

import java.io.Serializable;


public class Demande implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4028920286978053266L;
	
	private String numRep;
	private String numCli;
	private String natureRep;
	private String descRep;
	private String refProd;
	private String numFct;

	public Demande() {
	}

	public Demande(String numRep, String numCli, String natureRep, String descRep, String refProd, String numFct) {
		super();
		this.numRep = numRep;
		this.numCli = numCli;
		this.natureRep = natureRep;
		this.descRep = descRep;
		this.refProd = refProd;
		this.numFct = numFct;
	}

	public String getNumRep() {
		return numRep;
	}

	public void setNumRep(String numRep) {
		this.numRep = numRep;
	}

	public String getNumCli() {
		return numCli;
	}

	public void setNumCli(String numCli) {
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

	public String getRefProd() {
		return refProd;
	}

	public void setRefProd(String refProd) {
		this.refProd = refProd;
	}


	public String getNumFct() {
		return numFct;
	}

	public void setNumFct(String numFct) {
		this.numFct = numFct;
	}
	
	@Override
	public String toString() {
		return numRep + " | "+ numCli + " | " + natureRep + " | " + refProd ;
	}
	
}
