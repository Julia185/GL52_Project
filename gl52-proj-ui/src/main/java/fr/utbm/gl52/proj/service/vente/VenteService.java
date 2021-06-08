package fr.utbm.gl52.proj.service.vente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.utbm.gl52.proj.model.vente.Vente;
import fr.utbm.gl52.proj.service.IConnectDbService;

public class VenteService extends IConnectDbService{

	public VenteService() {
	}
	
	public String getNextValId() {
		String rqt = "SELECT * FROM T_VENTE c WHERE c.numvte=(SELECT max(c.numvte) FROM T_VENTE c )";

		List<Vente> venteList = new ArrayList<Vente>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				venteList.add(new Vente(rs.getString("numvte"),rs.getString("numcli"),rs.getString("numemp"),
						rs.getString("datevte"),rs.getString("montantvte")));
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
		
		Integer temp = Integer.parseInt(venteList.get(0).getNumVte())+1;
		
		return temp.toString();
	}
	
	public boolean insertNewVente(Vente vente) {
		String rqt = "INSERT INTO T_VENTE (numvte,numcli,numemp,datevte,montantvte) VALUES (?,?,?,?,?) ";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, vente.getNumVte());
			stmt.setString(2, vente.getNumCli());
			stmt.setString(3, vente.getNumEmp());
			stmt.setString(4, vente.getDate());
			stmt.setString(5, vente.getMontantVte());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;

	}
}
