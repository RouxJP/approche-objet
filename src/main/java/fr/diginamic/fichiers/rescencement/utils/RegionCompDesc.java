package fr.diginamic.fichiers.rescencement.utils;

import java.util.Comparator;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Region;

public class RegionCompDesc implements Comparator<Region> {

	@Override
	public int compare(Region o1, Region o2) {
		if( o1.getPopulation() < o2.getPopulation()) return 1 ;
		if( o1.getPopulation() > o2.getPopulation()) return -1 ;
		
		return 0;
	}

}
