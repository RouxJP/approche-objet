package fr.banque.entities;

public class Debit extends Operation {
	public Debit(String	dateOperation, double	mntOperation){
		super( 	dateOperation, 	mntOperation );
	}
	@Override
	public String afficherType() {
		return "D�bit : " + getDateOperation() + " " + getMntOperation();
		
	}
	@Override
	public String getType() {
		return( "DEBIT");
		
	}

}
