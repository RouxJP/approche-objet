package fr.diginamic.fichiers.rescencement.utils;

import java.util.Comparator;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

public class VilleCompAsc implements Comparator<Ville> {

	@Override
	/**
	 * Tri ascendant
	 * @param populationTot
	 */
	public int compare(Ville o1, Ville o2) {
		if( o1.getPopulation() > o2.getPopulation()) return 1 ;
		if( o1.getPopulation() < o2.getPopulation()) return -1 ;
		return 0;
	}

}
