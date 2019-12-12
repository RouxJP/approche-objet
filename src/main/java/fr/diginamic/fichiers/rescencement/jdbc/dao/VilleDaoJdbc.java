package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;



public class VilleDaoJdbc  implements VilleDao {
	static Connection 						con 		= ConnectionBaseRescencement.getConnection();

	String sqlInsertVille = "INSERT INTO Ville ( CodeCommune, NomCommune, CodeRegion, NomRegion, CodeDepartement, Population)  VALUES ( ?, ?, ?, ?, ?, ?)";
	

	@Override
	/** Insertion d'une ville  dans la table Ville de MariaDb
	 *  @return : 1 insertion OK  
	 *            0 insertion OK  
	 */
	public int insert( Ville ville) {
		
			try {
				// Inserer une nouvelle ville			
				PreparedStatement prep  = con.prepareStatement( sqlInsertVille);
		        prep.setString( 1,  ville.getCodeVille() );
		        prep.setString( 2,  ville.getNom() );
		        prep.setString( 3,  ville.getCodeRegion() );
		        prep.setString( 4,  ville.getNomRegion() );
		        prep.setString( 5,  ville.getCodeDepartement() );
		        prep.setFloat(  6,  ville.getPopulation() );

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



