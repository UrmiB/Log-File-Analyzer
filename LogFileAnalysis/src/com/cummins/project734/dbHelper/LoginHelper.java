package com.cummins.project734.dbHelper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Connection;
import com.cummins.project734.dbhandler.DatabaseHandler;

public class LoginHelper extends DatabaseHandler{
	public int GetUserId(String Username, String Password){
		
		int Uid = 0;
		Connection con = (Connection) getConnection();
		Statement st = null;
		
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("Select UserAccount.UserAccountID from UserAccount WHERE UserAccount.UserName='"+Username+"' and UserAccount.Password='"+Password+"'");
			while (rs.next()){
			 Uid = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Uid;
	}
	
	public boolean authenticateUser(String username, String password){
		
		Connection con = (Connection) getConnection();
		Statement st = null;
		boolean success = false;
		String pwd = "";
		
		try {
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("Select password from useraccount where UserName='"+username+"'");
			while(rs.next()){
				pwd = rs.getString(1);
			}
			if(pwd.trim().equals(password)){
				success = true;
			}
			else{
				success = false;
			}
			con.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return success;	
	}

}
