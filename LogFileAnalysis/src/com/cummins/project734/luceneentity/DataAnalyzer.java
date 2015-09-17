package com.cummins.project734.luceneentity;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.cummins.project734.entity.AnalysisData;
import com.cummins.project734.entity.DateIndexSearcher;
import com.cummins.project734.entity.DatewiseRecord;
import com.cummins.project734.entity.ErrorInformation;
import com.cummins.project734.entity.ErrorReport;
import com.cummins.project734.entity.SearchResult;

public class DataAnalyzer {

	public AnalysisData analyzeData(File indexDir, String searchQuery, SearchResult sResult, List<Integer> fieldLenArray) throws Exception {

		double percentage = 0.00;
		List<ErrorInformation> errorInfoList = new ArrayList<ErrorInformation>();
		AnalysisData analysis = new AnalysisData();
		SearchIndex errorSearcher = new SearchIndex();

				String queryStr = "error*";

		Directory directory = FSDirectory.open(indexDir);
		IndexReader reader = IndexReader.open(directory);
		
		//Calculate percentage
		double numDocs = reader.numDocs();
		double frequency = sResult.getFrequency();
		percentage = (double)((frequency/numDocs)*100);
		System.out.println("\nInside DataAnalyzer: ");
		System.out.println("Frequency: "+sResult.getFrequency()+" NumDocs: "+numDocs+" Percentage: "+percentage);
		analysis.setPercentage((float)percentage);
		analysis.setTotalNoOfRecords((int) numDocs);
		IndexSearcher searcher = new IndexSearcher(reader);
		
		//Get error information
		errorInfoList = getErrorInformation(errorSearcher,indexDir,queryStr);
		analysis.setErrorInfo(errorInfoList);
		return analysis;
	}


	public List<ErrorInformation> getErrorInformation(SearchIndex errorSearcher, File indexDir, String queryStr) throws Exception{

		int j=0;
		int flag=0;
		boolean checkIfExists = false;
		String checkVal = "";

		SearchResult errorResult = new SearchResult();
		List<ErrorInformation> errorInfoList = new ArrayList<ErrorInformation>();
		List<String> errorRecordList = new ArrayList<String>();
		errorResult = errorSearcher.searchIndex(indexDir, queryStr, 1000);
		System.out.println("\nErrorResult details:");
		//System.out.println("ErrorResult frequency: "+errorResult.getFrequency());
		//System.out.println("ErrorResult records: "+errorResult.getRecords());

		errorRecordList = errorResult.getRecords();
		//System.out.println("errorRecord list: "+errorRecordList);
		Iterator errorIterator = errorRecordList.iterator();
		while(errorIterator.hasNext()){
			String [] splitErrorRecord = errorIterator.next().toString().split(" ");
			//System.out.println("\nSplit String: "+splitErrorRecord[5]+"  "+splitErrorRecord.length);
			for(int i=0;i<splitErrorRecord.length;i++){
				//System.out.println("splitErrorRecord[i]+ "+splitErrorRecord[i]);
				if(splitErrorRecord[i].toString().trim().contains("[error".toString().trim())){
					j=i+1;
					if(j<splitErrorRecord.length){
						//System.out.println("j: "+j);
						flag=1;
						ErrorInformation eInfo = new ErrorInformation();
						//System.out.println("splitErrorRecord[i]: "+splitErrorRecord[i]+" splitErrorRecord[j]:"+splitErrorRecord[j]);
						if((checkIfExists=checkExistence(splitErrorRecord[j].substring(0, splitErrorRecord[j].length()-1),errorInfoList))){
							Iterator it = errorInfoList.iterator();
							while(it.hasNext()){
								eInfo = (ErrorInformation) it.next();
								if((checkVal=eInfo.getErrorType()).equalsIgnoreCase(splitErrorRecord[j].substring(0, splitErrorRecord[j].length()-1))){
									
									//System.out.println("Num: "+eInfo.getNumber()+" checkVal:"+checkVal);
									eInfo.setNumber(eInfo.getNumber()+1);
								}
							}
						}
						else{
							eInfo.setErrorType(splitErrorRecord[j].substring(0,splitErrorRecord[j].length()-1));
							eInfo.setNumber(eInfo.getNumber()+1);
							errorInfoList.add(eInfo);
							//System.out.println("\nErrorInfoList: "+errorInfoList);
						}
						j=0;
					}
				}
				flag=1;
			}
		}
	//	System.out.println("\n\nFinal error list: ");
		ErrorInformation displayList = new ErrorInformation();
		Iterator lIterator = errorInfoList.iterator();
		while(lIterator.hasNext()){
			displayList = (ErrorInformation) lIterator.next();
		//	System.out.println("\nType: "+displayList.getErrorType()+" Number: "+displayList.getNumber());
		}
		return errorInfoList;
	}


