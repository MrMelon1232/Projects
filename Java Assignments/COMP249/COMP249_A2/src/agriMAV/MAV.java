package agriMAV;

import uav.UAV;
//-------------------------------------------------
//Part: 1
//Written by: Julien Phan, ID:40133814
//-------------------------------------------------

/**
 * @author julienphan
 *
 */
public class MAV extends UAV {

	// 2 Attributes
	private String model;
	private double size;

	// Default Constructor
	public MAV() {
		super();
	}

	// Parametrized Constructor
	/**
	 * @param weight A variable of type double
	 * @param price  A variable of type double
	 * @param model  A variable of type String
	 * @param size   A variable of type double
	 */
	public MAV(double weight, double price, String model, double size) {
		super(weight, price);
		this.model = model;
		this.size = size;
	}

	// Copy Constructor
	/**
	 * @param mav An Object of type MAV
	 */
	public MAV(MAV mav) {
		mav.model = model;
		mav.size = size;
	}

	// Accessors and Mutators
	/**
	 * @return A String data type
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model A variable of type String
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return A double data type
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @param size A variable of type double
	 */
	public void setSize(double size) {
		this.size = size;
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
		return super.toString().replace("UAV'S", "MAV'S") + ",\nthe model is: " + this.model + ",\nthe size is: " + this.size + "cm^3.";
	}

	// equals method
	/**
	 * @return A boolean data type
	 */
	public boolean equals(Object mav) {
		if (mav == null)
			return false;

		if (this.getClass() == mav.getClass()) {
			MAV m = (MAV) mav;
			if (super.equals(m) && this.model == m.model && this.size == m.size)
				return true;
		}
		return false;
	}

	// Flying object method
	/**
	 * @param mav          An Object of type MAV
	 * @param flyingobject An array of type Object
	 */
	public void flyingObject(MAV mav, Object[] flyingobject) {
		super.flyingObject(mav, flyingobject);
	}
}
