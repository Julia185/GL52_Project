package fr.utbm.gl52.proj.model.sav.facture;

public class LigneFacture {

	private String idLigneFct;
	private String numFct;
	private String mttLigneFct;
	private String desLigneFct;
	
	
	public LigneFacture() {
		super();
	}

	public LigneFacture(String idLigneFct, String numFct, String mttLigneFct, String desLigneFct) {
		super();
		this.idLigneFct = idLigneFct;
		this.numFct = numFct;
		this.mttLigneFct = mttLigneFct;
		this.desLigneFct = desLigneFct;
	}

	public String getIdLigneFct() {
		return idLigneFct;
	}

	public void setIdLigneFct(String idLigneFct) {
		this.idLigneFct = idLigneFct;
	}

	public String getNumFct() {
		return numFct;
	}

	public void setNumFct(String numFct) {
		this.numFct = numFct;
	}

	public String getMttLigneFct() {
		return mttLigneFct;
	}

	public void setMttLigneFct(String mttLigneFct) {
		this.mttLigneFct = mttLigneFct;
	}

	public String getDesLigneFct() {
		return desLigneFct;
	}

	public void setDseLigneFct(String desLigneFct) {
		this.desLigneFct = desLigneFct;
	}

	@Override
	public String toString() {
		return desLigneFct + "	" +mttLigneFct + " €";
	}
		
	
}
