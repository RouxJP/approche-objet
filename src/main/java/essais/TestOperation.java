package essais;

import banque.entities.Credit;
import banque.entities.Debit;
import banque.entities.Operation;

public class TestOperation {

	public static void main(String[] args) {
		String libAff;
		double mntTotDebit, mntTotCredit;
		
		Operation[]  operations = new Operation[4];
		
		operations[ 0] = new Credit("01/01/2019", 100.0);
		operations[ 1] = new Credit("02/01/2019", 200.0);
		operations[ 2] = new Debit("03/01/2019", 300.0);
		operations[ 3] = new Debit("04/01/2019", 400.0);
		
		mntTotCredit = 0;
		mntTotDebit  = 0;
		for( int i = 0 ; i < operations.length ; i++) {
			//System.out.println(operations[i].getDateOperation() + " " + operations[i].getMntOperation());
			libAff = operations[i].afficherType() ;
			System.out.println( libAff);
			if( libAff.substring(0, 6).equals( "Crédit") ) {
				mntTotCredit += operations[i].getMntOperation();
				
			}else {			
				mntTotDebit -= operations[i].getMntOperation();
				
			}		
		}
		System.out.println("Le total débit est : " + mntTotDebit);
		System.out.println("Le total crébit est : " + mntTotCredit);
	}

}
