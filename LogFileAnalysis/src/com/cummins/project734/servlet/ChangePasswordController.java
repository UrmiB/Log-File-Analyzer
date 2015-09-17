package com.cummins.project734.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cummins.project734.dbHelper.ChangePasswordHelper;

public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangePasswordController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException{
		int userId = (Integer) request.getSession().getAttribute("UserId");
		String newPassword = request.getParameter("npass");
		String oldPassword = request.getParameter("cpass");
		//System.out.println("In ChangePasswordController: "+userName+" : "+userId);
		
		ChangePasswordHelper cph = new ChangePasswordHelper();
		
		boolean succ = cph.checkOldP(userId, oldPassword);
		
		if(succ == true){
			cph.changePassword(userId,newPassword);
			String message = "Password changed.";
			request.setAttribute("message", message);
			
			request.getRequestDispatcher("./HomeMenu.jsp").forward(request, response);
		}else{
			String message="Please enter correct password.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("./ChangePassword.jsp").forward(request, response);
		}
		
		
	}

}
