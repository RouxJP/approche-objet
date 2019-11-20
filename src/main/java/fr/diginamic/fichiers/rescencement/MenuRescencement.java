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

public class MenuRescencement {
	private static String[]         tabString ;

	private static ArrayList<Ville> lstCommune = new ArrayList<Ville>();
	private static ArrayList<Ville> lstVilleFiltree = new ArrayList<Ville>();
	/**
	 * Menu de l'application de rescencement 
	 */
	private static void afficherMenu() {
		System.out.println( "Menu du rescencemnet 2016 en France :\n"
		+ " 	- 1. Population d�une ville donn�e\n"
		+ "	- 2. Population d�un d�partement donn�\n"
		+ "	- 3. Population d�une r�gion donn�e\n"
		+ "	- 4. Afficher les 10 r�gions les plus peupl�es\n"
		+ "	- 5. Afficher les 10 d�partements les plus peupl�s\n"
		+ "	- 6. Afficher les 10 villes les plus peupl�es d�un d�partement\n"
		+ "	- 7. Afficher les 10 villes les plus peupl�es d�une r�gion\n"
		+ "	- 8. Afficher les 10 villes les plus peupl�es de France\n"
		+ "	- 9. Sortir\n");
	}
	/**
	 * Affiche la population d'une villee pass�e en param�tre
	 * @param nomVille
	 */
	private static void affPopVilleDonnee( String nomVille) {
		// Afficher info sur ville
		long	populationVille = 0L;
		for( Ville cVille : lstCommune) {
			if( cVille.getNomCommune().equals( nomVille)) {
				populationVille =  cVille.getPopulationTot();
				break;
			}
		}
		System.out.println("La population de " + nomVille + " est : " + populationVille);
	}	
	
	/**
	 * Affiche la population d'un d�partement pass� en param�tre
	 * @param codeDept
	 */
	private static void affPopDeptDonnee( String codeDept) {
		long	popDept = 0L;
		for( Ville cVille : lstCommune) {
			if( cVille.getCodeDepartement().equals(codeDept)) {
					popDept += cVille.getPopulationTot();
			}
		}
		System.out.println("La population de " + codeDept + " est : " + popDept);
	}
	
	/**
	 * Affiche la population d'une r�gion pass� en param�tre
	 * @param nomRegion
	 */
	private static void affPopRegionDonnee( String nomRegion) {
		long	popRegion = 0L;
		for( Ville cVille : lstCommune) {
			if( cVille.getNomRegion().equals(nomRegion)) {
					popRegion += cVille.getPopulationTot();
			}
		}
		System.out.println("La population de " + nomRegion + " est : " + popRegion);
	}
	
