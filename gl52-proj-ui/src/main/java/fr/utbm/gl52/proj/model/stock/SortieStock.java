package fr.utbm.gl52.proj.model.stock;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="T_SORTIE_STOCK")
public class SortieStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8765726525873048224L;
	@Column
	public int qteSortieStock;
	@Column
	public int refProd;
	@Column
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
