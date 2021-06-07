package fr.utbm.gl52.proj.controller;

import java.util.List;

import fr.utbm.gl52.proj.model.Produit;
import fr.utbm.gl52.proj.service.ProduitService;

public class ProduitController {
	
	private ProduitService service = new ProduitService();

	public ProduitController() {
	}
	
	public List<Produit> getAllProduit() {
		return this.service.getAllProduit();
	}

	public void insertNewProduct(Produit produit) {
	}
	
    public void modifyProduct(Produit produit) {
    	this.service.updateproduit(produit);
    }
    
    public void modifyProducList(List<Produit> producList) {
    	for (Produit produit : producList) {
			this.service.updateproduit(produit);
		}
    }

	public void eraseProduct(String referenceProd) {
	}


}
