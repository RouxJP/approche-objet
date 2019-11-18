package fr.diginamic.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FusionMap {

	public static void main(String[] args) {
		HashMap<Integer, String> map1= new HashMap<Integer, String>();
		map1.put(1, "Rouge");
		map1.put(2, "Vert");
		map1.put(3, "Orange");
		
		
		HashMap<Integer, String> map2= new HashMap<Integer, String>();
		map2.put(4, "Blanc");
		map2.put(5, "Bleu");
		map2.put(6, "Orange");

		HashMap<Integer, String> map3= new HashMap<Integer, String>();
		
		Set<Integer> itClef1 = map1.keySet();
		for( Integer key : itClef1  ) {
			map3.put( key, map1.get(key));
			System.out.println( "Clef " + key + " Valeur " + map1.get(key));
		}
		
		
		
		Set<Integer> itClef2 = map2.keySet();
		for( Integer key : itClef2  ) {
			map3.put( key, map2.get(key));
			System.out.println( "Clef " + key + " Valeur " + map2.get(key));
		}
		
		// 1er méthode de parcours de HashMap
		Set<Integer> itClef3 = map3.keySet();
		for( Integer key : itClef3  ) {
			System.out.println( key + " " + map3.get( key));
		}
	
		// 2eme méthode de parcours de HashMap
		Iterator<Integer> itClef4 = map3.keySet().iterator();
		Integer clef4 = itClef4.next();
		while( itClef4.hasNext()) {
			System.out.println( "Clef : " + clef4 + " Valeur : " + map3.get( clef4));;
			clef4 = itClef4.next();
			
		}


		
		
	}
	

}
