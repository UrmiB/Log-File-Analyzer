package com.cummins.project734.servlet;

import java.io.File;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDirectories
 */
public class UserDirectories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDirectories() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Createdirectory(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Createdirectory(request,response);
	}
			 
	public void Createdirectory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_name = request.getParameter("userid");
		
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));*/
		
		File user_dir = new File("c:\\User_Directories\\" + user_name);
		     
		        // create directory, if the directory does not exist
		        if (!user_dir.exists())
		        {
		          System.out.println("Creating Directory: " + user_dir.getName());
		          boolean result = user_dir.mkdir();  
		          System.out.println("Result: "+result);
		          if(result)
		          {    
		             System.out.println("New Directory Created");  
		          }
		          else
		          {
		        	  System.out.println("Error while creating directory.");
		          }
		        }
		        else
		        {
		        		System.out.println("Directory already exists.");
		        }
	}
		    
}
