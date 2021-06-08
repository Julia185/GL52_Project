package fr.utbm.gl52.proj.model.vente;

import java.io.Serializable;


public class LigneVente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5624615416185646196L;
	private String id;
	private String qteLigne;
	private String refProd;
	private String numVte;

	public LigneVente() {
	}

	public LigneVente(String id,String qteLigne, String refProd, String numVte) {
		super();
		this.id = id;
		this.qteLigne = qteLigne;
		this.refProd = refProd;
		this.numVte = numVte;
	}

	public String getQteLigne() {
		return qteLigne;
	}

	public void setQteLigne(String qteLigne) {
		this.qteLigne = qteLigne;
	}

	public String getRefProd() {
		return refProd;
	}

	public void setRefProd(String refProd) {
		this.refProd = refProd;
	}

	public String getNumVte() {
		return numVte;
	}

	public void setNumVte(String numVte) {
		this.numVte = numVte;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
