package fr.diginamic.listes;

import java.util.ArrayList;

public class Ville {
	private String	nom;
	private	long	nbHab;
	
	public Ville(  String	nom, long nbHab) {
		this.nom = nom ;
		this.nbHab = nbHab;
	}
	
	
	public static void main(String[] args) {
		String 	villePlusPeuplee;
		int		indMoinsPeuplee;
		long	minHab;
		
		ArrayList<Ville> lstV = new ArrayList<Ville>();
		lstV.add( new Ville( "Nice", 	343000) );
		lstV.add( new Ville("Carcassonne", 	47800));
		lstV.add( new Ville("Narbonne", 	53400 ));
		lstV.add( new Ville("Lyon", 	484000 ));
		lstV.add( new Ville("Foix", 	9700 ));
		lstV.add( new Ville("Pau", 	77200)); 
		lstV.add( new Ville("Marseille", 	850700) );
		lstV.add( new Ville("Tarbes", 	40600 ));
		for( int i = 0 ; i < lstV.size() ; i++) {
			System.out.println( lstV.get( i).nom);
		}
		
		long maxHab			= lstV.get( 0).nbHab;
		villePlusPeuplee	= lstV.get( 0).nom;
		minHab				= lstV.get( 0).nbHab;
		indMoinsPeuplee		= 0;
		for( int i = 0 ; i < lstV.size() ; i++) {
			if( maxHab < lstV.get( i).nbHab) {
				maxHab = lstV.get( i).nbHab;
				villePlusPeuplee = lstV.get( i).nom;				
			}
			if( minHab > lstV.get( i).nbHab) {
				minHab = lstV.get( i).nbHab;
				indMoinsPeuplee = i;				
			}
			
		}
		lstV.remove( indMoinsPeuplee);
		System.out.println("La ville la plus peuplée est : " + villePlusPeuplee);
		for( int i = 0 ; i < lstV.size() ; i++) {
			if( lstV.get(i).nbHab > 100000) {
				lstV.set(i, new Ville( lstV.get(i).nom.toUpperCase(), lstV.get(i).nbHab )) ;
			}
		}

		System.out.println("Les villes avec plus de 100000 hab sont en majuscules : ");
		for( int i = 0 ; i < lstV.size() ; i++) {
			System.out.println( lstV.get( i).nom);
		}

	}

}
