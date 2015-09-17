package com.cummins.project734.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TimelineRecords {
	
	public ArrayList<ArrayList<DatewiseRecord>> TimelineDateRecords(AnalysisData analysis) throws ParseException{
		
		List<DatewiseRecord>  DateList = new ArrayList<DatewiseRecord>();
		DateList = (ArrayList<DatewiseRecord>) analysis.getDatewiseRecords();
		DatewiseRecord dr = new DatewiseRecord();
		Iterator<DatewiseRecord> itd = DateList.iterator();
		
		ArrayList<ArrayList<DatewiseRecord>> MainList = new ArrayList<ArrayList<DatewiseRecord>>();
		List<DatewiseRecord> List1 = new  ArrayList<DatewiseRecord>();
		
		Date date;
		System.out.println("IN TIMELINE RECORDS: ");
		while(itd.hasNext())
		{
			dr = itd.next();
			date = dr.getDateOfEvent();
			//DateFormat inputFormatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
			//Date date1 = inputFormatter.parse(date);

			DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
			String output = outputFormatter.format(date);
			Date date2 = outputFormatter.parse(output);
			//System.out.println("DATE output: "+date2);
			if(List1.isEmpty())
			{
				List1.add(dr);
			}
			else
			{
				DateFormat outputFormatter1 = new SimpleDateFormat("MM/dd/yyyy");
				String output1 = outputFormatter1.format(List1.get(0).getDateOfEvent());
				Date date3 = outputFormatter.parse(output1);
				if(date2.equals(date3))
				{
					List1.add(dr);
				}
				else
				{
					/*Iterator lIter = List1.iterator();
					System.out.println("\n\n");
					while(lIter.hasNext()){
						DatewiseRecord dRec = new DatewiseRecord();
						dRec = (DatewiseRecord) lIter.next();
						System.out.println("DRec date: "+dRec.getDateOfEvent()+" DRec event: "+dRec.getEvent());
					}*/
					MainList.add((ArrayList<DatewiseRecord>) List1);
					List1 = new ArrayList<DatewiseRecord>();
					List1.add(dr);
				}
			}
		//	System.out.println("List: "+List1);
		}
		MainList.add((ArrayList<DatewiseRecord>) List1);
		/*Iterator mIter = MainList.iterator();
		System.out.println("\n\n");
		while(mIter.hasNext()){
			int count =0;
			ArrayList<DatewiseRecord> li = new ArrayList<DatewiseRecord>();
			li = (ArrayList<DatewiseRecord>) mIter.next();
			Iterator lt = li.iterator();
			System.out.println("\n");
			while(lt.hasNext())
			{
				DatewiseRecord dRec = new DatewiseRecord();
				dRec = (DatewiseRecord) lt.next();
				System.out.println("DRec date: "+dRec.getDateOfEvent()+" DRec event: "+dRec.getEvent());
				count++;
			}
			System.out.println("Count: "+count);
		}*/
		return MainList;
    }
	
}

