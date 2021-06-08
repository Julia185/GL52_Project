package fr.utbm.gl52.proj.service.vente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fr.utbm.gl52.proj.model.vente.LigneVente;
import fr.utbm.gl52.proj.service.IConnectDbService;

public class LigneVenteService extends IConnectDbService {

	public LigneVenteService() {
	}

	public String getNextValId() {
		String rqt = "SELECT * FROM T_LIGNE_VENTE c WHERE c.idlignevente=(SELECT max(c.idlignevente) FROM T_LIGNE_VENTE c )";

		List<LigneVente> ligneVenteList = new ArrayList<LigneVente>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ligneVenteList.add(new LigneVente(rs.getString("idlignevente"), rs.getString("refprod"),
						rs.getString("numvte"), rs.getString("qtelign")));
			}
			ligneVenteList.sort(new Comparator<LigneVente>() {
				@Override
				public int compare(LigneVente c1, LigneVente c2) {
					return c1.getId().compareToIgnoreCase(c2.getId());
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

		Integer temp = Integer.parseInt(ligneVenteList.get(0).getId()) + 1;

		return temp.toString();
	}

	public void insertNewLigneVente(LigneVente ligneVente) {
		String rqt = "INSERT INTO T_LIGNE_VENTE (idlignevente,refprod,numvte,qtelign) VALUES (?,?,?,?) ";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, ligneVente.getId());
			stmt.setString(2, ligneVente.getRefProd());
			stmt.setString(3, ligneVente.getNumVte());
			stmt.setString(4, ligneVente.getQteLigne());
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
