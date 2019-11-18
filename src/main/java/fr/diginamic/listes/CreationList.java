package fr.diginamic.listes;

import java.util.ArrayList;
import java.util.List;

public class CreationList {

	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>();
		
		for( Integer i = 1 ;  i <= 100 ; i++) {
			lst.add( i);
		}
		System.out.println( lst.size());
	}

}
