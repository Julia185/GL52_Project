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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PrixTTCProd == null) ? 0 : PrixTTCProd.hashCode());
		result = prime * result + ((TVAProd == null) ? 0 : TVAProd.hashCode());
		result = prime * result + ((desProd == null) ? 0 : desProd.hashCode());
		result = prime * result + ((prixHTProd == null) ? 0 : prixHTProd.hashCode());
		result = prime * result + ((refProd == null) ? 0 : refProd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (PrixTTCProd == null) {
			if (other.PrixTTCProd != null)
				return false;
		} else if (!PrixTTCProd.equals(other.PrixTTCProd))
			return false;
		if (TVAProd == null) {
			if (other.TVAProd != null)
				return false;
		} else if (!TVAProd.equals(other.TVAProd))
			return false;
		if (desProd == null) {
			if (other.desProd != null)
				return false;
		} else if (!desProd.equals(other.desProd))
			return false;
		if (prixHTProd == null) {
			if (other.prixHTProd != null)
				return false;
		} else if (!prixHTProd.equals(other.prixHTProd))
			return false;
		if (refProd == null) {
			if (other.refProd != null)
				return false;
		} else if (!refProd.equals(other.refProd))
			return false;
		return true;
	}
	
	
	
	
}
