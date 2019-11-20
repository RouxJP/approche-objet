package essais;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatteur = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss");
		
		Date d1 = cal.getTime();
		System.out.println( "Date systeme  : " + formatteur.format( d1));
		
		formatteur = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss");
		cal.set( Calendar.HOUR, 23);
		cal.set( Calendar.MINUTE, 30);
		cal.set( Calendar.SECOND, 59);
		Date d2 = cal.getTime();
		System.out.println( "Date manuelle : " + formatteur.format( d2));
	

		
	}

}
