package com.hemebiotech.analytics.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 * La class ReadSymptomDataFromFile implements l'interface ISymptomReader
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	//attribut de la call readsympdatafromfile
	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * Constructeur = crée des objets ReadSymptomDataFromFile est le constructeur de la class, prend en para filepath
	 * filepath attribut qui stock le chemin vers les symptomes 
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	//Méthode qui retourne ne liste de chaîne de cara représentant les symp lus, on lis les symp ligne par ligne et on retourne le fichier
	//getSymptoms est une implémentation de cette interface 
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			//Gérer les exceptions i/o
			try {
				//Lire le contenu du fichier 
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
