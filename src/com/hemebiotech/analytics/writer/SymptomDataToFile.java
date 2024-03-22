package com.hemebiotech.analytics.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SymptomDataToFile implements ISymptomWriter  {
	
	private String outputFileName;
	
	
	//SymptomDataToFile est le constructeur de la class qui prend en paramètre le nom du fichier de sortie et initialise le scripteur à null.
	//outputFileName variable qui stock le nom du fichier de sorti (result.txt)
	public SymptomDataToFile(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	
	@Override
	//writeSymptoms est une méthode chargée d'écrire les symptômes dans un fichier.
	//Elle prend en paramètre une Map de symptômes où les clés sont les noms des symptômes et les valeurs sont le nombre de chaque symptôme. 
	//La méthode ouvre un fichier de sortie spécifié, parcourt la Map des symptômes et écrit chaque symptôme suivi de son nombre d'occurrences dans le fichier.
	public void writeSymptoms(Map<String, Integer> symptoms){
		BufferedWriter writer;
		
  
		try {
			File fileToWrite = new File(outputFileName);
			writer = new BufferedWriter(new FileWriter(fileToWrite));
		 
        	if (symptoms != null && !symptoms.isEmpty()) {
        		// iterate map entries 
                for (Map.Entry<String, Integer> currentSymptomEntry : symptoms.entrySet()) { 
      
                     
                    writer.write(currentSymptomEntry.getKey() + " : " + currentSymptomEntry.getValue()); 
      
                     
                    writer.newLine(); 
                } 
      
                
                writer.flush();
    			
    		} else {
    			// Écrire un message par défaut si aucun symptôme n'est trouvé
    			writer.write("aucun symptome trouvé");
    		}
        } 
        
        /*@exception IOException
         * Une gestion appropriée des exceptions est implémentée tout au long du processus afin d'attraper 
         * et d'afficher toutes les exceptions IO qui peuvent survenir pendant les opérations sur les fichiers.
         * 
         * Type 
         */
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
		
    }

}
