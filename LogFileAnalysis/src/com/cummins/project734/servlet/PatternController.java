package com.cummins.project734.servlet;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PatternController
 */
public class PatternController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PatternController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	public void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		 //	System.out.println("In Pattern Controller.");
			HttpSession session = request.getSession();
	        String username = session.getAttribute("UserName").toString();
	        String filename = session.getAttribute("filename").toString();
	    //  System.out.println("UName: "+username);
	    //  System.out.println("FName: "+filename);
	       
	        FileInputStream fstream = new FileInputStream("C:\\User_Directories\\"+username+"\\Patterns\\"+filename+"\\pattern.txt");
	        DataInputStream in = new DataInputStream(fstream);
	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        String strLine;
	        List<String> list1 = new ArrayList<String>();

	        while ((strLine = br.readLine()) != null) {
	        	list1.add(strLine);	        	
	        }
	        
	        in.close();
	        session.setAttribute("list1", list1);
	        request.getRequestDispatcher("./ViewPatterns.jsp").forward(request, response);
	}

}

