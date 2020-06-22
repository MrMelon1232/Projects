package agriMAV;

import uav.UAV;
//-------------------------------------------------
//Part: 1
//Written by: Julien Phan, ID:40133814
//-------------------------------------------------

public class AgriculturalDrone extends UAV {

	// 2 Attributes
	private String brand;
	private int carryCapacity;

	// Default Constructor
	public AgriculturalDrone() {
		super();
	}

	// Parametrized Constructor
	/**
	 * @param weight        A variable of type double
	 * @param price         A variable of type double
	 * @param brand         A variable of type String
	 * @param carryCapacity A variable of type int
	 */
	public AgriculturalDrone(double weight, double price, String brand, int carryCapacity) {
		super(weight, price);
		this.brand = brand;
		this.carryCapacity = carryCapacity;
	}

	// Copy Constructor
	/**
	 * @param agriculturalDrone An Object of type AgriculturalDrone
	 */
	public AgriculturalDrone(AgriculturalDrone agriculturalDrone) {
		agriculturalDrone.brand = brand;
		agriculturalDrone.carryCapacity = carryCapacity;
	}

	// Accessors and Mutators
	/**
	 * @return A String data type
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand A variable of type String
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return An int data type
	 */
	public int getCarryCapacity() {
		return carryCapacity;
	}

	/**
	 * @param carryCapacity A variable of type int
	 */
	public void setCarryCapacity(int carryCapacity) {
		this.carryCapacity = carryCapacity;
	}

	// Overriden getPrice method
	/**
	 * @return A double data type
	 */
	public double getPrice() {
		return super.getPrice();
	}

	// toString method
	/**
	 * @return A String data type
	 */
	public String toString() {
		return super.toString().replace("UAV'S", "AgriculturalDrone's") + ",\nthe brand is: " + this.brand + ",\nthe carry capacity is: " + this.carryCapacity;
	}

	// equals method
	/**
	 * @return A boolean data type
	 */
	public boolean equals(Object agriculturalDrone) {
		if (agriculturalDrone == null)
			return false;

		if (this.getClass() == agriculturalDrone.getClass()) {
			AgriculturalDrone ad = (AgriculturalDrone) agriculturalDrone;
			if (super.equals(ad) && this.brand == ad.brand && this.carryCapacity == ad.carryCapacity)
				return true;
		}
		return false;
	}

	// Flying object method
	/**
	 * @param agriculturalDrone An Object of type AgriculturalDrone
	 * @param flyingobject      An array of type Object
	 */
	public void flyingObject(AgriculturalDrone agriculturalDrone, Object[] flyingobject) {
		super.flyingObject(agriculturalDrone, flyingobject);
	}

}
