package fr.diginamic.entities;

public class Moyenne {
	public static final int 	LG_TABLEAU		= 10;
	private double[]			tabNombre;
	private int					nbrTotNbr ;
	private int					nbrTotNbrMax;
	
	public Moyenne() {
		tabNombre 		= new double[LG_TABLEAU];
		nbrTotNbr 		= 0 ;
		nbrTotNbrMax	= LG_TABLEAU;
	}
	
	public String toString() {
		String affichage ;
		affichage = "";
		for( int i = 0 ; i < getNbrTotNbr(); i++ ) {
			affichage += this.tabNombre[ i] + " - ";
		}

		return affichage;
		
	}
	public void ajout( double nbr) {
		if(  getNbrTotNbr() == getNbrTotNbrMax()) {
			System.out.println(" Le tableau est plein on l'agrandi");
			double[] tabNombreTmp = new double[getNbrTotNbr() +LG_TABLEAU];
			for( int i = 0 ; i < getNbrTotNbr(); i++ ) {
				tabNombreTmp[ i] = tabNombre[i];
			}
			tabNombreTmp[ getNbrTotNbrMax()] = nbr;
			
			tabNombre = tabNombreTmp;			
			setNbrTotNbrMax(getNbrTotNbr() +LG_TABLEAU);
			int nbrNbr = getNbrTotNbr()+1;
			setNbrTotNbr( nbrNbr);
			
		}else {
			// On ajoute le nombre à la suite
			tabNombre[ getNbrTotNbr()] = nbr;
			int nbrNbr = getNbrTotNbr()+1;
			setNbrTotNbr( nbrNbr);
			
		}
		
			
	}

	public double calculeMoyenne() {
		double somme = 0.0;
		for( int i = 0 ; i < getNbrTotNbr(); i++ ) {
			somme  += tabNombre[i];
		}
		return (somme/ getNbrTotNbr());
		
	}

	public int getNbrTotNbr() {
		return nbrTotNbr;
	}

	public void setNbrTotNbr(int nbrTotNbr) {
		this.nbrTotNbr = nbrTotNbr;
	}

	public int getNbrTotNbrMax() {
		return nbrTotNbrMax;
	}

	public void setNbrTotNbrMax(int nbrTotNbrMax) {
		this.nbrTotNbrMax = nbrTotNbrMax;
	}
	
}
