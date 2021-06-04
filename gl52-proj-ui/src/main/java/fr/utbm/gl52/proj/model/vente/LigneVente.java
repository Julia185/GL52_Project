package fr.utbm.gl52.proj.model.vente;

import java.io.Serializable;


public class LigneVente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5624615416185646196L;
	public int qteLigne;
	public int refProd;
	public int numVte;

	public LigneVente() {
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
