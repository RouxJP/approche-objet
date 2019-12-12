package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Region;

public class RegionDaoJdbc implements RegionDao {
	static Connection 						con 		= ConnectionBaseRescencement.getConnection();

	String sqlInsertRegion = "INSERT INTO Region ( CodeRegion, NomRegion, Population) VALUES ( ?, ?, ?)" ;


	@Override
	/** Insertion d'une region dans la table Region de MariaDb
	 *  @return : 1 insertion OK  
	 *            0 insertion OK  
	 */
	public int insert(Region region)  {
		try {
			// Insertion d'une nouvelle région
			PreparedStatement prep = con.prepareStatement( sqlInsertRegion);
			
			prep.setString( 1, region.getCode());
			prep.setString( 2, region.getNom());
			prep.setFloat(  3, region.getPopulation());

			prep.executeUpdate( );
			
			con.commit();
		
		} catch (SQLIntegrityConstraintViolationException e) {
			return 0;
			
		} catch (SQLException e) {
			throw new RuntimeException( e);
			
		} 
		return 1;
	}

	

}
