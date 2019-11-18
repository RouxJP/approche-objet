package fr.diginamic.maps;

import java.util.HashMap;
import java.util.Map;

public class CreationMap {

	public static void main(String[] args) {
		Map<String, Double> mapSalaires = new HashMap<String, Double>();
		
		mapSalaires.put( "Paul", 1750.0);
		mapSalaires.put( "Hicham", 1825.0);
		mapSalaires.put( "Yu", 2250.0);
		mapSalaires.put( "Ingrid", 2015.0);
		mapSalaires.put( "Chantal", 2418.0);
		
		System.out.println(mapSalaires.size());
		
		

	}

}
