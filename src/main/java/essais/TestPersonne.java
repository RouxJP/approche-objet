package essais;

import entites.Personne;

public class TestPersonne {

	public static void main(String[] args) {
		
		Personne per1 = new Personne();
		per1.nom						= "Martin";
		per1.prenom						= "Paul";	
		per1.adressePost.numRue 		= 12 ;
		per1.adressePost.libRue 		= "rue Lilas";
		per1.adressePost.codePostal  	= 34070;
		per1.adressePost.libVille		= "Montpellier";
		
		Personne per2 = new Personne();
		per2.nom						= "Martin";
		per2.prenom						= "Eliane";	
		per2.adressePost.numRue 		= 24 ;
		per2.adressePost.libRue 		= "rue Lilas";
		per2.adressePost.codePostal  	= 34070;
		per2.adressePost.libVille		= "Montpellier";


	}

}
