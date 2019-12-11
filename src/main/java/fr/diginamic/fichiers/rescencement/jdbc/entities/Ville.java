package fr.diginamic.fichiers.rescencement.jdbc.entities;

import java.util.ArrayList;
import java.util.List;

/** Représente une ville
 * @author DIGINAMIC
 *
 */
public class Ville  {
	
	/** codeRegion : code de la région */
	private String codeRegion;
	/** nomRegion : nom de la région */
	private String nomRegion;
	/** codeDepartement : code du département */
	private String codeDepartement;
	/** code INSEE de la ville */
	private String codeVille;
	/** nom de la ville */
	private String nom;
	/** population totale */
	private long population;
	
	/** Constructeur
	 * @param codeRegion code de la région
	 * @param nomRegion nom de la région
	 * @param codeDepartement code du département
	 * @param codeVille code INSEE de la ville
	 * @param nom nom de la ville
	 * @param population population totale
	 */
	public Ville(String codeRegion, String nomRegion, String codeDepartement, String codeVille, String nom, long population) {
		this.codeRegion=codeRegion;
		this.nomRegion=nomRegion;
		this.codeDepartement=codeDepartement;
		this.codeVille = codeVille;
		this.nom = nom;
		this.population = population;
	}
	
	/**
	 * Retourne une liste de ville filtree par département
	 * @param lstVille
	 * @param codeRegion
	 * @return
	 */
	public static ArrayList<Ville> filterVilleDept( ArrayList<Ville> lstVille, String codeDepartement ){
		ArrayList<Ville> lstVilleFiltree = new ArrayList<Ville>();
		
		for( Ville ville : lstVille) {
			if( ville.getCodeDepartement().contentEquals(codeDepartement)) {
				lstVilleFiltree.add( ville);
							
			}
		}
		return lstVilleFiltree;
	}
	
	/**
	 * Retourne une liste de ville filtree par region
	 * @param lstVille
	 * @param codeRegion
	 * @return
	 */
	public static ArrayList<Ville> filterVilleRegion( ArrayList<Ville> lstVille, String codeRegion ){
		ArrayList<Ville> lstVilleFiltree = new ArrayList<Ville>();
		
		for( Ville ville : lstVille) {
			if( ville.getNomRegion().contentEquals(codeRegion)) {
				lstVilleFiltree.add( ville);
							
			}
		}
		return lstVilleFiltree;
	}
	
	@Override
	public String toString(){
		return nom + " " + population + " hab.";
	}

	/** Getter
	 * @return the codeRegion
	 */
	public String getCodeRegion() {
		return codeRegion;
	}

	/** Setter
	 * @param codeRegion the codeRegion to set
	 */
	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}

	/** Getter
	 * @return the nomRegion
	 */
	public String getNomRegion() {
		return nomRegion;
	}

	/** Setter
	 * @param nomRegion the nomRegion to set
	 */
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	/** Getter
	 * @return the codeDepartement
	 */
	public String getCodeDepartement() {
		return codeDepartement;
	}

	/** Setter
	 * @param codeDepartement the codeDepartement to set
	 */
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	/** Getter
	 * @return the codeVille
	 */
	public String getCodeVille() {
		return codeVille;
	}

	/** Setter
	 * @param codeVille the codeVille to set
	 */
	public void setCodeVille(String codeVille) {
		this.codeVille = codeVille;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the population
	 */
	public long getPopulation() {
		return population;
	}

	/** Setter
	 * @param population the population to set
	 */
	public void setPopulation(long population) {
		this.population = population;
	}




}
