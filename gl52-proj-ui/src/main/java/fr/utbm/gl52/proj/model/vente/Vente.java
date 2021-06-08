package fr.utbm.gl52.proj.model.vente;

import java.io.Serializable;


public class Vente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3735328494644124667L;
	private String numVte;
	private String numCli;
	private String numEmp;
	private String date;
	private String montantVte;

	public Vente() {
	}
	
	public Vente(String numVte, String numCli, String numEmp, String date, String montantVte) {
		super();
		this.numVte = numVte;
		this.numCli = numCli;
		this.numEmp = numEmp;
		this.date = date;
		this.montantVte = montantVte;
	}

	public String getNumVte() {
		return numVte;
	}

	public void setNumVte(String numVte) {
		this.numVte = numVte;
	}

	public String getNumCli() {
		return numCli;
	}

	public void setNumCli(String numCli) {
		this.numCli = numCli;
	}

	public String getNumEmp() {
		return numEmp;
	}

	public void setNumEmp(String numEmp) {
		this.numEmp = numEmp;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMontantVte() {
		return montantVte;
	}

	public void setMontantVte(String montantVte) {
		this.montantVte = montantVte;
	}
}
