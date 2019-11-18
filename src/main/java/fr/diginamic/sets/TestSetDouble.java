package fr.diginamic.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSetDouble {

	public static void main(String[] args) {
		Double max, min, newDouble ;
		Set<Double> setD = new HashSet<Double>();
		setD.add( 1.5);
		setD.add( 8.25);
		setD.add( -7.32);
		setD.add( 13.3);
		setD.add( -12.45);
		setD.add( 48.5);
		setD.add( 0.01);
		
		
		Iterator<Double> it = setD.iterator();
		max = it.next();
		min = max;
		while( it.hasNext()) {
			newDouble = it.next();
			if(  newDouble > max) {
				max = newDouble;
			}
			if(  newDouble < min) {
				min = newDouble;
			}
		}
		
		System.out.println("Le plus grand est : " + max);
		System.out.println("Le plus petit est : " + min);
		it = setD.iterator();
		while( it.hasNext()) {
			newDouble = it.next();
			if(  newDouble == min) {
				it.remove();
				break;
			}
		}
		
		System.out.println("Liste sans le plus petit element");
		it = setD.iterator();
		while( it.hasNext()) {
			System.out.println( it.next());
		}
		

	
		

	}

}
