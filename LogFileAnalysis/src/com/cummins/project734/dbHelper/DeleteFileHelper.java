package com.cummins.project734.dbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cummins.project734.dbhandler.DatabaseHandler;
import com.mysql.jdbc.Connection;

public class DeleteFileHelper extends DatabaseHandler{
	
	public void deletefile(String username, String filename){
		Connection con =  (Connection) getConnection();
		Statement st = null;
		int userid = 0;
		
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("Select UserAccountID from useraccount where UserName='"+username+"'");
			while(rs.next()){
				userid =rs.getInt(1);
			//	System.out.println("userid: "+userid);
			}
			st.executeUpdate("DELETE from FileTable where UserFileID="+userid+" and FileName='"+filename+"'");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
