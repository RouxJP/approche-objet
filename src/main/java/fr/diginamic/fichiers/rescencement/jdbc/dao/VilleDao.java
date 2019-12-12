package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.SQLException;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

public interface VilleDao {
	/** Insertion d'une ville  dans la table Ville de MariaDb
	 *  @return : 1 insertion OK  
	 *            0 insertion OK  
	 */
	public int insert( Ville ville) throws  SQLException;
}
