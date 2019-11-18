package fr.diginamic.essais;

import fr.diginamic.entities.Moyenne;

public class TestMoyenne {

	public static void main(String[] args) {
		Moyenne moyTab = new Moyenne();
		
		// Remplir le tableau
		for( int i = 0 ; i < moyTab.getNbrTotNbrMax() ; i++){
			moyTab.ajout( i+1);
		}
		System.out.println( moyTab);
		System.out.println( "La moyenne du tableau est : " + moyTab.calculeMoyenne());
		
		// Rajouter d'autres nombre pour dépasser la taille
		for( int i = 0 ; i < Moyenne.LG_TABLEAU ; i++){
			moyTab.ajout( (i+1)*2);
		}
		System.out.println( moyTab);
		System.out.println( "La moyenne du tableau est : " + moyTab.calculeMoyenne());
	
	}

}
