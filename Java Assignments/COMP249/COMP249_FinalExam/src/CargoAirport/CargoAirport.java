package CargoAirport;
import FX_W20PKG.Airport;
import FX_W20PKG.Structure;


public class CargoAirport extends Airport{
	
	private double landedWeight;

	public CargoAirport(CargoAirport cargo) {
		super(cargo.getYearOfCreation() , cargo.getCost() , cargo.getNumOfRunways() , cargo.getCode());
		this.landedWeight = cargo.landedWeight;
	}

	public CargoAirport(int yearOfCreation, double cost, int numOfRunways, String code, double landedWeight) {
		super(yearOfCreation, cost, numOfRunways, code);
		this.landedWeight = landedWeight;
	}

	public double getLandedWeight() {
		return landedWeight;
	}

	public void setLandedWeight(double landedWeight) {
		this.landedWeight = landedWeight;
	}
	
	@Override
	public Structure copy() {
		return new CargoAirport(this);
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof CargoAirport) {
			CargoAirport ca = (CargoAirport) obj;
			return super.equals(obj) && landedWeight == ca.landedWeight;
		}
		return false;
	}
	
	public String toString() {
		return super.toString().replace("Airport", "CargoAirport") + " and a landed weight of: " + this.landedWeight;
	}

	
	
	

}
