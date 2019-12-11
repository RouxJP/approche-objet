package fr.diginamic.fichiers.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

/** Recherche et affichage de la population d'une ville
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationVilleService extends MenuService {

	@Override
	public void traiter( List<Ville>  lstVille, Scanner scanner) {
		
		System.out.println("Quel est le nom de la ville recherchée ? ");
		String choix = scanner.nextLine();
		
		for (Ville ville: lstVille){
			if (ville.getNom().equalsIgnoreCase(choix) || ville.getNom().toLowerCase().startsWith(choix.toLowerCase()+" ")){
				System.out.println(ville.getNom()+" : "+ville.getPopulation());
			}
		}
	}

}
