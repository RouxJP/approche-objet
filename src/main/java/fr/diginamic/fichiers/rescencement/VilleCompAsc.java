package fr.diginamic.fichiers.rescencement;

import java.util.Comparator;

public class VilleCompAsc implements Comparator<Ville> {

	@Override
	/**
	 * Tri ascendant
	 * @param populationTot
	 */
	public int compare(Ville o1, Ville o2) {
		if( o1.getPopulationTot() > o2.getPopulationTot()) return 1 ;
		if( o1.getPopulationTot() < o2.getPopulationTot()) return -1 ;
		return 0;
	}

}
