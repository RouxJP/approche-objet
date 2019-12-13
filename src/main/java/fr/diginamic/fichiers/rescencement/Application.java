package fr.diginamic.fichiers.rescencement;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exceptions.FonctionnalException;
import fr.diginamic.fichiers.recensement.services.RecherchePopulationBorneServiceRegion;
import fr.diginamic.fichiers.recensement.services.RecherchePopulationDepartementService;
import fr.diginamic.fichiers.recensement.services.RecherchePopulationRegionService;
import fr.diginamic.fichiers.recensement.services.RecherchePopulationVilleDeptService;
import fr.diginamic.fichiers.recensement.services.RecherchePopulationVilleFranceService;
import fr.diginamic.fichiers.recensement.services.RecherchePopulationVilleRegionService;
import fr.diginamic.fichiers.recensement.services.RecherchePopulationVilleService;
import fr.diginamic.fichiers.rescencement.jdbc.dao.DepartementDaoJdbc;
import fr.diginamic.fichiers.rescencement.jdbc.dao.VilleDaoJdbc;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;


/**
 * Application de traitement des données de recensement de population
 * 
 * @param args
 */
public class Application {
	private static final Logger LOG = LoggerFactory.getLogger( Application.class);

	/**
	 * Point d'entrée
	 * 
	 * @param args
	 *            arguments (non utilisés ici)
	 */
	public static void main(String[] args)  {
		Scanner scanner = new Scanner(System.in);
		
		// Charger en mémoire les données
		// List<Ville> lstVille = RecensementUtils.lireVilles("C:/Tmp/Communes.csv");
		LOG.info("Chargement des villes en mémoire");
		VilleDaoJdbc villeDaoJdbc 	= new VilleDaoJdbc();
		List<Ville> lstVille 		= villeDaoJdbc.extraireVilles();
		if (lstVille == null) {
			LOG.error("L'application doit s'arrétée en raison d'une erreur d'exécution.");
			System.exit(0);
		}
		
		// Menu
		int choix = 0;
		do {

			// Affichage du menu
			afficherMenu();

			// Poser une question à l'utilisateur
			String choixMenu = scanner.nextLine();
			if(( choixMenu == null) || ( choixMenu.isEmpty())){
				continue;
			}

			// Conversion du choix utilisateur en int
			try {
				choix = Integer.parseInt(choixMenu);
			}catch ( NumberFormatException ie) {
				System.out.println("Saisir un nombre!");
				continue;
				
			}

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
				
			case 4: // Afficher les 10 régions les plus peuplées
				try {
					RecherchePopulationBorneServiceRegion recherchePopBorne = new RecherchePopulationBorneServiceRegion();
					recherchePopBorne.traiter( lstVille, scanner);
				
				}catch( FonctionnalException ie) {
					System.out.println( ie.getMessage());
				}
				break;

			case 5: // Afficher les 10 départements les plus peuplés
				DepartementDaoJdbc departDaoJdbc 	= new DepartementDaoJdbc();
				List<Departement> lstDept 			= departDaoJdbc.extraireDepartementPlusPeuplee();
				LOG.info(" Les 10 départements les plus peuplés sont : ");
				int count = 0;
				for( Departement dept : lstDept) {
					System.out.println( dept.getNom() + " : " + dept.getPopulation());
					count++;
					if( count == 10) break;
				}
				break;
				
			case 6: // Afficher les 10 villes les plus peuplées d'un département
				RecherchePopulationVilleDeptService rechVilleDept = new RecherchePopulationVilleDeptService();
				rechVilleDept.traiter( lstVille, scanner);
				break;
				
			case 7: // Afficher les 10 villes les plus peuplées d'une région
				RecherchePopulationVilleRegionService rechVilleRegion = new RecherchePopulationVilleRegionService();
				rechVilleRegion.traiter( lstVille, scanner);
				break;
				
			case 8: // Afficher les 10 villes les plus peuplées de France
				RecherchePopulationVilleFranceService rechVilleFrance = new RecherchePopulationVilleFranceService();
				rechVilleFrance.traiter( lstVille, scanner);
				break;
					
			case 9 :
				System.out.println("Au revoir !");
			break;	
			
			default :
				System.out.println("Choix inconnu !");
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
		System.out.println("5. Rechercher les 10 départements les plus peuplés");
		System.out.println("6. Rechercher les 10 villes les plus peuplées déun département");
		System.out.println("7. Rechercher les 10 villes les plus peuplées d'une région");
		System.out.println("8. Rechercher les 10 villes les plus peuplées de France");
		System.out.println("9. Sortir");
	}
}
