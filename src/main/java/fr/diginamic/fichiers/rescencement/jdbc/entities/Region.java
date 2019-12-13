package fr.diginamic.fichiers.rescencement.jdbc.entities;

import java.util.ArrayList;
import java.util.List;

/** Représente une région
 * @author DIGINAMIC
 *
 */
public class Region implements Comparable<Region>  {

	/** code : String*/
	private String code;
	/** nom : String*/
	private String nom;
	/** population : int*/
	private long population;
	
	/** villes : List<Ville>*/
	private List<Ville> villes = new ArrayList<>();
	
	/** Constructeur
	 * @param code code
	 * @param nom nom
	 */
	public Region(String code, String nom, long population) {
		this.code = code;
		this.nom = nom;
		this.population = population;
	}
	
	@Override
	public int compareTo(Region o) {
		return this.nom.compareTo( o.getNom());
	}

	
	/** Ajoute une ville
	 * @param ville ville
	 */
	public void addVille(Ville ville){
		villes.add(ville);
		this.population=this.population+ville.getPopulation();
	}
	
	/** Getter
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/** Setter
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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

	/** Getter
	 * @return the villes
	 */
	public List<Ville> getVilles() {
		return villes;
	}

	/** Setter
	 * @param villes the villes to set
	 */
	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	
}
