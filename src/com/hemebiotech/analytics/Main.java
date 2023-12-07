package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


	/*
	 *
     * Le point d'entrée principal du programme.
     * Cette méthode initialise le SymptomAnalyzer, lit le fichier de symptômes, trie et compte les symptômes,et écrit les résultats dans le fichier de sortie.
     *
     * @param args Les arguments de la ligne de commande 
     */ 
 
public class Main {

		public static void main(String args[]) {
			System.out.println("===============DEBUT DU PROGRAMME :=================");
			// Créer une instance d'AnalyctisSymptomAnalyzer avec les noms des fichiers d'entrée et de sortie.
			AnalyctisSymptomAnalyzer programAnalyzer = new AnalyctisSymptomAnalyzer("symptoms.txt", "result.txt");
			
			System.out.println("===============LECTURE DU FICHIER :=================");
			// Lire les données relatives aux symptômes dans le fichier d'entrée
			programAnalyzer.readSymptomFile();
			
			System.out.println("===============TRIAGE ET COMPTAGE DU FICHIER :=================");
			//trier et compter le fichier
			programAnalyzer.sortAndCoundSymptom();
			
			System.out.println("===============ECRITURE DANS LE FICHIER DE SORTI :=================");
			// Écrire les symptômes triés et comptés dans le fichier de sortie
			programAnalyzer.writeSymptomsInOutput();
		}
	}