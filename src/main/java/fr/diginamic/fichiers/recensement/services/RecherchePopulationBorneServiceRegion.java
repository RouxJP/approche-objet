package fr.diginamic.fichiers.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exceptions.FonctionnalException;
import fr.diginamic.fichiers.recensement.exceptions.BadFormatNumberException;
import fr.diginamic.fichiers.recensement.exceptions.HorsIntervalleException;
import fr.diginamic.fichiers.recensement.exceptions.RegionInexistantException;
import fr.diginamic.fichiers.rescencement.Application;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

/** Recherche et affichage de toutes les villes d'un département dont la population
 * est comprise entre une valeur min et une valeur max renseignées par l'utilisateur.
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneServiceRegion extends MenuService  {
	private static final Logger LOG = LoggerFactory.getLogger( Application.class);

	@Override
	public void traiter( List<Ville>  lstVilles, Scanner scanner) throws FonctionnalException {
		
		System.out.println("Quel est le code de la région recherchée ? ");
		String choix = scanner.nextLine();
		
		
		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();
		
		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		int min = 0;
		int max = 0;
		try {
			min = Integer.parseInt(saisieMin) * 1000;
			max = Integer.parseInt(saisieMax) * 1000;
		}
		catch( NumberFormatException ie) {
			throw new BadFormatNumberException( "Le nombre doit avoir que des chiffres.");
		}
			
		if( min < 0 ) {
			throw new HorsIntervalleException( "Le minimun doit etre > 0 ");
		}
		if( max < 0 ) {
			throw new HorsIntervalleException( "Le maximun doit etre > 0 ");
		}
		if( max < min ) {
			throw new HorsIntervalleException( "Le minimun doit etre < au maximun ");
		}

		boolean regionTrouve = false ;
		for (Ville ville: lstVilles){
			if (ville.getCodeRegion().equalsIgnoreCase(choix)){
				regionTrouve = true ;
				break ;
			}
		}
		if( regionTrouve == false ) {
			throw new RegionInexistantException( "La région est inexistante");
		}

		LOG.info( "Les villes de la région " + choix + " entre " + min + " et " + max + " (1000 hab) sont :");
		for (Ville ville: lstVilles){
				if (ville.getPopulation()>=min && ville.getPopulation()<=max)
				LOG.info( ville.getNom() + " : " + ville.getPopulation());
			}
		}
	

}
