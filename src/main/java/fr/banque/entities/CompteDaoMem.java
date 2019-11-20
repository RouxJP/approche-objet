package fr.banque.entities;

import java.util.ArrayList;
import java.util.Iterator;

public class CompteDaoMem implements CompteDAO {
	// Avant private Compte[]	lstComptes;
	ArrayList<Compte>	lstComptes;
	//private int			nbCpt;	
	
	public CompteDaoMem( ){
		this.lstComptes = new ArrayList<Compte>();
		//this.nbCpt		= 0;
	}
	public String toString() {
		String affichage ;
		if( lstComptes.size() == 0) {
			affichage = "La liste des comptes est vide";
		}
		else {
			affichage = "";
		}
		for( int i = 0 ; i < lstComptes.size() ; i++) {
			affichage += lstComptes.get(i)+ "\n" ;

		}
		
		return affichage ;
	}
	@Override
	public ArrayList<Compte> lister() {
		return lstComptes;
	}

	@Override
	public void sauvegarder(Compte nvCompte) {
		this.lstComptes.add( nvCompte) ;
		
	}

	@Override
	public boolean supprimer(String numero) {
		Compte 	cpt;
		boolean detruit;
		detruit = false;
		if( lstComptes.size() != 0) {
			Iterator<Compte> it = lstComptes.iterator();
			do {
				cpt = it.next();
				if( cpt.getNumCompte().contentEquals( numero)) {
					it.remove();
					detruit = true;
					break;
				}
				cpt = it.next();

			}while( it.hasNext());
			
		}
		return detruit;
		
		/**
		Compte[] cptSav = new Compte[10];
		boolean  cptSupprimer = false;
		int j = 0;
		for( int i = 0 ; i < nbCpt ; i++) {
			if( ! lstComptes[i].getNumCompte().contentEquals(numero )) {
				cptSav[j] = lstComptes[i] ;
				j++;
				
			}else {
				cptSupprimer = true;
			}
		}
		if( cptSupprimer) {
			this.lstComptes = cptSav;
			this.nbCpt		-= 1;
		}
		**/

	}

	@Override
	public boolean existe(String numero) {
		boolean compteExiste = false;
		for( int i = 0 ; i < lstComptes.size() ; i++) {
			if( lstComptes.get(i).getNumCompte().contentEquals(numero) ){
				compteExiste = true;
				break;
			}
		}
		return compteExiste;
	}

	@Override
	public Compte getCompte(String numero) {
		Compte cpt = null;
		for( int i = 0 ; i < lstComptes.size() ; i++) {
			if( lstComptes.get(i).getNumCompte().contentEquals(numero) ){
				cpt = lstComptes.get(i);
				break;
			}
		}
		return cpt;	
	}

}
