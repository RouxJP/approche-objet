package fr.diginamic.fichiers.rescencement;


import java.sql.SQLException;
import java.util.List;

import fr.diginamic.fichiers.rescencement.jdbc.dao.ConnectionBaseRescencement;
import fr.diginamic.fichiers.rescencement.jdbc.dao.DepartementDaoJdbc;
import fr.diginamic.fichiers.rescencement.jdbc.dao.RegionDaoJdbc;
import fr.diginamic.fichiers.rescencement.jdbc.dao.VilleDaoJdbc;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Region;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;
import fr.diginamic.fichiers.rescencement.utils.RecensementUtils;

public class IntegrationRescencement {
	public static void main(String[] args)   {
		int countDoublons 	= 0;
		int countInsertions = 0;

		// Insertion en BD Cloud MySql Rescencement
		ConnectionBaseRescencement conBaseRescencement = new ConnectionBaseRescencement();
	
		//*************
		// Les Regions
		//**************
		List<Region> lstRegion = RecensementUtils.lireRegions("C:/Tmp/Regions.csv");

		if ( lstRegion == null) {
			System.out.println("L'application doit s'arrétée en raison d'une erreur d'exécution.");
			System.exit(0);
		}
		
	
		// Region
		System.out.println("Insertion des regions en cours...");
		RegionDaoJdbc regionDaoJdbc = new RegionDaoJdbc();
		for( Region region : lstRegion) {
			try {
				regionDaoJdbc.insert( region);
				countInsertions++;
				System.out.println( "Insertion region " + countInsertions + " OK");
			} catch (SQLException e) {
				countDoublons ++;
			}
		}
		System.out.println(" Nombre de region insérées  OK : " + countInsertions);
		System.out.println(" Nombre de régions déja existantes : " + countDoublons);

		//**************
		// Les Departements
		//**************
		countDoublons 	= 0;
		countInsertions = 0;
		
		List<Departement> lstDepartement = RecensementUtils.lireDepartements("C:/Tmp/Departements.csv");

		if ( lstDepartement == null) {
			System.out.println("L'application doit s'arrétée en raison d'une erreur d'exécution.");
			System.exit(0);
		}
		
			
		// Departement
		System.out.println("Insertion des départements en cours...");
		DepartementDaoJdbc departementDaoJdbc = new DepartementDaoJdbc();
		for( Departement departement : lstDepartement) {
			try {
				departementDaoJdbc.insert( departement);
				countInsertions++;
				System.out.println( "Insertion Dept " + countInsertions + " OK");
			} catch (SQLException e) {
				countDoublons ++;
			}
		}
		System.out.println(" Nombre d'insertions OK : " + countInsertions);
		System.out.println(" Nombre de Département déja existantes : " + countDoublons);

		
		//*************
		// Les Communes
		//**************
		countDoublons 	= 0;
		countInsertions = 0;
		
		List<Ville> lstVille = RecensementUtils.lireVilles("C:/Tmp/Communes.csv");

		if ( lstVille == null) {
			System.out.println("L'application doit s'arrétée en raison d'une erreur d'exécution.");
			System.exit(0);
		}
		
			
		// Ville
		System.out.println("Insertion en cours...");
		VilleDaoJdbc villeDaoJdbc = new VilleDaoJdbc();
		for( Ville ville : lstVille) {
			try {
				villeDaoJdbc.insert( ville);
				countInsertions++;
				System.out.println( "Insertion " + countInsertions + " OK");
			} catch (SQLException e) {
				countDoublons ++;
			}
		}
		System.out.println(" Nombre d'insertions OK : " + countInsertions);
		System.out.println(" Nombre de Ville déja existantes : " + countDoublons);
		// Fermeture
		conBaseRescencement.CloseConnection();

	}

	
}
