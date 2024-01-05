package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

import com.hemebiotech.analytics.reader.ISymptomReader;
import com.hemebiotech.analytics.reader.SymptomReaderImpl;
import com.hemebiotech.analytics.writer.ISymptomWriter;
import com.hemebiotech.analytics.writer.SymptomWriterImpl;

import Exceptions.FileNotYetReadedException;

/**
 * La classe AnalyctisSymptomAnalyzer orchestre l'analyse des données relatives aux symptômes.
 * Elle utilise un ISymptomReader pour lire les symptômes à partir d'un fichier, un AnalyticsCounter pour trier et compter les symptômes 
 * et un ISymptomWriter pour écrire les résultats dans un fichier de sortie.
 */

public class AnalyctisSymptomAnalyzer {

	private ISymptomReader symptomReader;
	private AnalyticsCounter symptomCounter;
	private ISymptomWriter  symptomWriter;
	private Map<String, Integer> symptomsSortedAndCounted;
	
	/**
     * Construit une instance d'AnalyctisSymptomAnalyzer avec les noms de fichiers d'entrée et de sortie spécifiés.
     *
     * @param fileToRead Nom du fichier contenant les données relatives aux symptômes.
     * @param outputFileName Le nom du fichier dans lequel les résultats de l'analyse doivent être écrits.
     */
	
	public AnalyctisSymptomAnalyzer(String fileToRead, String outputFileName) {
		this.symptomReader = new SymptomReaderImpl(fileToRead);
		this.symptomCounter = new AnalyticsCounter();
		this.symptomWriter = new SymptomWriterImpl(outputFileName);
		this.symptomsSortedAndCounted = new HashMap<>();
	}
	
	/**
     * Lit les données relatives aux symptômes à partir du fichier d'entrée à l'aide de l'ISymptomReader.
     */
	
	public void readSymptomFile() {
		this.symptomReader.getSymptoms();
	}
	
	/**
     * Trie les données relatives aux symptômes à l'aide de la méthode sortSymptoms de ISymptomReader.
     */
	public void sortSymptomFile () {
		this.symptomReader.sortSymptoms();
	}
	
	/**
     * Trie et compte les données relatives aux symptômes en utilisant ISymptomReader, AnalyticsCounter, et met à jour symptomsSortedAndCounted.
     */
	public void sortAndCoundSymptom() {
		sortSymptomFile();
		this.symptomsSortedAndCounted = symptomCounter.countSymptomsReaded(this.symptomReader.getLineReaded());
	}
	
	/**
     * Écrit les données triées et comptées sur les symptômes dans le fichier de sortie en utilisant l'ISymptomWriter.
     */
	public void writeSymptomsInOutput() {
		if(!symptomsSortedAndCounted.isEmpty()) {
			this.symptomWriter.writeSymptoms(symptomsSortedAndCounted);
		}
	}

}