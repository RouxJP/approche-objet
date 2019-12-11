package fr.diginamic.fichiers.rescencement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Region;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;
import fr.diginamic.fichiers.rescencement.utils.DepartCompDesc;
import fr.diginamic.fichiers.rescencement.utils.RegionCompDesc;
import fr.diginamic.fichiers.rescencement.utils.VilleCompDesc;

public class MenuRescencement {
	private static String[]         tabString ;

	private static ArrayList<Ville> lstCommune = new ArrayList<Ville>();
	private static ArrayList<Ville> lstVilleFiltree = new ArrayList<Ville>();
	/**
	 * Menu de l'application de rescencement 
	 */
	private static void afficherMenu() {
		System.out.println( "Menu du rescencemnet 2016 en France :\n"
		+ " 	- 1. Population d'une ville donnée\n"
		+ "	- 2. Population d'un département donné\n"
		+ "	- 3. Population d'une région donnée\n"
		+ "	- 4. Afficher les 10 régions les plus peuplées\n"
		+ "	- 5. Afficher les 10 départements les plus peuplés\n"
		+ "	- 6. Afficher les 10 villes les plus peuplées déun département\n"
		+ "	- 7. Afficher les 10 villes les plus peuplées déune région\n"
		+ "	- 8. Afficher les 10 villes les plus peuplées de France\n"
		+ "	- 9. Sortir\n");
	}
	/**
	 * Affiche la population d'une villee passée en paramétre
	 * @param nomVille
	 */
	private static void affPopVilleDonnee( String nomVille) {
		// Afficher info sur ville
		long	populationVille = 0L;
		for( Ville cVille : lstCommune) {
			if( cVille.getNom().equals( nomVille)) {
				populationVille =  cVille.getPopulation();
				break;
			}
		}
		System.out.println("La population de " + nomVille + " est : " + populationVille);
	}	
	
	/**
	 * Affiche la population d'un département passé en paramétre
	 * @param codeDept
	 */
	private static void affPopDeptDonnee( String codeDept) {
		long	popDept = 0L;
		for( Ville cVille : lstCommune) {
			if( cVille.getCodeDepartement().equals(codeDept)) {
					popDept += cVille.getPopulation();
			}
		}
		System.out.println("La population de " + codeDept + " est : " + popDept);
	}
	
	/**
	 * Affiche la population d'une région passé en paramétre
	 * @param nomRegion
	 */
	private static void affPopRegionDonnee( String nomRegion) {
		long	popRegion = 0L;
		for( Ville cVille : lstCommune) {
			if( cVille.getNomRegion().equals(nomRegion)) {
					popRegion += cVille.getPopulation();
			}
		}
		System.out.println("La population de " + nomRegion + " est : " + popRegion);
	}
	
	/**
	 * Affiche les 10 régions les plus peuplées de Franc
	 * @param
	 */
	private static void aff10RegionPlusPeuplee() {

		System.out.println( "Les 10 régions les plus peuplées de France");
		Set<Region>		lstRegion			= new TreeSet< Region>();
		for( Ville cVille : lstCommune) {
			// Creation de la liste de region sans doublons
			lstRegion.add( new Region( cVille.getCodeRegion(), cVille.getNomRegion(), 0));
		}
		long		popRegion;
		for( Ville cVille : lstCommune) {
			// Cumuler la population par region
			for( Region cRegion : lstRegion) {
				if( cRegion.getNom().equals( cVille.getNomRegion())) {
					popRegion = cRegion.getPopulation();
					cRegion.setPopulation( popRegion + cVille.getPopulation());
				}
			}
		}
		List<Region>	lstRegionTriee = new ArrayList<Region>();
		for( Region cRegion : lstRegion) {
			lstRegionTriee.add( cRegion);
		}
		Collections.sort( lstRegionTriee, new RegionCompDesc());
		for( int i = 0 ; i < 10 ; i++) {
			System.out.println( i+1 + " : " + lstRegionTriee.get(i));
		}
	
	}
	
