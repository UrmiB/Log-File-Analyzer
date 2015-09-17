package com.cummins.project734.entity;

import java.util.ArrayList;
import java.util.List;

public class AnalysisData {
	private int frequency;
	private float percentage;
	private int totalNoOfRecords;
	private List<ErrorInformation> errorInfo;
	private List<DatewiseRecord> datewiseRecords;
	
	public AnalysisData(){
		frequency = 0;
		percentage = 0.0f;
		totalNoOfRecords = 0;
		setErrorInfo(new ArrayList<ErrorInformation>());
	}
	
	public int getTotalNoOfRecords() {
		return totalNoOfRecords;
	}
	public void setTotalNoOfRecords(int totalNoOfRecords) {
		this.totalNoOfRecords = totalNoOfRecords;
	}
	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void setErrorInfo(List<ErrorInformation> errorInfo) {
		this.errorInfo = errorInfo;
	}

	public List<ErrorInformation> getErrorInfo() {
		return errorInfo;
	}

	public void setDatewiseRecords(List<DatewiseRecord> datewiseRecords) {
		this.datewiseRecords = datewiseRecords;
	}

	public List<DatewiseRecord> getDatewiseRecords() {
		return datewiseRecords;
	}
	
}
