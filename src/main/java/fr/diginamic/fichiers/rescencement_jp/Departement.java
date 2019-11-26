package fr.diginamic.fichiers.rescencement_jp;

public class Departement implements Comparable<Departement>{
	private	String	codeDept;
	private long	population;
	public Departement( String codeDept, long popDept) {
		this.codeDept 	= codeDept ;
		this.population	= popDept ;
	}
	@Override
	public int compareTo(Departement o) {
		return getCodeDept().compareTo( o.getCodeDept());
	}
	public String toString() {
		return  getCodeDept() + " - " + getPopulation() ;
	}
	

	public String getCodeDept() {
		return codeDept;
	}

	public void setCodeDept(String codeDept) {
		this.codeDept = codeDept;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}
}
