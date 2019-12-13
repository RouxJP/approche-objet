package fr.diginamic.fichiers.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.fichiers.rescencement.Application;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

/** Recherche et affichage de la population d'une région
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationRegionService extends MenuService {

	private static final Logger LOG = LoggerFactory.getLogger( Application.class);

	@Override
	public void traiter( List<Ville> lstVille, Scanner scanner) {
		
		System.out.println("Quel est le code de la région recherchée ? ");
		String choix = scanner.nextLine();
		
		int somme = 0;
		String nom = null;
		for (Ville ville: lstVille){
			if (ville.getCodeRegion().equalsIgnoreCase(choix)){
				somme+=ville.getPopulation();
				nom=ville.getNomRegion();
			}
		}
		if (somme>0){
			LOG.info("Population de la région "+nom+" : "+ somme);
		}
		else {
			LOG.info("Région "+choix+" non trouvée.");
		}
	}

}
