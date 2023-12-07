package com.hemebiotech.analytics.reader;

import java.util.List;
import java.util.Scanner;

/*
 * Interface permettant de lire et de traiter les données relatives aux symptômes provenant d'une source externe.
 * Les classes qui implémentent cette interface sont censées fournir des fonctionnalités permettant d'obtenir, de trier et d'extraire des informations sur les symptômes, trier et récupérer des informations sur les symptômes.
 * 
 * La méthode getSymptoms est responsable de la récupération des données sur les symptômes à partir de la source externe.
 * Les implémentations de cette méthode peuvent impliquer la lecture d'un fichier, l'extraction de données d'une base de données,
 * ou tout autre moyen approprié d'obtenir des informations sur les symptômes.
 * 
 * La méthode sortSymptoms est destinée à trier les données sur les symptômes récupérées, ce qui permet une présentation ou une analyse cohérente.
 * une présentation ou une analyse cohérente. Les implémentations peuvent choisir un algorithme de tri approprié
 * en fonction des exigences spécifiques.
 * 
 * La méthode getLineReaded renvoie une liste de chaînes de caractères représentant les lignes de données sur les symptômes
 * lues à partir de la source externe. Cela peut être utile pour des analyses ou des rapports ultérieurs.
 */

public interface ISymptomReader {
		
	void getSymptoms ();
	
	void sortSymptoms();
	
	List<String> getLineReaded();
}
