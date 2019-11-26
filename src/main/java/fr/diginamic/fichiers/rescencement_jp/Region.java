package fr.diginamic.fichiers.rescencement_jp;

public class Region implements Comparable<Region>{
	private	String	nomRegion;
	private long	popRegion;
	public Region( String codeDept, long popDept) {
		this.nomRegion 	= codeDept ;
		this.popRegion	= popDept ;
	}
	@Override
	public int compareTo(Region o) {
		return getNomRegion().compareTo( o.getNomRegion());
	}
	public String toString() {
		return  getNomRegion() + " - " + getPopRegion() ;
	}
	public String getNomRegion() {
		return nomRegion;
	}
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}
	public long getPopRegion() {
		return popRegion;
	}
	public void setPopRegion(long popRegion) {
		this.popRegion = popRegion;
	}
	


}
