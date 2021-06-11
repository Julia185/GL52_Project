package fr.utbm.gl52.proj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fr.utbm.gl52.proj.model.Produit;

public class ProduitService extends IConnectDbService {

	public ProduitService() {
	}

	public List<Produit> getAllProduit() {
		String rqt = "Select * from T_PRODUIT";

		List<Produit> produitList = new ArrayList<Produit>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				produitList.add(new Produit(rs.getString("refProd"), rs.getString("desProd"), rs.getString("qteProd"),
						rs.getString("prixHtProd"), rs.getString("prixTTCProd"), rs.getString("tVAProd")));
			}
			produitList.sort(new Comparator<Produit>() {
				@Override
				public int compare(Produit c1, Produit c2) {
					return c1.getRefProd().compareToIgnoreCase(c2.getRefProd());
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

		return produitList;
	}
	
	public void updateProduit(Produit produit) {
		String rqt = "UPDATE T_PRODUIT SET refprod=?,desprod=?,qteprod=?,prixhtprod=?,prixttcprod=?,tvaprod=? where  refprod= ?";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, produit.getRefProd());
			stmt.setString(2, produit.getDesProd());
			stmt.setString(3, produit.getQteProd());
			stmt.setString(4, produit.getPrixHTProd());
			stmt.setString(5, produit.getPrixTTCProd());
			stmt.setString(6, produit.getTVAProd());
			stmt.setString(7, produit.getRefProd());
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
	
	public void deleteProduit(String refProd) {
		String rqt = "DELETE FROM T_PRODUIT where refprod = ?";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, refProd);
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

	public List<Produit> searchByProductNameOrRef(String searchName) {
		String rqt = "Select * from T_PRODUIT where upper(refprod) like ? UNION select * from T_PRODUIT where upper(desprod) like ?";

		List<Produit> produitList = new ArrayList<Produit>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, "%" + searchName.toUpperCase() + "%");
			stmt.setString(2, "%" + searchName.toUpperCase() + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				produitList.add(new Produit(rs.getString("refProd"), rs.getString("desProd"), rs.getString("qteProd"),
						rs.getString("prixHtProd"), rs.getString("prixTTCProd"), rs.getString("tVAProd")));
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
		return produitList;
	}

}
