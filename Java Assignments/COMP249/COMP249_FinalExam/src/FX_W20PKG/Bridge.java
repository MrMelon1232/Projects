package FX_W20PKG;

public class Bridge extends Structure implements Cloneable{
	
	private double length;
	private double height;
	
	public Bridge(int yearOfCreation, double cost, double height, double length) {
		super(yearOfCreation, cost);
		this.length = length;
		this.height = height;

	}
	public Bridge(Bridge bridge) {
		super(bridge.getYearOfCreation(), bridge.getCost());
		this.length = bridge.length;
		this.height = bridge.height;
		
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public Structure copy() {
		return new Bridge(this);
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof Bridge) {
			Bridge bd = (Bridge) obj;
			return super.equals(obj) && length == bd.length && height == bd.height;
		}
		return false;
	}
	
	public Structure clone() {
		return new Bridge(this);
	}
	
	public String toString() {
		return super.toString().replace("Structure", "Bridge") + " and a length of: " + this.length + " and a height of: " + this.height;
	}
	
	

}
