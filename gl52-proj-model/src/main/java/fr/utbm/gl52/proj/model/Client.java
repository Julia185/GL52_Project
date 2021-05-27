package fr.utbm.gl52.proj.model;

public class Client {
	public int numCli;
	public String nomCli;
	public String prenomCli;
	public String rueCli;
	public String villeCli;
	public int cpCli;
	public String paysCli;
	
	public Client(int numCli, String nomCli, String prenomCli, String rueCli, String villeCli, int cpCli,
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
		return "Client [numCli=" + numCli + ", nomCli=" + nomCli + ", prenomCli=" + prenomCli + ", rueCli=" + rueCli
				+ ", villeCli=" + villeCli + ", cpCli=" + cpCli + ", paysCli=" + paysCli + "]";
	}
}