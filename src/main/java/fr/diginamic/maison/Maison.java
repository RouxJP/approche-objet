package fr.diginamic.maison;

import fr.diginamic.maison.Piece.typePiece;

public class Maison {
	private static int NBR_MAX_PIECE = 20;
	private Piece[]	pieces;
	private int		nbrPiece ;
	
	public Maison() {
		this.pieces 	= new Piece[ NBR_MAX_PIECE];
		this.nbrPiece 	= 0 ;
	}
	
	public String toString() {
		String affichage;
		affichage = "Superfice de \n la maison : " + superficieMaison() + "\n";
		int i = 0;
		while( superficieEtageMaison( i) != 0) {
			affichage += " l'étage : " + i + " " + superficieEtageMaison( i) + "\n";
			i++;
		}
		return( affichage);
	}
	
	public void ajouterPiece( Piece piece) {
		if( ( ( nbrPiece < NBR_MAX_PIECE) && ( piece != null)) && piece.getNumEtage() >= 0) {
			pieces[ nbrPiece] = piece ;
			nbrPiece ++;
		}
	}
	
	public double superficieEtageMaison( int numEtage) {
		int superficie;
		superficie = 0;
		for( int i = 0 ; i < nbrPiece; i++) {
			if( pieces[i].getNumEtage() == numEtage){
				superficie += pieces[i].getSuperficie() ;
			}
		}
		return superficie;
	}
	
	public double superficieMaison() {
		int superficie;
		superficie = 0;
		for( int i = 0 ; i < nbrPiece; i++) {
			superficie += pieces[i].getSuperficie() ;
		}
		return superficie;
	}
	
	public double superficieTypePiece( typePiece typePiece) {
		int 		superficie;
		typePiece 	typePieceClasse ;
		
		superficie = 0;
		for( int i = 0 ; i < nbrPiece; i++) {
			typePieceClasse = getTypePieceClasse( pieces[i]);
			if( typePiece == typePieceClasse) {
				superficie += pieces[i].getSuperficie() ;
			}
			
		}
		return superficie;
	}

	public double nbrPieceTypePiece( typePiece typePiece) {
		int 		nbrPieceMemeType;
		typePiece 	typePieceClasse ;
		
		nbrPieceMemeType = 0;
		for( int i = 0 ; i < nbrPiece; i++) {
			typePieceClasse = getTypePieceClasse( pieces[i]);
			if( typePiece == typePieceClasse) {
				nbrPieceMemeType ++ ;
			}
			
		}
		return nbrPieceMemeType;
	}

	private typePiece getTypePieceClasse( Object classPiece) {
		typePiece 	typePieceClasse ;
		String		libClasse ;
		
		libClasse 		= classPiece.getClass().toString();
		typePieceClasse = typePiece.P_AUCUNE ;
		if( libClasse.equals( "class fr.diginamic.maison.Cuisine")){
			typePieceClasse = typePiece.P_CUISINE ;
		}
		if( libClasse.equals( "class fr.diginamic.maison.Chambre")){
			typePieceClasse = typePiece.P_CHAMBRE ;
		}
		if( libClasse.equals( "class fr.diginamic.maison.Salon")){
			typePieceClasse = typePiece.P_SALON ;
		}
		if( libClasse.equals( "class fr.diginamic.maison.SaleDeBain")){
			typePieceClasse = typePiece.P_SALE_DE_BAIN ;
		}
		if( libClasse.equals( "class fr.diginamic.maison.Wc")){
			typePieceClasse = typePiece.P_WC ;
		}
		return typePieceClasse;
	}
}
