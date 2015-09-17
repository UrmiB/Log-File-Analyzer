package com.cummins.project734.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cummins.project734.entity.ErrorReport;
import com.cummins.project734.entity.SearchResult;


public class RecordListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RecordListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void processRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		List<Integer> fieldLenArray = new ArrayList<Integer>();

		SearchResult sResult = new SearchResult();
		String searchQuery = (String) session.getAttribute("searchquery");
		request.setAttribute("query", searchQuery);

		ArrayList<String> RecordList = new ArrayList<String>();
		ArrayList<ErrorReport> ErrorList = new ArrayList<ErrorReport>();
		
		if(searchQuery != ""){
			
			sResult = (SearchResult) session.getAttribute("SearchResult");
			RecordList = (ArrayList<String>)sResult.getRecords();
			request.setAttribute("Recordlist", RecordList);
			fieldLenArray = (List<Integer>) session.getAttribute("FieldArray");
			request.setAttribute("FieldArray", fieldLenArray);
			
		}else{
			ErrorList = (ArrayList<ErrorReport>)session.getAttribute("errorList");
			request.setAttribute("erlist", ErrorList);
			fieldLenArray = (List<Integer>) session.getAttribute("FieldArray");
			request.setAttribute("FieldArray", fieldLenArray);
		}
		
		request.getRequestDispatcher("./ViewRecords.jsp").forward(request, response);

	}

}
