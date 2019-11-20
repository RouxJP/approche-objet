package fr.diginamic.chaines;

import fr.banque.entities.Compte;

/**

2) Utilisez la m�thode length() pour afficher la taille de la chaine de caract�res
3) Utilisez la m�thode indexOf(char c) pour afficher l�index du premier � ; � contenu dans la chaine de caract�res.
4) La m�thode substring(int start, int end) permet d�extraire une portion de chaine de caract�res comprise 
  entre un index de d�but et un index de fin (exclu).
Combinez la m�thode substring et indexOf pour extraire le nom de famille de la personne.
5) Utilisez la m�thode toUpperCase() pour afficher le nom de famille en majuscules.
6) Utilisez la m�thode toLowerCase() pour afficher le nom de famille en majuscules.
7) Utilisez la m�thode split pour d�couper la chaine de caract�res en morceaux. 
Le s�parateur est le caract�re � ; �. Cette m�thode retourne un tableau. Affichez le tableau ainsi obtenu.
8) Creez une instance et Client et de 
Compte � partir des �l�ments issus du d�coupage de la chaine de caract�res.
a. Astuce : le nombre � 1 523.5 � contient un espace qu�il ne faut pas supprimer manuellement mais de mani�re informatique en utilisant la m�thode replace(String, String) de la classe String
 * 
 * @author acer
 *
 */
public class ManipulationChaine {
	
	public static void main(String[] args) {
		String 		chaine 		= "Durand;Marcel;012543;1 523.5";
		String[]	tabChaine	= new String[10];

		char premierCaractere = chaine.charAt(0);
		System.out.println("Premier caract�re: " + premierCaractere);
		
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
