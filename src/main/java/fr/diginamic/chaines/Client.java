package fr.diginamic.chaines;

import banque.entities.Compte;

public class Client {
	private String	nom;
	private	String	prenom;
	private	Compte	cptClient;
	
	public Client( String	nom, String	prenom, Compte cpt) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.cptClient = cpt;
	}
	
	public String toString() {
		return  "Nom " + getNom() + " " + getPrenom() + " " + 
				cptClient;
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
