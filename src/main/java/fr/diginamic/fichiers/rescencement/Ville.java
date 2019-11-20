package fr.diginamic.fichiers.rescencement;

import java.util.ArrayList;


public class Ville {
	
	private String	nomRegion ;
	private	String	codeDepartement ;
	// private String	codeCommune ; ??
	private String	nomCommune ;
	private long	populationTot ;
	
	public Ville( 	String	nomRegion, 		String	codeDepartement, 	 String	codeCommune,
					String	nomCommune,	 	long	populationTot ) {
		this.nomRegion 			= nomRegion ;
		this.codeDepartement 	= codeDepartement ; 
		//this.codeCommune 		= codeCommune ;  ???
		this.nomCommune 		= nomCommune ; 
		this.populationTot 		= populationTot ; 

		
	}
	
	/**
	 * Retourne une liste de ville par departement
	 * @param lstVilles
	 * @param codeDept
	 * @return
	 */
	public static ArrayList<Ville> filterVilleDept(  ArrayList<Ville> lstVilles, String codeDept){
		ArrayList<Ville> lstVilleFiltrees = new ArrayList<Ville>() ;
		for( Ville cVille : lstVilles) {
			if( cVille.getCodeDepartement().contentEquals( codeDept)) {
				lstVilleFiltrees.add( cVille);
			}
		}
		return lstVilleFiltrees;
	}

	/**
	 * Retourne une liste de ville par region
	 * @param lstVilles
	 * @param codeDept
	 * @return
	 */
	public static ArrayList<Ville> filterVilleRegion(  ArrayList<Ville> lstVilles, String nomRegion){
		ArrayList<Ville> lstVilleFiltrees = new ArrayList<Ville>() ;
		for( Ville cVille : lstVilles) {
			if( cVille.getNomRegion().contentEquals( nomRegion)) {
				lstVilleFiltrees.add( cVille);
			}
		}
		return lstVilleFiltrees;
	}

	public String toString() {
		return getNomRegion() 	+ " - " + getCodeDepartement()   
								+ " - " + getNomCommune()  + " - " + getPopulationTot() ;
	}
	
	public String getNomRegion(){
		return nomRegion;
	}
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}
	public String getCodeDepartement() {
		return codeDepartement;
	}
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
	/* ??
	public String getCodeCommune() {
		return codeCommune;
	}
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}
	**/
	public String getNomCommune() {
		return nomCommune;
	}
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	public long getPopulationTot() {
		return populationTot;
	}
	public void setPopulationTot(long populationTot) {
		this.populationTot = populationTot;
	}


}
