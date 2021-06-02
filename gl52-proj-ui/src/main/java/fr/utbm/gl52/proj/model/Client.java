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
	public String telCli;
	@Column
	public String mailCli;
	@Column
	public String rueCli;
	@Column
	public String villeCli;
	@Column
	public int cpCli;
	@Column
	public String paysCli;
	
	public Client(int numCli, String nomCli, String prenomCli, Sring telCli, String mailCli, String rueCli, String villeCli, int cpCli,
			String paysCli) {
		super();
		this.numCli = numCli;
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.telCli = telCli;
		this.mailCli = mailCli;
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
		this.telCli = "0645892356"
		this.mailCli = "baker.simon@gmail.com"
		this.rueCli = "2 rue Michelet";
		this.villeCli = "Belfort";
		this.cpCli = 90000;
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

	public int getTelCli() {
		return telCli;
	}

	public void setTelCli(int telCli) {
		this.telCli = telCli;
	}

	public int getMailCli() {
		return mailCli;
	}

	public void setMailCli(int mailCli) {
		this.mailCli = mailCli;
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

	public int getCpCli() {
		return cpCli;
	}

	public void setCpCli(int cpCli) {
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
		return "Client [numCli=" + numCli + ", nomCli=" + nomCli + ", prenomCli=" + prenomCli + ", telCli=" + telCli + ", mailCli=" + mailCli + ", rueCli=" + rueCli
				+ ", villeCli=" + villeCli + ", cpCli=" + cpCli + ", paysCli=" + paysCli + "]";
	}
}