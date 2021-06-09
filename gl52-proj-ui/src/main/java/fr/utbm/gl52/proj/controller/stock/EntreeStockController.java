package fr.utbm.gl52.proj.controller.stock;

import java.time.LocalDateTime;

import fr.utbm.gl52.proj.model.Produit;
import fr.utbm.gl52.proj.service.stock.EntreeStockService;

public class EntreeStockController {
	
	private EntreeStockService service = new EntreeStockService();

	public EntreeStockController() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNextValId() {
		return this.service.getNextValId();		
	}

	public void insertNewEntree(Produit produit) {
		this.service.insertNewEntree(this.getNextValId(),produit, LocalDateTime.now());
	}

}
