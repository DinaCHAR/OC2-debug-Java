package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

import com.hemebiotech.analytics.reader.ISymptomReader;
import com.hemebiotech.analytics.reader.SymptomReaderImpl;
import com.hemebiotech.analytics.writer.ISymptomWriter;
import com.hemebiotech.analytics.writer.SymptomWriterImpl;

import Exceptions.FileNotYetReadedException;

public class AnalyctisSymptomAnalyzer {

	private ISymptomReader symptomReader;
	private AnalyticsCounter symptomCounter;
	private ISymptomWriter  symptomWriter;
	private Map<String, Integer> symptomsSortedAndCounted;
	//private String outputFileName;
	
	public AnalyctisSymptomAnalyzer(String fileToRead, String outputFileName) {
		//this.outputFileName = "result.txt";
		this.symptomReader = new SymptomReaderImpl(fileToRead);
		this.symptomCounter = new AnalyticsCounter();
		this.symptomWriter = new SymptomWriterImpl(outputFileName);
		this.symptomsSortedAndCounted = new HashMap<String, Integer>();
	}
	
	public void readSymptomFile() {
		this.symptomReader.getSymptoms();
	}
	
	public void sortSymptomFile () {
		this.symptomReader.sortSymptoms();
	}
	
	public void sortAndCoundSymptom() {
		sortSymptomFile();
		this.symptomsSortedAndCounted = symptomCounter.countSymptomsReaded(this.symptomReader.getLineReaded());
	}
	
	public void writeSymptomsInOutput() {
		if(!symptomsSortedAndCounted.isEmpty()) {
			this.symptomWriter.writeSymptoms(symptomsSortedAndCounted);
		}
	}

	/*public String getOutputFileName() {
		return outputFileName;
	}*/
}