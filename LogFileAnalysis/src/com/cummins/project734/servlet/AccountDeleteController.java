package com.cummins.project734.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cummins.project734.dbHelper.AccountDeleteHelper;

public class AccountDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request,HttpServletResponse response) {
		int userId = (Integer) request.getSession().getAttribute("UserId");
		
		AccountDeleteHelper del = new AccountDeleteHelper();
		del.deleteAccount(userId);
		String from = "accountDelete";
		request.setAttribute("from", from);
		try {
			request.getRequestDispatcher("./DeleteFileController").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
