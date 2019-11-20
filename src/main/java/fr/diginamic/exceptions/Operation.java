package fr.diginamic.exceptions;

public class Operation {
	
	public double diviser( double a, double b) throws DiviseurNullException {
		if( b == 0) {
			throw new DiviseurNullException( "Le diviseur doit etre non null") ;
		}
		return a/ b ;
	}
	
	
	static public double diviserRuntime( double a, double b)  {
		if( b == 0) {
			throw new RuntimeException( "Le diviseur doit etre non null") ;
		}
		return a/b;
	
	}

}
