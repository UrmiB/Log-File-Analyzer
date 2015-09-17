package com.cummins.project734.fileHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cummins.project734.entity.DateIndexSearcher;
import com.cummins.project734.entity.JaccardCoefficient;
import com.sun.xml.internal.ws.api.pipe.NextAction;

public class SavePattern {
	public void saveImportantPattern(List<ArrayList<ArrayList<String>>> allImportantRecords,List<Integer> fieldLenArray, String userName, String filename){

		ArrayList<ArrayList<String>> oneTypeList = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> listNonOne = new ArrayList<ArrayList<String>>();
		ArrayList<String> actualList = new ArrayList<String>();
		String errorRecord = "";
		int count=0;
		int flag=0;
		int flag1=0;
		int index = 0;
		int lowerbound = 0 ;
		int upperbound = 27 ;
		String record = "";
		int initialCnt = 0;
		Iterator allIter = allImportantRecords.iterator();
		List <String> errorList = new ArrayList<String>();
		System.out.println("\n\nInside savePattern: ");
		while(allIter.hasNext()){


			oneTypeList  = (ArrayList<ArrayList<String>>) allIter.next();
			if(!oneTypeList.isEmpty()){
				Iterator oneIter = oneTypeList.iterator();
				List <String> nonRepeatingRec = new ArrayList<String>();
				while(oneIter.hasNext()){

					actualList = (ArrayList<String>) oneIter.next();
					if(!actualList.isEmpty()){
						Iterator actualIter = actualList.iterator();
						count=0;
						while(actualIter.hasNext()){
							flag=0;
							if(count==0){
								flag1 = 0;
								errorRecord = actualIter.next().toString();
								if(errorRecord.isEmpty()){

								}
								else{

									errorRecord = errorRecord.substring(upperbound,errorRecord.length());
									if(errorList.isEmpty()){
										errorList.add(errorRecord);	
									}
									else{
										Iterator errorIter = errorList.iterator();
										while(errorIter.hasNext()){
											String rec = errorIter.next().toString();
											if(errorRecord.equalsIgnoreCase(rec)){
												flag1 = 1;
											//	System.out.println("errorRecord: "+errorRecord+"  flag1: "+flag1);
											}

										}
										if(flag1!=1){
											errorList.add(errorRecord);
										}
									}

								}
								count++;
							}
							else{
								String nextRecord = "";
								nextRecord = (String) actualIter.next();
								if(flag1!=1){
									if(nextRecord==errorRecord){

									}
									else{
										//System.out.println("nextRecord: "+nextRecord);
										if(!nextRecord.isEmpty() && !(nextRecord==null)){
											nextRecord = nextRecord.substring(upperbound,nextRecord.length()).toString();
											//System.out.println("nextRecord: "+nextRecord);
										}
										if(nextRecord==null){
										}
										else{
											if(nonRepeatingRec==null){
												nonRepeatingRec.add((nextRecord));
											}
											else{
												Iterator nrIter = nonRepeatingRec.iterator();
												while(nrIter.hasNext()){
													if(nextRecord.equalsIgnoreCase(nrIter.next().toString())){
														flag=1;
													}
												}
												if(flag==0){
													nonRepeatingRec.add(nextRecord);
												}
											}
										}
									}
								}
								count++;
							//	System.out.println("Count: "+count);	
							}


						}
					}
					if(flag1!=1){
						nonRepeatingRec.add(errorRecord);


						if(nonRepeatingRec!=null){
							//listNonOne.add((ArrayList<String>) nonRepeatingRec);

							FileOutputStream fop = null;
							File file;


							try {


								File user_dir = new File("c:\\User_Directories\\"+userName+"\\Patterns\\");

								// create directory, if the directory does not exist
								if (!user_dir.exists())
								{
									System.out.println("Creating Directory: " + user_dir.getName());
									boolean result = user_dir.mkdir();  
									System.out.println("Result: "+result);
									if(result)
									{    
										System.out.println("New Directory Created");  
									}
									else
									{
										System.out.println("Error while creating directory.");
									}
								}
								else
								{
									System.out.println("Directory already exists.");
								}

								File user_dir1 = new File("c:\\User_Directories\\"+userName+"\\Patterns\\"+filename);

								// create directory, if the directory does not exist
								if (!user_dir1.exists())
								{
									System.out.println("Creating Directory: " + user_dir.getName());
									boolean result = user_dir1.mkdir();  
									System.out.println("Result: "+result);
									if(result)
									{    
										System.out.println("New Directory Created");  
									}
									else
									{
										System.out.println("Error while creating directory.");
									}
								}
								else
								{
									System.out.println("Directory already exists.");
								}


								file = new File("c:\\User_Directories\\"+userName+"\\Patterns\\"+filename+"\\pattern.txt");
								fop = new FileOutputStream(file,true);

								// if file doesnt exists, then create it
								if (!file.exists()) {
									file.createNewFile();
								}

								// get the content in bytes
								Iterator<String> liIterator = nonRepeatingRec.iterator();
								fop.write(System.getProperty("line.separator").getBytes());
								while(liIterator.hasNext()){
									byte[] contentInBytes = liIterator.next().toString().concat("\n").getBytes();
									fop.write(contentInBytes);
									fop.write(System.getProperty("line.separator").getBytes());
								}
								fop.flush();
								fop.close();

								System.out.println("Done");

							} catch (IOException e) {
								e.printStackTrace();
							} finally {
								try {
									if (fop != null) {
										fop.close();
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
						System.out.println("nonRepeatingRecord: "+nonRepeatingRec);
						System.out.println("listNonOne: "+listNonOne);

					}

				}

			}
		}
	}
}
