package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

public interface VilleDao {
	

	/** Insertion d'une ville  dans la table Ville de MariaDb
	 *  @param  : ville objet ville
	 *  @return : 1 insertion OK  
	 *            0 insertion OK  
	 */
	public int insert( Ville ville) throws  SQLException;
	
	/**
	 * Récupérer toutes les informations de la table Ville de MariaDB
	 *  @return : List<Ville> liste des villes 
	 */
	public List<Ville> extraireVilles();
	
	/** Récupérer les villes les plus peuplées pour le département
	 *  passé en paramètre
	 *  @param  : dept  département sur lequel est fait la recherche
	 *  @return : List<Ville> liste des villes 
	 */
	public List<Ville> extraireVillePlusPeupleeDept( String dept);
	
	/** Récupérer les villes les plus peuplées pour la région
	 *  passée en paramètre
	 *  @param  : region  région sur laquelle est faite la recherche
	 *  @return : List<Ville> liste des villes 
	 */
	public List<Ville> extraireVillePlusPeupleeRegion(String region);
	
}
