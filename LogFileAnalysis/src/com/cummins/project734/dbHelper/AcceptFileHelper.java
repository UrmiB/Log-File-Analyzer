package com.cummins.project734.dbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cummins.project734.dbhandler.DatabaseHandler;
import com.mysql.jdbc.Connection;

public class AcceptFileHelper extends DatabaseHandler{
	public void InsertAcceptFileData(String fileName,int userid,ArrayList<Integer> fieldLen,int NoFields){

		Connection con =  (Connection) getConnection();
		Statement st = null;
		int Fid = 0;
	
		try {
			st = con.createStatement();
			st.executeUpdate("INSERT INTO FileTable(UserFileID,FileName,NoOfFields) values("+userid+",'"+fileName+"',"+NoFields+")");
			
			ResultSet rs = st.executeQuery("Select MAX(FileTable.FileID) from FileTable");
			while (rs.next()){
				 Fid = rs.getInt(1);
				}
			System.out.println("File ID : "+Fid);

			for(int j = 0; j < fieldLen.size(); j++) {
			    int d = (int) fieldLen.get(j);
			    System.out.println("ACCEPTFileHelper fieldlen: "+d);
			    System.out.println("ACCEPTFileHelper fieldlen: "+j);
			    st.executeUpdate("INSERT INTO FileFieldLength(FileLenID,FieldNumber,FieldLength) values("+Fid+","+j+","+d+")");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkFileName(String filename,String username){

		//System.out.println("\nInside AcceptFileHelper: ");

		Connection con = (Connection) getConnection();
		Statement st = null;
		int userid = 0;
		boolean exists = false;
		String fileDb = "";
		try {
			st = con.createStatement();

			ResultSet rs = st.executeQuery("Select UserAccountID from useraccount where UserName='"+username+"'");
			while(rs.next()){
				userid =rs.getInt(1);
				//System.out.println("userid: "+userid);
			}
			//System.out.println("filename in helper: "+filename);
			ResultSet rs1 = st.executeQuery("Select * from filetable where UserFileID="+userid+" and FileName='"+filename+"'");
			if(rs1==null){
				exists = false;
			}
			else{
				while(rs1.next()){
					fileDb = rs1.getString(3);
					System.out.println("fileDb: "+fileDb);
				}
				if(fileDb.equalsIgnoreCase(filename)){
					exists = true;
				}
				else{
					exists = false;
				}
			}
			//System.out.println("Exists in helper: "+exists);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return exists;

	}
}
