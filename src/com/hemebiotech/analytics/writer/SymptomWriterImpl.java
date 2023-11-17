package com.hemebiotech.analytics.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SymptomWriterImpl implements ISymptomWriter {

	private BufferedWriter writer;
	private String outputFileName;
	
	
	public SymptomWriterImpl(String outputFileName) {
		this.outputFileName = outputFileName;
		this.writer = null;
	}
	
	private void resetWriter() {
		try {
			File fileToWrite = new File(outputFileName);
			this.writer = new BufferedWriter(new FileWriter(fileToWrite));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms){
        try { 
        	if (symptoms != null && !symptoms.isEmpty()) {
        		resetWriter();
        		// iterate map entries 
                for (Map.Entry<String, Integer> currentSymptomEntry : symptoms.entrySet()) { 
      
                    // put key and value separated by a colon 
                    writer.write(currentSymptomEntry.getKey() + " : " + currentSymptomEntry.getValue()); 
      
                    // new line 
                    writer.newLine(); 
                } 
      
                //Write into final stream
                writer.flush();
    			
    		} else {
    			writer.write("aucun symptome trouvé");
    		}
        } 
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
        finally { 
  
            try { 
                // always close the writer 
                writer.close(); 
            } 
            catch (Exception e) {
                e.printStackTrace(); 
            } 
        } 
		
    } 
}
