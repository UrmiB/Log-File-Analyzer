package com.cummins.project734.dbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cummins.project734.dbhandler.DatabaseHandler;
import com.cummins.project734.entity.UserAccount;
import com.mysql.jdbc.Connection;


public class ProfileHelper extends DatabaseHandler{
	public UserAccount getUserData(int userid){
		Connection con =  (Connection) getConnection();
		Statement st = null;

		UserAccount uacc = new UserAccount();
		
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from userinfo WHERE UserId="+userid);
			while(rs.next()){
				uacc.setFname(rs.getString("FirstName"));
				uacc.setLname(rs.getString("LastName"));
				uacc.setContact(rs.getString("ContactNo"));
				uacc.setEmail(rs.getString("EmailId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return uacc;
	}

}
