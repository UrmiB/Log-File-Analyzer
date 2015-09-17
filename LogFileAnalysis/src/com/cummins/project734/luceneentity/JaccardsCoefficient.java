package com.cummins.project734.luceneentity;

import java.util.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.cummins.project734.entity.DateIndexSearcher;
import com.cummins.project734.entity.JaccardCoefficient;


public class JaccardsCoefficient implements Similarity {

	public ArrayList<ArrayList<ArrayList<JaccardCoefficient>>> calculateJaccardCoefficient(List<ArrayList<ArrayList<String>>> segregatedList, List<Integer> fieldLenArray, int noPreRec) {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int i=0;
		int j=0;
		int k=0;
		int index = 0;
		String line1 = "";
		String line2 = "";

		System.out.println("\nInside JaccardsCoefficient: ");
		
		if(segregatedList!=null){
			DateIndexSearcher dis = new DateIndexSearcher();
			//Get sample record for fetching date index
			String sample = segregatedList.get(0).get(0).get(0);
			index = dis.dateIndexSearcher(sample, fieldLenArray);
		}


		int noOffields = fieldLenArray.size();
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

		ArrayList<ArrayList<ArrayList<JaccardCoefficient>>> jcoeffWholeList = new ArrayList<ArrayList<ArrayList<JaccardCoefficient>>>();
		count1 = segregatedList.size();
		for(i=0;i<count1;i++){

			ArrayList<ArrayList<String>> listOneErrorType = new ArrayList<ArrayList<String>>();

			//Fetching a list of one type of error (which is a list of records preceding and succeeding the error)
			listOneErrorType = (ArrayList<ArrayList<String>>) segregatedList.get(i);
			count2 = listOneErrorType.size();
			ArrayList<ArrayList<JaccardCoefficient>> jcoeffOneTypeList = new ArrayList<ArrayList<JaccardCoefficient>>();
			for(j=0;j<count2;j++){
				//Actual list of records at index j of listOneErrorType

				List<String> actualRecords1  = new ArrayList<String>();
				actualRecords1 = listOneErrorType.get(j);
				count3 = actualRecords1.size();
				List<JaccardCoefficient> intermediateList = new ArrayList<JaccardCoefficient>();
				for(k=j+1;k<count2;k++){
					//Actual list of records at index j of listOneErrorType
					List<String> actualRecords2  = new ArrayList<String>();
					actualRecords2 = listOneErrorType.get(k);
					count4 = actualRecords2.size();
					//System.out.println("\nCount1,Count2,Count3,Count4: "+count1+","+count2+","+count3+","+count4);

					if(count3>1 && count4>1){
						line1 = "";
						line2 = "";
						for(int l=1;l<count3;l++){
							String x =  "";
							x = actualRecords1.get(l);
							x = x.substring(upperbound, x.length());
							line1 = line1.concat(x);


						}
						for(int m=1;m<count4;m++){
							String y = "";
							y = actualRecords2.get(m);
							y = y.substring(upperbound, y.length());
							line2 = line2.concat(y);

						}


						//	System.out.println("LineX: "+line1);
						//System.out.println("LineY: "+line2);

						String [] x = line1.split(" ");
						//System.out.println("X in main: "+x[0]+" "+x[1]);
						String [] y = line2.split(" ");


						//	System.out.println("Line1: "+line1);
						//	System.out.println("Line2: "+line2);
						JaccardsCoefficient jc = new JaccardsCoefficient();
						double coeff = jc.similarity(x, y,index);

						//	System.out.println("Coefficient: "+coeff);
						JaccardCoefficient jCoeff = new JaccardCoefficient();
						jCoeff.setI(j);
						jCoeff.setJ(k);
						jCoeff.setCoefficientVal(coeff);
						intermediateList.add(jCoeff);

					}

				}
					jcoeffOneTypeList.add((ArrayList<JaccardCoefficient>) intermediateList);
			}
			if(!jcoeffOneTypeList.isEmpty()){
				jcoeffWholeList.add(jcoeffOneTypeList);
			}
		}

		return jcoeffWholeList;
	}
	private static final long serialVersionUID = 1L;

	public double similarity(String[] x, String[] y, int index)
	{
		System.out.println("X: "+Arrays.asList(x)+"  Y: "+y);
		double similarity_coefficient = 0.0d;
		if ( (x!=null && y!=null) && (x.length>0 || y.length>0))
		{
			similarity_coefficient = similarity(Arrays.asList(x), Arrays.asList(y),index); 
		}
		else
		{
			throw new IllegalArgumentException("The arguments x and y must be not NULL and either x or y must be non-empty.");
		}

		return similarity_coefficient;
	}

	private double similarity(List<String> x, List<String> y,int index)
	{
		if( x.size() == 0 || y.size() == 0 )
		{
			return 0.0;
		}
		Set<String> unionXY = new HashSet<String>(x);
		unionXY.addAll(y);
		//System.out.println("Set unionXY: "+unionXY);

		Set<String> intersectionXY = new HashSet<String>(x);
		intersectionXY.retainAll(y);
		//System.out.println("Set intersectionXY: "+intersectionXY);
		//System.out.println("Size of intersection: "+intersectionXY.size()+" Size of union: "+unionXY.size());
		return (double) intersectionXY.size() / (double) unionXY.size(); 
	}
}