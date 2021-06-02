package fr.utbm.gl52.proj.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="T_CLIENT")
public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8871689719055509735L;
	@Id
	@Column
	public int numCli;
	@Column
	public String nomCli;
	@Column
	public String prenomCli;
	@Column
	public String rueCli;
	@Column
	public String villeCli;
	@Column
	public String cpCli;
	@Column
	public String paysCli;
	
	public Client(int numCli, String nomCli, String prenomCli, String rueCli, String villeCli, String cpCli,
			String paysCli) {
		super();
		this.numCli = numCli;
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.rueCli = rueCli;
		this.villeCli = villeCli;
		this.cpCli = cpCli;
		this.paysCli = paysCli;
	}

	public Client() {
		super();
		this.numCli = 1;
		this.nomCli = "Baker";
		this.prenomCli = "Simon";
		this.rueCli = "2 rue Michelet";
		this.villeCli = "Belfort";
		this.paysCli = "France";
	}
	
	public int getNumCli() {
		return numCli;
	}

	public void setNumCli(int numCli) {
		this.numCli = numCli;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getPrenomCli() {
		return prenomCli;
	}

	public void setPrenomCli(String prenomCli) {
		this.prenomCli = prenomCli;
	}

	public String getRueCli() {
		return rueCli;
	}

	public void setRueCli(String rueCli) {
		this.rueCli = rueCli;
	}

	public String getVilleCli() {
		return villeCli;
	}

	public void setVilleCli(String villeCli) {
		this.villeCli = villeCli;
	}

	public String getCpCli() {
		return cpCli;
	}

	public void setCpCli(String cpCli) {
		this.cpCli = cpCli;
	}

	public String getPaysCli() {
		return paysCli;
	}

	public void setPaysCli(String paysCli) {
		this.paysCli = paysCli;
	}

	@Override
	public String toString() {
		return "Client [numCli=" + numCli + ", nomCli=" + nomCli + ", prenomCli=" + prenomCli + ", rueCli=" + rueCli
				+ ", villeCli=" + villeCli + ", cpCli=" + cpCli + ", paysCli=" + paysCli + "]";
	}
}