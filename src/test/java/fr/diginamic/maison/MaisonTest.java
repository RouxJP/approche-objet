package fr.diginamic.maison;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;





import fr.diginamic.maison.Piece.typePiece;

class MaisonTest {
	Maison m1;
	Piece p1 ;
	Piece p2 ;
	Piece p3 ;
	Piece p4 ;
	Piece p5 ;
	

	@Test
	void testSuperficieMaison() {
		m1 = new Maison();
		p1 = new Salon( 10, 0);
		p2 = new Chambre( 10, 0);
		p3 = new Cuisine( 10, 0);
		p4 = new SaleDeBain( 10, 0);
		p5 = new Wc( 10, 0);
		
		m1.ajouterPiece(p1);
		m1.ajouterPiece(p2);
		m1.ajouterPiece(p3);
		m1.ajouterPiece(p4);
		m1.ajouterPiece(p5);
		
		double s = m1.superficieMaison();
		assertEquals(50, s, 0);
	}

	@Test
	void testSuperficieMaisonNegative() {
		m1 = new Maison();
		p1 = new Salon( -10, 0);
		p2 = new Chambre( 10, 0);
		p3 = new Cuisine( 10, 0);
		p4 = new SaleDeBain( 10, 0);
		p5 = new Wc( 10, 0);
		
		m1.ajouterPiece(p1);
		m1.ajouterPiece(p2);
		m1.ajouterPiece(p3);
		m1.ajouterPiece(p4);
		m1.ajouterPiece(p5);
		
		double s = m1.superficieMaison();
		assertEquals(50, s, 0);
	}
	
	@Test
	void testSuperficieMaisonNull() {
		m1 = new Maison();
		
		m1.ajouterPiece(null);
		m1.ajouterPiece(null);
		
		double s = m1.superficieMaison();
		assertEquals(0, s, 0);
	}

	@Test
	void testSuperficieTypePiece() {
		m1 = new Maison();
		p1 = new Salon( 10, 0);
		p2 = new Chambre( 10, 0);
		m1.ajouterPiece(p1);
		m1.ajouterPiece(p2);
		
		double s = m1.superficieTypePiece( typePiece.P_CHAMBRE);
		assertEquals(10, s, 0);
	
	}

	@Test
	void testSuperficieTypePieceNull() {
		m1 = new Maison();
		p1 = null;
		p2 = null;
		m1.ajouterPiece(p1);
		m1.ajouterPiece(p2);
		
		double s = m1.superficieTypePiece( typePiece.P_CHAMBRE);
		assertEquals(0, s, 0);
	
	}

}
