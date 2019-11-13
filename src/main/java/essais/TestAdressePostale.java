package essais;

import entites.AdressePostale;

public class TestAdressePostale {

	public static void main(String[] args) {
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

	}

}
