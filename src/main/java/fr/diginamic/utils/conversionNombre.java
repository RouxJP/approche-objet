package fr.diginamic.utils;

public class conversionNombre {

	public static void main(String[] args) {
		String	nombreString;
		int		nombre, a, b;

		nombreString = "123";
		nombre = Integer.valueOf(nombreString);
		
		System.out.println( "Le nombre en chane est " + nombreString + " en entier est : " + nombre);
		a = 10 ;
		b = 11;
		System.out.println( "La valeur max de " + a + " et de " + b + " : " + Math.max( a,  b));
	}

}
