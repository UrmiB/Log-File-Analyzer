package com.cummins.project734.dbhandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {

	public Connection getConnection(){
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "user";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root" ;
		String password = "moodle" ;
		try{
			
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected to database.");

		} catch(Exception e){
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static void releaseConnection(Connection con) throws SQLException{
		con.close();
	}
}
