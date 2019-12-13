package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;


public interface DepartementDao {
	/** Insertion d'un département dans la table Departement de MariaDb
	 *  @return : 1 insertion OK  
	 *            0 insertion OK  
	 */
	public int insert( Departement departement) ;

	/**
	 * Extraire de la base MariaDb les départements les plus peuplés 
	 * triés par ordre décroissant
	 * @return
	 */
	public List<Departement> extraireDepartementPlusPeuplee();

	
}
