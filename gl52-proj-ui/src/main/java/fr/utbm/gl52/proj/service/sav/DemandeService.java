package fr.utbm.gl52.proj.service.sav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fr.utbm.gl52.proj.model.sav.Demande;
import fr.utbm.gl52.proj.service.IConnectDbService;



public class DemandeService  extends IConnectDbService {

	public DemandeService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Demande> getAllDemande() {
		String rqt = "Select * from DEMANDE";

		List<Demande> demandeList = new ArrayList<Demande>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				demandeList.add(new Demande(rs.getString("numRep"), rs.getString("numCli"), rs.getString("natureRep"),
						rs.getString("descRep"), rs.getString("refProd")));
			}
			demandeList.sort(new Comparator<Demande>() {
				@Override
				public int compare(Demande d1, Demande d2) {
					return d1.getNumRep().compareToIgnoreCase(d2.getNumRep());
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
		
		return demandeList;
	}

	public void inserClient(Demande demande) {
		String rqt = "INSERT INTO DEMANDE (numRep,numCli,natureRep,descRep,refProd) VALUES (?,?,?,?,?) ";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, demande.getNumRep());
			stmt.setString(2, demande.getNumCli());
			stmt.setString(3, demande.getNatureRep());
			stmt.setString(4, demande.getDescRep());
			stmt.setString(5, demande.getRefProd());
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
