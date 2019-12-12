package fr.diginamic.fichiers.rescencement;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.exceptions.FonctionnalException;
import fr.diginamic.fichiers.recensement.services.RecherchePopulationBorneService;
import fr.diginamic.fichiers.recensement.services.RecherchePopulationDepartementService;
import fr.diginamic.fichiers.recensement.services.RecherchePopulationRegionService;
import fr.diginamic.fichiers.recensement.services.RecherchePopulationVilleService;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;
import fr.diginamic.fichiers.rescencement.utils.RecensementUtils;

/**
 * Application de traitement des données de recensement de population
 * 
 * @param args
 */
public class Application {

	/**
	 * Point d'entrée
	 * 
	 * @param args
	 *            arguments (non utilisés ici)
	 */
	public static void main(String[] args)  {
		Scanner scanner = new Scanner(System.in);
		
		// Charger en mémoire les données
		List<Ville> lstVille = RecensementUtils.lireVilles("C:/Tmp/Communes.csv");

		if (lstVille == null) {
			System.out.println("L'application doit s'arrétée en raison d'une erreur d'exécution.");
			System.exit(0);
		}
		

		// Menu
		int choix = 0;
		do {

			// Affichage du menu
			afficherMenu();

			// Poser une question à l'utilisateur
			String choixMenu = scanner.nextLine();

			// Conversion du choix utilisateur en int
			choix = Integer.parseInt(choixMenu);

			// On exécute l'option correspondant au choix de l'utilisateur
			switch (choix) {
			case 1:
				RecherchePopulationVilleService rechercheVille = new RecherchePopulationVilleService();
				rechercheVille.traiter( lstVille, scanner);
				break;
			case 2:
				RecherchePopulationDepartementService rechercheDept = new RecherchePopulationDepartementService();
				rechercheDept.traiter( lstVille, scanner);
				break;
			case 3:
				RecherchePopulationRegionService rechercheRegion = new RecherchePopulationRegionService();
				rechercheRegion.traiter( lstVille, scanner);
				break;
			case 4:
				try {
					RecherchePopulationBorneService recherchePopBorne = new RecherchePopulationBorneService();
					recherchePopBorne.traiter( lstVille, scanner);
				
				}catch( FonctionnalException ie) {
					System.out.println( ie.getMessage());
				}
				break;
			}
		} while (choix != 99);

		scanner.close();

	}

	/**
	 * Affichage du menu
	 */
	private static void afficherMenu() {
		System.out.println("***** Recensement population *****");
		System.out.println("1. Rechercher la population d'une ville");
		System.out.println("2. Rechercher la population d'un département");
		System.out.println("3. Rechercher la population d'une région");
		System.out.println("4. Rechercher la population des villes d'un dept entre min et max");
		System.out.println("99. Sortir");
	}
}