package fr.utbm.gl52.proj.model;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6261539949986980820L;
	
	private String refProd;
	private String desProd;
	private String qteProd;
	private String prixHTProd;
	private String PrixTTCProd;
	private String TVAProd;

	private StringProperty refProdProperty = new SimpleStringProperty(refProd);
	
	public Produit() {
		super();
	}

	public Produit(String referenceProd, String descriptionProduct, String quantity, String prixHTT, String prixTTC, String tVA) {
		super();
		this.refProd = referenceProd;
		this.desProd = descriptionProduct;
		this.qteProd = quantity;
		this.prixHTProd = prixHTT;
		PrixTTCProd = prixTTC;
		TVAProd = tVA;
	}

	public String getRefProd() {
		return refProd;
	}

	public void setRefProd(String refProd) {
		this.refProd = refProd;
	}
	
	public StringProperty refProdProperty() {
		return refProdProperty;
	}
	
	public final String getrefProdProperty() {
		   return refProdProperty.get();
		}

		public final void setProject(String refProd) {
		    refProdProperty.set(refProd);
		}

	public String getDesProd() {
		return desProd;
	}

	public void setDesProd(String desProd) {
		this.desProd = desProd;
	}
	
	public StringProperty desProdProperty() {
		return new SimpleStringProperty(desProd);
	}

	public String getQteProd() {
		return qteProd;
	}

	public void setQteProd(String qteProd) {
		this.qteProd = qteProd;
	}
	
	public StringProperty qteProdProperty() {
		return new SimpleStringProperty(qteProd);
	}

	public String getPrixHTProd() {
		return prixHTProd;
	}

	public void setPrixHTProd(String prixHTProd) {
		this.prixHTProd = prixHTProd;
	}
	
	public StringProperty prixHTProdProperty() {
		return new SimpleStringProperty(prixHTProd);
	}

	public String getPrixTTCProd() {
		return PrixTTCProd;
	}

	public void setPrixTTCProd(String prixTTCProd) {
		PrixTTCProd = prixTTCProd;
	}
	
	public StringProperty prixTTCProdProperty() {
		return new SimpleStringProperty(PrixTTCProd);
	}

	public String getTVAProd() {
		return TVAProd;
	}

	public void setTVAProd(String tVAProd) {
		TVAProd = tVAProd;
	}
	
	public StringProperty tvaProdProperty() {
		return new SimpleStringProperty(TVAProd);
	}

	@Override
	public String toString() {
		return  refProd + " | " + desProd + " Qtt : " + qteProd + " HT : "
				+ prixHTProd + "€ / TTC : " + PrixTTCProd + "€ | TVA" + TVAProd ;
	}
	
	
}
