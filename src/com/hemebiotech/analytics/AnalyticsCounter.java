package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//import java.io.FileOutputStream;
import java.util.Map;
import java.util.TreeMap;

/**
 * La classe AnalyticsCounter permet de compter les occurrences de symptômes dans une liste.
 */
public class AnalyticsCounter {
	
	/**
     * Compte les occurrences des symptômes dans la liste fournie et renvoie un TreeMap avec les noms des symptômes comme clés
     * et leur nombre d'occurrences correspondant comme valeurs.
     *
     * @param listToCount La liste des symptômes à compter
     * @return Un TreeMap contenant les noms des symptômes comme clés et leur nombre d'occurrences comme valeurs
     */
	
	public Map<String, Integer> countSymptomsReaded(List<String> listToCount){	    
	    
		// TreeMap pour stocker les symptômes et leur nombre d'occurrences dans un ordre trié.
		Map<String,Integer> countedSymptoms = new TreeMap<>();
	    
		// Interroger la liste des symptômes pour compter les occurrences
		for(int currentLineFromFileIndex = 0; currentLineFromFileIndex < listToCount.size(); currentLineFromFileIndex++) {
			// Récupère la valeur actuelle du symptôme dans la liste
			String currentSymptomValue = listToCount.get(currentLineFromFileIndex);
	       
			// Vérifier si le symptôme se trouve déjà dans le TreeMap
	       if (countedSymptoms.containsKey(currentSymptomValue)) {
	    	   // Si oui, incrémenter le nombre d'occurrences
	    	   int currentSymptomsOccurenceNumber = countedSymptoms.get(currentSymptomValue);
	    	   countedSymptoms.put(currentSymptomValue,currentSymptomsOccurenceNumber+1);
	       } else {
	    	   // Si non, ajouter le symptôme au TreeMap avec un nombre d'occurrences de 1
	    	   countedSymptoms.put(currentSymptomValue, 1); 
	                  
	       }
	     }
	     
	     return countedSymptoms;
	}
}


