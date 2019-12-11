package fr.diginamic.fichiers.rescencement.jdbc.entities;

import java.util.ArrayList;
import java.util.List;


/** Données du recensement
 * @author DIGINAMIC
 *
 */
public class Recensement {
	
	/** Liste des Villes */
	private List<Ville> villes  		= new ArrayList<>();
	/** Liste des regions */
	private List<Region> regions  		= new ArrayList<>();
	/** Liste des départements */
	private List<Departement> departements 		 = new ArrayList<>();

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

	/** Getter
	 * @return the regions
	 */
	public List<Region> getRegions() {
		return regions;
	}

	/** Setter
	 * @param regions the regions to set
	 */
	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	/** Getter
	 * @return the departements
	 */
	public List<Departement> getDepartements() {
		return departements;
	}

	/** Setter
	 * @param departements the departements to set
	 */
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
}
