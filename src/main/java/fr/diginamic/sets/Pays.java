package fr.diginamic.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Pays {
	private String	nom;
	private	double	nbrHab;
	private	double	pibParHab;
	
	public Pays(  String	nom, double	nbrHab, double	pibParHab  ) {
		this.nom 		= nom;
		this.nbrHab 	= nbrHab ;
		this.pibParHab	 = pibParHab ;
	}
	public static void main(String[] args) {
		double pibPaHabMax, pibTotalMax, pibTotalMin;
		Pays   pays, paysMin;
		String	paysPibParHabMax, paysPibTotMax, paysPibTotMin ;
		Set<Pays> lstPays = new HashSet<Pays>();
		
		lstPays.add( new Pays("Italie", 	50000000, 100));
		lstPays.add( new Pays("Allemagne", 	80000000, 200));
		lstPays.add( new Pays("USA", 	    250000000, 300));
		lstPays.add( new Pays("Inde", 		1500000000, 100));
		lstPays.add( new Pays("UK", 		70000000, 200));

		Iterator<Pays> it = lstPays.iterator();
		pays = it.next();
		pibPaHabMax			= pays.pibParHab ;
		paysPibParHabMax   	= pays.nom;
		pibTotalMax 		= pays.pibParHab * pays.nbrHab ;
		paysPibTotMax   	= pays.nom;
		paysPibTotMin  		= pays.nom;
		pibTotalMin 		= pays.pibParHab * pays.nbrHab ;
		paysMin				= pays;

		
		while( it.hasNext()) {
			pays = it.next();
			if( pays.pibParHab > pibPaHabMax) {
				pibPaHabMax = pays.pibParHab ;
				paysPibParHabMax     = pays.nom;
			}
			if( ( pays.pibParHab * pays.nbrHab) > pibTotalMax) {
				pibTotalMax = pays.pibParHab * pays.nbrHab ;
				paysPibTotMax   = pays.nom;
			}
			if( ( pays.pibParHab * pays.nbrHab) < pibTotalMin) {
				pibTotalMin 	= pays.pibParHab * pays.nbrHab ;
				paysPibTotMin   = pays.nom;
				paysMin			= pays;
			}
			
		}
		System.out.println("Pays qui a le Pib par Hab Max est : " + paysPibParHabMax + " - " + pibPaHabMax);
		System.out.println("Pays qui a le Pib Tot Max est     : " + paysPibTotMax + " - " + pibTotalMax);
		System.out.println("Pays qui a le Pib Tot Min est     : " + paysPibTotMin + " - " + pibTotalMin);
		
		lstPays.remove(paysMin);
		paysMin.setNom( paysMin.getNom().toUpperCase());
		lstPays.add(paysMin);

		// Resultats des modifs et calculs
		it = lstPays.iterator();
		do {
			pays = it.next();
			System.out.println( pays.nom + " / " + "Nbr Hab " + pays.nbrHab + " / Pib total : " + pays.pibParHab * pays.nbrHab);
			
			
		}while ( it.hasNext());

	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getNbrHab() {
		return nbrHab;
	}
	public void setNbrHab(double nbrHab) {
		this.nbrHab = nbrHab;
	}
	public double getPibParHab() {
		return pibParHab;
	}
	public void setPibParHab(double pibParHab) {
		this.pibParHab = pibParHab;
	}

}
