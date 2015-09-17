package com.cummins.project734.dbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cummins.project734.dbhandler.DatabaseHandler;
import com.mysql.jdbc.Connection;

public class ChangePasswordHelper extends DatabaseHandler{
	
	public void changePassword(int userid, String newPassword) throws SQLException{
		Connection con =  (Connection) getConnection();
		Statement st = null;
		
		st = con.createStatement();
		/*int succ =*/ st.executeUpdate("Update UserAccount SET Password='"+newPassword+"' Where UserAccountID="+userid);

		/*if(succ == 1){
			System.out.println("Updated.");
		}else{
			System.out.println("Not Updated.");
		}*/
	}
	
	public boolean checkOldP(int userid, String oldPassword){
		
		Connection con = (Connection) getConnection();
		Statement st = null;
		String password = null;
		boolean succ = false;
		
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("Select Password from UserAccount Where UserAccountID="+userid);
			while(rs.next()){
				password = rs.getString("Password");
			}
			
			if(password.equals(oldPassword)){
				succ = true;
			}else{
				succ = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return succ;
		
	}

}
