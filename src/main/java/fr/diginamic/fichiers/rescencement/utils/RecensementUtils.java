package fr.diginamic.fichiers.rescencement.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Recensement;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Region;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

/** Classe permettant de lire le contenu d'un fichier
 * @author DIGINAMIC
 *
 */
public class RecensementUtils {

	/** Lit le contenu du fichier en paramétre, contenant des données de recensement avec le format attendu,
	 * et retourne une instance de la classe Region avec toutes ses Regions
	 * @param cheminFichier chemin d'accés au fichier sur le disque dur
	 * @return {@link Recensement}
	 */
	public static List<Region> lireRegions(String cheminFichier){
		List<Region> lstRegion = new ArrayList<>();
		
		List<String> lignes = null;
		try {
			File file = new File(cheminFichier);
			lignes = FileUtils.readLines(file, "UTF-8");
			
			// On supprime la ligne d'entéte avec les noms des colonnes
			lignes.remove(0);
			
			for (String ligne: lignes){
				ParseurRegion.ajoutLigne( lstRegion, ligne);
			}
			return lstRegion;
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	/** Lit le contenu du fichier en paramétre, contenant des données de recensement avec le format attendu,
	 * et retourne une liste Departement 
	 * @param cheminFichier chemin d'accés au fichier sur le disque dur
	 * @return List<Departement>
	 */
	public static List<Departement> lireDepartements(String cheminFichier){
		List<Departement> lstDepartement = new ArrayList<>();
		
		List<String> lignes = null;
		try {
			File file = new File(cheminFichier);
			lignes = FileUtils.readLines(file, "UTF-8");
			
			// On supprime la ligne d'entéte avec les noms des colonnes
			lignes.remove(0);
			
			for (String ligne: lignes){
				ParseurDepartement.ajoutLigne( lstDepartement, ligne);
			}
			return lstDepartement;
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	

	/** Lit le contenu du fichier en paramétre, contenant des données de recensement avec le format attendu,
	 * et retourne une liste de Villes
	 * @param cheminFichier chemin d'accés au fichier sur le disque dur
	 * @return List<Ville>
	 */
	public static List<Ville> lireVilles(String cheminFichier){
		List<Ville> lstVille = new ArrayList<>();
		
		List<String> lignes = null;
		try {
			File file = new File(cheminFichier);
			lignes = FileUtils.readLines(file, "UTF-8");
			
			// On supprime la ligne d'entéte avec les noms des colonnes
			lignes.remove(0);
			
			for (String ligne: lignes){
				ParseurVille.ajoutLigne( lstVille, ligne);
			}
			return lstVille;
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	

}
