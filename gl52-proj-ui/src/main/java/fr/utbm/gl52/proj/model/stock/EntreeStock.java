package fr.utbm.gl52.proj.model.stock;

import java.io.Serializable;


public class EntreeStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4525335752106527022L;
	private int idEntr;
	private int qteEnStock;
	private String refProduct;
	private String dateEntree;
	
	public EntreeStock() {
	}

	public EntreeStock(int idEntr, int qteEnStock, String refProduct, String dateEntree) {
		super();
		this.idEntr = idEntr;
		this.qteEnStock = qteEnStock;
		this.refProduct = refProduct;
		this.dateEntree = dateEntree;
	}

	public int getIdEntr() {
		return idEntr;
	}

	public void setIdEntr(int idEntr) {
		this.idEntr = idEntr;
	}

	public int getQteEnStock() {
		return qteEnStock;
	}

	public void setQteEnStock(int qteStock) {
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
