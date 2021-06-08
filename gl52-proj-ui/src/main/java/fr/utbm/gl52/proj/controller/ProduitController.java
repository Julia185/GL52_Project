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

	public void insertNewProduit(Produit produit) {
	}
	
    public void modifyProduit(Produit produit) {
    	this.service.updateProduit(produit);
    }
    
    public void modifyProduitList(List<Produit> producList) {
    	for (Produit produit : producList) {
			this.service.updateProduit(produit);
		}
    }

	public void deleteProduit(String referenceProd) {
		this.service.deleteProduit(referenceProd);
	}

	public List<Produit> searchByProductNameOrRef(String searchName) {
		return this.service.searchByProductNameOrRef(searchName);
	}


}
