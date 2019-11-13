package essais;

import entites.AdressePostale;
import entites.Personne;

public class TestPersonne {

	public static void main(String[] args) {
		
		/** avant
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
		
		Personne per1 = new Personne( "Martin", "Paul", new AdressePostale(12, "rue Lilas", 34070, "Montpellier"));
		Personne per2 = new Personne( "Martin", "Eliane", new AdressePostale(24, "rue Lilas", 34100, "Montpellier"));
		System.out.println( "per1.nom prenom : " + per1.nom + " " + per1.prenom + " Ville : " + per1.adressePost.libVille);
		System.out.println( "per1.nom prenom : " + per2.nom + " " + per2.prenom + " Ville : " + per2.adressePost.libVille);
		**/
		
		Personne per1 = new Personne( "Martin", "Paul", new AdressePostale(12, "rue Lilas", 34070, "Montpellier"));
		Personne per2 = new Personne( "Martin", "Eliane", new AdressePostale(24, "rue Lilas", 34100, "Montpellier"));
		per1.afficherNomPrenomMaj();
		per1.afficherAdressePost();
		
		per1.setNom( "Durand");
		per1.setAdresse( new AdressePostale(1200, "rue Mimosas", 34000, "Montpellier"));
		
		per1.afficherNomPrenomMaj();
		per1.afficherAdressePost();



	}

}
