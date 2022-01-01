package DAO;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectSQLDAO {
	private Connection con;	 
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Connection getConection(){
		try {
			String url = "jdbc:sqlserver://WINDOWS-9V3RQKK\\SQLEXPRESS:1433;databaseName=LIBRARY;user=sa;password=123456";
			this.con = DriverManager.getConnection(url);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return this.con;
	}
	
	public ConnectSQLDAO (){
		getConection();
	}
		
}

