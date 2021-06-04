package fr.utbm.gl52.proj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.utbm.gl52.proj.model.Client;

public class ClientService extends IConnectDbService {

	public ClientService() {
	}

//	public String getNextValId() {
//		List<Client> nextId = new ArrayList<Client>();
//		return  nextId.get(0).getNumCli()+1;
//	}

	public List<Client> getAllClient() {
		String rqt = "Select * from T_CLIENT";

		List<Client> clientList = new ArrayList<Client>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				clientList.add(new Client(rs.getString("numCli"), rs.getString("nomCli"), rs.getString("prenomCli"),
						rs.getString("telCli"), rs.getString("mailCli"), rs.getString("rueCli"),
						rs.getString("villeCli"), rs.getString("cpCli"), rs.getString("paysCli")));
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

		return clientList;
	}

}
