package FX_W20PKG;

//Structure Class
public class Structure implements Cloneable  {
	
	private int yearOfCreation;
	private double cost;
	
	public Structure(int yearOfCreation, double cost) {
		this.yearOfCreation = yearOfCreation;
		this.cost = cost;
	}
	
	public Structure(Structure structure) {
		this.yearOfCreation = structure.yearOfCreation;
		this.cost = structure.cost;
	}
	
	public int getYearOfCreation() {
		return yearOfCreation;
	}

	public void setYearOfCreation(int yearOfCreation) {
		this.yearOfCreation = yearOfCreation;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public boolean equals(Object obj) {
		
		if(obj != null && obj.getClass() == getClass()) {
			Structure st = (Structure) obj;
			return yearOfCreation == st.yearOfCreation && cost == st.cost;
		}
		return false;
	}
	
	public Structure copy() {
		return new Structure(this);
	}
	
	public Structure clone() {
		return new Structure(this);
	}
	
	
	public String toString() {
		
		return "The Structure has a year of creation of: " + this.yearOfCreation + " and a cost of: " + this.cost;
	}
	
	

}
