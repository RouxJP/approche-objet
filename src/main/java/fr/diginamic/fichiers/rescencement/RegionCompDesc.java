package fr.diginamic.fichiers.rescencement;

import java.util.Comparator;

public class RegionCompDesc implements Comparator<Region> {

	@Override
	public int compare(Region o1, Region o2) {
		if( o1.getPopRegion() < o2.getPopRegion()) return 1 ;
		if( o1.getPopRegion() > o2.getPopRegion()) return -1 ;
		
		return 0;
	}

}
