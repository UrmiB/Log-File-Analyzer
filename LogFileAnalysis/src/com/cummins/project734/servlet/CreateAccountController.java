package com.cummins.project734.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cummins.project734.dbHelper.CreateAccountHelper;

public class CreateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreateAccountController() {
        super();
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
		String Fname = request.getParameter("firstname");
		String Lname = request.getParameter("lastname");
		String Contact = request.getParameter("contact");
		String Email = request.getParameter("email");
		String Uname = request.getParameter("user");
		String Pword = request.getParameter("password");
		CreateAccountHelper helper = new CreateAccountHelper();
		String errorMessage = "";
		String message = "";
		boolean available = false;

		available = helper.checkUsernameAvailability(Uname);
		if(available){
			helper.InsertRecord(Fname,Lname,Contact,Email,Uname,Pword);
			//System.out.println("\nInside CreateAccountController: ");
			message="Account Created. Please login with your username and password.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("./LoginPage.jsp").forward(request, response);
		}
		else{
			errorMessage = "Username is not available. Please enter another username";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("./CreateAccount.jsp").forward(request, response);
		}

	}

}
