package com.cummins.project734.servlet;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.cummins.project734.dbHelper.LoginHelper;


/**
 * Servlet implementation class MyServlet
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(request, response);
		 processRequest(request,response);
	
		
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		//PrintWriter out = response.getWriter();
		//out.println("<html>SERVLET POST</html>");
	
		HttpSession session = request.getSession(true);
		String Username = (String) request.getParameter("userid");
		session.setAttribute("UserName", Username);
		String Password = request.getParameter("pswrd");
		
		LoginHelper Lhelper = new LoginHelper();
	
		boolean success = Lhelper.authenticateUser(Username, Password);
		if(success){
			UserDirectories Userd = new UserDirectories();
			Userd.Createdirectory(request, response);
			System.out.println("\nInside LoginController: ");

			int UId = Lhelper.GetUserId(Username,Password);
			session.setAttribute("UserId",UId);

			//String Username = request.getParameter("userid");
			//request.setAttribute("myname",Username);
			//response.sendRedirect("AcceptFile.jsp");
			request.getRequestDispatcher("./HomeMenu.jsp").forward(request, response);
		}
		else{
			String errorMessage = "Username or password is incorrect.";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("./LoginPage.jsp").forward(request, response);
		}	
	}

}
