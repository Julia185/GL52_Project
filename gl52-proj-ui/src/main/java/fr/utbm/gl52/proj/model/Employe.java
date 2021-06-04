package fr.utbm.gl52.proj.model;

import java.io.Serializable;


public class Employe implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 566068823307389766L;
	public int numEmp;
	private String nomEmp;
	private String prenomEmp;
	private String telEmp;
	private String mailEmp;
	private String rueEmp;
	private String villeEmp;
	private String cpEmp;
	private String paysEmp;

	public Employe() {
	}	

	public Employe(int numEmp, String nomEmp, String prenomEmp, String telEmp, String mailEmp, String rueEmp, String villeEmp, String cpEmp,
			String paysEmp) {
		super();
		this.numEmp = numEmp;
		this.nomEmp = nomEmp;
		this.prenomEmp = prenomEmp;
		this.telEmp = telEmp;
		this.mailEmp = mailEmp;
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

	public String getTelEmp() {
		return telEmp;
	}

	public void setTelEmp(String telEmp) {
		this.telEmp = telEmp;
	}

	public String getMailEmp() {
		return mailEmp;
	}

	public void setMailEmp(String mailEmp) {
		this.mailEmp = mailEmp;
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

	public String getCpEmp() {
		return cpEmp;
	}

	public void setCpEmp(String cpEmp) {
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
