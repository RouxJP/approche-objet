package fr.diginamic.listes;

import java.util.ArrayList;
import java.util.List;

public class TestListeInt {

	public static void main(String[] args) {
		Integer max = 0 ;
		Integer min = 0;
		int		indMin = 0;
		
		List<Integer> liste1= new ArrayList<Integer>();
		liste1.add(-1);
		liste1.add(5);
		liste1.add(7);
		liste1.add(3);
		liste1.add(-2);
		liste1.add(4);
		liste1.add(8);
		liste1.add(5);

		min = liste1.get(0);
		indMin = 0;
		max = liste1.get(0);
		
		for ( int i = 0 ; i < liste1.size() ; i++){
			System.out.println(liste1.get(i));
			if( liste1.get(i) > max) {
				max = liste1.get(i);
			}
			if( liste1.get(i) < min) {
				min = liste1.get(i);
				indMin = i;
			}
		}
		liste1.remove( liste1.get(indMin));
		
		System.out.println( "Taille liste " + liste1.size());
		System.out.println( "Max de la liste " + max);
		
		System.out.println("Liste après suppression du plus petit");
		for ( int i = 0 ; i < liste1.size() ; i++){
			System.out.println(liste1.get(i));
		}
		
		System.out.println("Liste apres mise en positif");
		for ( int i = 0 ; i < liste1.size() ; i++){
			if( liste1.get(i) < 0) {
				liste1.set(i, -liste1.get(i));
			}
			System.out.println(liste1.get(i));
		}
	
	}

}
