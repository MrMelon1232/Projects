package CommercialAirport;
import FX_W20PKG.Airport;
import FX_W20PKG.Structure;

public class CommercialAirport extends Airport {
	
	private int numOfGates;

	public CommercialAirport(CommercialAirport commercialairport) {
		super(commercialairport.getYearOfCreation() , commercialairport.getCost() , commercialairport.getNumOfRunways(), commercialairport.getCode());
		numOfGates = commercialairport.numOfGates;
	
	}

	public CommercialAirport(int yearOfCreation, double cost, int numOfRunways, String code, int numOfGates) {
		super(yearOfCreation, cost, numOfRunways, code);
		this.numOfGates = numOfGates;
	}

	public int getNumOfGates() {
		return numOfGates;
	}

	public void setNumOfGates(int numOfGates) {
		this.numOfGates = numOfGates;
	}
	
	@Override
	public Structure copy() {
		return new CommercialAirport(this);
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof CommercialAirport) {
			CommercialAirport ca = (CommercialAirport) obj;
			return super.equals(obj) && numOfGates == ca.numOfGates;
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + " and a number of gates of: " + this.numOfGates;
	}

	
	

}
