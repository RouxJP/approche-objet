package essais;

import geometrie.Cercle;
import geometrie.ObjetGeometrique;
import geometrie.Rectangle;

public class TestObjetGeometrique {

	public static void main(String[] args) {
		ObjetGeometrique[ ]	objets = new ObjetGeometrique[ 2];
		
		objets[0] = new Cercle( 10);
		objets[1] = new Rectangle( 20, 30);
		
		for( int i = 0 ; i < objets.length ; i++) {
			System.out.println( "Perimetre objet " + i + " : " + objets[i].perimetre() + " surface : "  +objets[i].surface());
		}
		/*
		Cercle c1 = (Cercle) objets[0];
		System.out.println( "Périmètre du cercle de rayon - " +c1.getRayon() + " : " + c1.perimetre() + " surface : " + c1.surface());
		*/
	}

}
