package fr.diginamic.fichiers.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.exceptions.FonctionnalException;
import fr.diginamic.fichiers.rescencement.jdbc.entities.Ville;

/** Classe représentant un service
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/** Méthode abstraite de traitement que doivent posséder toutes les méthodes de services 
	 * @param lignes lignes du fichier
	 * @param scanner scanner
	 */
	public abstract void traiter(List<Ville>  lstVilles, Scanner scanner) throws FonctionnalException ;
}
