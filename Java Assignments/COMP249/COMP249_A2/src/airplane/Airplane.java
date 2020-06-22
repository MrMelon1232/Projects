package airplane;
//-------------------------------------------------

//Part: 1
//Written by: Julien Phan, ID:40133814
//-------------------------------------------------

/**
 * 
 * @author julienphan
 *
 */
public class Airplane {

	// 3 Attributes
	private String brand;
	private double price;
	private int horsePower;

	// Default Constructor
	public Airplane() {
	}

	// Parametrized Constructor
	/**
	 * @param brand      A variable of type String
	 * @param price      A variable of type double
	 * @param horsePower A variable of type int
	 */
	public Airplane(String brand, double price, int horsePower) {
		this.brand = brand;
		this.price = price;
		this.horsePower = horsePower;
	}

	// Copy Constructor
	/**
	 * 
	 * @param airplane An object of type Airplane
	 */
	public Airplane(Airplane airplane) {
		airplane.brand = brand;
		airplane.price = price;
		airplane.horsePower = horsePower;
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

	/**
	 * @return An int data type
	 */
	public int getHorsePower() {
		return horsePower;
	}

	/**
	 * @param horsePower A variable of type int
	 */
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	// toString Method
	/**
	 * @return A String data type
	 */
	public String toString() {
		return "The Airplane's brand is: " + this.brand + "\nthe price is: " + this.price + "$,\nthe horsepower is: "
				+ this.horsePower + "hp.";
	}

	// equals method
	/**
	 * @return A boolean data type
	 */
	public boolean equals(Object airplane) {
		if (airplane == null)
			return false;

		if (this.getClass() == airplane.getClass()) {
			Airplane p = (Airplane) airplane;
			if (this.brand == p.brand && this.horsePower == p.horsePower && this.price == p.price)
				return true;
		}
		return false;
	}

	// Flying object method
	/**
	 * @param airplane     An Object of type Airplane
	 * @param flyingobject An array of type Object
	 */
	public void flyingObject(Airplane airplane, Object[] flyingobject) {
		for (int i = 0; i < flyingobject.length; i++) {
			if (flyingobject[i] == null) {
				flyingobject[i] = airplane;
				break;
			}
		}
	}
}
