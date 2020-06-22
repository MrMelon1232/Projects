package FX_W20PKG;

public class HighRise extends Building implements Cloneable {
	
	private double height;

	public HighRise(HighRise highrise) {
		super(highrise.getYearOfCreation() , highrise.getCost() , highrise.getLandSpace() , highrise.getMaterial());
		this.height = highrise.height;
	}

	public HighRise(int yearOfCreation, double cost, double landSpace, String material, double height) {
		super(yearOfCreation, cost, landSpace, material);
		this.height = height;
		
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public Structure copy() {
		return new HighRise(this);
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof HighRise) {
			HighRise hr = (HighRise) obj;
			return super.equals(obj) && height == hr.height;
		}
		return false;
	}
	
	public Structure clone() {
		return new HighRise(this);
	}
	
	public String toString() {
		return super.toString().replace("Building", "High Rise") + " and a height of: " + this.height;
	}

	
	

}
