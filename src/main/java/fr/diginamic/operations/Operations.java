package fr.diginamic.operations;

public class Operations {
	public static double calcul( double a, double b, char mode) {
		double result = 0 ;
		
		switch( mode) {
			case '-' :
				result=  a - b;
			break;
			case '+' :
				result=  a + b;
			break;
			case '*' :
				result = a * b;
			break;
			case '/' :
				result = a / b;
			break;
		}
			return result;
		
	}
	
}
