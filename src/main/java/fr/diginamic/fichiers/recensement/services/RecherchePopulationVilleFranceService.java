package fr.diginamic.fichiers.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.fichiers.rescencement.Application;
import fr.diginamic.fichiers.rescencement.jdbc.dao.VilleDaoJdbc;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

/** 
 * Recherche et affichage des villes les plus peuplées d'un département
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationVilleFranceService extends MenuService {
	private static final Logger LOG = LoggerFactory.getLogger( Application.class);

	@Override
	public void traiter( List<Ville> lstVille, Scanner scanner) {
		
		VilleDaoJdbc villeFranceDaoJdbc 	= new VilleDaoJdbc();
		List<Ville> lstVilleFrance 		= villeFranceDaoJdbc.extraireVilles();
		int count = 0;
		for( Ville ville : lstVilleFrance) {
			if( count == 0 ) LOG.info(" Les 10 villes les plus peuplés sont : ");
			LOG.info( ville.getNom() + " : " + ville.getPopulation());
			count++;
			if( count == 10) break;
		}
	}

}
