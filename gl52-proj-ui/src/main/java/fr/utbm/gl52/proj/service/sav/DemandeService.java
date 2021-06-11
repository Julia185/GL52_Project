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
		String rqt = "Select * from T_DEMANDE";

		List<Demande> demandeList = new ArrayList<Demande>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				demandeList.add(new Demande(rs.getString("numRep"), rs.getString("numCli"), rs.getString("natureRep"),
						rs.getString("desRep"), rs.getString("refProd"),rs.getString("numFct")));
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
		System.out.println(demandeList.size());
		return demandeList;
	}

	public void insertDemande(Demande demande) {
		String rqt = "INSERT INTO T_DEMANDE (numRep,numCli,natureRep,desRep,refProd,numFct) VALUES (?,?,?,?,?,?) ";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, demande.getNumRep());
			stmt.setString(2, demande.getNumCli());
			stmt.setString(3, demande.getNatureRep());
			stmt.setString(4, demande.getDescRep());
			stmt.setString(5, demande.getRefProd());
			stmt.setString(6, demande.getNumFct());
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

	public void updateDemande(Demande demande) {
		String rqt = "INSERT INTO T_DEMANDE (numcli,numRep,natureRep,desRep,refProd) VALUES (?,?,?,?,?) ";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, demande.getNumCli());
			stmt.setString(2, demande.getNumRep());
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

	public void deleteDemande(Demande demande) {
		// TODO Auto-generated method stub
		
	}

	

}
