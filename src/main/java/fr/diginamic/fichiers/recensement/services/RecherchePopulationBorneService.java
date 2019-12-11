package fr.diginamic.fichiers.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.exceptions.BadFormatNumberException;
import fr.diginamic.exceptions.DeptInexistantException;
import fr.diginamic.exceptions.FonctionnalException;
import fr.diginamic.exceptions.HorsIntervalleException;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

/** Recherche et affichage de toutes les villes d'un département dont la population
 * est comprise entre une valeur min et une valeur max renseignées par l'utilisateur.
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService  {

	@Override
	public void traiter( List<Ville>  lstVilles, Scanner scanner) throws FonctionnalException {
		
		System.out.println("Quel est le code du département recherché ? ");
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

		boolean deptTrouve = false ;
		for (Ville ville: lstVilles){
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)){
				deptTrouve = true ;
				break ;
			}
		}
		if( deptTrouve == false ) {
			throw new DeptInexistantException( "Le département n'existe pas");
		}

		for (Ville ville: lstVilles){
				if (ville.getPopulation()>=min && ville.getPopulation()<=max)
				System.out.println(ville);
			}
		}
	

}
