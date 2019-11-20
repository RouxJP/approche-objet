package fr.banque.entities;

public class Credit extends Operation {
	public Credit(String	dateOperation, double	mntOperation){
		super( 	dateOperation, 	mntOperation );
	}

	@Override
	public String afficherType() {
		return "Cr�dit : " + getDateOperation() + " " + getMntOperation();
		
	}

	@Override
	public String getType() {
		return( "CREDIT");
		
	}
	

}
