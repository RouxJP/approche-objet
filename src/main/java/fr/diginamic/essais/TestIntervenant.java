package fr.diginamic.essais;

import fr.diginamic.salaire.Intervenant;
import fr.diginamic.salaire.Pigiste;
import fr.diginamic.salaire.Salarie;

public class TestIntervenant {

	public static void main(String[] args) {
		Intervenant int1 = new Pigiste( "Durand", "Pierre", 10, 300);
		Intervenant int2 = new Salarie( "Martin", "Nathalie", 1500);
		
		int1.afficheDonnees();
		int2.afficheDonnees();
		

	}
	

}
