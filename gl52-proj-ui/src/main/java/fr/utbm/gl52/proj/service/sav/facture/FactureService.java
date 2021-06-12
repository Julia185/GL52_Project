package fr.utbm.gl52.proj.service.sav.facture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.utbm.gl52.proj.model.sav.facture.Facture;
import fr.utbm.gl52.proj.service.IConnectDbService;

public class FactureService extends IConnectDbService {
	
	public FactureService() {
	}

	public String getNextValId() {
		String rqt = "SELECT * FROM T_FACTURE c WHERE c.numFct=(SELECT max(c.numFct) FROM T_FACTURE c )";

		List<Facture> factureList = new ArrayList<Facture>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				factureList.add(new Facture(rs.getString("numFct"), rs.getString("dateFct"),rs.getString("numEmp")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		if (factureList.size() == 0) {
			return "1";
		} else {
			Integer temp = Integer.parseInt(factureList.get(0).getNumFct())+1;
			return temp.toString();
		}
		
	}

	public Facture getById(String numFct) {
		String rqt = "SELECT * FROM T_FACTURE c WHERE c.numFct=?";

		Facture facture = new Facture();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, numFct);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				facture = new Facture(rs.getString("numFct"), rs.getString("dateFct"), rs.getString("numEmp"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return facture;
	}

}
