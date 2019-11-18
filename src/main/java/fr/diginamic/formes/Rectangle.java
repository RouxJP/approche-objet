package fr.diginamic.formes;

public class Rectangle extends Forme{
	private 	double	largeur;
	private		double	longueur;
	
	public Rectangle( double largeur, double longueur) {
		this.longueur 	= longueur;
		this.largeur	= largeur ;
	}
	
	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return (largeur + longueur) * 2;
	}

	@Override
	public double surface() {
		// TODO Auto-generated method stub
		return largeur * longueur;
	}

	
}
