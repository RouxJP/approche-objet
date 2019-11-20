package fr.diginamic.essais;

import fr.banque.entities.Compte;

public class TestBanque {

	public static void main(String[] args) {
		Compte c1 = new Compte( "C123", 100);
		Compte c2 = new Compte( "C123", 100);
		Compte c3 = c2 ;
		
		System.out.println( c1.equals( c2));
		System.out.println( c3.equals( c2));
	}

}
