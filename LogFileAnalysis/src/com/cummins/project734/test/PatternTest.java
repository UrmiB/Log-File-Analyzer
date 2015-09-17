package com.cummins.project734.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cummins.project734.entity.ErrorRelevantRecordsList;
import com.cummins.project734.entity.SearchResult;
import com.cummins.project734.luceneentity.JaccardsCoefficient;
import com.cummins.project734.luceneentity.SearchIndex;

public class PatternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String userName = "Urmi";
			String fileName = "error4.txt";
			File indexDir = new File("C:\\User_Directories\\"+userName+"\\"+fileName);
			ErrorRelevantRecordsList relevantRecordList = new ErrorRelevantRecordsList();
			List<Integer> fieldLenArray = new ArrayList<Integer>();
			fieldLenArray.add(27);
			fieldLenArray.add(13);
			
			List<ArrayList> errorRecList = new ArrayList<ArrayList>();
			List searchResultList = new ArrayList<String>();
			List docIdList = new ArrayList<Integer>();
			SearchIndex search = new SearchIndex();
			Integer lineNo = 0;
			Integer recId = 0;
			//No. of records 
			int upper = 4;
			//Toal no. of records in the indexed file
			int maxDocs = 0;
			String record = "";
			String queryStr = "error*";
			SearchResult searchResult = new SearchResult();
			try {
				searchResult = search.searchIndex(indexDir, queryStr, 1000);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			maxDocs = searchResult.getMaxDocs();
			searchResultList = searchResult.getRecords();
			docIdList = searchResult.getDocIds();

			System.out.println("searchResultList: "+searchResultList);
			System.out.println("docIdList: "+ docIdList);
			
			Iterator recIterator = searchResultList.iterator();
			Iterator idIter = docIdList.iterator();

			while(recIterator.hasNext()){
				List<String>  errorRelRecords = new ArrayList<String>();
				errorRelRecords.add((String) recIterator.next());
				lineNo = (Integer) idIter.next();
				if(lineNo==0){
					upper = 0;
				}
				else if(lineNo==1){
					recId = lineNo -1;
					upper = 1;
				}
				else if(lineNo==2){
					recId = lineNo-2;
					upper = 2;
				}
				else if(lineNo ==3){
					recId = lineNo-3;
					upper = 3;
				}
				else{
					recId = lineNo - 4;	
					upper = 4;
				}
			
				for(int i=0;i<upper;i++){
					if(i<maxDocs){
						System.out.println("RecId: "+recId+"  i: "+i+"  lineNo+ "+lineNo+"  upper: "+upper);
						if(recId==lineNo){
							i = upper;
							System.out.println("RecId: "+recId+"  i: "+i+"  lineNo+ "+lineNo+"  upper: "+upper);
						}
						if(i<maxDocs){
							try {
								record = search.getRecordById(recId, indexDir);
								System.out.println("\nRecord: "+record );
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}


							errorRelRecords.add(record);
							recId++;
						}
					}
				}
				System.out.println("errorRelRecords: "+errorRelRecords);
				errorRecList.add((ArrayList<String>) errorRelRecords);

			}

			for(int j=0;j<5;j++){
				//System.out.println("\n\nArrayList of ArrayList : "+errorRecList.get(j));	
			}

			
		}


}
