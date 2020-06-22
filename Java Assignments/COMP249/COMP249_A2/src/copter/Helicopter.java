package copter;

import airplane.Airplane;
//-------------------------------------------------
//Part: 1
//Written by: Julien Phan, ID:40133814
//-------------------------------------------------

/**
 * @author julienphan
 *
 */
public class Helicopter extends Airplane {

	// 3 Attributes
	private int cylindersNum;
	private int yearCreated;
	private int passengerCapacity;

	// Default Constructor
	public Helicopter() {
		super();
	}

	// Parametized Constructor
	/**
	 * @param brand             A variable of type String
	 * @param price             A variable of type double
	 * @param horsePower        A variable of type int
	 * @param cylindersNum      A variable of type int
	 * @param yearCreated       A variable of type int
	 * @param passengerCapacity A variable of type int
	 */
	public Helicopter(String brand, double price, int horsePower, int cylindersNum, int yearCreated,
			int passengerCapacity) {
		super(brand, price, horsePower);
		this.cylindersNum = cylindersNum;
		this.yearCreated = yearCreated;
		this.passengerCapacity = passengerCapacity;
	}

	// Copy Constructor
	/**
	 * @param helicopter An object of type Helicopter
	 */
	public Helicopter(Helicopter helicopter) {
		helicopter.cylindersNum = cylindersNum;
		helicopter.yearCreated = yearCreated;
		helicopter.passengerCapacity = passengerCapacity;
	}

	// Accessors and Mutators
	/**
	 * @return An int data type
	 */
	public int getCylindersNum() {
		return cylindersNum;
	}

	/**
	 * @param cylindersNum A variable of type int
	 */
	public void setCylindersNum(int cylindersNum) {
		this.cylindersNum = cylindersNum;
	}

	/**
	 * @return An int data type
	 */
	public int getYearCreated() {
		return yearCreated;
	}

	/**
	 * @param yearCreated A variable of type int
	 */
	public void setYearCreated(int yearCreated) {
		this.yearCreated = yearCreated;
	}

	/**
	 * @return An int data type
	 */
	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	/**
	 * @param passengerCapacity A variable of type int
	 */
	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
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
		return super.toString().replace("Airplane's", "Helicopter's") + ",\nthe number of cylinders is: " + this.cylindersNum + ",\nthe year of creation is: "
				+ this.yearCreated + ",\nthe passenger capacity is: " + this.passengerCapacity;
	}

	// equals method
	/**
	 * @return A boolean data type
	 */
	public boolean equals(Object helicopter) {
		if (helicopter == null)
			return false;

		if (this.getClass() == helicopter.getClass()) {
			Helicopter h = (Helicopter) helicopter;
			if (super.equals(h) && this.cylindersNum == h.cylindersNum && this.passengerCapacity == h.passengerCapacity
					&& this.yearCreated == h.yearCreated)
				return true;
		}
		return false;
	}

	// Flying object method
	/**
	 * @param helicopter   An Object of type Helicopter
	 * @param flyingobject An array of type Object
	 */
	public void flyingObject(Helicopter helicopter, Object[] flyingobject) {
		super.flyingObject(helicopter, flyingobject);
	}
}
