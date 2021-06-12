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
	}

	public String getNextValid() {
		String rqt = "SELECT * FROM T_REPARATION c WHERE c.numRep=(SELECT max(c.numRep) FROM T_REPARATION c )";

		List<Reparation> reparationList = new ArrayList<Reparation>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				reparationList.add(new Reparation(rs.getString("numRep"), rs.getString("etatRep")));
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
		
		Integer temp = Integer.parseInt(reparationList.get(0).getNumRep())+1;
		
		return temp.toString();
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

	public void insertReparation(Reparation reparation) {
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

	public Reparation getById(String numRep) {
		String rqt = "SELECT * FROM T_REPARATION c WHERE c.numRep=?";

		Reparation reparation = new Reparation();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, numRep);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				reparation = new Reparation(rs.getString("numRep"), rs.getString("etatRep"));
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
		return reparation;
	}

	public void updateReparation(Reparation reparation) {
		String rqt = "UPDATE  T_REPARATION SET numRep=?,etatRep=? where  numRep=?";
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

	public void deleteReparation(String numRep) {
		String rqt = "DELETE FROM T_REPARATION where numRep = ?";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, numRep);
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
