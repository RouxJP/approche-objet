package fr.diginamic.fichiers.rescencement.utils;

import java.util.List;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Region;

public class ParseurDepartement {
	/** Ajoute une ligne représentant une region au recensement
	 * @param List<Region> lstRegion à compléter
	 * @param ligne ligne de laquelle on extrait une region
	 */
	public static void ajoutLigne( List<Departement> lstDepartement, String ligne){
		
		String[] morceaux 		= ligne.split(";");
		String codeDepartement 	= morceaux[0];
		String nomDepartement 	= morceaux[1];
		String population 		= morceaux[2];
		int populationTotale 	= Integer.parseInt(population.replace(" ", "").trim());
		
		// Creer  maintenant la Region avec toutes ses données
		Departement departement = new Departement( codeDepartement, nomDepartement, populationTotale);
		
		// Ajouter la Region é la liste des Regions du recensement
		lstDepartement.add( departement);
		
	}

}
