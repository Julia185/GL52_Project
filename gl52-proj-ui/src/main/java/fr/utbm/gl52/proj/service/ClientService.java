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

	public String getNextValId() {
		String rqt = "SELECT * FROM T_CLIENT c WHERE c.numCli=(SELECT max(c.numCli) FROM T_CLIENT c )";

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
		
		Integer temp = Integer.parseInt(clientList.get(0).getNumCli())+1;
		
		return temp.toString();
	}

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

	public void updateClient(Client client) {
		String rqt = "UPDATE T_CLIENT SET numcli=?,nomcli=?,prenomcli=?,telcli=?,mailcli=?,ruecli=?,villecli=?,cpcli=?,payscli=?  where  numcli = ?";
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
			stmt.setString(10, client.getNumCli());
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

	public void deleteClient(String numCli) {
		String rqt = "DELETE FROM T_CLIENT where numcli = ?";
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, numCli);
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

	public List<Client> searchByclientName(String searchName) {
		String rqt = "Select * from T_CLIENT where upper(nomcli) like ? UNION select * from T_CLIENT where upper(prenomcli) like ?";

		List<Client> clientList = new ArrayList<Client>();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(1, "%" + searchName.toUpperCase() + "%"); 
			stmt.setString(2, "%" + searchName.toUpperCase() + "%");
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

	public Client getById(String numCli) {
		String rqt = "SELECT * FROM T_CLIENT c WHERE c.numCli=?";

		Client client = new Client();
		PreparedStatement stmt;
		Connection con = this.connect();
		try {
			stmt = con.prepareStatement(rqt);
			stmt.setString(0, numCli);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				client = new Client(rs.getString("numCli"), rs.getString("nomCli"), rs.getString("prenomCli"),
						rs.getString("telCli"), rs.getString("mailCli"), rs.getString("rueCli"),
						rs.getString("villeCli"), rs.getString("cpCli"), rs.getString("paysCli"));
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
		return client;
	}
	

}
