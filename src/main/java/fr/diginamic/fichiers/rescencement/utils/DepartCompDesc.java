package fr.diginamic.fichiers.rescencement.utils;

import java.util.Comparator;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;

public class DepartCompDesc implements Comparator<Departement> {

	@Override
	public int compare(Departement o1, Departement o2) {
		if( o1.getPopulation() < o2.getPopulation()) return 1 ;
		if( o1.getPopulation() > o2.getPopulation()) return -1 ;
		
		return 0;
	}

}
