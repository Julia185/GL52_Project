package fr.utbm.gl52.proj.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class IConnectDbService {
	
	 @SuppressWarnings("unused")
	protected Connection connect() {
	    	Connection con = null;
	    	try {
	    		Class.forName("org.sqlite.JDBC");
	    		String url = "jdbc:sqlite:src/main/resources/GL52.db";
				con = DriverManager.getConnection(url);
				System.out.println("Connection to SQLite has been stablished");
				return con;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return con;
	    }

}
