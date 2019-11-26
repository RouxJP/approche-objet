package fr.diginamic.fichiers.rescencement_jp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;


public class RescencementSimple {
	private static String[]         tabString ;

	private static ArrayList<Ville> lstCommune = new ArrayList<Ville>();
	private static ArrayList<Ville> lstVilleFiltree = new ArrayList<Ville>();
	
	
	public static void main(String[] args) {
		long	population ;
		Ville	ville ;
		int		numLigne = 0;
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
		
		// Afficher info sur Montpellier
		long	popHerault = 0L;
		for( Ville cVille : lstCommune) {
			if( cVille.getNomCommune().equals( "Montpellier")) {
				System.out.println( cVille);
			}
			if( cVille.getCodeDepartement().equals("34")) {
				popHerault = popHerault +  cVille.getPopulationTot();
			}
		}
		System.out.println("La population de l'h�rault est : " + popHerault);
		
		
		long	popMin = -1L;
		String	villeMoinsPeuplee = "";
		for( Ville cVille : lstCommune) {
			if( cVille.getCodeDepartement().equals("34")) {
				if( (cVille.getPopulationTot() < popMin) || ( popMin ==-1l) ) {
					popMin = cVille.getPopulationTot();
					villeMoinsPeuplee = cVille.getNomCommune();
				}
			}
		}
		System.out.println("La ville la moins peupl�e de l'h�rault est   : " + villeMoinsPeuplee + "( " + popMin + " )");

		
		System.out.println("Les 10 villes les moins peupl�es de l'H�rault");
		lstVilleFiltree = Ville.filterVilleDept( lstCommune, "34") ;
		Collections.sort( lstVilleFiltree , new VilleCompAsc());
		for( int i = 0 ; i < 10; i++) {
			System.out.println( i+1 + " : " + lstVilleFiltree.get(i));
		}

		
		System.out.println("Les 10 villes les plus peupl�es de l'H�rault");
		Collections.sort( lstVilleFiltree , new VilleCompDesc());
		for( int i = 0 ; i < 10; i++) {
			System.out.println( i+1 + " : " + lstVilleFiltree.get(i));
		}

		
		// Afficher info sur population Occitanie
		long	popOccitanie = 0L;
		for( Ville cVille : lstCommune) {
			if( cVille.getNomRegion().equals( "Occitanie")) {
				popOccitanie = popOccitanie +  cVille.getPopulationTot();
			}
		}
		System.out.println("La population de l'Occitanie est : " + popOccitanie);

		
		System.out.println("Les 10 villes les plus peupl�es de l'Occitanie");
		lstVilleFiltree = Ville.filterVilleRegion( lstCommune, "Occitanie") ;
		Collections.sort( lstVilleFiltree , new VilleCompDesc());
		for( int i = 0 ; i < 10; i++) {
			System.out.println( i+1 + " : " + lstVilleFiltree.get(i));
		}
		
		
		System.out.println("Le departement le plus peupl� d'Occitanie");
		ArrayList<Ville> 	lstVillesRegion = Ville.filterVilleRegion( lstCommune, "Occitanie") ;
		Set<Departement>	lstDept			= new TreeSet< Departement>();
		for( Ville cVille : lstVillesRegion) {
			// Creation de la liste de d�partements de la R�gion sans doublons
			lstDept.add( new Departement( cVille.getCodeDepartement(), 0l));
		}
		//System.out.println(lstDept.size());
		long		popDept;
		for( Ville cVille : lstVillesRegion) {
			// Cumuler la population par departement
			for( Departement cDept : lstDept) {
				if( cDept.getCodeDept().equals( cVille.getCodeDepartement())) {
					popDept = cDept.getPopulation();
					cDept.setPopulation( popDept + cVille.getPopulationTot());
				}
			}
		}
		List<Departement>	lstDeptTriee = new ArrayList<Departement>();
		for( Departement cDept : lstDept) {
			lstDeptTriee.add( cDept);
		}
		Collections.sort( lstDeptTriee, new DepartCompDesc());
		for( int i = 0 ; i < 1; i++) {
			System.out.println( i+1 + " : " + lstDeptTriee.get(i));
		}
		
		
		System.out.println( "Affichez les 10 r�gions les plus peupl�es de France");
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
	
		
		System.out.println( " Affichez les 10 d�partement les plus peupl�s de France");
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

}
