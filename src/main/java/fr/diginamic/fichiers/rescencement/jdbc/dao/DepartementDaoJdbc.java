package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;

public class DepartementDaoJdbc implements DepartementDao {
	Connection 								con 		= null;
	Statement								stat 		= null;
	ResultSet								rs	 		= null ;
	ConnectionBaseRescencement				conRescencement  	= new ConnectionBaseRescencement();

	// Static bloc pour récupérer la 1ere fois la connection à la BD
	{
		 con = conRescencement.getConnection();
	}
	

	@Override
	public void insert(Departement departement) throws SQLException {
		try {
			// Insertion d'un nouveau Article
			
			stat = con.createStatement();
			stat.executeUpdate( "INSERT INTO Departement ( CodeDepartement, NomDepartement, Population) "
					           + "VALUES ( '" 	+ departement.getCode() + "', '" 
					        					+ departement.getNom().replace("'", "''") + "',' " 
					           					+ departement.getPopulation() + 
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
