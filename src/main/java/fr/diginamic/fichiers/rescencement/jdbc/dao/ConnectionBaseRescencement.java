package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.fichiers.rescencement.IntegrationRescencement;

public class ConnectionBaseRescencement {
	static Connection 			con 		= null;
	private static final Logger LOG = LoggerFactory.getLogger( IntegrationRescencement.class);

	
	// Static bloc pour récupérer la 1ere fois la connection à la BD
	{
		connectionDataBase();
	}
	/**
	 * Charger le driver à la base MariaDb et établir une connection avec les 
	 * paramètres dans le fichier de properties ( url/user/passwd)
	 */
	public static void connectionDataBase() {
		try {
			// Récupérer les paramètres de connection
			ResourceBundle prop = ResourceBundle.getBundle("DataBaseRescLocale");
			String url 			= prop.getString("url");
			String user 		= prop.getString("user");
			String passwd 		= prop.getString("passwd");
			
			// Charger le driver de MaraiDb
			LOG.info("Tentative de connection à la nbase de donnée...");
		
			DriverManager.registerDriver( new org.mariadb.jdbc.Driver());
			con =  DriverManager.getConnection( url, user, passwd);
			
			if( con == null ) {
				throw new RuntimeException( "Impossible d'établir une connection");
			}
			LOG.info("Connection OK");
			
		} catch (SQLException e) {
			throw new RuntimeException( "Impossible d'établir une connection");

		}
	}
	/**
	 * Retourne la connection fait lors de la primière utilisation de cette classe
	 * @return Connection : con
	 */
	public static Connection getConnection() {
		try {
			if( ( con == null) || ( con.isClosed())){
				connectionDataBase();
			}
		} catch (SQLException e) {
			throw new RuntimeException( "Impossible de rétablir une connection");
		}
		return con;
	}
	
	/** 
	 * Ferme la connection à la base de données
	 */
	public  void closeConnection() {
		try {
			con.close();
					
			
		} catch (SQLException e) {
			throw new RuntimeException( "Impossible de fermer la connection à la Base de données");

		} 
	}
	

}
