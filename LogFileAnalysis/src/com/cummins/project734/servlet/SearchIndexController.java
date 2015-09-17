package com.cummins.project734.servlet;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cummins.project734.dbHelper.PatternHelper;
import com.cummins.project734.dbHelper.SearchIndexHelper;
import com.cummins.project734.entity.AnalysisData;
import com.cummins.project734.entity.DateIndexSearcher;
import com.cummins.project734.entity.DatewiseRecord;
import com.cummins.project734.entity.ErrorInformation;
import com.cummins.project734.entity.ErrorReport;
import com.cummins.project734.entity.SearchResult;
import com.cummins.project734.entity.TimelineRecords;
import com.cummins.project734.fileHelper.SavePattern;
import com.cummins.project734.luceneentity.DataAnalyzer;
import com.cummins.project734.luceneentity.PatternSearcher;
import com.cummins.project734.luceneentity.SearchIndex;

public class SearchIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchIndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		AnalysisData analysis = new AnalysisData();
		SearchResult sResult = new SearchResult();
		DataAnalyzer analyzer = new DataAnalyzer();
		String searchQuery = request.getParameter("searchQuery");
		SearchIndex search = new SearchIndex();
		PatternSearcher ps = new PatternSearcher();
		TimelineRecords tr = new TimelineRecords();
		SavePattern patternSave = new SavePattern();
		SearchIndexHelper siHelper = new SearchIndexHelper();
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");

		List<DatewiseRecord>  drList = new ArrayList<DatewiseRecord>();
		List<Integer> fieldLenArray = new ArrayList<Integer>();
		ArrayList<ArrayList<DatewiseRecord>> MainList = new ArrayList<ArrayList<DatewiseRecord>>();
		List<ArrayList<ArrayList<String>>> allImportantRecords = new ArrayList<ArrayList<ArrayList<String>>>();

		System.out.println("WORD: "+searchQuery);
		//Directory to be passed depends on the user account

		HttpSession session = request.getSession();
		String UserN  = (String) session.getAttribute("UserName");
		session.setAttribute("searchquery", searchQuery);

		//Search Query Storage and Retrieval
		List<String> queryList = new ArrayList<String>();
		queryList = siHelper.searchQueryOperations(searchQuery,UserN);
		System.out.println("queryList: "+queryList);
		Integer [] indices = {-1,-1,-1,-1};
		List<String> queries = new ArrayList<String>();
		int cnt = 0;
		int flag = 0;
		int iterations = 0;
		int stopFlag = 0;
		if(queryList.size()<4){
			iterations = queryList.size();
		}
		else{
			iterations = 4;
		}
		for(int i=0;i<iterations;i++){
			
			if(stopFlag<=queryList.size()){
				Random r = new Random();
				int index = r.nextInt(queryList.size());
				System.out.println("Index: "+index);
				for(int j=0;j<iterations;j++){
					if(indices[j]==index || queryList.size()<index){
						flag=1;
						i = i-1;
					}
				}
				if(flag==0){
					indices[cnt] = index;
					cnt++;
					if(index!=-1){
						queries.add(queryList.get(index));
					}
				}
				stopFlag++;
			}
			else{
				i = iterations;
			}
		}

		System.out.println("queries: "+queries);

		String Filename= request.getParameter("filename");	
		session.setAttribute("filename", Filename);

		File indexDir = new File("c:\\User_Directories\\" + UserN+"\\Index\\"+Filename);
		if(searchQuery == "")
		{
			try {
				fieldLenArray = siHelper.getFieldLengths(UserN,Filename);
				System.out.println("fieldLenArray: " +fieldLenArray);
				request.setAttribute("FieldArray", fieldLenArray);
				drList = analyzer.DateWiseRecord(fieldLenArray,UserN,Filename);
				analysis = analyzer.analyzeData(indexDir,searchQuery,sResult,fieldLenArray);
				analysis.setDatewiseRecords(drList);

				boolean exists = siHelper.checkPatternFileExistence(Filename, UserN);
				System.out.println("SIC exists: "+exists);
				if(!exists){
					allImportantRecords = ps.searchPattern(analysis, fieldLenArray, UserN, Filename);
					patternSave.saveImportantPattern(allImportantRecords, fieldLenArray,UserN,Filename);
					PatternHelper pHelper = new PatternHelper();
					pHelper.createPatternFileRecord(Filename,UserN);
				}
				else{
					System.out.println("Exists. Not inserted in database.");
				}

				MainList = tr.TimelineDateRecords(analysis);
				request.setAttribute("Mainlist", MainList);
				request.setAttribute("Analysis", analysis);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ArrayList<ErrorInformation> l1 = new ArrayList<ErrorInformation>();
			//String []str;
			ArrayList<String> str1 =  new ArrayList<String>();
			ArrayList<Integer> number = new ArrayList<Integer>();
			//str = new String[3];
			//int []numb;
			//numb = new int[3];
			int i=0;
			l1 = (ArrayList<ErrorInformation>) analysis.getErrorInfo();
			Iterator<ErrorInformation> it = l1.iterator();
			ErrorInformation ei = new ErrorInformation();
			while(it.hasNext())
			{
				ei = (ErrorInformation)it.next();
				str1.add(ei.getErrorType());
				number.add(ei.getNumber());
				//str[i]= ei.getErrorType();
				//numb[i] = ei.getNumber();
				//i++;
			}

			session.setAttribute("numb", number);
			session.setAttribute("str", str1);

			ArrayList<ErrorReport> erList = new ArrayList<ErrorReport>();
			erList = (ArrayList<ErrorReport>) analyzer.getErrorRecords(search, indexDir);
			erList = checkSearchResult(erList, fromDate, toDate, fieldLenArray);
			request.setAttribute("erL", erList);
			/*Iterator<ErrorReport> erITer = erList.iterator();
				while(erITer.hasNext()){
					ErrorReport erRep = new ErrorReport();
					String error = "";
					erRep = (ErrorReport) erITer.next();
					error = erRep.getErrorRecord();
					System.out.println("\nerList record: "+error);
				}*/
		}
		else
		{	
			try {
				sResult = search.searchIndex(indexDir, searchQuery, 1000);

				fieldLenArray = siHelper.getFieldLengths(UserN,Filename);
				System.out.println("fieldLenArray: " +fieldLenArray);
				sResult = checkSearchResult(sResult,fromDate,toDate,fieldLenArray);
				request.setAttribute("SearchResult", sResult);
				request.setAttribute("FieldArray", fieldLenArray);
				drList = analyzer.DateWiseRecord(fieldLenArray,UserN,Filename);
				analysis = analyzer.analyzeData(indexDir,searchQuery,sResult,fieldLenArray);
				analysis.setDatewiseRecords(drList);

				boolean exists = siHelper.checkPatternFileExistence(Filename, UserN);
				System.out.println("SIC exists: "+exists);
				if(!exists){
					allImportantRecords = ps.searchPattern(analysis, fieldLenArray, UserN, Filename);
					patternSave.saveImportantPattern(allImportantRecords, fieldLenArray,UserN,Filename);
					PatternHelper pHelper = new PatternHelper();
					pHelper.createPatternFileRecord(Filename,UserN);
				}
				else{
					System.out.println("Exists. Not inserted in database.");
				}

				MainList = tr.TimelineDateRecords(analysis);
				request.setAttribute("Mainlist", MainList);
				request.setAttribute("Analysis", analysis);

				int freq = sResult.getFrequency();
				float percent = analysis.getPercentage();

				session.setAttribute("freq", freq);
				session.setAttribute("percent", percent);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		request.getRequestDispatcher("./AnalysisReport.jsp").forward(request, response);
	}

	private ArrayList<ErrorReport> checkSearchResult(ArrayList<ErrorReport> erList,
			String fromDate, String toDate, List<Integer> fieldLenArray) throws ParseException {
		int index = 0;

		if(erList.equals(null)){
			System.out.println("drList is null.");
		}
		else{
			if(fromDate.isEmpty() || toDate.isEmpty()){
				System.out.println("From, To date fields are empty.");
				return erList;
			}
			else{
				Date fDate = new SimpleDateFormat("dd-mm-yyyy",Locale.ENGLISH).parse(fromDate);
				Date tDate = new SimpleDateFormat("dd-mm-yyyy",Locale.ENGLISH).parse(toDate);
				ArrayList<ErrorReport> modifiedRecordList = new ArrayList<ErrorReport>();

				DateIndexSearcher dis = new DateIndexSearcher();
				//Get sample record for fetching date index
				String sample = erList.get(0).getErrorRecord();
				index = dis.dateIndexSearcher(sample, fieldLenArray);

				int lowerbound = 0 ;
				int upperbound = 0 ;
				int sum = 0 ;
				int count = 0;
				Iterator<Integer> fieldLenIter = fieldLenArray.iterator();
				while(fieldLenIter.hasNext()){
					if(index==count){
						lowerbound=sum;
						sum=sum+fieldLenIter.next();
						upperbound=sum;

					}
					else{
						sum=sum+fieldLenIter.next();

					}
					count++;
				}


				Iterator erit = erList.iterator();
				System.out.println("errorReport size: "+erList.size());
				while(erit.hasNext()){

					ErrorReport er = new ErrorReport();

					er = (ErrorReport) erit.next();
					String record = er.getErrorRecord();
					Date tempdate = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy",Locale.ENGLISH).parse(record.substring(lowerbound+1, upperbound-1));
					DateFormat outputFormatter1 = new SimpleDateFormat("dd-mm-yyyy");
					String dateStr = outputFormatter1.format(tempdate);
					Date date1 = outputFormatter1.parse(dateStr);
					if(date1.after(fDate) && date1.before(tDate)){
						modifiedRecordList.add(er);
					}


				}
				System.out.println("modifiedRecordList in checkSearchResult: "+modifiedRecordList);
				erList = modifiedRecordList;
			}
		}
		return erList;
	}

	private SearchResult checkSearchResult(SearchResult sResult,
			String fromDate, String toDate, List<Integer> fieldLenArray) throws ParseException {
		int index = 0;

		if(sResult.equals(null)){
			System.out.println("sResult is null.");
		}
		else{
			if(fromDate.isEmpty() || toDate.isEmpty()){
				System.out.println("From, To date fields are empty.");
				return sResult;
			}
			else{
				Date fDate = new SimpleDateFormat("dd-mm-yyyy",Locale.ENGLISH).parse(fromDate);
				Date tDate = new SimpleDateFormat("dd-mm-yyyy",Locale.ENGLISH).parse(toDate);
				ArrayList<String> records = new ArrayList<String>(sResult.getRecords());
				ArrayList<String> modifiedRecordList = new ArrayList<String>();
				Iterator it = records.iterator();

				DateIndexSearcher dis = new DateIndexSearcher();
				//Get sample record for fetching date index
				String sample = records.get(0);
				index = dis.dateIndexSearcher(sample, fieldLenArray);

				int lowerbound = 0 ;
				int upperbound = 0 ;
				int sum = 0 ;
				int count = 0;
				Iterator<Integer> fieldLenIter = fieldLenArray.iterator();
				while(fieldLenIter.hasNext()){
					if(index==count){
						lowerbound=sum;
						sum=sum+fieldLenIter.next();
						upperbound=sum;

					}
					else{
						sum=sum+fieldLenIter.next();

					}
					count++;
				}

				while(it.hasNext()){
					String record = it.next().toString();
					Date tempdate = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy",Locale.ENGLISH).parse(record.substring(lowerbound+1, upperbound-1));
					DateFormat outputFormatter1 = new SimpleDateFormat("dd-mm-yyyy");
					String dateStr = outputFormatter1.format(tempdate);
					Date date1 = outputFormatter1.parse(dateStr);
					if(date1.after(fDate) && date1.before(tDate)){
						modifiedRecordList.add(record);
					}

				}
				sResult.setRecords(modifiedRecordList);
			}
		}
		System.out.println("sResult records: "+sResult.getRecords());
		return sResult;
	}

}