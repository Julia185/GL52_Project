package fr.utbm.gl52.proj.model.stock;

import java.io.Serializable;


public class EntreeStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4525335752106527022L;
	private String idEntr;
	private String qteEnStock;
	private String refProduct;
	private String dateEntree;
	
	public EntreeStock() {
	}

	public EntreeStock(String idEntr, String qteEnStock, String refProduct, String dateEntree) {
		super();
		this.idEntr = idEntr;
		this.qteEnStock = qteEnStock;
		this.refProduct = refProduct;
		this.dateEntree = dateEntree;
	}

	public String getIdEntr() {
		return idEntr;
	}

	public void setIdEntr(String idEntr) {
		this.idEntr = idEntr;
	}

	public String getQteEnStock() {
		return qteEnStock;
	}

	public void setQteEnStock(String qteStock) {
		this.qteEnStock = qteStock;
	}

	public String getRefProduct() {
		return refProduct;
	}

	public void setRefProduct(String refProduct) {
		this.refProduct = refProduct;
	}

	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}
}
