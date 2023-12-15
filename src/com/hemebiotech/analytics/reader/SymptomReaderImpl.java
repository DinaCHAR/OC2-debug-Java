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

/*
 * Implémentation de l'interface ISymptomReader pour la lecture et le traitement des données relatives aux symptômes à partir d'un fichier.
 * Cette classe utilise un BufferedReader pour lire efficacement les chaînes de symptômes à partir du fichier spécifié.
 * 
 * Le constructeur prend un chemin de fichier comme paramètre et initialise la liste lineReaded et le lecteur à null.
 * La méthode resetReader est responsable de la création d'un nouveau BufferedReader pour le chemin de fichier donné.
 * 
 * La méthode getSymptoms lit les chaînes de symptômes du fichier, en ajoutant chaque ligne à la liste lineReaded.
 * La méthode gère les exceptions IO et s'assure que le lecteur est fermé dans le bloc final.
 * 
 * La méthode sortSymptoms trie les lignes de données sur les symptômes sans tenir compte de la casse, à l'aide de Collections.sort.
 * Cela peut s'avérer utile pour une présentation ou une analyse cohérente des données relatives aux symptômes.
 */
public class SymptomReaderImpl implements ISymptomReader {

	private String filepath;
	private List<String> lineReaded;
	private BufferedReader reader;
	
	/**
	 * Construit une instance de SymptomReaderImpl avec le chemin d'accès spécifié
	 * 
	 * @param filepath un chemin complet ou partiel vers un fichier contenant des chaînes de symptômes, une par ligne
	 */
	public SymptomReaderImpl (String filepath) {
		this.filepath = filepath;
		this.lineReaded = new ArrayList<>();
		this.reader = null;
	}
	
	/**
	 * Obtient le chemin d'accès au fichier associé à cette instance de SymptomReaderImpl.
	 * 
	 * @return file path
	 */
	public String getPath() {
		return filepath;
	}
	
	/**
	 * Récupère la liste des chaînes de symptômes lues dans le fichier.
	 * 
	 * @return la liste des chaînes de symptômes
	 */
	
	@Override
	public List<String> getLineReaded() {
		return this.lineReaded;
	}
	
	/*
	 * Réinitialise le BufferedReader avec un nouveau FileReader pour le chemin d'accès au fichier spécifié.
	 * Gère l'exception FileNotFound en affichant la trace de la pile.
	 * (stack trace représente la pile d'appel du programme au moment où l'exception a été générée)
	 */
	private void resetReader() {
		try {
			this.reader = new BufferedReader (new FileReader(this.getPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Lit les chaînes de symptômes dans le fichier et remplit la liste lineReaded.
	 * Gère les exceptions IO et s'assure que le lecteur est fermé dans le bloc final.
	 * s'assurer que le lecteur n'est pas nul avant de tenter de le fermer
	 */
	
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
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (reader != null) {
	                    reader.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	/**
	 * Trie les chaînes de caractères des symptômes sans tenir compte de la casse.
	 * Cela peut être utile pour une présentation ou une analyse cohérente des données relatives aux symptômes.
	 */
	
	public void sortSymptoms() {
		Collections.sort(getLineReaded(), String.CASE_INSENSITIVE_ORDER);
	}	
}

	