package fr.utbm.gl52.proj.model;

import java.io.Serializable;


public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8871689719055509735L;

	private String numCli;
	private String nomCli;
	private String prenomCli;
	private String telCli;
	private String mailCli;
	private String rueCli;
	private String villeCli;
	private String cpCli;
	private String paysCli;

	
	public Client(String numCli, String nomCli, String prenomCli, String telCli, String mailCli, String rueCli, String villeCli, String cpCli,
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
	}
	

	public String getNumCli() {

		return numCli;
	}

	public void setNumCli(String numCli) {
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

	public String getTelCli() {
		return telCli;
	}

	public void setTelCli(String telCli) {
		this.telCli = telCli;
	}

	public String getMailCli() {
		return mailCli;
	}

	public void setMailCli(String mailCli) {
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
	
	private String getAdresse() {
		return rueCli +" " + cpCli + " " + villeCli + " "+paysCli; 
	}

	@Override
	public String toString() {
		return " "+ nomCli + " " + prenomCli.substring(0,1) + prenomCli.substring(1).toLowerCase() + " | " + this.getAdresse() + " | " + telCli + " | " + mailCli;
	}
}