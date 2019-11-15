package banque.entities;


import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class MenuCompteBancaire {
	public static String aujourdhui() throws ParseException {
		Date aujourdhui = new Date();
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
		        DateFormat.SHORT,
		        DateFormat.SHORT);


	    return shortDateFormat.format(aujourdhui);
	}
	
	public static void main(String[] args) throws ParseException {
		int				numMenu ;
		Compte			compte;
		CompteDaoMem  	comptesDaoMem = new CompteDaoMem();
		
		Scanner sc = new Scanner( System.in);
		numMenu = 0;

		do {
			System.out.println( "***** Administration des comptes *****\r\n" + 
				"1. Lister les comptes\r\n" + 
				"2. Ajouter un nouveau compte\r\n" + 
				"3. Ajouter une opération à un compte\r\n" + 
				"4. Supprimer un compte\r\n" + 
				"99. Sortir" );
			numMenu= sc.nextInt( );

			switch( numMenu){
				case 1 : 
					System.out.println( comptesDaoMem);
				break;
				case 2 :
					String 	numCompte = null;
					double 	soldeInit = 0.0;
					float 	taux = 0.0f;
					int		typeCompte ;
					do {
						System.out.println( "Saisir le type de compte : \n"
								+ "1 : compte courant \n"
								+ "2 : compte rémunéré");
						typeCompte = sc.nextInt( );
					}while( (typeCompte != 1) && ( typeCompte != 2));

					do {
						System.out.println( "Saisir le numéro de compte : ");
						numCompte = sc.next( );
					}while( comptesDaoMem.existe(numCompte));

					System.out.println( "Saisir le solde initial du compte : ");
					soldeInit = sc.nextDouble();

					if( typeCompte == 2 ) {
						System.out.println( "Saisir le taux du compte : ");
						taux = sc.nextFloat();
					}

					if( typeCompte == 1 ) {
						compte = new Compte(numCompte, soldeInit );
					}else {
						compte = new CompteTaux( taux, numCompte, soldeInit );
					}
					comptesDaoMem.sauvegarder(compte);
					
					
					System.out.println("Le compte a été ajouté ");
					
				break;
				
				case 3 :
					int			typeOpe = 0;
					double		mntOpe = 0.0;
					String		numCpt;
					Compte 		cpt;
					Operation	ope;
					
					System.out.println( comptesDaoMem);
					do {
						System.out.println( "Saisir le numéro de compte concerné : ");
						numCpt = sc.next();
					}while( !comptesDaoMem.existe(numCpt));
	
					do {
						System.out.println( "Saisir le type d'opération : \n"
								+ "1 : Crédit \n"
								+ "2 : Débit");
						typeOpe = sc.nextInt( );
					}while(  ( typeOpe != 1 )&& ( typeOpe != 2));

					do {
						System.out.println( "Saisir le montant de l'opération (positif) : ");
						mntOpe = sc.nextDouble();
					}while( mntOpe < 0);
					
					cpt = comptesDaoMem.getCompte(numCpt);
					if( typeOpe == 1){
						ope = new Credit( aujourdhui(), mntOpe);
					}
					else {
						ope = new Debit( aujourdhui(), mntOpe);				
					}
					cpt.ajouterOperation(ope);
					
			break;
				case 4 :
					
					System.out.println( comptesDaoMem);
					do {
						System.out.println( "Saisir le numéro de compte à supprimer : ");
						numCpt = sc.next();
					}while( !comptesDaoMem.existe(numCpt));
	
					comptesDaoMem.supprimer(numCpt);

				break;
				
				case 99 :
					System.out.println("Au revoir");
				break;
				default :
					System.out.println( "Erreur de saisie");
				break;
			
			}
			
			
		}while( numMenu != 99);
		
		sc.close();
	}

}
