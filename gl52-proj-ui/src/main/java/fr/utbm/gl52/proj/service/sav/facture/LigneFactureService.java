package fr.utbm.gl52.proj.service.sav.facture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.utbm.gl52.proj.model.sav.facture.LigneFacture;
import fr.utbm.gl52.proj.service.IConnectDbService;

public class LigneFactureService extends IConnectDbService {

	public LigneFactureService() {
		super();
	}

	public String getNextValId() {
		String rqt = "SELECT * FROM T_LIGNE_FACTURE c WHERE c.idLigneFct=(SELECT max(c.idLigneFct) FROM T_LIGNE_FACTURE c )";

		List<LigneFacture> factureList = new ArrayList<LigneFacture>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				factureList.add(new LigneFacture(rs.getString("idLigneFct"), rs.getString("numFct"),
						rs.getString("montantLignFct"), rs.getString("descLigneFct")));
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
			Integer temp = Integer.parseInt(factureList.get(0).getNumFct()) + 1;
			return temp.toString();
		}

	}

	public void insertNewLigneFacture(LigneFacture ligneFacture) {
		String rqt = "INSERT INTO T_LIGNE_FACTURE (idLigneFct,numFct,montantLignFct,descLigneFct) VALUES (?,?,?,?) ";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, ligneFacture.getIdLigneFct());
			stmt.setString(2, ligneFacture.getNumFct());
			stmt.setString(3, ligneFacture.getMttLigneFct());
			stmt.setString(4, ligneFacture.getDesLigneFct());
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

	public LigneFacture getById(String idLigneFct) {
		String rqt = "SELECT * FROM T_LIGNE_FACTURE c WHERE c.idLigneFct=?";

		LigneFacture lignefacture = new LigneFacture();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, idLigneFct);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lignefacture = new LigneFacture(rs.getString("idLigneFct"), rs.getString("numFct"),
						rs.getString("montantLignFct"), rs.getString("descLigneFct"));
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
		return lignefacture;
	}

	public void updateLigneFacture(LigneFacture ligneFacture) {
		String rqt = "UPDATE  T_LIGNE_FACTURE SET idLigneFct=?,numFct=?,montantLignFct=?,descLigneFct=? where idLigneFct=? ";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, ligneFacture.getIdLigneFct());
			stmt.setString(2, ligneFacture.getNumFct());
			stmt.setString(3, ligneFacture.getMttLigneFct());
			stmt.setString(4, ligneFacture.getDesLigneFct());
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

	public LigneFacture getByIdFct(String numFct) {
		String rqt = "SELECT * FROM T_LIGNE_FACTURE c WHERE c.numFct=?";

		LigneFacture lignefacture = new LigneFacture();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, numFct);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lignefacture = new LigneFacture(rs.getString("idLigneFct"), rs.getString("numFct"),
						rs.getString("montantLignFct"), rs.getString("descLigneFct"));
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
		return lignefacture;
	}

	public void deleteLigneFactureByFactureId(String numFct) {
		String rqt = "DELETE FROM T_LIGNE_FACTURE where numFct = ?";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, numFct);
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

	public void deleteLigneFactureById(String idLigneFct) {
		String rqt = "DELETE FROM T_LIGNE_FACTURE where idLigneFct = ?";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, idLigneFct);
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
