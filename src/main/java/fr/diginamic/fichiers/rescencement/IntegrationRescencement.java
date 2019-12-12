package fr.diginamic.fichiers.rescencement;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.fichiers.rescencement.jdbc.dao.ConnectionBaseRescencement;
import fr.diginamic.fichiers.rescencement.jdbc.dao.DepartementDaoJdbc;
import fr.diginamic.fichiers.rescencement.jdbc.dao.RegionDaoJdbc;
import fr.diginamic.fichiers.rescencement.jdbc.dao.VilleDaoJdbc;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Departement;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Region;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;
import fr.diginamic.fichiers.rescencement.utils.RecensementUtils;

/**
 * Intégrer les données de recensement 2016 à partir de trois fichiers
 *   Regions.csv
*    Departement.csv
*    Communes.csv
 * @author acer
 *
 */
public class IntegrationRescencement {
	private static final String fichierRegion 			= "C:/Tmp/Regions.csv";
	private static final String fichierDepartement 		= "C:/Tmp/Departements.csv";
	private static final String fichierVille 			= "C:/Tmp/Villes.csv";
	private static final Logger LOG = LoggerFactory.getLogger( IntegrationRescencement.class);
	
	
	public static void main(String[] args)   {
		int countDoublons 	= 0;
		int countInsertions = 0;
		int res = 0;
		long tempsDeb = 0;
		long tempsFin = 0;


		// Se connecter à la base MariaDb pour tous les accés à la base
		tempsDeb = System.currentTimeMillis();
	
		LOG.info("Début d'intégration des données");
		ConnectionBaseRescencement conBaseRescencement = new ConnectionBaseRescencement();
	
		//*************
		// Les Regions
		//**************
		List<Region> lstRegion = RecensementUtils.lireRegions( fichierRegion);

		if ( lstRegion == null) {
			LOG.error("L'application doit s'arrétée en raison d'une erreur d'exécution.");
			System.exit(0);
		}
		
		/** Insertion des régions */
		LOG.info("Insertion des regions en cours...");
		RegionDaoJdbc regionDaoJdbc = new RegionDaoJdbc();
		for( Region region : lstRegion) {
				res = regionDaoJdbc.insert( region);
				if( res == 1) {
					countInsertions++;
				}else {
					countDoublons++;
				}
				LOG.debug( "Region " +  region.getNom() +  "traitée");
		}
		LOG.info(" Nombre de region insérées         : " + countInsertions);
		LOG.warn(" Nombre de régions déja existantes : " + countDoublons);

		//**************
		// Les Departements
		//**************
		countDoublons 	= 0;
		countInsertions = 0;
		
		List<Departement> lstDepartement = RecensementUtils.lireDepartements( fichierDepartement);

		if ( lstDepartement == null) {
			LOG.error("L'application doit s'arrétée en raison d'une erreur d'exécution.");
			System.exit(0);
		}
		
			
		// Departement
		LOG.info("Insertion des départements en cours...");
		DepartementDaoJdbc departementDaoJdbc = new DepartementDaoJdbc();
		for( Departement departement : lstDepartement) {
				res = departementDaoJdbc.insert( departement);
				if( res == 1) {
					countInsertions++;
				}else {
					countDoublons++;
				}
				LOG.debug( "Département " +  departement.getNom() +  " traité");
		}
		LOG.info(" Nombre d'insertions OK : " + countInsertions);
		LOG.warn(" Nombre de Département déja existantes : " + countDoublons);

		
		//*************
		// Les Communes
		//**************
		countDoublons 	= 0;
		countInsertions = 0;
		
		List<Ville> lstVille = RecensementUtils.lireVilles( fichierVille);

		if ( lstVille == null) {
			LOG.error("L'application doit s'arrétée en raison d'une erreur d'exécution.");
			System.exit(0);
		}
		
			
		// Ville
		LOG.info("Insertion en cours...");
		VilleDaoJdbc villeDaoJdbc = new VilleDaoJdbc();
		for( Ville ville : lstVille) {
				res = villeDaoJdbc.insert( ville);
				if( res == 1) {
					countInsertions++;
				}else {
					countDoublons++;
				}
				LOG.debug( "Ville " +  ville.getNom() +  " traitée");
		}
		
		LOG.info(" Nombre d'insertions OK : " + countInsertions);
		LOG.warn(" Nombre de Ville déja existantes : " + countDoublons);
	
		// Fermer la base de donnée
		conBaseRescencement.closeConnection();
		
		tempsFin = System.currentTimeMillis();
		LOG.info("Temps d'execution total  : " + (tempsFin - tempsDeb));
		LOG.info("Fin d'intégration des données");

	}

	
}
