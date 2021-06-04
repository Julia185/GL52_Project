package fr.utbm.gl52.proj.model;

import java.io.Serializable;

public class Produit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6261539949986980820L;
	
	public String refProd;
	public String desProd;
	public String qteProd;
	public String prixHTProd;
	public String PrixTTCProd;
	public String TVAProd;

	public Produit() {
		super();
	}

	public Produit(String refProd, String desProd, String qteProd, String prixHTProd, String prixTTCProd, String tVAProd) {
		super();
		this.refProd = refProd;
		this.desProd = desProd;
		this.qteProd = qteProd;
		this.prixHTProd = prixHTProd;
		PrixTTCProd = prixTTCProd;
		TVAProd = tVAProd;
	}

	public String getRefProd() {
		return refProd;
	}

	public void setRefProd(String refProd) {
		this.refProd = refProd;
	}

	public String getDesProd() {
		return desProd;
	}

	public void setDesProd(String desProd) {
		this.desProd = desProd;
	}

	public String getQteProd() {
		return qteProd;
	}

	public void setQteProd(String qteProd) {
		this.qteProd = qteProd;
	}

	public String getPrixHTProd() {
		return prixHTProd;
	}

	public void setPrixHTProd(String prixHTProd) {
		this.prixHTProd = prixHTProd;
	}

	public String getPrixTTCProd() {
		return PrixTTCProd;
	}

	public void setPrixTTCProd(String prixTTCProd) {
		PrixTTCProd = prixTTCProd;
	}

	public String getTVAProd() {
		return TVAProd;
	}

	public void setTVAProd(String tVAProd) {
		TVAProd = tVAProd;
	}
}
