package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;



public class VilleDaoJdbc extends ConnectionBaseRescencement implements VilleDao {
	Connection 								con 		= null;
	Statement								stat 		= null;
	ResultSet								rs	 		= null ;
	ConnectionBaseRescencement				conRescencement  	= new ConnectionBaseRescencement();

	// Static bloc pour récupérer la 1ere fois la connection à la BD
	{
		 con = conRescencement.getConnection();
	}
	

	@Override
	public void insert( Ville ville) throws  SQLException{
		
			try {
				// Insertion d'un nouveau Article
				
				stat = con.createStatement();
				stat.executeUpdate( "INSERT INTO Ville ( CodeCommune, NomCommune, CodeRegion, NomRegion, CodeDepartement, Population) "
						           + "VALUES ( '" 	+ ville.getCodeVille().replace("'", "''")  + "', '" 
						           					+ ville.getNom().replace("'", "''") + "', '" 
						           					+ ville.getCodeRegion() + "', '" 
						        					+ ville.getNomRegion().replace("'", "''") + "',' " 
						        					+ ville.getCodeDepartement() + "', " 
						           					+ ville.getPopulation() + 
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



