package banque.entities;

public class Compte {
	private	String			numCompte ;
	private	double			soldeInitial ;
	private Operation[]		operations;
	private int				nbTotOp;	
	
	public Compte( String numCompte, double soldeInitialCompte) {
		this.numCompte 		= numCompte ;
		this.soldeInitial 	= soldeInitialCompte ;
		this.nbTotOp 		= 0;
		this.operations 	= new Operation[100];
	}
	
	public void ajouterOperation( Operation ope) {
		int nbOpe = getNbTotOp() + 1;
		setNbTotOp( nbOpe);
		operations[nbOpe-1] = ope;
	}
	public double getSolde() {

		return getSoldeInitial()+ getSolde( "CREDIT") + getSolde("DEBIT") ;
	}
	
	public double getSolde( String type) {
		double solde = 0;
		
		for( int i = 0 ; i< getNbTotOp() ; i++) {
			if(  operations[i].getType().equals(type)) {
				solde += operations[i].getMntOperation();
			}
		}
		return solde ;
	}
	
	public String toString() {
		return "Compte " + numCompte + " solde initial : " + soldeInitial  + " Nombre d'opérations : " + getNbTotOp() + " Solde : " + getSolde() ;
	}	

	
	
	public String getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}
	public double getSoldeCompte() {
		return soldeInitial;
	}
	public void setSoldeCompte(double soldeCompte) {
		this.soldeInitial = soldeCompte;
	}
	
	public double getSoldeInitial() {
		return soldeInitial;
	}

	public void setSoldeInitial(double soldeInitial) {
		this.soldeInitial = soldeInitial;
	}

		public int getNbTotOp() {
		return nbTotOp;
	}

	public void setNbTotOp(int nbTotOp) {
		this.nbTotOp = nbTotOp;
	}
	
}
