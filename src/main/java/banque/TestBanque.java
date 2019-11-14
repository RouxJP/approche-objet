package banque;
import banque.entities.*;

public class TestBanque {

	public static void main(String[] args) {
		Compte[] tabCpt = new Compte[ 2];
		
		Compte cpt = new Compte( "987654321", 100000);
		System.out.println("Le solde du compte " + cpt.getNumCompte() + " est " + cpt.getSoldeCompte() );
		System.out.println(cpt);
		
		CompteTaux cptTaux = new CompteTaux( 0.04f, "1234A", 1500.0);
		System.out.println(cptTaux);
		
		tabCpt[0] = cpt;
		tabCpt[1] = cptTaux;		
		for( int i = 0 ; i < tabCpt.length ; i++) {
			System.out.println( tabCpt[i]);
		}

	}

}
