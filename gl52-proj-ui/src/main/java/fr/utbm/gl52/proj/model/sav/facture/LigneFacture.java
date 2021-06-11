package fr.utbm.gl52.proj.model.sav.facture;

public class LigneFacture {

	private String idLigneFct;
	private String numFct;
	private String MttLigneFct;
	private String dseLigneFct;
	
	
	public LigneFacture() {
		super();
	}

	public LigneFacture(String idLigneFct, String numFct, String mttLigneFct, String dseLigneFct) {
		super();
		this.idLigneFct = idLigneFct;
		this.numFct = numFct;
		MttLigneFct = mttLigneFct;
		this.dseLigneFct = dseLigneFct;
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
		return MttLigneFct;
	}

	public void setMttLigneFct(String mttLigneFct) {
		MttLigneFct = mttLigneFct;
	}

	public String getDseLigneFct() {
		return dseLigneFct;
	}

	public void setDseLigneFct(String dseLigneFct) {
		this.dseLigneFct = dseLigneFct;
	}

	@Override
	public String toString() {
		return dseLigneFct + "	" +MttLigneFct ;
	}
		
	
}
