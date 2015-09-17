package com.cummins.project734.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cummins.project734.dbHelper.ProfileHelper;
import com.cummins.project734.entity.UserAccount;

public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProfileController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int userId = (Integer) request.getSession().getAttribute("UserId");
				
		ProfileHelper pr = new ProfileHelper();
		UserAccount uacc = new UserAccount();
		uacc = pr.getUserData(userId);
		
		String fname = uacc.getFname();
		request.setAttribute("fname", fname);
		String lname = uacc.getLname();
		request.setAttribute("lname", lname);
		String contact = uacc.getContact();
		request.setAttribute("contact", contact);
		String email = uacc.getEmail();
		request.setAttribute("email", email);

		request.getRequestDispatcher("./ViewProfile.jsp").forward(request, response);

	}

}
