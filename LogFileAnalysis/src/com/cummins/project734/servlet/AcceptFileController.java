package com.cummins.project734.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cummins.project734.dbHelper.AcceptFileHelper;
import com.cummins.project734.luceneentity.IndexBuilder;

public class AcceptFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AcceptFileController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request,HttpServletResponse response) {
	
		String filePath = request.getParameter("filePath");
		System.out.println("fileName in AcceptFileController: "+filePath);
		String no_fields = request.getParameter("no_fields");
	
		String errorMessage = ""; 
		String fileName = "";
		boolean exists = false;
		
		HttpSession session = request.getSession();
		String UserN  = (String) session.getAttribute("UserName");
		
		request.setAttribute("jspPath", "AcceptFileController");
		session.setAttribute("filename", filePath);
		
		int Userid = (Integer) request.getSession().getAttribute("UserId");
		System.out.println("Session Variable : "+UserN);
		System.out.println("USER ID session: "+Userid);
		/*System.out.println("File Type: "+fileType);
		System.out.println("File Name: "+fileName );*/
		/* Extracting file name*/
		String tempName = new StringBuffer(filePath).reverse().toString();
		String [] buffer = tempName.split("\\\\");
		tempName = "";
		tempName = buffer[0].toString().trim();
		/*for(int i=1;i<=buffer.length;i++){
			if(i<buffer.length){
				System.out.println("Split string: "+buffer[i]);
				if(i!=1){
					buffer[i] = "\\".concat(buffer[i]);
				}
				tempName = new StringBuffer(tempName.concat(buffer[i])).toString();
				System.out.println("tempName in loop i="+i+" : "+tempName);
			}
		}*/
		fileName = new StringBuffer(tempName).reverse().toString();
		System.out.println("FileName after manipulation: "+fileName);
		IndexBuilder ibuild = new IndexBuilder();
		AcceptFileHelper AcceptHelper = new AcceptFileHelper();

		exists = AcceptHelper.checkFileName(fileName, UserN);
		System.out.println("Exists: "+exists);

		//Calling index builder for performing indexing
		if(!exists){
		try {
				String count = request.getParameter("count");
				int cnt = Integer.parseInt(count);
				int j=0;
				ArrayList<Integer> fieldLen = new ArrayList<Integer>();
				String[] a = request.getParameterValues("txt");
				System.out.println("Count : "+cnt);
				
				for(j=0;j<cnt;j++)
				{ 
					Integer val = Integer.parseInt(a[j]);
					System.out.println("Field Array : "+val);
					fieldLen.add(val);
					System.out.println("Fields : "+fieldLen);
				}				
				ibuild.buildIndex(filePath, fileName, fieldLen, UserN);
				AcceptHelper.InsertAcceptFileData(fileName,Userid,fieldLen,cnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			request.getRequestDispatcher("./SearchIndex.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		else{
			if(fileName == null || fileName==""){
				errorMessage = "Please add a file.";
			}else{
				errorMessage = "File already exists in the database. Please add a different file or click on 'Open File' in the menu.";
			}
			request.setAttribute("errorMessage", errorMessage);

			try {
				request.getRequestDispatcher("./AcceptFile.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
