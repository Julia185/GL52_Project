package fr.utbm.gl52.proj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
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
			clientList.sort(new Comparator<Client>() {
				@Override
				public int compare(Client c1, Client c2) {
					return c1.getNomCli().compareToIgnoreCase(c2.getNomCli());
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
		
		return clientList;
	}

	public void inserClient(Client client) {
		String rqt = "INSERT INTO T_CLIENT (numcli,nomcli,prenomcli,telcli,mailcli,ruecli,villecli,cpcli,payscli) VALUES (?,?,?,?,?,?,?,?,?) ";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, client.getNumCli());
			stmt.setString(2, client.getNomCli());
			stmt.setString(3, client.getPrenomCli());
			stmt.setString(4, client.getTelCli());
			stmt.setString(5, client.getMailCli());
			stmt.setString(6, client.getRueCli());
			stmt.setString(7, client.getVilleCli());
			stmt.setString(8, client.getCpCli());
			stmt.setString(9, client.getPaysCli());
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
