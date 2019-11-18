package essais;

import fr.diginamic.maison.*;
import fr.diginamic.maison.Piece.typePiece;

public class TestMaison {

	public static void main(String[] args) {
		Maison maison = new Maison();
		
		maison.ajouterPiece(  new Cuisine( 10, 0));
		maison.ajouterPiece(  new SaleDeBain( 10, 0));
		maison.ajouterPiece(  new Salon( 40, 0));
		maison.ajouterPiece(  new Wc( 5, 0));

		maison.ajouterPiece(  new Chambre( 10, 1));
		maison.ajouterPiece(  new Chambre( 15, 1));
		maison.ajouterPiece(  new SaleDeBain( 10, 1));
		maison.ajouterPiece(  new Wc( 5, 1));
		
		maison.ajouterPiece(  new Cuisine( 10, -1));
		
		System.out.println( maison );
		
		System.out.println( " Superficie cuisines : " + maison.superficieTypePiece( typePiece.P_CUISINE));
		System.out.println( " Superficie SaleDeBains : " + maison.superficieTypePiece( typePiece.P_SALE_DE_BAIN));

		System.out.println( " Nbr cuisines : " + maison.nbrPieceTypePiece( typePiece.P_CUISINE));
		System.out.println( " Nbr SaleDeBains : " + maison.nbrPieceTypePiece( typePiece.P_SALE_DE_BAIN));

	}

}
