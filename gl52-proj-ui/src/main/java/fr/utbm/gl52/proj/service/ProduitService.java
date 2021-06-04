package fr.utbm.gl52.proj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
