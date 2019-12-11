package fr.diginamic.fichiers.rescencement.utils;

import java.util.List;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

/** Permet de constituer notre recensement progressivement é partir des lignes du fichier
 * @author DIGINAMIC
 *
 */
public class ParseurVille {
	
	/** Ajoute une ligne représentant une ville au recensement
	 * @param List<Ville> lstVille à compléter
	 * @param ligne ligne de laquelle on extrait une ville
	 */
	public static void ajoutLigne( List<Ville> lstVille, String ligne){
		
		String[] morceaux = ligne.split(";");
		String codeRegion = morceaux[0];
		String nomRegion = morceaux[1];
		String codeDepartement = morceaux[2];
		String codeCommune = morceaux[4];
		String nomCommune = morceaux[5];
		String population = morceaux[6];
		int populationTotale = Integer.parseInt(population.replace(" ", "").trim());
		
		// Creer  maintenant la ville avec toutes ses données
		Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);
		
		// Ajouter la ville é la liste des villes du recensement
		lstVille.add(ville);
		
	}

}
