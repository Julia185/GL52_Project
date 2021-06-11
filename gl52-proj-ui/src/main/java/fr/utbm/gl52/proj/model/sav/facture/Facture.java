package fr.utbm.gl52.proj.model.sav.facture;

public class Facture {
	
	private String numFct;
	private String dateFct;
	private String numEmp;
	
	public Facture() {
		super();
	}
	public Facture(String numFct, String dateFct, String numEmp) {
		super();
		this.numFct = numFct;
		this.dateFct = dateFct;
		this.numEmp = numEmp;
	}
	public String getNumFct() {
		return numFct;
	}
	public void setNumFct(String numFct) {
		this.numFct = numFct;
	}
	public String getDateFct() {
		return dateFct;
	}
	public void setDateFct(String dateFct) {
		this.dateFct = dateFct;
	}
	public String getNumEmp() {
		return numEmp;
	}
	public void setNumEmp(String numEmp) {
		this.numEmp = numEmp;
	}
	@Override
	public String toString() {
		return "Facture [numFct=" + numFct + ", dateFct=" + dateFct + ", numEmp=" + numEmp + "]";
	}
	
	
}
