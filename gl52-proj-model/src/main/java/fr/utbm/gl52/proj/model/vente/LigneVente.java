package fr.utbm.gl52.proj.model.vente;

public class LigneVente {
	public int qteLigne; 
	public int refProd;
	public int numVte;

	public LigneVente() {
		this.qteLigne = 10;
		this.refProd = 10;
		this.numVte = 1;
	}

	public LigneVente(int qteLigne, int refProd, int numVte) {
		super();
		this.qteLigne = qteLigne;
		this.refProd = refProd;
		this.numVte = numVte;
	}

	public int getQteLigne() {
		return qteLigne;
	}

	public void setQteLigne(int qteLigne) {
		this.qteLigne = qteLigne;
	}

	public int getRefProd() {
		return refProd;
	}

	public void setRefProd(int refProd) {
		this.refProd = refProd;
	}

	public int getNumVte() {
		return numVte;
	}

	public void setNumVte(int numVte) {
		this.numVte = numVte;
	}
}
