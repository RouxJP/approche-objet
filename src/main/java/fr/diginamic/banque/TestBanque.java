package fr.diginamic.banque;
import banque.entities.*;

public class TestBanque {

	public static void main(String[] args) {
		Compte[] tabCpt = new Compte[ 2];
		
		Compte cpt = new Compte( "987654321", 1000);
		cpt.ajouterOperation( new Credit("01/01/2019", 100));
		cpt.ajouterOperation( new Credit("02/01/2019", 200));
		cpt.ajouterOperation( new Debit("03/01/2019", 10));
		cpt.ajouterOperation( new Debit("04/01/2019", 20));
	/*	
		CompteTaux cptTaux = new CompteTaux( 4f, "1234A", 1500.0);
		cpt.ajouterOperation( new Credit("01/01/2019", 100));
		cpt.ajouterOperation( new Credit("02/01/2019", 200));
		cpt.ajouterOperation( new Debit("03/01/2019", 10));
		cpt.ajouterOperation( new Debit("04/01/2019", 20));
		*/
		tabCpt[0] = cpt;
		System.out.println(cpt);
		/*
		 * tabCpt[1] = cptTaux;		
		 *
		for( int i = 0 ; i < tabCpt.length ; i++) {
			System.out.println( tabCpt[i]);
		}
		*/

	}

}
