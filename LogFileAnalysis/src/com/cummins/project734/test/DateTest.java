package com.cummins.project734.test;

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fieldVal = "[Sat Jan 27 12:14:20 2011]";
		System.out.println("\nFieldVal: "+fieldVal);
		if(fieldVal.matches("^(\\[)?(Mon(day)?|Tue(day)?|Wed(nesday)?|Thur(sday)?|Fri(day)?|Sat(urday)?|Sun(day)?) (Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|June?|July?|Aug(ust)?|Sep(t(ember)?)?|Oct(ober)?|Nov(ember)?|Dec(ember)?) (0?[1-9]|[12][0-9]|3[01]) ([01]?[0-9]|2[0-3])(:[0-5][0-9])* ((19|20)\\d\\d)(\\])?$")){
			System.out.println("Trial success.");
			
		}
		else{
			System.out.println("Trial failure.");
		}
	}

}
