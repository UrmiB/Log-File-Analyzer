package com.cummins.project734.entity;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
	private int frequency;
	private List<String> records = new ArrayList<String>();
	private List<Integer> docIds = new ArrayList<Integer>();
	private int maxDocs;
	
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public List<String> getRecords() {
		return records;
	}
	public void setRecords(List<String> records) {
		this.records = records;
	}
	public void setDocIds(List<Integer> docIds) {
		this.docIds = docIds;
	}
	public List<Integer> getDocIds() {
		return docIds;
	}
	public void setMaxDocs(int maxDocs) {
		this.maxDocs = maxDocs;
	}
	public int getMaxDocs() {
		return maxDocs;
	}
	
}
