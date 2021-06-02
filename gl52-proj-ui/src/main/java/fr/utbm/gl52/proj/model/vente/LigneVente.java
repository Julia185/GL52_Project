package fr.utbm.gl52.proj.model.vente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="T_LIGNE_VENTE")
public class LigneVente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5624615416185646196L;
	@Column
	public int qteLigne;
	@ManyToOne
	@JoinColumn(name="refprod")
	public int refProd;
	@Column
	public int numVte;

	public LigneVente() {
		this.qteLigne = 10;
		this.refProd = 10;
		this.numVte = 1;
	}

	public LigneVente(int qteLigne, int refProd, int numVte) {
		super();
		this.qteLigne = qteLigne;
		this.refProd = refProd;
		this.numVte = numVte;
	}

	public int getQteLigne() {
		return qteLigne;
	}

	public void setQteLigne(int qteLigne) {
		this.qteLigne = qteLigne;
	}

	public int getRefProd() {
		return refProd;
	}

	public void setRefProd(int refProd) {
		this.refProd = refProd;
	}

	public int getNumVte() {
		return numVte;
	}

	public void setNumVte(int numVte) {
		this.numVte = numVte;
	}
}
