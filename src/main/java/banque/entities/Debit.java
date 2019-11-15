package banque.entities;

public class Debit extends Operation {
	public Debit(String	dateOperation, double	mntOperation){
		super( 	dateOperation, 	mntOperation );
	}
	@Override
	public String afficherType() {
		return "Débit : " + getDateOperation() + " " + getMntOperation();
		
	}
	@Override
	public String getType() {
		return( "DEBIT");
		
	}

}
