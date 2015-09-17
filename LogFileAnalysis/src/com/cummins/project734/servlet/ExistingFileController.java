package com.cummins.project734.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cummins.project734.dbHelper.ExistingFileHelper;


public class ExistingFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExistingFileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
			int userId = (Integer) request.getSession().getAttribute("UserId");
			String userName  = (String) request.getSession().getAttribute("UserName");
			System.out.println("Existing FILE CONTROLLER: "+userName);
			ArrayList<String> efiles = new ArrayList<String>();
			ExistingFileHelper eHelper = new ExistingFileHelper();
			efiles = eHelper.getFiles(userId);
			request.setAttribute("EFiles", efiles);
			String str = request.getParameter("id");
			//System.out.println("ID: "+str);
			if(str.trim().equalsIgnoreCase("open")){
				request.getRequestDispatcher("./ExistingFiles.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("./DeleteFile.jsp").forward(request, response);
			}
	}

}
