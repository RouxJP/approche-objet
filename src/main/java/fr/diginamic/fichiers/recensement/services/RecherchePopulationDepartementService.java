package fr.diginamic.fichiers.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

/** Recherche et affichage de la population d'un département
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationDepartementService extends MenuService {

	@Override
	public void traiter( List<Ville> lstVille, Scanner scanner) {
		
		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();
		
		int somme = 0;
		for (Ville ville: lstVille){
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)){
				somme+=ville.getPopulation();
			}
		}
		if (somme>0){
			System.out.println("Population du département "+choix+" : "+ somme);
		}
		else {
			System.out.println("Département "+choix+ " non trouvé.");
		}
	}

}
