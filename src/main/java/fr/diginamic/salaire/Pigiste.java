package fr.diginamic.salaire;

public class Pigiste extends Intervenant {
	private double nbrJoursTRavailleMois;
	private double tarifJour;
	
	public Pigiste( String nom, String prenom, double nbrJoursTravailleMois, double tarifJour ) {
		setNbrJoursTRavailleMois(nbrJoursTravailleMois);
		setTarifJour(tarifJour);
		setNom(nom);
		setPrenom(prenom);
	}
	
	@Override
	public double getSalaire() {
		return nbrJoursTRavailleMois*tarifJour ;
	}
	
	@Override
	public void afficheDonnees() {
		System.out.println( super.toString() + " statut pigiste");
		
	}


	public double getNbrJoursTRavailleMois() {
		return nbrJoursTRavailleMois;
	}

	public void setNbrJoursTRavailleMois(double nbrJoursTRavailleMois) {
		this.nbrJoursTRavailleMois = nbrJoursTRavailleMois;
	}

	public double getTarifJour() {
		return tarifJour;
	}

	public void setTarifJour(double tarifJour) {
		this.tarifJour = tarifJour;
	}

}
