package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;

public class DepartementDaoJdbc implements DepartementDao {
	static Connection 						con 		= ConnectionBaseRescencement.getConnection();

	String sqlInsertDepartement = "INSERT INTO Departement ( CodeDepartement, NomDepartement, Population) VALUES ( ?, ?, ?)";

	@Override
	/** Insertion d'un département dans la table Departement de MariaDb
	 *  @return : 1 insertion OK  
	 *            0 insertion OK  
	 */
	public int  insert( Departement departement) {
		try {
			// Insertion d'un nouveau Article
			
			PreparedStatement prep = con.prepareStatement( sqlInsertDepartement);

			prep.setString( 1, departement.getCode());
			prep.setString( 2, departement.getNom());
			prep.setFloat(  3, departement.getPopulation()); 

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
