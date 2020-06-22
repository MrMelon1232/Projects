package FX_W20PKG;

public class Airport extends Structure implements Cloneable {
	
	private int numOfRunways;
	private String code;
	
	public Airport(int yearOfCreation, double cost, int numOfRunways, String code) {
		super(yearOfCreation, cost);
		this.numOfRunways = numOfRunways;
		this.code = code;
		
	}
	public Airport(Airport airport) {
		super(airport.getYearOfCreation() , airport.getCost());
		this.numOfRunways = airport.numOfRunways;
		this.code = airport.code;
	}
	public int getNumOfRunways() {
		return numOfRunways;
	}
	public void setNumOfRunways(int numOfRunways) {
		this.numOfRunways = numOfRunways;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public Structure copy() {
		return new Airport(this);
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof Airport) {
			Airport a = (Airport) obj;
			return super.equals(obj) && numOfRunways == a.numOfRunways && code == a.code;
		}
		return false;
	}
	
	public Structure clone() {
		return new Airport(this);
	}
	
	public String toString() {
		return super.toString().replace("Structure", "Airport") + " and a number of runways of: " + this.numOfRunways + " and a code of: " + this.code;
	}

}