package fr.diginamic.listes;

import java.util.ArrayList;
import java.util.Iterator;

public class TestListeString {

	public static void main(String[] args) {
		String villePLusGrande;
		int	tailllePlusGrande;
		ArrayList<String> lst1 = new ArrayList<String>();
		
		lst1.add( "Nice");
		lst1.add( "Carcassonne");
		lst1.add( "Narbonne");
		lst1.add( "Lyon");
		lst1.add( "Foix");
		lst1.add( "Pau");
		lst1.add( "Marseille");
		lst1.add( "Tarbes");
		
		villePLusGrande 	= lst1.get(0);
		tailllePlusGrande 	= lst1.get(0).length();
		for( int i = 0 ; i < lst1.size() ; i++) {
			if( lst1.get(i).length() > tailllePlusGrande) {
				villePLusGrande = lst1.get(i);
				tailllePlusGrande = lst1.get(i).length();
			}
		}
		System.out.println("La plus grande ville est :" + villePLusGrande);
		
		for( int i = 0 ; i < lst1.size(); i++) {
			lst1.set(i, lst1.get(i).toUpperCase());
		}
		
		Iterator<String> it = lst1.iterator();
		while( it.hasNext()) {
			if( it.next().substring( 0, 1).contentEquals("N")) {
				it.remove();
			}
		}
		for( int i = 0 ; i < lst1.size(); i++) {
			System.out.println( lst1.get(i));
		}
	}

}
