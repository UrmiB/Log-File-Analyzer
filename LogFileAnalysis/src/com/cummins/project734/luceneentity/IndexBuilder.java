package com.cummins.project734.luceneentity;


import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;



public class IndexBuilder {


	public void buildIndex(String filePath,String fileName, List<Integer> fieldLen,String UserN) throws IOException {
		// TODO Auto-generated method stub
			
		System.out.println("\nInside IndexBuilder: ");
		String tempName = new StringBuffer(filePath).reverse().toString();
		String [] buffer = tempName.split("\\\\");
		tempName = "";
		for(int i=1;i<=buffer.length;i++){
			if(i<buffer.length){
				//System.out.println("Split string: "+buffer[i]);
				if(i!=1){
					buffer[i] = "\\".concat(buffer[i]);
				}
				tempName = new StringBuffer(tempName.concat(buffer[i])).toString();
				//System.out.println("tempName in loop i="+i+" : "+tempName);
			}
		}
		filePath = new StringBuffer(tempName).reverse().toString();
		System.out.println("FilePath in IndexBuilder: "+filePath);
		File   fileDir  = new File(filePath);
		
		System.out.println("FileDir after manipulation shit: "+fileDir.getName());
		System.out.println("FileName after manipulation shit: "+fileName);
	
		
		
		System.out.println("FileName in IndexBuilder: "+fileName);
		//indexDir is the directory that hosts Lucene's index files
		Directory indexDir = null;
		try {
			indexDir = FSDirectory.open(new File( "c:\\User_Directories\\" + UserN+"\\Index\\"+fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//File  indexDir = new File("C:\\luceneIndex");
		Analyzer luceneAnalyzer = new StandardAnalyzer(Version.LUCENE_40);
		IndexWriterConfig conf = new IndexWriterConfig(null, luceneAnalyzer).setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
		IndexWriter indexWriter = new IndexWriter(indexDir,conf);


		File[] textFiles  = fileDir.listFiles();

		System.out.println("Files: "+fileDir.getName());
		System.out.println("Files: "+fileDir.getName()+ " length: "+fileDir.exists());
		long startTime = new Date().getTime();

		//Add documents to the index
		for(int i = 0; i < textFiles.length; i++){
			System.out.println("Loop: "+i);
			//if(textFiles[i].isFile() && textFiles[i].getName().endsWith(".txt")){
			if(textFiles[i].getName().toString().equalsIgnoreCase(fileName)){
				System.out.println("File " + textFiles[i].getCanonicalPath() 
						+ " is being indexed");
				String file = textFiles[i].toString();
				Reader textReader = new FileReader(textFiles[i]);
				BufferedReader br = new BufferedReader(textReader);
				String line = "";
				int totalLen = 0;
				int k=0;
				int j=1;

				String temp = "";
				while((line=br.readLine())!=null){

					List<String> tokenizedLine = new ArrayList<String>();

					if(line.length()>0){
						//	System.out.println("Array: 0:"+fieldLen[0]+" 1:"+fieldLen[1]+" 2:"+fieldLen[2]+" 3: "+fieldLen[3]+" 4:"+fieldLen[4] );
						//System.out.println("Record: "+line+" Length: "+line.length());
						int length = 0;
						Iterator it = fieldLen.iterator();

						while(it.hasNext()){
							//System.out.println("Iteration no: "+j);
							length = (Integer) it.next();
							//System.out.println("TotalLen: "+totalLen+" TotalLen+fieldLen: "+(totalLen+length));
							temp = line.substring(totalLen, totalLen+length);

							//System.out.println("Temp: "+temp);
							totalLen = totalLen+length;
							tokenizedLine.add(temp.trim());
							//System.out.println("Tokenized line,location "+k+": "+tokenizedLine);
							temp="";
							j++;
						}
						temp = line.substring(totalLen, line.length());
						//System.out.println("Temp: "+temp);
						tokenizedLine.add(temp.trim());
						totalLen =0;
						k=0;
						Document document = new Document();
						FieldType ft  = new FieldType();

						ft.setIndexed(true);
						//ft.tokenized();
						ft.setTokenized(true);

						Iterator<String> iToken = tokenizedLine.iterator();
						j=1;
						while(iToken.hasNext()){
							//System.out.println("Field after tokenization: "+iToken.next());

							/*Reader readRec = new StringReader(iToken.next());
						BufferedReader br1 = new BufferedReader(readRec);
						System.out.println("After tokenization: Field "+j+": "+br.readLine());*/
							document.add(new Field("Field "+j, iToken.next(), ft));
							j++;

						}
						document.add(new TextField("contents",line, Field.Store.YES));
						document.add(new StringField("path",textFiles[i].getCanonicalPath(), Field.Store.YES));
						//System.out.println(""+document);
						indexWriter.addDocument(document);
					}

				}

				// indexWriter.optimize();
				indexWriter.close();
				indexDir.close();
				long endTime = new Date().getTime();

				System.out.println("It took " + (endTime - startTime) 
						+ " milliseconds to create an index for the files in the directory "
						+ fileDir.getPath());
				//}
			}
		}

	}
}