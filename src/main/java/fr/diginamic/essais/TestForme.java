package fr.diginamic.essais;


import fr.diginamic.formes.Carre;
import fr.diginamic.formes.Cercle;
import fr.diginamic.formes.Forme;
import fr.diginamic.formes.Rectangle;

public class TestForme {

	public static void main(String[] args) {
		Forme f1 = new Cercle( 10);
		Forme f2 = new Rectangle( 10, 20);
		Forme f3 = new Carre( 10);
		
		AffichageForme.afficheForme( f1);
		AffichageForme.afficheForme( f2);
		AffichageForme.afficheForme( f3);
		

	}

}
