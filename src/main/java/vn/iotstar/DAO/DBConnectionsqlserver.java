package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionsqlserver {
	private final String serverName = "MSI\\SQLEXPRESS";
	private final String dbName = "QLBOOK";
	private final String portNumber = "1433";
	private final String instance = "";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	//private final String userID = "";
	//private final String password = "";
	
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
		+ "\\" + instance + ";integratedSecurity=true;databaseName=" + 
		dbName;
		if (instance == null || instance.trim().isEmpty())
		url = "jdbc:sqlserver://" + serverName + ":" + portNumber + 
		";integratedSecurity=true;databaseName=" + dbName;
		//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url);
		}
	
	public static void main(String[] args) {
		try {
		System.out.println(new DBConnectionsqlserver().getConnection());
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
}
