package com.cummins.project734.dbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cummins.project734.dbhandler.DatabaseHandler;
import com.mysql.jdbc.Connection;

public class ExistingFileHelper extends DatabaseHandler{

	public ArrayList<String> getFiles(int userId){
		Connection con =  (Connection) getConnection();
		Statement st = null;
		ArrayList<String> eFiles = new ArrayList<String>();
		
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("Select FileTable.FileName from FileTable WHERE FileTable.UserFileID="+userId+"");
			while(rs.next())
			{
				eFiles.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eFiles;
	}
}
