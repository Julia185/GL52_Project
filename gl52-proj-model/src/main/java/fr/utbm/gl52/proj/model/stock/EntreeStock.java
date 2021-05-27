package fr.utbm.gl52.proj.model.stock;

public class EntreeStock {

	public int qteStock;
	public String refProduct;
	public String dateEntree;
	
	public EntreeStock() {
		this.qteStock = 100;
		this.refProduct = "P10";
		this.dateEntree = "27/05/2021";
	}

	public EntreeStock(int qteStock, String refProduct, String dateEntree) {
		super();
		this.qteStock = qteStock;
		this.refProduct = refProduct;
		this.dateEntree = dateEntree;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
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
