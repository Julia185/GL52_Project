package fr.utbm.gl52.proj.model;

public class Employe {
	
	public int numEmp;
	public String nomEmp;
	public String prenomEmp;
	public String rueEmp;
	public String villeEmp;
	public int cpEmp;
	public String paysEmp;

	public Employe() {
		this.numEmp = 1;
		this.nomEmp = "Jane";
		this.prenomEmp = "Patrick";
		this.rueEmp = "14 rue de l'Eau Vive";
		this.villeEmp = "Torcy";
		this.cpEmp = 25300;
		this.paysEmp = "France";
	}	

	public Employe(int numEmp, String nomEmp, String prenomEmp, String rueEmp, String villeEmp, int cpEmp,
			String paysEmp) {
		super();
		this.numEmp = numEmp;
		this.nomEmp = nomEmp;
		this.prenomEmp = prenomEmp;
		this.rueEmp = rueEmp;
		this.villeEmp = villeEmp;
		this.cpEmp = cpEmp;
		this.paysEmp = paysEmp;
	}

	public int getNumEmp() {
		return numEmp;
	}

	public void setNumEmp(int numEmp) {
		this.numEmp = numEmp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public String getPrenomEmp() {
		return prenomEmp;
	}

	public void setPrenomEmp(String prenomEmp) {
		this.prenomEmp = prenomEmp;
	}

	public String getRueEmp() {
		return rueEmp;
	}

	public void setRueEmp(String rueEmp) {
		this.rueEmp = rueEmp;
	}

	public String getVilleEmp() {
		return villeEmp;
	}

	public void setVilleEmp(String villeEmp) {
		this.villeEmp = villeEmp;
	}

	public int getCpEmp() {
		return cpEmp;
	}

	public void setCpEmp(int cpEmp) {
		this.cpEmp = cpEmp;
	}

	public String getPaysEmp() {
		return paysEmp;
	}

	public void setPaysEmp(String paysEmp) {
		this.paysEmp = paysEmp;
	}

	@Override
	public String toString() {
		return "Employe [numEmp=" + numEmp + ", nomEmp=" + nomEmp + ", prenomEmp=" + prenomEmp + ", rueEmp=" + rueEmp
				+ ", villeEmp=" + villeEmp + ", cpEmp=" + cpEmp + ", paysEmp=" + paysEmp + "]";
	}
}
