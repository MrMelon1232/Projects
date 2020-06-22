package FX_W20PKG;

public class CondoBuilding extends ResidentialBuilding implements Cloneable {

	private int numOfUnits;

	public CondoBuilding(int yearOfCreation, double cost, double landSpace, String material, int maxNumberOfHabitants, int numOfUnits) {
		super(yearOfCreation, cost, landSpace, material, maxNumberOfHabitants);
		this.numOfUnits = numOfUnits;
	}

	public CondoBuilding(CondoBuilding condobuilding) {
		super(condobuilding.getYearOfCreation() , condobuilding.getCost() , condobuilding.getLandSpace() , condobuilding.getMaterial() , condobuilding.getMaxNumberOfHabitants());
		this.numOfUnits = condobuilding.numOfUnits;
	}

	public int getNumOfUnits() {
		return numOfUnits;
	}

	public void setNumOfUnits(int numOfUnits) {
		this.numOfUnits = numOfUnits;
	}

	@Override
	public Structure copy() {
		return new CondoBuilding(this);
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof CondoBuilding) {
			CondoBuilding cb = (CondoBuilding) obj;
			return super.equals(obj) && numOfUnits == cb.numOfUnits;
		}
		return false;
	}
	
	public Structure clone() {
		return new CondoBuilding(this);
	}
	
	public String toString() {
		return super.toString() + " and a number of units of: " + this.numOfUnits;
	}

	
	
}
