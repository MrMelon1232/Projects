package copter;
//-------------------------------------------------

//Part: 1
//Written by: Julien Phan, ID:40133814
//-------------------------------------------------

/**
 * @author julienphan
 *
 */
public class Quadcopter extends Helicopter {

	// 1 Attribute
	private int maxSpeed;

	// Default Constructor
	public Quadcopter() {
		super();
	}

	// Parametrized Constructors
	/**
	 * @param brand             A variable of type String
	 * @param price             A variable of type double
	 * @param horsePower        A variable of type int
	 * @param cylindersNum      A variable of type int
	 * @param yearCreated       A variable of type int
	 * @param passengerCapacity A variable of type int
	 * @param maxSpeed          A variable of type int
	 */
	public Quadcopter(String brand, double price, int horsePower, int cylindersNum, int yearCreated,
			int passengerCapacity, int maxSpeed) {
		super(brand, price, horsePower, cylindersNum, yearCreated, passengerCapacity);
		this.maxSpeed = maxSpeed;
	}

	// Copy Constructor
	/**
	 * @param quadcopter An object of type Quadcopter
	 */
	public Quadcopter(Quadcopter quadcopter) {
		quadcopter.maxSpeed = maxSpeed;
	}

	// Accessors and Mutators
	/**
	 * @return An int data type
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @param maxSpeed A variable of type int
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
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
	 * @return A string data type
	 */
	public String toString() {
		return super.toString().replace("Helicopter's", "Quadcopter's") + ",\nthe max speed is: " + this.maxSpeed + "mph.";
	}

	// equals method
	/**
	 * @return A boolean date type
	 */
	public boolean equals(Object quadcopter) {
		if (quadcopter == null)
			return false;

		if (this.getClass() == quadcopter.getClass()) {
			Quadcopter q = (Quadcopter) quadcopter;
			if (super.equals(q) && this.maxSpeed == q.maxSpeed)
				return true;
		}
		return false;
	}

	// Flying object method
	/**
	 * @param quadcopter   An Object of type Quadcopter
	 * @param flyingobject An array of type Object
	 */
	public void flyingObject(Quadcopter quadcopter, Object[] flyingobject) {
		super.flyingObject(quadcopter, flyingobject);
	}
}
