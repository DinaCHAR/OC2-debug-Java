package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.writer.SymptomDataToFile;

public class AnalyticsCounter {
	
	//countSymptoms méthode pour compter le symptome dans une liste de donnée
	public Map<String, Integer> countSymptoms(List<String> listToCount){
		//countedSymptoms objet de type HashMap utilisé pour stocker les symptomes et leurs nombres
		HashMap<String, Integer> countedSymptoms = new HashMap<>();
				
		for(int currentLineFromFileIndex = 0; currentLineFromFileIndex < listToCount.size(); currentLineFromFileIndex++) {
			String currentSymptomValue = listToCount.get(currentLineFromFileIndex);
			
			if (countedSymptoms.containsKey(currentSymptomValue)) {
				//recup la valeur asscoié a la clé = currentsymptom ex l'ocurrence c'est insomni
				int currentSymptomsOccurenceNumber = countedSymptoms.get(currentSymptomValue);
				countedSymptoms.put(currentSymptomValue, currentSymptomsOccurenceNumber + 1);
			} else {
				countedSymptoms.put(currentSymptomValue, 1); 
			}
		}
		return countedSymptoms;
	}
	
	//mapTrier méthode utilisée pour trier le map des symptômes et de leurs nombres par ordre alphabétique.
	//sortSymptom objet de type TreeMap<String,Integer> utilisé pour stocker les symptomes trier par ordre alphbétique 
	public TreeMap<String,Integer> mapTrier (Map <String, Integer> countedSymptoms){
		TreeMap<String,Integer> sortSymptom = new TreeMap<>(countedSymptoms);
		return sortSymptom;
	}
	
	//SymptomDataToFile constructeur de la classe SymptomDataToFile, utilisé pour créer un objet writer pour écrire les symptômes dans le fichier.
	//writeSymptom méthode utilisé pour écrire les symptomes
	//writer objet de type SymptomDataToFile utilisé pour écrire les symptomes dans le fichier result.txt
	public void writeSymptom(TreeMap<String,Integer> mapTrier) {
		SymptomDataToFile writer = new SymptomDataToFile("result.out");
		//objet writer de type writesymptome
		writer.writeSymptoms(mapTrier);
	}
	
	//ReadSymptomDataFromFile constructeur de la classe ReadSymptomDataFromFile, utilisé pour créer un objet reader pour lire les symptômes à partir du fichier
	//readSymptoms() méthode utilisée pour lire les symptômes à partir du fichier symptoms.txt et retourner une liste.
	//reader objet de type ReadSymptomDataFromFile utilisé pour lire les symptomes à partir du fichier symptoms.txt
	public List<String> readSymptoms(){	
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		return reader.getSymptoms();
	}
	

	public static void main(String args[]) {
		//AnalyticsCounter() constructeur de la classe AnalyticsCounter, utilisé pour créer un objet ac dans la méthode main
		//crée un objet ac avec le constructeur new AnalyticsCounter(); = constructeur vide
		//ac : Objet de type AnalyticsCounter, créé dans la méthode main, utilisé pour appeler les méthodes de la classe AnalyticsCounter
		AnalyticsCounter ac = new AnalyticsCounter();
		
		List<String> mySymptoms = ac.readSymptoms();
		
		Map<String, Integer> listToCount = ac.countSymptoms(mySymptoms);
		
		TreeMap<String,Integer> mapTrier = ac.mapTrier(listToCount);
		
		ac.writeSymptom(mapTrier);
	}
}
