package com.cummins.project734.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.shingle.ShingleAnalyzerWrapper;
import org.apache.lucene.analysis.shingle.ShingleFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.util.AttributeSource;
import org.apache.lucene.util.AttributeSource.State;
import org.apache.lucene.util.Version;

public class ShingleFilterTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//String test = "[Tue Mar 08 15:27:51 2011] [notice] Child 3372: Child process is running"; 
		Reader textReader = new FileReader("C:\\morefiles\\error1.txt");
		BufferedReader br = new BufferedReader(textReader);
		int min =2;
		int max=2;
		
		/*SimpleAnalyzer simpleAnalyzer = new SimpleAnalyzer(Version.LUCENE_35);			
		ShingleAnalyzerWrapper shingleAnalyzer = new ShingleAnalyzerWrapper(simpleAnalyzer, min,max);
 
		TokenStream stream = shingleAnalyzer.tokenStream("contents", textReader);
		CharTermAttribute charTermAttribute = stream.getAttribute(CharTermAttribute.class);*/
		
		/*while (stream.incrementToken())
		{					
			System.out.println(charTermAttribute.toString());					
		}*/
 
		
		String line="";
		while((line=br.readLine())!=null){
			Tokenizer wsTokenizer = new WhitespaceTokenizer(Version.LUCENE_40, br); 
			ShingleFilter filter = new ShingleFilter(wsTokenizer, 2); 
			filter.setOutputUnigrams(false); 
			ShingleAnalyzerWrapper wrapper1 = new ShingleAnalyzerWrapper(new StandardAnalyzer(Version.LUCENE_40));
			CharTermAttribute termAtt = (CharTermAttribute) filter.getAttribute(CharTermAttribute.class); 
									
			while (filter.incrementToken())            
				System.out.println(termAtt.toString());
		}


	}

}
