package fr.diginamic.essais;

import fr.diginamic.entities.AdressePostale;

public class TestAdressePostale {

	public static void main(String[] args) {
		/** Avant 
		AdressePostale adP1 = new AdressePostale() ;
		adP1.numRue 		= 12 ;
		adP1.libRue 		= "rue Lilas";
		adP1.codePostal  	= 34070;
		adP1.libVille		= "Montpellier";

		AdressePostale adP2 = new AdressePostale() ;
		adP2.numRue 		= 24 ;
		adP2.libRue 		= "rue Paquerettes";
		adP2.codePostal  	= 34100;
		adP2.libVille		= "Montpellier";
		**/
		AdressePostale adP1 = new AdressePostale( 	12, "rue Lilas", 34070, "Montpellier") ;
		AdressePostale adP2 = new AdressePostale( 	24, "rue Paquerettes", 34100, "Montpellier") ;

		System.out.println(adP1.NB_DEPT);
		System.out.println(adP2.NB_DEPT);
		System.out.println(AdressePostale.NB_DEPT);

	}

}
