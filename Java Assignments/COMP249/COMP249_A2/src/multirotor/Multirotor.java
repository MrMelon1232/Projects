package multirotor;

import copter.Helicopter;
//-------------------------------------------------
//Part: 1
//Written by: Julien Phan, ID:40133814
//-------------------------------------------------

/**
 * @author julienphan
 *
 */
public class Multirotor extends Helicopter {

	// 1 Attribute
	private int rotorNum;

	// Default Constructor
	public Multirotor() {
		super();
	}

	// Parmetrized Constructor
	/**
	 * @param brand             A variable of type String
	 * @param price             A variable of type double
	 * @param horsePower        A variable of type int
	 * @param cylindersNum      A variable of type int
	 * @param yearCreated       A variable of type int
	 * @param passengerCapacity A variable of type int
	 * @param rotorNum          A variable of type int
	 */
	public Multirotor(String brand, double price, int horsePower, int cylindersNum, int yearCreated,
			int passengerCapacity, int rotorNum) {
		super(brand, price, horsePower, cylindersNum, yearCreated, passengerCapacity);
		this.rotorNum = rotorNum;
	}

	// Copy Constructor
	/**
	 * @param multirotor An Object of type Multirotor
	 */
	public Multirotor(Multirotor multirotor) {
		multirotor.rotorNum = rotorNum;
	}

	// Accessors and Mutators
	/**
	 * @return An int data type
	 */
	public int getRotorNum() {
		return rotorNum;
	}

	/**
	 * @param rotorNum A variable of type int
	 */
	public void setRotorNum(int rotorNum) {
		this.rotorNum = rotorNum;
	}

	// Overriden getPrice method
	/**
	 * @return A double type of data
	 */
	public double getPrice() {
		return super.getPrice();
	}

	// toString method
	/**
	 * @return A String data type
	 */
	public String toString() {
		return super.toString().replace("Helicopter's", "Multirotor's") + ",\nthe rotor number is: " + this.rotorNum;
	}

	// equals method
	/**
	 * @return A boolean data type
	 */
	public boolean equals(Object multirotor) {
		if (multirotor == null)
			return false;

		if (this.getClass() == multirotor.getClass()) {
			Multirotor m = (Multirotor) multirotor;
			if (super.equals(m) && this.rotorNum == m.rotorNum)
				return true;
		}
		return false;
	}

	// Flying object method
	/**
	 * @param multirotor   An Object of type Multirotor
	 * @param flyingobject An array of type Object
	 */
	public void flyingObject(Multirotor multirotor, Object[] flyingobject) {
		super.flyingObject(multirotor, flyingobject);
	}
}
