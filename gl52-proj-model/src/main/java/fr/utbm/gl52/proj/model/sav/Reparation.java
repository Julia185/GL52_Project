package fr.utbm.gl52.proj.model.sav;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="T_REPARATION")
public class Reparation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2951661481225212439L;
	@Id
	@Column
	public int numRep;
	@Column
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
