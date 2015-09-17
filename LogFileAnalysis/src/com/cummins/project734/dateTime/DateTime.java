package com.cummins.project734.dateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DateTime 
{
	public String[] dateTime1() throws IOException {

		FileInputStream date1 = new FileInputStream("C:\\morefiles\\error1.txt");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(date1));
		String line1 = br1.readLine();
		String[] str = {"",""};
		if(line1.substring(1,25) != null)
		{
			String s2 = line1.substring(1,25);
			str[0] = s2;
			System.out.println("Earliest Record: "+s2);
		}
		
		String strLine = null, tmp;
		while ((tmp = br1.readLine()) != null)
		{
			strLine = tmp;
		}

		String lastLine = strLine;

		if(lastLine.substring(1,25) != null)
		{
			String s3 = lastLine.substring(1,25);
			System.out.println("Latest Record: "+s3);
			str[1] = s3;
		}
		br1.close();
		return str;
		
		
	}
}

