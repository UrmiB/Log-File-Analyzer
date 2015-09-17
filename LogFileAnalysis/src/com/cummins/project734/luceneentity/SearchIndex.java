package com.cummins.project734.luceneentity;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Fields;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.lucene.index.FieldInfo;



import com.cummins.project734.entity.AnalysisData;
//import org.apache.lucene.search.Hits;
import com.cummins.project734.entity.SearchResult;

public class SearchIndex {
	
	public static final String FIELD_PATH = "path";
	public static final String FIELD_CONTENTS = "contents";
	

	
	public SearchResult searchIndex(File indexDir, String queryStr, int maxHits) 
	throws Exception {
		System.out.println("\nInside SearchIndex: ");
		Directory directory = FSDirectory.open(indexDir);
		IndexReader reader = IndexReader.open(directory);
		SearchResult result = new SearchResult();
		ArrayList<String> records = new ArrayList<String>();
		IndexSearcher searcher = new IndexSearcher(reader);
		ArrayList<Integer> docIds = new ArrayList<Integer>();
		
		QueryParser parser = new QueryParser(Version.LUCENE_40, 
				"contents", new StandardAnalyzer(Version.LUCENE_40));
		Query query = parser.parse(queryStr);

		TopDocs topDocs = searcher.search(query, maxHits);
		int maxDocs = getMaxDocuments(directory);
		result.setMaxDocs(maxDocs);
		ScoreDoc[] hits = topDocs.scoreDocs;
		for (int i = 0; i < hits.length; i++) {
			int docId = hits[i].doc;
			docIds.add(docId);
			Document d = searcher.doc(docId);
		//	System.out.println(d.get("path"));
		//	System.out.println(d.get("contents"));
			records.add(d.get("contents"));
		}

		//System.out.println("Found " + hits.length);

		result.setRecords(records);
		result.setDocIds(docIds);
		reader.close();
		directory.close();
		searcher.getIndexReader().close();
		result.setFrequency(hits.length);
		return result;

	}
	
	public String getRecordById(Integer id,File indexDir) throws IOException{
		String record = "";
		Directory directory = FSDirectory.open(indexDir);
		IndexReader reader = IndexReader.open(directory);
		IndexSearcher searcher = new IndexSearcher(reader);
		Document d = searcher.doc(id);
		record = d.get("contents");
		//System.out.println("\nRecord by id: "+record);
		return record;
	}

	public Integer getMaxDocuments(Directory directory) throws IOException{
		
		IndexReader reader = IndexReader.open(directory);
		Integer maxDocs = 0 ;
		maxDocs = reader.maxDoc();
		return maxDocs;
		
	}

}