	/**
	 * Affiche les 10 r�gions les plus peupl�es de Franc
	 * @param
	 */
	private static void aff10RegionPlusPeuplee() {

		System.out.println( "Les 10 r�gions les plus peupl�es de France");
		Set<Region>		lstRegion			= new TreeSet< Region>();
		for( Ville cVille : lstCommune) {
			// Creation de la liste de region sans doublons
			lstRegion.add( new Region( cVille.getNomRegion(), 0l));
		}
		long		popRegion;
		for( Ville cVille : lstCommune) {
			// Cumuler la population par region
			for( Region cRegion : lstRegion) {
				if( cRegion.getNomRegion().equals( cVille.getNomRegion())) {
					popRegion = cRegion.getPopRegion();
					cRegion.setPopRegion( popRegion + cVille.getPopulationTot());
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
	 * Affiche les 10 d�partements les plus peupl�es de France
	 * @param
	 */
	private static void aff10DepartementPlusPeuplee() {

		System.out.println( " Les 10 d�partement les plus peupl�s de France");
		Set<Departement>	lstDeptPlusPeuple	= new TreeSet< Departement>();
		for( Ville cVille : lstCommune) {
			// Creation de la liste de d�partements de France sans doublons
			lstDeptPlusPeuple.add( new Departement( cVille.getCodeDepartement(), 0l));
		}
		long		populationDept;
		for( Ville cVille : lstCommune) {
			// Cumuler la population par departement
			for( Departement cDept : lstDeptPlusPeuple) {
				if( cDept.getCodeDept().equals( cVille.getCodeDepartement())) {
					populationDept = cDept.getPopulation();
					cDept.setPopulation( populationDept + cVille.getPopulationTot());
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
	 * Affiche les 10 villes les plus peupl�es d'un d�partement
	 * @param codeDept
	 */
	private static void aff10VillePlusPeupleeDepartement( String codeDept) {
		System.out.println("Les 10 villes les plus peupl�es du d�partement :  " + codeDept + " sont : ");
		lstVilleFiltree = Ville.filterVilleDept( lstCommune, codeDept) ;
		Collections.sort( lstVilleFiltree , new VilleCompDesc());
		for( int i = 0 ; i < 10; i++) {
			System.out.println( i+1 + " : " + lstVilleFiltree.get(i));
		}
	}

	
	/**
	 * Affiche les 10 villes les plus peupl�es d'une r�gion
	 * @param nomRegion
	 */
	private static void aff10VillePlusPeupleeRegion( String nomRegion) {
		System.out.println("Les 10 villes les plus peupl�es de " + nomRegion + " sont : ");
		lstVilleFiltree = Ville.filterVilleRegion( lstCommune, nomRegion) ;
		Collections.sort( lstVilleFiltree , new VilleCompDesc());
		for( int i = 0 ; i < 10; i++) {
			System.out.println( i+1 + " : " + lstVilleFiltree.get(i));
		}
	}

	/**
	 * Affiche les 10 villes les plus peupl�es de France
	 * @param
	 */
	private static void aff10VillePlusPeupleeFrance( ) {
		System.out.println("Les 10 villes les plus peupl�es de France sont : ");
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
			if( cVille.getNomCommune().equals( nomVille)){
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
	 * Test de l'existence de la r�gion de france
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
					// On a saut� l'entete
					
					tabString = cLigne.split( ";");
					population = 0l;
					population = Long.parseLong( tabString[ 6].replaceAll( " ", ""));
					ville = new Ville( tabString[ 1], tabString[ 2], tabString[ 4], tabString[ 5], population );
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
				case 1 : // Population d�une ville donn�e
					do {
						System.out.println("Saisir une ville de France");
						nomVille = sc.next();
						if( !existeVille( nomVille)){
							System.out.println("La ville : " + nomVille + " n'existe pas");
						}
					}while(  !existeVille( nomVille)) ; 
					
					affPopVilleDonnee( nomVille);
					
				break;
				
				case 2 : // Population d�un d�partement donn�
					do {
						System.out.println("Saisir un d�partement de France");
						codeDpt = sc.next();
						if( !existeDept( codeDpt)){
							System.out.println("Le code d�partement  : " + codeDpt + " n'existe pas");
						}
					}while(  !existeDept( codeDpt)) ; 
					
					affPopDeptDonnee( codeDpt);
			break;
				
				case 3 : // Population d�une r�gion donn�e
					do {
						System.out.println("Saisir une r�gion de France");
						nomRegion = sc.next();
						if( !existeRegion( nomRegion)){
							System.out.println("La r�gion  : " + nomRegion + " n'existe pas");
						}
					}while(  !existeRegion( nomRegion)) ; 
					
					affPopRegionDonnee( nomRegion);
				break;
				
				case 4 : // Afficher les 10 r�gions les plus peupl�es
					aff10RegionPlusPeuplee();
				break;
				
				case 5 : // Afficher les 10 d�partements les plus peupl�s
					aff10DepartementPlusPeuplee();
				break;
				
				case 6 : // Afficher les 10 villes les plus peupl�es d�un d�partement
					do {
						System.out.println("Saisir un num�ro de d�partement de France");
						codeDpt = sc.next();
						if( !existeDept( codeDpt)){
							System.out.println("Le code d�partement  : " + codeDpt + " n'existe pas");
						}
					}while(  !existeDept( codeDpt)) ; 				
				
					aff10VillePlusPeupleeDepartement( codeDpt);
					
				break;
				
				case 7 : // Afficher les 10 villes les plus peupl�es d�une r�gion
					do {
						System.out.println("Saisir une r�gion de France");
						nomRegion = sc.next();
						if( !existeRegion( nomRegion)){
							System.out.println("La r�gion  : " + nomRegion + " n'existe pas");
						}
					}while(  !existeRegion( nomRegion)) ; 
					
				
					aff10VillePlusPeupleeRegion( nomRegion);
				break;
				
				case 8 : // Afficher les 10 villes les plus peupl�es de France
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
