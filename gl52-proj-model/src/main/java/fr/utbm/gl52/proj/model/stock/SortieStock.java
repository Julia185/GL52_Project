package fr.utbm.gl52.proj.model.stock;

public class SortieStock {

	public int qteSortieStock;
	public int refProd;
	public String date;
	
	public SortieStock() {
		this.qteSortieStock = 50;
		this.refProd = 10;
		this.date = "27/05/2021";
	}

	public SortieStock(int qteSortieStock, int refProd, String date) {
		super();
		this.qteSortieStock = qteSortieStock;
		this.refProd = refProd;
		this.date = date;
	}

	public int getQteSortieStock() {
		return qteSortieStock;
	}

	public void setQteSortieStock(int qteSortieStock) {
		this.qteSortieStock = qteSortieStock;
	}

	public int getRefProd() {
		return refProd;
	}

	public void setRefProd(int refProd) {
		this.refProd = refProd;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
