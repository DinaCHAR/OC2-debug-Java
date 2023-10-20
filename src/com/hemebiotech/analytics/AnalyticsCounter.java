package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.FileOutputStream;

public class AnalyticsCounter {
	//peuvent être appeler n'importe ou dans la class
	//ne jamais mettre en public car c'est une faille de sécurité
	//getter = qui récupére la var, setter = qui remplace une var
	//protected seulement au niveau du package on peux voir certaine méthode 
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0

	//ajouter des try et catch afin de mieux gérer l'exception 
	public static void main(String args[]) {
		// first get input

		//Fermer la var pas la classe
		//BufferedReader fermer ca ressources
		try {
			BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));	
			String line = reader.readLine(); //lire ligne après ligne 

			//int i = 0;	// set i to 0
			//		int headCount = 0;	// counts headaches cette var ne sert a rien 

			// SUPPRIMER try (FileOutputStream fis = new FileOutputStream("result.out")){
			while (line != null) {// tant que line est diff de null on lance ce qu'il y a de la l19 à 34

				System.out.println("symptom from file: " + line);//ecrit à la console ce qu'on lis dans le fichier line
				if (line.equals("headache")) {// si c'est égale à la string headache l22 à 25
					headacheCount++;//headcount +1
					System.out.println("number of headaches: " + headacheCount);// afficher ce headcount System.out.println permet d'imprimer un argument
				}
				else if (line.equals("rash")) {
					rashCount++;
					//afin d'avoir un résultat system.out pour la console 
					System.out.println("number of rash: " + rashCount);
				}
				else if (line.contains("dialated pupils")) {//si la ligne contient pupils alors on fait pupils +1
					pupilCount++;
					System.out.println("number of dialated pupils: " + pupilCount);
				}


				//try + catch

				line = reader.readLine();
				//erreur essayer le debugg
				reader.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// get another symptom retour sur le while l19

		// next generate output ecrire les résultats

		//fermer la ressource du filewriter
		//mettre try et catch dans cette zone
		try {
			FileWriter writer = new FileWriter ("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	/*catch (IOException e) {
		e.printStackTrace();
	}*/

	// Ne peux faire d'action sur une class, donc ca ne fonctionne pasBufferedReader.close(); 
	// Ne peux faire d'action sur une class, donc ca ne fonctionne pas FileWriter.close();

}
