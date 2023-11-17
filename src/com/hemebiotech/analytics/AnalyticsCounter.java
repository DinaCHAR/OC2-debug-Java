package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
//import java.io.FileOutputStream;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	public Map<String, Integer> countSymptomsReaded(List<String> listToCount){	    
	    
		TreeMap<String,Integer> countedSymptoms = new TreeMap<String, Integer>();
	    
		for(int currentLineFromFileIndex = 0; currentLineFromFileIndex < listToCount.size(); currentLineFromFileIndex++) {
	       String currentSymptomValue = listToCount.get(currentLineFromFileIndex);
	       
	       if (countedSymptoms.containsKey(currentSymptomValue)) {
	    	   int currentSymptomsOccurenceNumber = countedSymptoms.get(currentSymptomValue);
	    	   countedSymptoms.put(currentSymptomValue,currentSymptomsOccurenceNumber+1);
	       } else {
	    	   countedSymptoms.put(currentSymptomValue, 1); 
	                  
	       }
	     }
	     
	     return countedSymptoms;
	}
}


/*catch (IOException e) {
		e.printStackTrace();
	}*/

// Ne peux faire d'action sur une class, donc ca ne fonctionne pasBufferedReader.close(); 
// Ne peux faire d'action sur une class, donc ca ne fonctionne pas FileWriter.close();


