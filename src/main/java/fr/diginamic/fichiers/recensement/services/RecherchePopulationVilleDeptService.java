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
public class RecherchePopulationVilleDeptService extends MenuService {
	private static final Logger LOG = LoggerFactory.getLogger( Application.class);

	@Override
	public void traiter( List<Ville> lstVille, Scanner scanner) {
		
		System.out.println("Quel est le code du département de recherche ? ");
		String choix = scanner.nextLine();
		
		VilleDaoJdbc villeDeptDaoJdbc 	= new VilleDaoJdbc();
		List<Ville> lstVilleDept 		= villeDeptDaoJdbc.extraireVillePlusPeupleeDept( choix);
		int count = 0;
		for( Ville dept : lstVilleDept) {
			if( count == 0 ) LOG.info(" Les 10 villes les plus peuplés de " + choix + " sont : ");
			LOG.info( dept.getNom() + " : " + dept.getPopulation());
			count++;
			if( count == 10) break;
		}
		if( count == 0 ) System.out.println("Le département est inconnu");
	}

}
