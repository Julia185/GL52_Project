package fr.utbm.gl52.proj.model.vente;

public class Vente {
	public int numVte;
	public int numCli;
	public int numEmp;
	public String libVte;
	public String date;
	public int montantVte;

	public Vente() {
		this.numVte = 1;
		this.numCli = 1;
		this.numEmp = 1;
		this.libVte = "Vente machine à laver";
		this.date = "27/05/2021";
		this.montantVte = 300;
	}

	public Vente(int numVte, int numCli, int numEmp, String libVte, String date, int montantVte) {
		super();
		this.numVte = numVte;
		this.numCli = numCli;
		this.numEmp = numEmp;
		this.libVte = libVte;
		this.date = date;
		this.montantVte = montantVte;
	}

	public int getNumVte() {
		return numVte;
	}

	public void setNumVte(int numVte) {
		this.numVte = numVte;
	}

	public int getNumCli() {
		return numCli;
	}

	public void setNumCli(int numCli) {
		this.numCli = numCli;
	}

	public int getNumEmp() {
		return numEmp;
	}

	public void setNumEmp(int numEmp) {
		this.numEmp = numEmp;
	}

	public String getLibVte() {
		return libVte;
	}

	public void setLibVte(String libVte) {
		this.libVte = libVte;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMontantVte() {
		return montantVte;
	}

	public void setMontantVte(int montantVte) {
		this.montantVte = montantVte;
	}
}
