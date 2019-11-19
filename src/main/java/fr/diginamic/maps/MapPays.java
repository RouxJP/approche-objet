package fr.diginamic.maps;

import java.util.HashMap;
import java.util.Set;



public class MapPays {


	public static void main(String[] args) {
		Integer nbrHab, nbrHabMin;
		String paysMoinsPeuple;
		
		HashMap<String, Integer> mapPays= new HashMap<String, Integer>();
		mapPays.put("Italie", 	50000000);
		mapPays.put("Allemagne", 	80000000);
		mapPays.put("USA", 	    250000000);
		mapPays.put("Inde", 		1500000000);
		mapPays.put("UK", 		70000000);
		
		Set<String> itClef1 = mapPays.keySet();
		paysMoinsPeuple = "Allemagne"; 
		nbrHabMin = mapPays.get(paysMoinsPeuple);
		for( String key : itClef1  ) {
			nbrHab = mapPays.get( key);
			if( nbrHab < nbrHabMin) {
				nbrHabMin = nbrHab;
				paysMoinsPeuple = key;
			}
		}
		System.out.println( "Le pays qui est le moins peuplé est " + paysMoinsPeuple + " hab : " + nbrHabMin);
		
		mapPays.remove(paysMoinsPeuple);
	
		Set<String> itClef2 = mapPays.keySet();
		for( String key : itClef2  ) {
			System.out.println( "Clef : " + key + " valeur : " + mapPays.get( key));
		}
		


	}



}
