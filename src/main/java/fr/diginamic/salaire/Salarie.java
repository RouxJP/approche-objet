package fr.diginamic.salaire;

public class Salarie extends Intervenant {
	private double mntSalaireMensuel;
	public Salarie( String nom, String prenom, double mntSalaireMensuel ) {
		setMntSalaireMensuel(mntSalaireMensuel);
		setNom(nom);
		setPrenom(prenom);
	}
	
	@Override
	public double getSalaire() {
		return mntSalaireMensuel;
	}

	public double getMntSalaireMensuel() {
		return mntSalaireMensuel;
	}

	public void setMntSalaireMensuel(double mntSalaireMensuel) {
		this.mntSalaireMensuel = mntSalaireMensuel;
	}

	@Override
	public void afficheDonnees() {
		System.out.println( super.toString() + " statut salarié");
		
	}
	
	

}
