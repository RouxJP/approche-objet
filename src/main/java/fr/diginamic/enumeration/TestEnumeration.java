package fr.diginamic.enumeration;

public class TestEnumeration {

	public static void main(String[] args) {
		Saison[] lstSaison = Saison.values();
		for( Saison saison:lstSaison) {
			System.out.println(saison.getLibelle());
		}
		System.out.println(Saison.HIVER);
		System.out.println(Saison.getSaison( "Hiver"));
	}

}
