package fr.diginamic.fichiers.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.fichiers.rescencement.Application;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

/** Recherche et affichage de la population d'une ville
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationVilleService extends MenuService {
	private static final Logger LOG = LoggerFactory.getLogger( Application.class);

	@Override
	public void traiter( List<Ville>  lstVille, Scanner scanner) {
		
		System.out.println("Quel est le nom de la ville recherchée ? ");
		String choix = scanner.nextLine();
		LOG.info( "RecherchePopulationVilleService : " + choix );
		
		boolean villeTrouvee= false;
		for (Ville ville: lstVille){
			if ( ville.getNom().equalsIgnoreCase(choix) 
					|| 
				 ville.getNom().toLowerCase().startsWith( choix.toLowerCase())){
				 LOG.info( "Ville trouvée : "+ ville.getNomRegion()+ " / Dept : " + ville.getCodeDepartement() + " / " + ville.getNom()+" : "+ville.getPopulation());
				 villeTrouvee = true;
			}
		}
		if( !villeTrouvee) {
			LOG.warn( "Aucune ville trouvée." );
		}
	}

}
