package FX_W20PKG;

public class Building extends Structure implements Cloneable{
	
	private double landSpace;
	private String material;
	
	public Building(int yearOfCreation, double cost, double landSpace, String material) {
		super(yearOfCreation, cost);
		this.landSpace = landSpace;
		this.material = material;
		
	}
	public Building(Building building) {
		super(building.getYearOfCreation() , building.getCost());
		this.landSpace = building.landSpace;
		this.material = building.material;
	}
	
	
	public double getLandSpace() {
		return landSpace;
	}

	public void setLandSpace(double landSpace) {
		this.landSpace = landSpace;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public Structure copy() {
		return new Building(this);
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof Building) {
			Building bd = (Building) obj;
			return super.equals(obj) && landSpace == bd.landSpace && material == bd.material;
		}
		return false;
	}
	
	public Structure clone() {
		return new Building(this);
	}
	
	public String toString() {
		return super.toString().replace("Structure", "Building") + " and a land space of: " + this.landSpace + " and made out of the material: " + this.material;
	}

	
	

}
