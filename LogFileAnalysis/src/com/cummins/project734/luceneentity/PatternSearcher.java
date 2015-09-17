package com.cummins.project734.luceneentity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.cummins.project734.entity.AnalysisData;
import com.cummins.project734.entity.ErrorInformation;
import com.cummins.project734.entity.ErrorRelevantRecordsList;
import com.cummins.project734.entity.JaccardCoefficient;
import com.cummins.project734.entity.SearchResult;

public class PatternSearcher {

	public ArrayList<ArrayList<ArrayList<String>>> searchPattern(AnalysisData analysis,List<Integer> fieldLenArray,String userName,String fileName) throws Exception{
		File indexDir = new File("C:\\User_Directories\\"+userName+"\\Index\\"+fileName);
		ErrorRelevantRecordsList relevantRecordList = new ErrorRelevantRecordsList();

		List<ArrayList> errorRecList = new ArrayList<ArrayList>();
		List searchResultList = new ArrayList<String>();
		List docIdList = new ArrayList<Integer>();
		SearchIndex search = new SearchIndex();
		Integer lineNo = 0;
		Integer recId = 0;
		int noPreRec = 4;
		//No. of records 
		int upper = 4;
		//Toal no. of records in the indexed file
		int maxDocs = 0;
		String record = "";
		String queryStr = "error*";
		SearchResult searchResult = new SearchResult();
		System.out.println("\n\nInside Pattern Searcher searchPattern: ");
		searchResult = search.searchIndex(indexDir, queryStr, 1000);
		maxDocs = searchResult.getMaxDocs();
		searchResultList = searchResult.getRecords();
		docIdList = searchResult.getDocIds();

		Iterator recIterator = searchResultList.iterator();
		Iterator idIter = docIdList.iterator();

		while(recIterator.hasNext()){
			List<String>  errorRelRecords = new ArrayList<String>();
			errorRelRecords.add((String) recIterator.next());
			//	System.out.println("\n\nerrorRelRecords before addition of other records: "+errorRelRecords);
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
			//		System.out.println("RecId: "+recId+"  i: "+i+"  lineNo+ "+lineNo+"  upper: "+upper);
					if(recId==lineNo){
						i = upper;
				//		System.out.println("RecId: "+recId+"  i: "+i+"  lineNo+ "+lineNo+"  upper: "+upper);
					}
					if(i<maxDocs){
						try {
							record = search.getRecordById(recId, indexDir);
					//		System.out.println("\nRecord: "+record );
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}


						errorRelRecords.add(record);
						recId++;
					}
				}
			}
			//System.out.println("errorRelRecords: "+errorRelRecords);
			errorRecList.add((ArrayList<String>) errorRelRecords);

		}

		for(int j=0;j<5;j++){
			//System.out.println("\n\nArrayList of ArrayList : "+errorRecList.get(j));	
		}

		List<ArrayList<ArrayList<String>>> segregatedList = new ArrayList<ArrayList<ArrayList<String>>>();
		segregatedList = segregateLists(errorRecList,analysis);

		JaccardsCoefficient jc = new JaccardsCoefficient();
		ArrayList<ArrayList<ArrayList<JaccardCoefficient>>> jcoeffWholeList = new ArrayList<ArrayList<ArrayList<JaccardCoefficient>>>();
		jcoeffWholeList = jc.calculateJaccardCoefficient(segregatedList,fieldLenArray,noPreRec);

		//displayJCList(jcoeffWholeList);
		ArrayList<ArrayList<ArrayList<String>>> allImportantRecords = new ArrayList<ArrayList<ArrayList<String>>>();
		allImportantRecords = analyzeJaccardCoefficient(jcoeffWholeList,segregatedList);
		return allImportantRecords;
	}

	private ArrayList<ArrayList<ArrayList<String>>> analyzeJaccardCoefficient(
			ArrayList<ArrayList<ArrayList<JaccardCoefficient>>> jcoeffWholeList, List<ArrayList<ArrayList<String>>> segregatedList) {
		// TODO Auto-generated method stub

		double threshold = 0.6;
		int i = 0;
		int j = 0;
		int listno = 0;
		int count = 0;
		int flag = 0;
		ArrayList<ArrayList<JaccardCoefficient>> oneTypeList = new ArrayList<ArrayList<JaccardCoefficient>>();
		ArrayList<JaccardCoefficient> actualList = new ArrayList<JaccardCoefficient>();
		ArrayList<ArrayList<ArrayList<String>>> allImportantRecords = new ArrayList<ArrayList<ArrayList<String>>>();
		Iterator wholeIter = jcoeffWholeList.iterator();
		
		System.out.println("\n\nInside analyzeJaccardCoefficient: ");
		while(wholeIter.hasNext()){
			listno = count;
			System.out.println("listno: "+listno);
			oneTypeList  = (ArrayList<ArrayList<JaccardCoefficient>>) wholeIter.next();

			Iterator oneIter = oneTypeList.iterator();
			System.out.println("\nI  J  Val");
			List<ArrayList<String>> impRec = new ArrayList<ArrayList<String>>();
			while(oneIter.hasNext()){

				actualList = (ArrayList<JaccardCoefficient>) oneIter.next();

				Iterator actualIter = actualList.iterator();
				List<Integer> addedRecordIndices = new ArrayList<Integer>();
				while(actualIter.hasNext()){
					flag=0;
					JaccardCoefficient jc = new JaccardCoefficient();
					jc = (JaccardCoefficient) actualIter.next();
					double coeff = jc.getCoefficientVal();
					
					if(coeff>=threshold){
						System.out.println("\nCoefficient: "+coeff);
						i = jc.getI();
						j = jc.getJ();

						Iterator addedIter = addedRecordIndices.iterator();
						while(addedIter.hasNext()){
							int k = (Integer) addedIter.next();
							if(i==k){
								flag=1;
							}
							if(j==k){
								flag=2;
							}
						}
						if(flag!=1 || flag!=2){
							if(flag!=1){
								impRec.add(segregatedList.get(count).get(i));
							//	System.out.println("imprec for i="+i+":  "+segregatedList.get(count).get(i));
							}
							if(flag!=2){
								impRec.add(segregatedList.get(count).get(j));
							//	System.out.println("imprec for j="+j+":  "+segregatedList.get(count).get(j));
							}
						}
					}

					//System.out.println("\n"+jc.getI()+"  "+jc.getJ()+"  "+jc.getCoefficientVal());
				}
				allImportantRecords.add((ArrayList<ArrayList<String>>) impRec);
			}
			count++;
		}
	//	System.out.println("allImportantRecords: "+allImportantRecords);
		return allImportantRecords;
	}

	private void displayJCList(
			ArrayList<ArrayList<ArrayList<JaccardCoefficient>>> jcoeffWholeList) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<JaccardCoefficient>> oneTypeList = new ArrayList<ArrayList<JaccardCoefficient>>();
		ArrayList<JaccardCoefficient> actualList = new ArrayList<JaccardCoefficient>();


		Iterator wholeIter = jcoeffWholeList.iterator();
		while(wholeIter.hasNext()){

			oneTypeList  = (ArrayList<ArrayList<JaccardCoefficient>>) wholeIter.next();
			Iterator oneIter = oneTypeList.iterator();
			System.out.println("\nI  J  Val");
			while(oneIter.hasNext()){

				actualList = (ArrayList<JaccardCoefficient>) oneIter.next();

				Iterator actualIter = actualList.iterator();

				while(actualIter.hasNext()){
					JaccardCoefficient jc = new JaccardCoefficient();
					jc = (JaccardCoefficient) actualIter.next();
					System.out.println("\n"+jc.getI()+"  "+jc.getJ()+"  "+jc.getCoefficientVal());
				}

			}
		}



	}

	private List<ArrayList<ArrayList<String>>> segregateLists(List<ArrayList> errorRecList, AnalysisData analysis) {

		List<ArrayList<ArrayList<String>>> segregatedList = new ArrayList<ArrayList<ArrayList<String>>>();
		List<String> tempLinkedList = new LinkedList<String>();
		String record = new String();
		int flag = 0;
		int count=0;
		int x=0;

		List<String> errorTypes = new ArrayList<String>();
		List<ErrorInformation> eInfo = new ArrayList<ErrorInformation>();
		eInfo = analysis.getErrorInfo();
		Iterator eInfoIter = eInfo.iterator();

		Integer eNo = eInfo.size();
		List<ArrayList<String>> errorTypeList = new ArrayList<ArrayList<String>>();

		while(eInfoIter.hasNext()){

			Iterator<ArrayList> erlIterator = errorRecList.iterator();
			List<ArrayList<String>> oneTypeList = new ArrayList<ArrayList<String>>();

			ErrorInformation type = (ErrorInformation) eInfoIter.next();
			while(erlIterator.hasNext()){
				tempLinkedList = erlIterator.next();
				Iterator<String> tllIterator = tempLinkedList.iterator();
				record = tllIterator.next();
				int j=0;
				String [] splitErrorRecord = record.toString().split(" ");
				//	System.out.println("\nSplit String: "+splitErrorRecord[5]+"  "+splitErrorRecord.length);
				for(int i=0;i<splitErrorRecord.length;i++){
					//System.out.println("splitErrorRecord[i]+ "+splitErrorRecord[i]);
					if(splitErrorRecord[i].toString().trim().equalsIgnoreCase("[error".toString().trim())){
						j=i+1;
						if(splitErrorRecord[j].toString().equals(type.getErrorType().toString().trim())){
							oneTypeList.add((ArrayList<String>) tempLinkedList);

						}
					}

				}

			}
			//	System.out.println("OneTypeList: "+oneTypeList.get(0)+"  No of elements: "+oneTypeList.size());
			segregatedList.add((ArrayList<ArrayList<String>>) oneTypeList);
			//System.out.println("Segregated list: "+segregatedList);
			// TODO Auto-generated method stub

		}	
		return segregatedList;
	}

}
