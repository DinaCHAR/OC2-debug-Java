/*
	Gestion des ressources :
	Il est important de fermer les ressources correctement afin d'éviter les fuites de ressources potentielles. 
	le BufferedReader est déjà fermer dans le bloc finally, 
	mais il faut penser à utiliser l'instruction try-with-resources pour le fermer automatiquement.

*Gestion des exceptions :
*Bien que nous imprimons l'exception (IOException e.printStackTrace() ;), il pourrait être plus approprié d'enregistrer l'exception ou de lancer une exception personnalisée pour indiquer un problème avec la lecture du fichier.

*Validation du chemin d'accès au fichier :
*Il pourrait être utile d'ajouter une validation du chemin d'accès au fichier pour s'assurer qu'il ne s'agit pas d'une chaîne vide ou d'une valeur nulle avant d'essayer de lire le fichier.
**/

/*package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
/*public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	/*public ReadSymptomDataFromFile (String filepath) {
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

}*/
