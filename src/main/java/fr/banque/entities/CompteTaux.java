package fr.banque.entities;

public class CompteTaux extends Compte{
	private	float	taux ;	
	
	public CompteTaux( float taux, String numCpt, double solde){
		super( numCpt, solde );
		
		this.taux = taux;
	}
	
	public String toString() {
		return super.toString() + " Taux " + taux ;
	}
}
