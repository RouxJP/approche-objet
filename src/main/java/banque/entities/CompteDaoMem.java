package banque.entities;

public class CompteDaoMem implements CompteDAO {
	private Compte[]	lstComptes;
	private int			nbCpt;	
	
	public CompteDaoMem( ){
		this.lstComptes = new Compte[10];
		this.nbCpt		= 0;
	}
	public String toString() {
		String affichage ;
		if( nbCpt == 0) {
			affichage = "La liste des comptes est vide";
		}
		else {
			affichage = "";
		}
		for( int i = 0 ; i < nbCpt ; i++) {
			affichage += lstComptes[i]+ "\n" ;

		}
		
		return affichage ;
	}
	@Override
	public Compte[] lister() {
		return lstComptes;
	}

	@Override
	public void sauvegarder(Compte nvCompte) {
		this.lstComptes[ getNbCpt()] = nvCompte ;
		this.nbCpt					 += 1;
		
		
	}

	@Override
	public boolean supprimer(String numero) {
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
		return false;
	}

	@Override
	public boolean existe(String numero) {
		boolean compteExiste = false;
		for( int i = 0 ; i < nbCpt ; i++) {
			if( lstComptes[ i].getNumCompte().contentEquals(numero) ){
				compteExiste = true;
				break;
			}
		}
		return compteExiste;
	}

	@Override
	public Compte getCompte(String numero) {
		Compte cpt = null;
		for( int i = 0 ; i < lstComptes.length ; i++) {
			if( lstComptes[ i].getNumCompte().contentEquals(numero) ){
				cpt = lstComptes[ i];
				break;
			}
		}
		return cpt;	
	}

	public int getNbCpt() {
		return nbCpt;
	}

	public void setNbCpt(int nbCpt) {
		this.nbCpt = nbCpt;
	}

}
