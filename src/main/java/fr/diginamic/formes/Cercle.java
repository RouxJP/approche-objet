package fr.diginamic.formes;



public class Cercle extends Forme{
	private 	double	rayon ;
	
	public Cercle(  double rayon) {
		this.rayon = rayon;
	}
	
	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * getRayon();
	}

	@Override
	public double surface() {
		// TODO Auto-generated method stub
		return Math.PI * getRayon() * getRayon();
	}

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}
	

}
