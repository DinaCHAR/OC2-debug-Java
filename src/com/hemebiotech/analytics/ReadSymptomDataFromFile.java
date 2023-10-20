package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
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
	
	//Ajout d'une class pour écrire les symptome et mettre un évéenement
	//permettre de trier dans l'ordre alphabétique
	//throws permet de relayer le traitement de l'exception à la méthode appelante (throw est une exception)
	//IOException = une exception qui est levée lorsqu'une erreur d'entrée et sorti se produit. Elle appartient à la calsse des exceptions vérifiées.
	public void putSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException{
		
		//System.getProperty renvoie l'ensemble de toutes les "propriétés d'environnement Java"
			String directoryUsersHome = System.getProperty("user.home");
		//Utilisation de la variable path pour localiser le fichers exécutables depuis la ligne de commande
		//file.separator = caractère utilisé pour séparer les noms de répertoires qui constituent le chemin d'accès à un emplacement spécifique
			String path = directoryUsersHome + System.getProperty("file.separator") + "result.out";
			//écrire les fichiers textes, passer en param path
			FileWriter writer = new FileWriter(path);
			if (mapSymptomsOccurences != null && !mapSymptomsOccurences.isEmpty()) {
				//calcul mettre les var qu'on va utiliser dans notre calcul symptome + nombre (litteration)
				
				mapSymptomsOccurences.forEach((a, z) -> {
					try {
						writer.write(a + "=" + z);
						writer.write(System.getProperty("line.separator"));
					}
					
					catch (IOException e) {
						e.printStackTrace();
					}
				});
				
				writer.close();
				
			} else {
				writer.write("aucun symptome trouvé");
				writer.close();
			}
			System.out.println("le fichier de sortie se trouve: " + path);
		}

	}

	