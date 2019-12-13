package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

public class DepartementDaoJdbc implements DepartementDao {
	static Connection 						con 		= ConnectionBaseRescencement.getConnection();

	String sqlInsertDepartement 	= "INSERT INTO Departement ( CodeDepartement, NomDepartement, Population) VALUES ( ?, ?, ?)";
	String sqlSelectDptPlusPeuple = "SELECT CodeDepartement, NomDepartement, Population FROM DEPARTEMENT ORDER BY POPULATION DESC ";

	/**
	 * Extraire de la base MariaDb les départements les plus peuplés 
	 * triés par ordre décroissant
	 * @return
	 */
	public List<Departement> extraireDepartementPlusPeuplee(){
		List<Departement>  lstDepartement = new ArrayList<Departement>();
		try {
					
			PreparedStatement prep  = con.prepareStatement( sqlSelectDptPlusPeuple);

			ResultSet rs =  prep.executeQuery( );
			
			while( rs.next()) {
				Departement departement = 
						new Departement( rs.getString( 1), rs.getString( 2),  rs.getLong( 3)) ;
				lstDepartement.add( departement);
			}
			
			rs.close();
		
		} catch (SQLException e) {
			throw new RuntimeException( e);
			
		} 
		return lstDepartement;
	}
	



	
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
