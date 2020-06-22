package FX_W20PKG;

public class Overpass extends Bridge implements Cloneable {
	
	private double maxLoad;

	public Overpass(Overpass overpass) {
		super(overpass.getYearOfCreation() , overpass.getCost() , overpass.getLength() , overpass.getHeight());
		this.maxLoad = overpass.maxLoad;
		
	}

	public Overpass(int yearOfCreation, double cost, double height, double length, double maxLoad) {
		super(yearOfCreation, cost, height, length);
		this.maxLoad = maxLoad;
		
	}

	public double getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(double maxLoad) {
		this.maxLoad = maxLoad;
	}
	
	@Override
	public Structure copy() {
		return new Overpass(this);
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof Overpass) {
			Overpass op = (Overpass) obj;
			return super.equals(obj) && maxLoad == op.maxLoad;
		}
		return false;
	}
	
	public Structure clone() {
		return new Overpass(this);
	}
	
	public String toString() {
		return super.toString().replace("Bridge", "Overpass") + " and a max load of: " + this.maxLoad;
	}
	

}
