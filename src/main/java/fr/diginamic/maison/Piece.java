package fr.diginamic.maison;

public abstract class Piece {
	public  enum typePiece { P_AUCUNE, P_CHAMBRE, P_CUISINE, P_SALE_DE_BAIN, P_SALON, P_WC };
	private double	superficie;
	private int		numEtage;
	
	public Piece( double	superficie, int		numEtage) {
		if( numEtage < 0) {
			System.out.println(" Impossible saisir �tage n�gatif");
		}
		this.superficie = Math.abs(superficie) ;
		this.numEtage 	= numEtage;
	}
	
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public int getNumEtage() {
		return numEtage;
	}
	public void setNumEtage(int numEtage) {
		this.numEtage = numEtage;
	}
}
