package fr.diginamic.essais;

import fr.diginamic.entities.Cercle;
import fr.diginamic.utils.CercleFactory;

public class TestCercle {

	public static void main(String[] args) {
		Cercle c1 = new Cercle( 10);
		Cercle c2 = new Cercle( 20);
		
		System.out.println("Cercle 1 : La surface est : " +c1.surface() + " et le perimetre est : " + c1.perimetre());
		System.out.println("Cercle 2 : La surface est : " +c2.surface() + " et le perimetre est : " + c2.perimetre());
		
		Cercle c3 = CercleFactory.buildCercle(10);
		Cercle c4 = CercleFactory.buildCercle(20);
			System.out.println("Cercle 3 : La surface est : " +c3.surface() + " et le perimetre est : " + c3.perimetre());
			System.out.println("Cercle 4 : La surface est : " +c4.surface() + " et le perimetre est : " + c4.perimetre());

	}

}
