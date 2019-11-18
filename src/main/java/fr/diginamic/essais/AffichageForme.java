package fr.diginamic.essais;

import fr.diginamic.formes.Forme;

public class AffichageForme {
	public static void afficheForme( Forme forme) {
		System.out.println( "Le perimetre est : " + forme.perimetre() + " et la surce est : " + forme.surface());
	}
}
