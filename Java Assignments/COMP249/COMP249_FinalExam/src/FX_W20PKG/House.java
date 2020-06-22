package FX_W20PKG;

public class House extends ResidentialBuilding implements Cloneable {
	
	private double numberOfRooms;
	private int numOfFloors;
	
	public House(int yearOfCreation, double cost, double landSpace, String material, int maxNumberOfHabitants, double numberOfRooms , int numOfFloors) {
		super(yearOfCreation, cost, landSpace, material, maxNumberOfHabitants);
		this.numberOfRooms = numberOfRooms;
		this.numOfFloors = numOfFloors;

	}
	
	public House(House house) {
		super(house.getYearOfCreation() , house.getCost() , house.getLandSpace() , house.getMaterial() , house.getMaxNumberOfHabitants());
		this.numberOfRooms = house.numberOfRooms;
		this.numOfFloors = house.numOfFloors;
	}
	public double getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(double numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public int getNumOfFloors() {
		return numOfFloors;
	}
	public void setNumOfFloors(int numOfFloors) {
		this.numOfFloors = numOfFloors;
	}
	
	@Override
	public Structure copy() {
		return new House(this);
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof House) {
			House h = (House) obj;
			return super.equals(obj) && numberOfRooms == h.numberOfRooms && numOfFloors == h.numOfFloors;
		}
		return false;
	}
	
	public Structure clone() {
		return new House(this);
	}
	
	public String toString() {
		return super.toString().replace("Residential Building", "House") + " and a number of rooms of: " + this.numberOfRooms + " and a number of floors of: " + this.numOfFloors;
	}
	

}
