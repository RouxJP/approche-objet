package fr.diginamic.fichiers.rescencement.jdbc.dao;


import fr.diginamic.fichiers.rescencement.jdbc.entities.Region;


public interface RegionDao {
	/** Insertion d'une region dans la table Region de MariaDb
	 *  @return : 1 insertion OK  
	 *            0 insertion OK  
	 */
	public int insert(Region region) ;
}
