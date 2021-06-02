package fr.utbm.gl52.proj.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="T_PRODUIT")
public class Produit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6261539949986980820L;
	
	@Id
	@Column
	public int refProd;
	@Column
	public String desProd;
	@Column
	public int qteProd;
	@Column
	public float prixHTProd;
	@Column
	public float PrixTTCProd;
	@Column
	public float TVAProd;

	public Produit() {
		this.refProd = 1;
		this.desProd = "Machine à laver";
		this.qteProd = 50;
		this.prixHTProd = 300;
		this.PrixTTCProd = 300;
		this.TVAProd = 0;
	}

	public Produit(int refProd, String desProd, int qteProd, float prixHTProd, float prixTTCProd, float tVAProd) {
		super();
		this.refProd = refProd;
		this.desProd = desProd;
		this.qteProd = qteProd;
		this.prixHTProd = prixHTProd;
		PrixTTCProd = prixTTCProd;
		TVAProd = tVAProd;
	}

	public int getRefProd() {
		return refProd;
	}

	public void setRefProd(int refProd) {
		this.refProd = refProd;
	}

	public String getDesProd() {
		return desProd;
	}

	public void setDesProd(String desProd) {
		this.desProd = desProd;
	}

	public int getQteProd() {
		return qteProd;
	}

	public void setQteProd(int qteProd) {
		this.qteProd = qteProd;
	}

	public float getPrixHTProd() {
		return prixHTProd;
	}

	public void setPrixHTProd(float prixHTProd) {
		this.prixHTProd = prixHTProd;
	}

	public float getPrixTTCProd() {
		return PrixTTCProd;
	}

	public void setPrixTTCProd(float prixTTCProd) {
		PrixTTCProd = prixTTCProd;
	}

	public float getTVAProd() {
		return TVAProd;
	}

	public void setTVAProd(float tVAProd) {
		TVAProd = tVAProd;
	}
}
