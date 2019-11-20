package fr.diginamic.exceptions;

public class TestException {

	public static void main(String[] args) {
		Operation op = new Operation();
	
		try {
			System.out.println( op.diviser(12.12, 24.24));
			System.out.println( op.diviser(12.12, 48.24));
			System.out.println( op.diviser(12.12, 0));
			
		} catch (DiviseurNullException e) {
			System.out.println( e.getMessage());
		}
	}

}
