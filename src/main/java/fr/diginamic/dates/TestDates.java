package fr.diginamic.dates;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDates {

	public static void main(String[] args) {
		Date d1 = new Date();
		SimpleDateFormat formatteur = new SimpleDateFormat( "dd/mm/yyyy HH:mm:ss");
		System.out.println( formatteur.format( d1));
		
		
		Date d2 = new Date(2019, 11, 20, 23, 59, 00);
		System.out.println( formatteur.format( d2));
/*
		Calendar cal = Calendar.getInstance();
		cal.set( Calendar.HOUR, 23);
		cal.set( Calendar.MINUTE, 59);
		cal.set( Calendar.SECOND, 00);
		
		Date d2 = cal.getTime();
		System.out.println(formatteur.format( d2));
*/		
	}

}
