package fr.utbm.gl52.proj.service.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.utbm.gl52.proj.model.Produit;
import fr.utbm.gl52.proj.model.stock.EntreeStock;
import fr.utbm.gl52.proj.service.IConnectDbService;

public class EntreeStockService extends IConnectDbService{

	public EntreeStockService() {
		// TODO Auto-generated constructor stub
	}

	public String getNextValId() {
		String rqt = "SELECT * FROM T_ENTREE_STOCK c WHERE c.numCli=(SELECT max(c.numCli) FROM T_ENTREE_STOCK c )";

		List<EntreeStock> entreStockList = new ArrayList<EntreeStock>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				entreStockList.add(new EntreeStock(rs.getString("identr"), rs.getString("refprod"), rs.getString("qteentstk"),
						rs.getString("datentr")));
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
		
		Integer temp = Integer.parseInt(entreStockList.get(0).getIdEntr())+1;
		
		return temp.toString();
	}

	public void insertNewEntree(String nextValId, Produit produit, LocalDateTime now) {
		String rqt = "INSERT INTO T_ENTREE_STOCK (identr,refprod,qteentstk,dateentr) VALUES (?,?,?,?) ";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, nextValId);
			stmt.setString(2, produit.getRefProd());
			stmt.setString(3, produit.getQteProd());
			stmt.setString(4, now.toString());
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
