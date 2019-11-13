package entites;

public class Personne {
	public 		String			nom ;
	public		String			prenom;
	public		AdressePostale 	adressePost;
	
	/**
	 * Lire l'adresse postale
	 */
	public AdressePostale getAdressePostale() {
		return this.adressePost ;
	}
	/**
	 * Lire le prenom
	 */
	public String getPreom() {
		return( this.prenom);
	}
	/**
	 * Lire le nom
	 */
	public String getNom() {
		return( this.nom);
	}
	/**
	 * Maj de l'adresse postale
	 * @param adPost
	 */
	public void setAdresse( AdressePostale adPost) {
		this.adressePost = adPost;
	}
	/**
	 * Maj du prenom
	 * @param prenom
	 */
	public void setPrenom( String prenom) {
		this.prenom = prenom ;
	}
	
	/**
	 * Maj du nom
	 * @param nom
	 */
	
	public void setNom( String nom) {
		this.nom = nom ;
	}
	
	/**
	 * Afficher nom et prenom en majuscule
	 */
	public void afficherNomPrenomMaj() {
		System.out.println( nom.toUpperCase() + " " + prenom);
	}
	/**
	 * Afficher adresse postale
	 * @param nom
	 * @param prenom
	 * @param adressePost
	 */
	public void afficherAdressePost() {
		System.out.println( adressePost.numRue + " " + adressePost.libRue 
							+ " "+ adressePost.codePostal	 + " " + adressePost.libVille);
		
	}
	
	public Personne( 	String			nom, 
						String			prenom,
						AdressePostale 	adressePost) {
		this.nom = nom ;
		this.prenom = prenom ;
		this.adressePost = adressePost;
	}

}
