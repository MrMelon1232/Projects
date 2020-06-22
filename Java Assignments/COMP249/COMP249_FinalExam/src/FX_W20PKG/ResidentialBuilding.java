package FX_W20PKG;

public class ResidentialBuilding extends Building implements Cloneable {
	
	private int maxNumberOfHabitants;

	public ResidentialBuilding(ResidentialBuilding residentialbuilding) {
		super(residentialbuilding.getYearOfCreation() , residentialbuilding.getCost() , residentialbuilding.getLandSpace() , residentialbuilding.getMaterial());
		this.maxNumberOfHabitants = residentialbuilding.maxNumberOfHabitants;
	}

	public ResidentialBuilding(int yearOfCreation, double cost, double landSpace, String material, int maxNumberOfHabitants) {
		super(yearOfCreation, cost, landSpace, material);
		this.maxNumberOfHabitants = maxNumberOfHabitants;
		
	}

	public int getMaxNumberOfHabitants() {
		return maxNumberOfHabitants;
	}

	public void setMaxNumberOfHabitants(int maxNumberOfHabitants) {
		this.maxNumberOfHabitants = maxNumberOfHabitants;
	}
	
	@Override
	public Structure copy() {
		return new ResidentialBuilding(this);
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof ResidentialBuilding) {
			ResidentialBuilding rb = (ResidentialBuilding) obj;
			return super.equals(obj) && maxNumberOfHabitants == rb.maxNumberOfHabitants;
		}
		return false;
	}
	
	public Structure clone() {
		return new ResidentialBuilding(this);
	}
	
	public String toString() {
		return super.toString().replace("Building", "Residential Building") + " and a max number of habitants of: " + this.maxNumberOfHabitants;
	}

	
	

}
