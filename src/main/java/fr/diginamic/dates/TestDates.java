package fr.diginamic.dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDates {

	public static void main(String[] args) {
		Date d1 = new Date();
		SimpleDateFormat formatteur = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss");
		System.out.println( formatteur.format( d1));
		
		
		Date d2 = new Date(119, 11, 20, 23, 59, 00);	/* 117 pour 2017 */
		System.out.println( formatteur.format( d2));

		Calendar cal = Calendar.getInstance();
		cal.set( Calendar.HOUR, 11);   					/* 12 + x */
		cal.set( Calendar.MINUTE, 59);
		cal.set( Calendar.SECOND, 00);
		
		Date d3 = cal.getTime();
		System.out.println(formatteur.format( d3));	
	}

}
