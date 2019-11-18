package fr.diginamic.formes;

public class Carre extends Rectangle{
	private		double	longueur;
	
	public Carre(  double longueur) {
		super(  longueur, longueur);
		this.setLongueur(longueur);
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	
	

}
