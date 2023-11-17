package com.hemebiotech.analytics.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class SymptomReaderImpl implements ISymptomReader {

	private String filepath;
	private List<String> lineReaded;
	private BufferedReader reader;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public SymptomReaderImpl (String filepath) {
		this.filepath = filepath;
		this.lineReaded = new ArrayList<String>();
		this.reader = null;
	}
	

	public String getPath() {
		return filepath;
	}
	
	@Override
	public List<String> getLineReaded() {
		return this.lineReaded;
	}
	
	private void resetReader() {
		try {
			this.reader = new BufferedReader (new FileReader(this.getPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void getSymptoms() {
		
		if (filepath != null) {
			try {
				resetReader();
				String line = reader.readLine();
				
				while (line != null) {
					this.lineReaded.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sortSymptoms() {
		Collections.sort(getLineReaded(), String.CASE_INSENSITIVE_ORDER);
	}	
}

	