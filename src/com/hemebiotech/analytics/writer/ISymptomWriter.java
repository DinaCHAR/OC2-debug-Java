package com.hemebiotech.analytics.writer;

import java.util.Map;

/*
* Interface pour l'écriture des symptômes dans un fichier de sortie (result.txt).
* La mise en œuvre de cette interface permet de définir une stratégie personnalisée 
* pour l'écriture des données relatives aux symptômes.
* 
* La méthode "writeSymptoms" est responsable de l'écriture d'une carte de symptômes et 
* de leur nombre dans le fichier de sortie.
* Les clés de la carte représentent les noms des symptômes et les valeurs correspondantes représentent les nombres d'occurrences.
*/

//Si tu imlemente cette interface dans une class, alors cette class doit obligatoirement avoir une fonction qui s'appel wrtie symptome qui nenvoie rien et prenant en para une map de string integer
public interface ISymptomWriter {
	void writeSymptoms(Map<String, Integer> symptoms);
}
