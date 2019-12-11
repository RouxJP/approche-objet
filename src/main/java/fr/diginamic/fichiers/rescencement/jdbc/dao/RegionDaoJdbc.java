package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Region;

public class RegionDaoJdbc implements RegionDao {
	Connection 								con 		= null;
	Statement								stat 		= null;
	ResultSet								rs	 		= null ;
	ConnectionBaseRescencement				conRescencement  	= new ConnectionBaseRescencement();

	// Static bloc pour récupérer la 1ere fois la connection à la BD
	{
		 con = conRescencement.getConnection();
	}
	


	@Override
	public void insert(Region region) throws SQLException {
		
		try {
			// Insertion d'un nouveau Article
			
			stat = con.createStatement();
			stat.executeUpdate( "INSERT INTO Region ( CodeRegion, NomRegion, Population) "
					           + "VALUES ( '" 	+ region.getCode() + "', '" 
					        					+ region.getNom().replace("'", "''") + "',' " 
					           					+ region.getPopulation() + 
					           					" )");
			
			con.commit();
		
		} catch (SQLException e) {
			throw e;
		} finally {
			// Fermetures
			try {
				stat.close();
			} catch (SQLException e) {
				System.out.println( e.getMessage());
			}
		}
	}

	

}
