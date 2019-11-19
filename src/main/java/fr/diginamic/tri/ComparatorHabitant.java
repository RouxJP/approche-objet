package fr.diginamic.tri;

import java.util.Comparator;

public class ComparatorHabitant implements Comparator<Pays>{

	@Override
	public int compare(Pays o1, Pays o2) {
		if( o1.getNbrHab() > o2.getNbrHab()) return 1;
		if( o1.getNbrHab() < o2.getNbrHab()) return -1;
		return 0;
	}

}