	private boolean checkExistence(String string, List<ErrorInformation> errorInfoList) {
		// TODO Auto-generated method stub
		Iterator listIterator = errorInfoList.iterator();
		ErrorInformation eInfo = new ErrorInformation();
		//System.out.println("\nIn checkExistence function");
		//System.out.println("String: "+string);
		while(listIterator.hasNext()){
			String type = (((ErrorInformation) listIterator.next()).getErrorType()).toString();
			//System.out.println("Type: "+type);
			if(type.equalsIgnoreCase(string)){
				//System.out.println("True.");
				return true;
			}
		}

		return false;
	}

	
	public List<ErrorReport> getErrorRecords(SearchIndex errorSearcher, File indexDir) throws Exception{
		SearchResult errorResult = new SearchResult();
		List<String> errorRecordList = new ArrayList<String>();
		List<ErrorReport> errorRecords = new ArrayList<ErrorReport>();
		errorResult = errorSearcher.searchIndex(indexDir, "error*", 1000);
		errorRecordList = errorResult.getRecords();
		Iterator errorListIter = errorRecordList.iterator();
		while(errorListIter.hasNext()){
			ErrorReport er = new ErrorReport();
			er.setErrorRecord((String)errorListIter.next());
			errorRecords.add(er);
		}
		return errorRecords;
		
	}
	
	public List<DatewiseRecord> DateWiseRecord(List<Integer> fieldLenArray,String userName,String fileName) throws IOException, ParseException
	{
		
		SearchIndex search = new SearchIndex();
		String record = new String();
		Integer maxDocs = 0;
		Integer recId = 0;
		File indexDir = new File("C:\\User_Directories\\"+userName+"\\Index\\"+fileName);
		Directory directory = FSDirectory.open(indexDir);
		maxDocs = search.getMaxDocuments(directory);
		
		record = search.getRecordById(recId, indexDir);
		
		DateIndexSearcher dis = new DateIndexSearcher();
		int dateIndex = dis.dateIndexSearcher(record,fieldLenArray);
		System.out.println("DateIndex: "+dateIndex);
				
		
		List<DatewiseRecord> drList = new ArrayList<DatewiseRecord>();
				
		String dateStr = "";
		int count=0;
		
		int noOffields = fieldLenArray.size();
		
		
		int lowerbound = 0 ;
		int upperbound = 0 ;
		int sum = 0 ;
		
		Iterator<Integer> fieldLenIter = fieldLenArray.iterator();
		while(fieldLenIter.hasNext()){
			if(dateIndex==count){
				lowerbound=sum;
				sum=sum+fieldLenIter.next();
				upperbound=sum;
				
			}
			else{
				sum=sum+fieldLenIter.next();
				
			}
			count++;
			
		}
		System.out.println("Upperbound: "+upperbound+"  Lowerbound: "+lowerbound);
		
		for(int i=0;i<maxDocs;i++){
			DatewiseRecord dr = new DatewiseRecord();
			recId = i;
			record="";
			record = search.getRecordById(recId, indexDir);
			//System.out.println("Record in datewise record method: "+record);
			dateStr = record.substring(lowerbound, upperbound);
			
			if(dateStr.startsWith("[")|| dateStr.startsWith("]") || dateStr.startsWith("\\") || dateStr.startsWith(":") || dateStr.startsWith("-") ){
				dateStr = dateStr.substring(1).toString().trim();
			}
			
			if(dateStr.endsWith("[")|| dateStr.endsWith("]") || dateStr.endsWith("\\") || dateStr.endsWith(":") || dateStr.endsWith("-") ){
				dateStr = dateStr.substring(0, dateStr.length()-1);
			}
			//System.out.println("DateStr: "+dateStr);
			Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.ENGLISH).parse(dateStr);
			/*String date1 = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(date);
			Date d1 = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss", Locale.ENGLISH).parse(date1);*/
			//System.out.println("Date: "+date.toString());
			dr.setDateOfEvent(date);
			dr.setEvent(record);
			drList.add(dr);
		}
		return drList;
		
	
	}
}
