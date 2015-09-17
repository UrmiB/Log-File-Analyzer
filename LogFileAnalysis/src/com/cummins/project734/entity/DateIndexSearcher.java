package com.cummins.project734.entity;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DateIndexSearcher {


	public int dateIndexSearcher()
	{
		int dateIndex = -1;

		try{
			FileInputStream fstream = new FileInputStream("C:\\morefiles\\error1.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String strLine="";
			String trial = "Sat Jan 27 12:14:20 2011";


			strLine=br.readLine();
			List<String> dateList = new ArrayList<String>();

			dateList.add(strLine.substring(1, 25).trim());
			dateList.add(strLine.substring(28, 40).trim());
			dateList.add(strLine.substring(42, strLine.length()).trim());
			Iterator dateIterator = dateList.iterator();


			while(dateIterator.hasNext()){

				String fieldVal = (String) dateIterator.next();
				System.out.println("\nFieldVal: "+fieldVal);
				if(fieldVal.matches("^(\\[)?(Mon(day)?|Tue(day)?|Wed(nesday)?|Thur(sday)?|Fri(day)?|Sat(urday)?|Sun(day)?) (Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|June?|July?|Aug(ust)?|Sep(t(ember)?)?|Oct(ober)?|Nov(ember)?|Dec(ember)?) (0?[1-9]|[12][0-9]|3[01]) ([01]?[0-9]|2[0-3])(:[0-5][0-9])* ((19|20)\\d\\d)(\\])?$")){
					System.out.println("Trial success. Index of date field: "+dateList.indexOf(fieldVal));
					dateIndex = dateList.indexOf(fieldVal);
				}
				else{
					System.out.println("Trial failure.");
				}
			}





			in.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		return dateIndex;
	}
	
	public int dateIndexSearcher(String record,List<Integer> fieldLenArray)
	{
		int dateIndex = -1;
		Integer sum = 0;
		int lowerbound = 0 ;
		int upperbound = 0 ;
		String fieldVal = "";
		try{
			
			String strLine= record;
		//	String trial = "Sat Jan 27 12:14:20 2011";


			
			List<String> dateList = new ArrayList<String>();
			
			Iterator fieldLenIter = fieldLenArray.iterator();
			
			while(fieldLenIter.hasNext()){
				int temp = (Integer) fieldLenIter.next();
				lowerbound=sum;
				sum=sum+temp;
				upperbound=sum;
				dateList.add(strLine.substring(lowerbound, upperbound));
			}
			dateList.add(strLine.substring(sum, strLine.length()));
		//	System.out.println();
			/*dateList.add(strLine.substring(1, 25).trim());
			dateList.add(strLine.substring(28, 40).trim());
			dateList.add(strLine.substring(42, strLine.length()).trim());*/
			Iterator dateIterator = dateList.iterator();

			int count = 0;
			while(dateIterator.hasNext()){
				
				fieldVal = (String) dateIterator.next().toString().trim();
			//	System.out.println("\nFieldVal: "+fieldVal);
				if(fieldVal.matches("^(\\[)?(Mon(day)?|Tue(day)?|Wed(nesday)?|Thur(sday)?|Fri(day)?|Sat(urday)?|Sun(day)?) (Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|June?|July?|Aug(ust)?|Sep(t(ember)?)?|Oct(ober)?|Nov(ember)?|Dec(ember)?) (0?[1-9]|[12][0-9]|3[01]) ([01]?[0-9]|2[0-3])(:[0-5][0-9])* ((19|20)\\d\\d)(\\])?$")){
				//System.out.println("Trial success. Index of date field: "+count);
					dateIndex = count;
				}
				else{
					System.out.println("Trial failure.");
				}
				fieldVal = "";
				count++;
			}


		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		return dateIndex;
	}
}
