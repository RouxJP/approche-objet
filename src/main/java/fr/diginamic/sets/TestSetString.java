package fr.diginamic.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSetString {

	public static void main(String[] args) {
		String maxPays, newPays, pays;
		Set<String> setD = new HashSet<String>();
		setD.add( "USA");
		setD.add( "France");
		setD.add( "Allemagne");
		setD.add( "UK");
		setD.add( "Italie");
		setD.add( "Japon");
		setD.add( "Chine");
		setD.add( "Russie");
		setD.add( "Inde");
		
		System.out.println("Liste de pays");
		Iterator<String> it = setD.iterator();
		pays = it.next();
		while( it.hasNext()) {
			System.out.println( pays);
			pays = it.next();
			
		}
		
		it = setD.iterator();
		maxPays = it.next();
		while( it.hasNext()) {
			newPays = it.next();
			if(  newPays.length() > maxPays.length()) {
				maxPays = newPays;
			}
		}
		
		System.out.println("La ville la plus longue est  : " + maxPays);
		it = setD.iterator();
		while( it.hasNext()) {
			newPays = it.next();
			if(  newPays.contentEquals(  maxPays)) {
				it.remove();
				break;
			}
		}
		
		System.out.println("Liste sans le pays la plus grande");
		it = setD.iterator();
		pays = it.next();
		while( it.hasNext()) {
			System.out.println( pays);
			pays = it.next();
			
		}
		

	
	
	}

}
