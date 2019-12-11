package fr.diginamic.fichiers.rescencement.utils;

import java.util.List;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Region;


/** Permet de constituer notre recensement progressivement é partir des lignes du fichier
 * @author DIGINAMIC
 *
 */
public class ParseurRegion {
	
	/** Ajoute une ligne représentant une region au recensement
	 * @param List<Region> lstRegion à compléter
	 * @param ligne ligne de laquelle on extrait une region
	 */
	public static void ajoutLigne( List<Region> lstRegion, String ligne){
		
		String[] morceaux 	= ligne.split(";");
		String codeRegion 	= morceaux[0];
		String nomRegion 	= morceaux[1];
		String population 	= morceaux[2];
		int populationTotale = Integer.parseInt(population.replace(" ", "").trim());
		
		// Creer  maintenant la Region avec toutes ses données
		Region Region = new Region( codeRegion, nomRegion, populationTotale);
		
		// Ajouter la Region é la liste des Regions du recensement
		lstRegion.add(Region);
		
	}

}
