package entites;

public class Personne {
	public 		String			nom ;
	public		String			prenom;
	public		AdressePostale 	adressePost;
	
	public Personne( 	String			nom, 
						String			prenom,
						AdressePostale 	adressePost) {
		this.nom = nom ;
		this.prenom = prenom ;
		this.adressePost = adressePost;
	}

}
