package com.cummins.project734.dbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.cummins.project734.dbhandler.DatabaseHandler;
import com.mysql.jdbc.Connection;

public class SearchIndexHelper  extends DatabaseHandler{
	public List<Integer> getFieldLengths(String userName,String fileName){
		Connection con = (Connection) getConnection();
		List<Integer> fieldLengths = new ArrayList<Integer>();
		Statement st = null;
		int userid = 0;
		int fileid = 0;
		int noOfFields = 0;
		try {
			st = con.createStatement();

			ResultSet rs = st.executeQuery("Select UserAccountID from useraccount where UserName='"+userName+"'");
			while(rs.next()){
				userid =rs.getInt(1);
				System.out.println("userid: "+userid);
			}

			st = con.createStatement();

			ResultSet rs1 = st.executeQuery("Select FileId,NoOfFields from filetable where UserFileID="+userid+" and FileName='"+fileName+"'");
			while(rs1.next()){
				fileid = rs1.getInt(1);
				noOfFields = rs1.getInt(2);
			}

			st = con.createStatement();
			ResultSet rs2 = st.executeQuery("Select FieldLength from filefieldlength where FileLenID="+fileid+" and FieldNumber between 0 AND "+(noOfFields-1)+"");
			while(rs2.next()){
				fieldLengths.add(rs2.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fieldLengths;

	}

	public boolean checkPatternFileExistence(String filename,String username){
		System.out.println("\nInside SearchIndexHelper: ");
		Connection con = (Connection) getConnection();
		Statement st = null;
		boolean exists = false;
		int userid = 0;
		int fileid = 0;
		String patternfile = "";
		try {
			st = con.createStatement();

			ResultSet rs = st.executeQuery("Select UserAccountID from useraccount where UserName='"+username+"'");
			while(rs.next()){
				userid =rs.getInt(1);
				System.out.println("userid: "+userid);
			}

			st = con.createStatement();

			ResultSet rs1 = st.executeQuery("Select FileId from filetable where UserFileID="+userid+" and FileName='"+filename+"'");
			while(rs1.next()){
				fileid = rs1.getInt(1);
			}
			System.out.println("\nSIH: userid:"+userid+"  fileid: "+fileid);
			ResultSet rs2 = st.executeQuery("Select * from patternfileinfo where UserPatternID="+userid+" and FilePatternID="+fileid+"");
			if(rs2==null){
				exists = false;
				System.out.println("\nrs2 is null");
			}
			else{
				while(rs2.next()){
					patternfile = rs2.getString(3);
					System.out.println("patternfile: "+patternfile);
				}
				if(patternfile.contains(filename)){
					//if(patternfile.equalsIgnoreCase("C:\\User_Directories\\"+username+"\\Patterns\\"+filename+"\\pattern.txt")){
					exists = true;
				}
				else{
					exists = false;
				}
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return exists;

	}

	public List<String> searchQueryOperations(String searchQuery,String username){
		
		System.out.println("\nInside SearchIndexHelper (query operations): ");
		System.out.println("\nsearchQuery: "+searchQuery+" Value of expression: "+(searchQuery==""));
		Connection con = (Connection) getConnection();
		Statement st = null;
		int userid = 0;
		List<Integer> queryIds = new ArrayList<Integer>();
		List<String> queryList = new ArrayList<String>();
		if(!(searchQuery.trim()=="")){
			System.out.println("\nsearchQuery: "+searchQuery+" Value of expression: "+(searchQuery==""));
			try {

				st = con.createStatement();

				ResultSet rs3 = st.executeQuery("Select UserAccountID from useraccount where UserName='"+username+"'");
				while(rs3.next()){
					userid =rs3.getInt(1);
					System.out.println("userid: "+userid);
				}



				st = con.createStatement();

				ResultSet rs = st.executeQuery("Select UserID from usersearchhistory where SearchString='"+searchQuery+"'");

				if(rs==null){
					System.out.println("No userids retrieved.");
				}
				else{
					
					while(rs.next()){
						queryIds.add(rs.getInt(1));
						
						System.out.println("ID: "+queryIds);
					}
					
					Set<Integer> tempset = new HashSet<Integer>(queryIds);
					System.out.println("tempset: "+tempset);
					
					queryIds = new ArrayList<Integer>(tempset);
					System.out.println("queryIds after set: "+queryIds);
					Iterator<Integer> idIterator = queryIds.iterator();
					while(idIterator.hasNext()){
						st = con.createStatement();
						ResultSet rs1 = st.executeQuery("Select SearchString from usersearchhistory where UserID="+idIterator.next());

						if(rs1==null){
							System.out.println("No searchstrings retrieved.");
						}
						else{
							while(rs1.next()){
								queryList.add(rs1.getString(1));
								System.out.println("querylist last entry: "+queryList.get((queryList.size()-1)));
							}
						}
					}
				}

				/*for(int i=0;i<queryList.size();i++){
					queryList.remove(searchQuery);
				}*/

				st = con.createStatement();
				st.executeUpdate("Insert into usersearchhistory(UserID,SearchString) values("+userid+",'"+searchQuery+"')");
				
				
				HashSet<String> temp = new HashSet<String>();
				System.out.println("queryList size: "+queryList.size());
				Iterator<String> quIter = queryList.iterator();
				while(quIter.hasNext()){
					temp.add(quIter.next());
				}
				System.out.println("temp size: "+temp.size());
				queryList = new ArrayList<String>();
				Iterator<String> tempIter = temp.iterator();
				while(tempIter.hasNext()){
					queryList.add(tempIter.next());
				}
				System.out.println("queryList size: "+queryList.size());				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return queryList;


	}
}
