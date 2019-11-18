package fr.diginamic.chaines;

import banque.entities.Compte;

/**

2) Utilisez la méthode length() pour afficher la taille de la chaine de caractères
3) Utilisez la méthode indexOf(char c) pour afficher l’index du premier « ; » contenu dans la chaine de caractères.
4) La méthode substring(int start, int end) permet d’extraire une portion de chaine de caractères comprise 
  entre un index de début et un index de fin (exclu).
Combinez la méthode substring et indexOf pour extraire le nom de famille de la personne.
5) Utilisez la méthode toUpperCase() pour afficher le nom de famille en majuscules.
6) Utilisez la méthode toLowerCase() pour afficher le nom de famille en majuscules.
7) Utilisez la méthode split pour découper la chaine de caractères en morceaux. 
Le séparateur est le caractère « ; ». Cette méthode retourne un tableau. Affichez le tableau ainsi obtenu.
8) Creez une instance et Client et de 
Compte à partir des éléments issus du découpage de la chaine de caractères.
a. Astuce : le nombre « 1 523.5 » contient un espace qu’il ne faut pas supprimer manuellement mais de manière informatique en utilisant la méthode replace(String, String) de la classe String
 * 
 * @author acer
 *
 */
public class ManipulationChaine {
	
	public static void main(String[] args) {
		String 		chaine 		= "Durand;Marcel;012543;1 523.5";
		String[]	tabChaine	= new String[10];

		char premierCaractere = chaine.charAt(0);
		System.out.println("Premier caractère: " + premierCaractere);
		
		System.out.println( "La taille de la chaine est " + chaine.length());
		
		System.out.println( "L'index du premier ; est : " + chaine.indexOf(";"));
		
		System.out.println(" Le nom de famille est : " + chaine.substring( 0, chaine.indexOf(";")));
	
		System.out.println(" MAJ : Le nom de famille est : " + chaine.substring( 0, chaine.indexOf(";")).toUpperCase());
		
		System.out.println(" MIN : Le nom de famille est : " + chaine.substring( 0, chaine.indexOf(";")).toLowerCase());
	
		tabChaine = chaine.split( ";", 4);
		for( int i = 0 ; i < 4; i++) {
				System.out.println( tabChaine[i]) ;
		}
		String 	nom 		= tabChaine[0];
		String 	prenom 		= tabChaine[1];
		String	numCompte	= tabChaine[2];
		Double 	mntInit			= Double.parseDouble( tabChaine[3].replace(" ", ""));
		Compte 	compteClient	= new Compte(numCompte, mntInit );
		Client 	client 			= new Client( nom, prenom, compteClient);
		
		System.out.println( compteClient);
		System.out.println( client);
		
		
	}
}
