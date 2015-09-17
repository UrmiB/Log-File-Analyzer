package com.cummins.project734.dbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cummins.project734.dbhandler.DatabaseHandler;
import com.mysql.jdbc.Connection;

public class PatternHelper extends DatabaseHandler{
	public void createPatternFileRecord(String filename, String userName){
		System.out.println("\nInside PatternHelper: ");
		
		Connection con = (Connection) getConnection();
		Statement st = null;
		int userid = 0;
		int fileid = 0;

		try {
			st = con.createStatement();

			ResultSet rs = st.executeQuery("Select UserAccountID from useraccount where UserName='"+userName+"'");
			while(rs.next()){
				userid =rs.getInt(1);
				System.out.println("userid: "+userid);
			}

			st = con.createStatement();

			ResultSet rs1 = st.executeQuery("Select FileId from filetable where UserFileID="+userid+" and FileName='"+filename+"'");
			while(rs1.next()){
				fileid = rs1.getInt(1);
			}	
			
			st = con.createStatement();
			st.executeUpdate("Insert into patternfileinfo values("+userid+","+fileid+",'C:\\\\User_Directories\\\\"+userName+"\\\\Patterns\\\\"+filename+"\\\\pattern.txt')");
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
