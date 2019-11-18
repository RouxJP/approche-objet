package fr.diginamic.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CreationEtManipulationMap {

		public static void main( String args[]) {
			HashMap<Integer, String> mapVilles= new HashMap<>();
			
			mapVilles.put(13, "Marseille");
			mapVilles.put(34, "Montpellier");
			mapVilles.put(44, "Nantes");
			mapVilles.put(75, "Paris");
			mapVilles.put(31, "Toulouse");
			mapVilles.put(59, "Lille");
			mapVilles.put(69, "Lyon");
			mapVilles.put(33, "Bordeaux");
	
			Iterator<Integer> itKeys = mapVilles.keySet().iterator();
			Integer keys = itKeys.next();
			System.out.println( keys);
			do {
				keys = itKeys.next();
				System.out.println( keys);
			}while( itKeys.hasNext());
			
			Iterator<String> itValues = mapVilles.values().iterator();
			String valeur = itValues.next();
			System.out.println( valeur);
			while( itValues.hasNext()) {
				valeur = itValues.next();
				System.out.println( valeur);
				
			}
			System.out.println("La taille de la Map est : " + mapVilles.size());
			
		}
	
}