	/**
	 * Affiche les 10 départements les plus peuplées de France
	 * @param
	 */
	private static void aff10DepartementPlusPeuplee() {

		System.out.println( " Les 10 département les plus peuplés de France");
		Set<Departement>	lstDeptPlusPeuple	= new TreeSet< Departement>();
		for( Ville cVille : lstCommune) {
			// Creation de la liste de départements de France sans doublons
			lstDeptPlusPeuple.add( new Departement( cVille.getCodeDepartement(), "", 0));
		}
		long		populationDept;
		for( Ville cVille : lstCommune) {
			// Cumuler la population par departement
			for( Departement cDept : lstDeptPlusPeuple) {
				if( cDept.getCode().equals( cVille.getCodeDepartement())) {
					populationDept = cDept.getPopulation();
					cDept.setPopulation( populationDept + cVille.getPopulation());
				}
			}
		}
		List<Departement>	lstDeptPlusPeupleTrie = new ArrayList<Departement>();
		for( Departement cDept : lstDeptPlusPeuple) {
			lstDeptPlusPeupleTrie.add( cDept);
		}
		Collections.sort( lstDeptPlusPeupleTrie, new DepartCompDesc());
		for( int i = 0 ; i < 10; i++) {
			System.out.println( i+1 + " : " + lstDeptPlusPeupleTrie.get(i));
		}
	
	}
	/**
	 * Affiche les 10 villes les plus peuplées d'un département
	 * @param codeDept
	 */
	private static void aff10VillePlusPeupleeDepartement( String codeDept) {
		System.out.println("Les 10 villes les plus peuplées du département :  " + codeDept + " sont : ");
		lstVilleFiltree = Ville.filterVilleDept( lstCommune, codeDept) ;
		Collections.sort( lstVilleFiltree , new VilleCompDesc());
		for( int i = 0 ; i < 10; i++) {
			System.out.println( i+1 + " : " + lstVilleFiltree.get(i));
		}
	}

	
	/**
	 * Affiche les 10 villes les plus peuplées d'une région
	 * @param nomRegion
	 */
	private static void aff10VillePlusPeupleeRegion( String nomRegion) {
		System.out.println("Les 10 villes les plus peuplées de " + nomRegion + " sont : ");
		lstVilleFiltree = Ville.filterVilleRegion( lstCommune, nomRegion) ;
		Collections.sort( lstVilleFiltree , new VilleCompDesc());
		for( int i = 0 ; i < 10; i++) {
			System.out.println( i+1 + " : " + lstVilleFiltree.get(i));
		}
	}

	/**
	 * Affiche les 10 villes les plus peuplées de France
	 * @param
	 */
	private static void aff10VillePlusPeupleeFrance( ) {
		System.out.println("Les 10 villes les plus peuplées de France sont : ");
		Collections.sort( lstCommune , new VilleCompDesc());
		for( int i = 0 ; i < 10; i++) {
			System.out.println( i+1 + " : " + lstCommune.get(i));
		}
	}

	/**
	 * Test de l'existence de la ville en france
	 * @param nomVille
	 * @return
	 */
	private static boolean existeVille(String nomVille) {
		boolean villeExiste = false;
		
		for( Ville cVille : lstCommune) {
			//System.out.println(cVille.getNomCommune());
			if( cVille.getNom().equals( nomVille)){
				villeExiste = true;
				break;
			}
		}
		return villeExiste;
	}
	
	/**
	 * Test de l'existence du departement en france
	 * @param codeDept
	 * @return
	 */
	private static boolean existeDept(String codeDept) {
		boolean deptExiste = false;
		
		for( Ville cVille : lstCommune) {
			if( cVille.getCodeDepartement().equals( codeDept)){
				deptExiste = true;
				break;
			}
		}
		return deptExiste;
	}

