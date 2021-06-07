package fr.utbm.gl52.proj.service.sav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fr.utbm.gl52.proj.model.sav.Reparation;
import fr.utbm.gl52.proj.service.IConnectDbService;


public class ReparationService extends IConnectDbService {

	public ReparationService() {
		// TODO Auto-generated constructor stub
	}


	public List<Reparation> getAllReparation() {
		String rqt = "Select * from T_REPARATION";

		List<Reparation> reparationList = new ArrayList<Reparation>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				reparationList.add(new Reparation(rs.getString("numRep"), rs.getString("etatRep")));
			}
			reparationList.sort(new Comparator<Reparation>() {
				@Override
				public int compare(Reparation r1, Reparation r2) {
					return r1.getNumRep().compareToIgnoreCase(r2.getEtatRep());
				}
			});
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
		
		return reparationList;
	}

	public void inserReparation(Reparation reparation) {
		String rqt = "INSERT INTO T_REPARATION (numrep,etatrep) VALUES (?,?) ";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, reparation.getNumRep());
			stmt.setString(2, reparation.getEtatRep());
			stmt.executeUpdate();
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

	}
	
}
