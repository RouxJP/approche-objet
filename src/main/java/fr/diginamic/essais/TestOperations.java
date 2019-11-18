package fr.diginamic.essais;

import fr.diginamic.operations.Operations;

public class TestOperations {

	public static void main(String[] args) {
		double a = 100;
		double b = 50;
		System.out.println("A = " + a + "\nB = " + b);
		System.out.println(" A - B : " + Operations.calcul( a, b, '-'));
		System.out.println(" A + B : " + Operations.calcul( a, b, '+'));
		System.out.println(" A * B : " + Operations.calcul( a, b, '*'));
		System.out.println(" A / B : " + Operations.calcul( a, b, '/'));

	}

}
