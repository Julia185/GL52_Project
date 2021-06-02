package fr.utbm.gl52.proj.model.sav;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="DEMANDE")
public class Demande implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4028920286978053266L;
	
	@ManyToOne
	@JoinColumn(name="numrep")
	public int numRep;
	@ManyToOne
	@JoinColumn(name="numcli")
	public int numCli;
	@Column
	public String natureRep;
	@Column
	public String descRep;
	@ManyToOne
	@JoinColumn(name="refprod")
	public int refProd;

	public Demande() {
		this.numRep = 1;
		this.numCli = 1;
		this.natureRep = "Produit cassé";
		this.descRep = "Remplacement du produit";
		this.refProd = 10;
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
