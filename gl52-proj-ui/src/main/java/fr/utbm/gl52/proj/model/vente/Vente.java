package fr.utbm.gl52.proj.model.vente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="T_VENTE")
public class Vente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3735328494644124667L;
	@Id
	@Column
	public int numVte;
	@ManyToOne
	@JoinColumn(name="numcli")
	public int numCli;
	@ManyToOne
	@JoinColumn(name="numemp")
	public int numEmp;
	@Column
	public String libVte;
	@Column
	public String date;
	@Column
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
