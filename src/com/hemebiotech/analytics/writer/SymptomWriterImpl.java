package com.hemebiotech.analytics.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/*
 * Implémentation de l'interface ISymptomWriter pour l'écriture des données sur les symptômes dans un fichier de sortie (result.txt).
 * Cette classe utilise un BufferedWriter pour écrire efficacement les informations relatives aux symptômes dans le fichier de sortie spécifié.
 * 
 * Le constructeur prend en paramètre le nom du fichier de sortie et initialise l'auteur à null.
 * 
 * La méthode resetWriter est responsable de la création d'un nouveau BufferedWriter pour le fichier de sortie donné.
 * Elle gère les exceptions IO en affichant la trace de la pile si une exception se produit.
 * 
 * La méthode writeSymptoms accepte une carte de symptômes et leur nombre. Si la carte d'entrée n'est pas vide ou nulle,
 * la méthode réinitialise l'auteur et parcourt les entrées de la carte, en écrivant chaque symptôme et son nombre dans le fichier de sortie. 
 * Si la carte est vide ou nulle, un message par défaut "aucun symptôme trouvé" est écrit dans le fichier.
 * Le BufferedWriter est nettoyé pour s'assurer que toutes les données ont été écrites, et l'auteur est fermé dans le bloc final.
 * La gestion des exceptions est implémentée afin d'attraper et d'afficher toute exception IOException pouvant survenir pendant les opérations de fichier.
 */
public class SymptomWriterImpl implements ISymptomWriter {

	/** La classe utilise un BufferedWriter pour écrire efficacement 
	 * les informations sur les symptômes dans le fichier de sortie spécifié.
	 * 
	 * @param outputFileName le nom du fichier de sortie
	 */
	private BufferedWriter writer;
	private String outputFileName;
	
	/*Le constructeur prend en paramètre le nom du fichier de sortie et initialise le scripteur à null.*/
	public SymptomWriterImpl(String outputFileName) {
		this.outputFileName = outputFileName;
		this.writer = null;
	}
	
	/*La méthode resetWriter est responsable de la création d'un nouveau BufferedWriter 
	 * pour le fichier de sortie donné.
	 * 
	 * Réinitialise le BufferedWriter avec un nouveau FileWriter pour le fichier de sortie spécifié.
	 * Gère les exceptions IO en affichant la trace de la pile.
	 */
	
	private void resetWriter() {
		try {
			File fileToWrite = new File(outputFileName);
			this.writer = new BufferedWriter(new FileWriter(fileToWrite));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	/*
	 * Écrit les données relatives aux symptômes dans le fichier de sortie en fonction de la carte des symptômes et de leur nombre.
	 * 
	 * @param symptoms une carte contenant les noms des symptômes comme clés et leur nombre comme valeurs
	 *
	 * 
	 * La méthode writeSymptoms accepte une carte de symptômes et leur nombre, itère à travers les entrées et écrit chaque symptôme et son nombre dans le fichier de sortie.
	 * chaque symptôme et son nombre dans le fichier de sortie. Si la carte d'entrée est vide ou nulle, un message par défaut "aucun symptôme trouvé"
	 * est écrit dans le fichier. 
	 * Le BufferedWriter est nettoyé pour s'assurer que toutes les données ont été écrites, et le writer est fermé dans le bloc final.
	 */
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
        finally { 
            try { 
            	//Toujours fermer le writer (check for null to avoid NullPointerException)
            	if (writer != null) {
                writer.close(); 
            	}
            } 
            catch (Exception e) {
                e.printStackTrace(); 
            } 
        } 
		
    } 
}
