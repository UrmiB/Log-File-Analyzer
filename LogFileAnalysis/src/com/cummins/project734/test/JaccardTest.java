package com.cummins.project734.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cummins.project734.entity.DateIndexSearcher;
import com.cummins.project734.luceneentity.JaccardsCoefficient;

public class JaccardTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			int noPreRec = 2;
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			int count4 = 0;
			int i=0;
			int j=0;
			int k=0;
			
			String line1 = "";
			String line2 = "";

			ArrayList<String> individualRecord = new ArrayList<String>();
			List<ArrayList<ArrayList<String>>> segregatedList = null;
			count1 = segregatedList.size();
			for(i=0;i<count1;i++){
				
				ArrayList<ArrayList<String>> listOneErrorType = new ArrayList<ArrayList<String>>();
				listOneErrorType = (ArrayList<ArrayList<String>>) segregatedList.get(i);
				count2 = listOneErrorType.size();
				for(j=0;j<count2;j++){
						List<String> actualRecords1  = new ArrayList<String>();
						actualRecords1 = listOneErrorType.get(j);
						count3 = actualRecords1.size();
					for(k=1;j<count2;k++){
						List<String> actualRecords2  = new ArrayList<String>();
						actualRecords2 = listOneErrorType.get(k);
						count4 = actualRecords2.size();
						if(count3<3 || count4<3){
							
						}
						else{
							for(int l=0;l<noPreRec;l++){
								for(int m=0;m<noPreRec;m++){
									if(m!=(noPreRec-1)){
										line1 = actualRecords1.get(l);
										line2 = actualRecords2.get(m);
										
										System.out.println("LineX: "+line1+"  LineY: "+line2);
										DateIndexSearcher dis = new DateIndexSearcher();
										line1 = line1.substring(26, line1.length());
										line2 = line2.substring(26, line2.length());
										String [] x = line1.split(" ");

										//System.out.println("X in main: "+x[0]+" "+x[1]);
										String [] y = line2.split(" ");

									

										/*br1.close();
										br2.close();*/
										System.out.println("Line1: "+line1+"  Line2: "+line2);
										JaccardsCoefficient jc = new JaccardsCoefficient();
									}
								}
							}
						}
					}
				}
				
			}
			
			
			
			
			//int index = dis.dateIndexSearcher("[Mon Apr 25 14:57:43 2011] [notice] Child 540: Starting thread to listen on port 443.");
			//System.out.println("Index: "+index);
			
			
			//double coeff = jc.similarity(x, y,index);
			//System.out.println("Coefficient: "+coeff);

	}

}
