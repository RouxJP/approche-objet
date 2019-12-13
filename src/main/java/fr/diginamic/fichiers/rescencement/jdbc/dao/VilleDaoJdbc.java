package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;



public class VilleDaoJdbc  implements VilleDao {
	/** Connection à la base MariaDb */
	static Connection 						con 		= ConnectionBaseRescencement.getConnection();

	/** Requetes utilisées pour les prepare statements */
	String sqlSelectVille = 
			"Select CodeRegion, NomRegion, CodeDepartement, CodeCommune, NomCommune, Population from  Ville order by Population desc";
	String sqlSelectVillePlusPeupleeDpt = 
			"Select CodeRegion, NomRegion, CodeDepartement, CodeCommune, NomCommune, Population "
		  + "from  Ville where CodeDepartement = ? order by Population desc";
	String sqlSelectVillePlusPeupleeRegion = 
			"Select CodeRegion, NomRegion, CodeDepartement, CodeCommune, NomCommune, Population "
		  + "from  Ville where CodeRegion = ? order by Population desc";
	String sqlInsertVille = 
			"INSERT INTO Ville ( CodeCommune, NomCommune, CodeRegion, NomRegion, CodeDepartement, Population)  VALUES ( ?, ?, ?, ?, ?, ?)";

	@Override
	/** Récupérer les villes les plus peuplées pour la région
	 *  passée en paramètre
	 *  @param  : region  région sur laquelle est faite la recherche
	 *  @return : List<Ville> liste des villes 
	 */
	public List<Ville> extraireVillePlusPeupleeRegion(String region) {
		List<Ville>  lstVille = new ArrayList<Ville>();
		try {
					
			PreparedStatement prep  = con.prepareStatement( sqlSelectVillePlusPeupleeRegion);
			prep.setString( 1, region);

			ResultSet rs =  prep.executeQuery( );
			
			while( rs.next()) {
				Ville ville = new Ville(  	rs.getString( 1), rs.getString( 2), 
											rs.getString( 3), rs.getString( 4), 
											rs.getString( 5), rs.getLong( 6)) ;
				lstVille.add( ville);
			}
			
			rs.close();
		
		} catch (SQLException e) {
			throw new RuntimeException( e);
			
		} 
		return lstVille;
	

	}


	@Override
	/** Récupérer les villes les plus peuplées pour le département
	 *  passé en paramètre
	 *  @param  : dept  département sur lequel est fait la recherche
	 *  @return : List<Ville> liste des villes 
	 */
	public List<Ville> extraireVillePlusPeupleeDept(String dept) {
		List<Ville>  lstVille = new ArrayList<Ville>();
		try {
					
			PreparedStatement prep  = con.prepareStatement( sqlSelectVillePlusPeupleeDpt);
			prep.setString( 1, dept);

			ResultSet rs =  prep.executeQuery( );
			
			while( rs.next()) {
				Ville ville = new Ville(  	rs.getString( 1), rs.getString( 2), 
											rs.getString( 3), rs.getString( 4), 
											rs.getString( 5), rs.getLong( 6)) ;
				lstVille.add( ville);
			}
			
			rs.close();
		
		} catch (SQLException e) {
			throw new RuntimeException( e);
			
		} 
		return lstVille;
	

	}

	
	@Override
	/**
	 * Récupérer toutes les informations de la table Ville de MariaDB
	 *  @return : List<Ville> liste des villes 
	 */
	public List<Ville> extraireVilles() {
		List<Ville>  lstVille = new ArrayList<Ville>();
		try {
					
			PreparedStatement prep  = con.prepareStatement( sqlSelectVille);

			ResultSet rs =  prep.executeQuery( );
			
			while( rs.next()) {
				Ville ville = new Ville(  	rs.getString( 1), rs.getString( 2), 
											rs.getString( 3), rs.getString( 4), 
											rs.getString( 5), rs.getLong( 6)) ;
				lstVille.add( ville);
			}
			
			rs.close();
		
		} catch (SQLException e) {
			throw new RuntimeException( e);
			
		} 
		return lstVille;
	

	}


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
		        prep.setLong(  6,  ville.getPopulation() );

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



