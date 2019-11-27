package fr.diginamic.enumeration;

public enum Saison {
	PRINTEMPS( "Printemps", 1),
	ETE( "Eté", 2),
	AUTOMNE( "Automne", 3),
	HIVER( "Hiver", 4);
	
	
	private String	libelle;
	private int		numOrdre;
	
	private Saison( String libelle, int numOrdre){
		this.libelle 	= libelle;
		this.numOrdre 	= numOrdre;
	}

	public static Saison getSaison( String libelle) {
		if( libelle.equals(PRINTEMPS.getLibelle())) {
			return PRINTEMPS;
		}
		if( libelle.equals(ETE.getLibelle())) {
			return ETE;
		}
		if( libelle.equals(AUTOMNE.getLibelle())) {
			return AUTOMNE;
		}
		if( libelle.equals(HIVER.getLibelle())) {
			return HIVER;
		}
		return null;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getNumOrdre() {
		return numOrdre;
	}

	public void setNumOrdre(int numOrdre) {
		this.numOrdre = numOrdre;
	}

}
