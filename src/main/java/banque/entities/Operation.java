package banque.entities;

public abstract class Operation {
	private String	dateOperation;
	private double	mntOperation;
	

	public Operation( String	dateOperation, double	mntOperation ) {
		this.dateOperation 	= dateOperation;
		this.mntOperation	= mntOperation ;
	}
	public String getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMntOperation() {
		return mntOperation;
	}

	public void setMntOperation(double mntOperation) {
		this.mntOperation = mntOperation;
	}
	
	public abstract String afficherType();


}
