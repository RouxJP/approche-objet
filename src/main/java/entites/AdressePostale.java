package entites;

public class AdressePostale {
	
	public 	int		numRue ;
	public 	String	libRue ;
	public 	int		codePostal;
	public 	String	libVille;

	public AdressePostale( 	 	int		numRue, 	 	
								String	libRue, 
								int		codePostal,
	 							String	libVille) {
		
		this.numRue 		= numRue ;
		this.libRue 		= libRue ;
		this.codePostal		= codePostal ;
		this.libVille		= libVille;
		
	}

}
