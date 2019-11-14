package banque;
import banque.entities.*;

public class TestBanque {

	public static void main(String[] args) {
		Compte cpt = new Compte( "987654321", 100000);
		
		System.out.println("Le solde du compte " + cpt.getNumCompte() + " est " + cpt.getSoldeCompte() );
		System.out.println(cpt);

	}

}
