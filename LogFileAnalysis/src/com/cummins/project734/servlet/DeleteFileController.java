package com.cummins.project734.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cummins.project734.dbHelper.DeleteFileHelper;

public class DeleteFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public final static String INDEX_DIRECTORY = "indexDirectory";

	public final static  String FIELD_PATH = "path";
    public DeleteFileController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
		
	}
	private void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	
		//System.out.println("In DeleteFileController");
		String filename = request.getParameter("id");
		System.out.println("Filename: "+filename);
		String userName  = (String) request.getSession().getAttribute("UserName");
		System.out.println("name: "+userName);
		String from = (String) request.getAttribute("from");
		System.out.println("from: "+from);
		boolean result;

		
		if(from == null){
			DeleteFileHelper Dhelper = new DeleteFileHelper();
			Dhelper.deletefile(userName,filename);
			
			File path = new File("C:\\User_Directories//"+userName+"//Index//"+filename);
			File path1 = new File("C:\\User_Directories//"+userName+"//Patterns//"+filename);
			
			result = deleteDirectory(path);
			if(result){
				deleteDirectory(path1);
			}
			
			String errorMessage = "Record Deleted.";
			request.setAttribute("errorMessage", errorMessage);
			
			request.getRequestDispatcher("./HomeMenu.jsp").forward(request, response);
		}else if(from.equals("accountDelete")){
			File path = new File("C:\\User_Directories//"+userName);
			result = deleteDirectory(path);
			if(result){
				System.out.println("Deleted.");
			}
			
			String errorMessage = "User Account Deleted.";
			request.setAttribute("message", errorMessage);
			
			request.getRequestDispatcher("./LoginPage.jsp").forward(request, response);
		}
			
		/*	Directory path  = FSDirectory.open(new File( "C:\\User_Directories//"+userName+"//Index//"+filename));
		deleteDocumentsFromIndexUsingTerm(path);*/
		
		
		
	}
	public boolean deleteDirectory(File path){
		boolean value = false;
		if (path.exists()) {
	        File[] files = path.listFiles();
	       // System.out.println("File length: "+files.length);
	        for (int i = 0; i < files.length; i++) {
	            if (files[i].isDirectory()) {
	            	deleteDirectory(files[i]);
	                
	            } else {
	                boolean fileStatus = files[i].delete();
	              //  System.out.println("files: "+files[i] + " Is File deleted: " + fileStatus);
	            }
	        }
	        value = path.delete();
	        System.out.println("Value: "+value);
	    }
		return value;
	}
	
	/*public static void deleteDocumentsFromIndexUsingTerm(Directory path) throws IOException {

		System.out.println(" In my funct Deleting documents with field " );
		//Term term = new Term();
		Analyzer luceneAnalyzer = new StandardAnalyzer(Version.LUCENE_40);
		IndexWriterConfig conf = new IndexWriterConfig(null, luceneAnalyzer).setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
		IndexWriter indexWriter = new IndexWriter(path,conf);
		//IndexReader indexReader = IndexReader.open(directory);
		System.out.println("No of docs: "+indexWriter.numDocs());
		indexWriter.deleteAll();
		indexWriter.commit();
		indexWriter.close();

	}*/
}