	/**
	 * Test de l'existence de la région de france
	 * @param nomRegion
	 * @return
	 */
	private static boolean existeRegion(String nomRegion) {
		boolean regionExiste = false;
		
		for( Ville cVille : lstCommune) {
			if( cVille.getNomRegion().equals( nomRegion)){
				regionExiste = true;
				break;
			}
		}
		return regionExiste;
	}

	public static void main(String[] args) {
		long	population ;
		Ville	ville ;
		int		numLigne = 0;
		String	nomVille; 
		String	codeDpt ;
		String	nomRegion ;
		
		try {
			File fResc2016 = new File( "c:/tmp/recensement population 2016.csv");
			List<String> lignes = FileUtils.readLines( fResc2016, "UTF-8");
			
			for( String cLigne : lignes) {
				if( numLigne > 0){
					// On a sauté l'entete
					
					tabString = cLigne.split( ";");
					population = 0l;
					population = Long.parseLong( tabString[ 6].replaceAll( " ", ""));
					ville = new Ville( 	tabString[ 0], tabString[ 1], 
										tabString[ 2], tabString[ 4],
										tabString[ 5], population );
					lstCommune.add( ville);
				}
				numLigne++;
			}
				
		}catch( IOException ie) {
			System.out.println(ie.getMessage());
		}
		
		int menu = 0;
		Scanner sc = new Scanner( System.in);
		do {
			afficherMenu();
			menu = sc.nextInt();
			
			switch( menu) {
				case 1 : // Population déune ville donnée
					do {
						System.out.println("Saisir une ville de France");
						nomVille = sc.next();
						if( !existeVille( nomVille)){
							System.out.println("La ville : " + nomVille + " n'existe pas");
						}
					}while(  !existeVille( nomVille)) ; 
					
					affPopVilleDonnee( nomVille);
					
				break;
				
				case 2 : // Population déun département donné
					do {
						System.out.println("Saisir un département de France");
						codeDpt = sc.next();
						if( !existeDept( codeDpt)){
							System.out.println("Le code département  : " + codeDpt + " n'existe pas");
						}
					}while(  !existeDept( codeDpt)) ; 
					
					affPopDeptDonnee( codeDpt);
			break;
				
				case 3 : // Population déune région donnée
					do {
						System.out.println("Saisir une région de France");
						nomRegion = sc.next();
						if( !existeRegion( nomRegion)){
							System.out.println("La région  : " + nomRegion + " n'existe pas");
						}
					}while(  !existeRegion( nomRegion)) ; 
					
					affPopRegionDonnee( nomRegion);
				break;
				
				case 4 : // Afficher les 10 régions les plus peuplées
					aff10RegionPlusPeuplee();
				break;
				
				case 5 : // Afficher les 10 départements les plus peuplés
					aff10DepartementPlusPeuplee();
				break;
				
				case 6 : // Afficher les 10 villes les plus peuplées déun département
					do {
						System.out.println("Saisir un numéro de département de France");
						codeDpt = sc.next();
						if( !existeDept( codeDpt)){
							System.out.println("Le code département  : " + codeDpt + " n'existe pas");
						}
					}while(  !existeDept( codeDpt)) ; 				
				
					aff10VillePlusPeupleeDepartement( codeDpt);
					
				break;
				
				case 7 : // Afficher les 10 villes les plus peuplées déune région
					do {
						System.out.println("Saisir une région de France");
						nomRegion = sc.next();
						if( !existeRegion( nomRegion)){
							System.out.println("La région  : " + nomRegion + " n'existe pas");
						}
					}while(  !existeRegion( nomRegion)) ; 
					
				
					aff10VillePlusPeupleeRegion( nomRegion);
				break;
				
				case 8 : // Afficher les 10 villes les plus peuplées de France
					aff10VillePlusPeupleeFrance();
				break;
				
				case 9 : 
						System.out.println("Au revoir !!");
				break;
				
				
			}
	
		}while( menu != 9);
		
		sc.close();
	}

}
