package fr.diginamic.fichiers.rescencement.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionBaseRescencement {
	static Connection 			con 		= null;

	
	// Static bloc pour récupérer la 1ere fois la connection à la BD
	{
		connectionDataBase();
	}
	/**
	 * Charger le driver à la base MariaDb et établir une connection avec les 
	 * paramètres dans le fichier de properties ( url/user/passwd)
	 */
	public void connectionDataBase() {
		try {
			// Récupérer les paramètres de connection
			ResourceBundle prop = ResourceBundle.getBundle("DataBaseRescLocale");
			String url 			= prop.getString("url");
			String user 		= prop.getString("user");
			String passwd 		= prop.getString("passwd");
			
			// Charger le driver de MaraiDb
			DriverManager.registerDriver( new org.mariadb.jdbc.Driver());
			con =  DriverManager.getConnection( url, user, passwd);
			
			if( con == null ) {
				throw new RuntimeException( "Impossible d'établir une connection");
			}
			
		} catch (SQLException e) {
			throw new RuntimeException( "Impossible d'établir une connection");

		}
	}
	/**
	 * Retourne la connection fait lors de la primière utilisation de cette classe
	 * @return Connection : con
	 */
	public static Connection getConnection() {
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
