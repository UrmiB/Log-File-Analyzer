package com.cummins.project734.dbHelper;

import java.sql.SQLException;
import java.sql.Statement;

import com.cummins.project734.dbhandler.DatabaseHandler;
import com.mysql.jdbc.Connection;

public class AccountDeleteHelper extends DatabaseHandler{
	
	public void deleteAccount(int userid){
		Connection con =  (Connection) getConnection();
		Statement st = null;
		
		try {
			st = con.createStatement();
			st.executeUpdate("Delete from UserInfo Where UserId="+userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
