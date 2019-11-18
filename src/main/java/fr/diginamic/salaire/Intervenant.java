package fr.diginamic.salaire;

public abstract class Intervenant {
		public abstract double getSalaire();
	
		private String	nom;
		private	String	prenom;
		
		public abstract void afficheDonnees() ;
		
		public String toString( ) {
			return "Nom " + getNom() + " " + getPrenom() + " a un salaire de " + getSalaire();

		}

		
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

}
