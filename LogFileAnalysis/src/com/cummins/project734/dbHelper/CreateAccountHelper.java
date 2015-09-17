package com.cummins.project734.dbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cummins.project734.dbhandler.DatabaseHandler;
import com.mysql.jdbc.Connection;

public class CreateAccountHelper extends DatabaseHandler{
	public void InsertRecord(String Fname,String Lname,String Contact,String Email,String Uname,String Pword){
		
		Connection con = (Connection) getConnection();
		Statement st = null;
		int id=0;
		try {
			st = con.createStatement();
			st.executeUpdate("INSERT INTO UserInfo(FirstName,LastName,ContactNo,EmailId) values('"+Fname+"','"+Lname+"','"+Contact+"','"+Email+"')");
			ResultSet rs = st.executeQuery("Select UserInfo.UserID from UserInfo WHERE UserInfo.ContactNo="+Contact+" and UserInfo.EmailId='"+Email+"'");
			while (rs.next()){
			 id = rs.getInt(1);
			}
			st.executeUpdate("INSERT INTO UserAccount(UserAccountID,UserName,Password) values("+id+",'"+Uname+"','"+Pword+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	public boolean checkUsernameAvailability(String username){
		boolean available = false;
		Connection con = (Connection) getConnection();
		Statement st = null;
		int id = -1;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("Select UserAccountID from useraccount where UserName='"+username+"'");
			if(rs==null){
				available = true;
			}
			else{
				while(rs.next()){
					id = rs.getInt(1);
				}
				if(id==-1){
					available = true;
				}
				else{
					available = false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return available;		
	}
}
