package uav;
//-------------------------------------------------

//Part: 1
//Written by: Julien Phan, ID:40133814
//-------------------------------------------------

public class UAV {

	// 2 Attributes
	private double weight;
	private double price;

	// Default Constructor
	public UAV() {
	}

	// Parametrized Constructor
	/**
	 * @param weight A variable of type double
	 * @param price  A variable of type double
	 */
	public UAV(double weight, double price) {
		this.weight = weight;
		this.price = price;
	}

	// Copy Constructor
	/**
	 * @param uav An Object of type UAV
	 */
	public UAV(UAV uav) {
		uav.weight = weight;
		uav.price = price;
	}

	// Accessors and Mutators
	/**
	 * @return A double data type
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight A variable of type double
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return A double data type
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price A variable of type double
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	// toString method
	/**
	 * @return A String data type
	 */
	public String toString() {
		return "The UAV'S weight is: " + this.weight + "Kg,\nthe price is: " + this.price + "$";
	}

	// equals method
	/**
	 * @return A boolean data type
	 */
	public boolean equals(Object uav) {
		if (uav == null)
			return false;

		if (this.getClass() == uav.getClass()) {
			UAV u = (UAV) uav;
			if (this.price == u.price && this.weight == u.weight)
				return true;
		}
		return false;
	}

	// Flying object method
	/**
	 * @param uav          An object of type UAV
	 * @param flyingobject An array of type Object
	 */
	public void flyingObject(UAV uav, Object[] flyingobject) {
		for (int i = 0; i < flyingobject.length; i++) {
			if (flyingobject[i] == null) {
				flyingobject[i] = uav;
				break;
			}
		}
	}
}