package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Exceptions.FileNotYetReadedException;

public class Main {

	//ajouter des try et catch afin de mieux gérer l'exception 
		public static void main(String args[]) {
			System.out.println("===============DEBUT DU PROGRAMME :=================");
			AnalyctisSymptomAnalyzer programAnalyzer = new AnalyctisSymptomAnalyzer("symptoms.txt", "result.txt");
			
			System.out.println("===============LECTURE DU FICHIER :=================");
			programAnalyzer.readSymptomFile();
			
			System.out.println("===============TRIAGE ET COMPTAGE DU FICHIER :=================");
			programAnalyzer.sortAndCoundSymptom();
			
			System.out.println("===============ECRITURE DANS LE FICHIER DE SORTI :=================");
			programAnalyzer.writeSymptomsInOutput();
		}
	}

//Ajouter le fichier de sorti