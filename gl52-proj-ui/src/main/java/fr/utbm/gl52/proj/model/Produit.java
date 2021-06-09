package fr.utbm.gl52.proj.model;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

public class Produit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6261539949986980820L;
	
	private String refProd;
	private String desProd;
	private String qteProd;
	private String prixHTProd;
	private String prixTTCProd;
	private String tVAProd;

	@FXML
	private SimpleStringProperty refProdProperty;
	@FXML
	private SimpleStringProperty desProdProperty;
	@FXML
	private SimpleStringProperty qteProdProperty;
	@FXML
	private SimpleStringProperty prixHTProdProperty;
	@FXML
	private SimpleStringProperty prixTTCProdProperty;
	@FXML
	private SimpleStringProperty tVAProdProperty;
	
	public Produit() {
		super();
	}

	public Produit(String referenceProd, String descriptionProduct, String quantity, String prixHTT, String prixTTC, String tVA) {
		super();
		this.refProd = referenceProd;
		this.desProd = descriptionProduct;
		this.qteProd = quantity;
		this.prixHTProd = prixHTT;
		this.prixTTCProd = prixTTC;
		this.tVAProd = tVA;
		
		this.refProdProperty = new SimpleStringProperty(refProd);
		this.desProdProperty = new SimpleStringProperty(desProd);
		this.qteProdProperty = new SimpleStringProperty(qteProd);
		this.prixHTProdProperty = new SimpleStringProperty(prixHTProd);
		this.prixTTCProdProperty = new SimpleStringProperty(prixTTCProd);
		this.tVAProdProperty = new SimpleStringProperty(tVAProd);
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
		return prixTTCProd;
	}

	public void setPrixTTCProd(String prixTTCProd) {
		this.prixTTCProd = prixTTCProd;
	}
	
	public String getTVAProd() {
		return tVAProd;
	}

	public void setTVAProd(String tVAProd) {
		this.tVAProd = tVAProd;
	}
	
	
	public final String getRefProdProperty() {
		   return refProdProperty.get();
	}
	public final String getDesProdProperty() {
		return desProdProperty.get();
	}
	public final String getQteProdProperty() {
		return qteProdProperty.get();
	}
	public final String getPrixHTProdProperty() {
		return prixHTProdProperty.get();
	}
	public final String getPrixTTCProdProperty() {
		return prixTTCProdProperty.get();
	}
	public final String getTVAProdProperty() {
		return tVAProdProperty.get();
	}

	@Override
	public String toString() {
		return  refProd + " | " + desProd + " Qtt : " + qteProd + " HT : "
				+ prixHTProd + "€ / TTC : " + prixTTCProd + "€ | TVA" + tVAProd ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prixTTCProd == null) ? 0 : prixTTCProd.hashCode());
		result = prime * result + ((tVAProd == null) ? 0 : tVAProd.hashCode());
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
		if (prixTTCProd == null) {
			if (other.prixTTCProd != null)
				return false;
		} else if (!prixTTCProd.equals(other.prixTTCProd))
			return false;
		if (tVAProd == null) {
			if (other.tVAProd != null)
				return false;
		} else if (!tVAProd.equals(other.tVAProd))
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
