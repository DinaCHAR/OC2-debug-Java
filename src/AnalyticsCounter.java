/*
*Incohérence des noms de variables :
    Les noms des variables utilisées pour compter les symptômes ne sont pas cohérents (headCount vs headacheCount). Il est conseillé de conserver des noms de variables cohérents pour une meilleure lisibilité.

    Faute de frappe dans la vérification du "rush" :
    Il y a une faute de frappe dans la condition de vérification des symptômes de "rush". Elle devrait être remplacée par "rash".

    Gestion des ressources du lecteur et du rédacteur de fichiers :
    Il est important de fermer les ressources (BufferedReader et FileWriter) en utilisant l'instruction try-with-resources ou un bloc finally pour assurer une bonne gestion des ressources.

    Logique de comptage incorrecte :
    La logique de comptage semble incorrecte. Elle incrémente les variables locales (headCount, rashCount, pupilCount), mais les variables statiques au niveau de la classe (headacheCount, rashCount, pupilCount) ne sont pas mises à jour. 
    Cela peut conduire à des comptages incorrects.
 */


/*package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}*/
