import uav.*;
import multirotor.*;
import copter.*;
import airplane.*;
import agriMAV.*;
//-------------------------------------------------
// Part: 1
// Written by: Julien Phan, ID:40133814
//-------------------------------------------------

/**
 * @author julienphan
 *
 */
public class Assignment2_driver {

	// copyFlyingObjects method
	/**
	 * @param objectArray An array of type Object
	 * @return An array data type
	 */
	public static Object[] copyFlyingObjects(Object objectArray[]) {

		Object[] arrayCopy = new Object[objectArray.length];

		for (int i = 0; i < objectArray.length; i++) {
			arrayCopy[i] = objectArray[i];
		}
		return arrayCopy;
	}

	public static void main(String[] args) {
		
		// Declarations of variables
		double cheapestPrice = 0;
		double cheapestPrice2 = 0;

		// Array of flying objects
		Object[] flyingobjects = new Object[20];

		// Basic objects
		flyingobjects[0] = new Airplane("boeing", 12000, 600);
		flyingobjects[1] = new Airplane("boeing", 12000, 600);
		flyingobjects[2] = new Helicopter("Heli", 1, 10000, 3, 2020, 6);
		flyingobjects[3] = new Helicopter("Copter", 1, 10000, 3, 2020, 6);
		flyingobjects[4] = new Quadcopter("Super", 1, 10000, 3, 2020, 6, 10000);
		flyingobjects[5] = new Quadcopter("Duper", 2, 1222, 3, 1900, 3, 1000);
		flyingobjects[6] = new Multirotor("Vroom", 20, 1000, 3, 2011, 5, 1000);
		flyingobjects[7] = new Multirotor("Rotom", 100, 12000, 3, 2009, 45, 24957);
		flyingobjects[8] = new Multirotor("Pikachu", 1, 10000, 3, 2020, 6, 4);
		flyingobjects[9] = new UAV(1200, 2000);
		flyingobjects[10] = new UAV(1200, 2000);
		flyingobjects[11] = new AgriculturalDrone(100201, 1200, "Kewl", 3);
		flyingobjects[12] = new AgriculturalDrone(2000, 10000, "Tesla", 4);
		flyingobjects[13] = new MAV(100, 1298, "pichu", 200);
		flyingobjects[14] = new MAV(2000, 1000, "t1000", 300);
		flyingobjects[15] = new MAV(986, 3754, "raichu", 201);

		// Displaying basic objects/Testing toString method
		System.out.println("\nHere are the flying objects created: ");
		for (int i = 0; i < flyingobjects.length; i++) {
			if (flyingobjects[i] != null)
				System.out.println(flyingobjects[i].toString() + "\n");
			if (flyingobjects[i] == null)
				break;
		}

		// Testing equals method
		System.out.println(flyingobjects[0].equals(flyingobjects[1]));
		System.out.println(flyingobjects[0].equals(flyingobjects[2]));
		System.out.println(flyingobjects[4].equals(flyingobjects[5]));
		System.out.println(flyingobjects[9].equals(flyingobjects[10] + "\n\n"));

		// Trace method
		// Storing initial price
		if (flyingobjects[0] != null) {
			if (flyingobjects[0].getClass() == Airplane.class || flyingobjects[0].getClass() == Helicopter.class
					|| flyingobjects[0].getClass() == Quadcopter.class
					|| flyingobjects[0].getClass() == Multirotor.class) {
				cheapestPrice = ((Airplane) flyingobjects[0]).getPrice();
			}
			if (flyingobjects[0].getClass() == UAV.class || flyingobjects[0].getClass() == AgriculturalDrone.class
					|| flyingobjects[0].getClass() == MAV.class) {
				cheapestPrice = ((UAV) flyingobjects[0]).getPrice();
			}
		}

		// Finding the cheapest price
		for (int i = 1; i < flyingobjects.length; i++) {
			if (flyingobjects[i] != null) {
				if (flyingobjects[i].getClass() == Airplane.class || flyingobjects[i].getClass() == Helicopter.class
						|| flyingobjects[i].getClass() == Quadcopter.class
						|| flyingobjects[i].getClass() == Multirotor.class) {

					if (((Airplane) flyingobjects[i]).getPrice() < cheapestPrice) {
						cheapestPrice = ((Airplane) flyingobjects[i]).getPrice();
					}
				}
				if (flyingobjects[i].getClass() == UAV.class || flyingobjects[i].getClass() == AgriculturalDrone.class
						|| flyingobjects[i].getClass() == MAV.class) {
					if (((UAV) flyingobjects[i]).getPrice() < cheapestPrice) {
						cheapestPrice = ((UAV) flyingobjects[i]).getPrice();
					}
				}
			}
			if (flyingobjects[i] == null) {
				break;
			}
		}
		System.out.println("This is the cheapest price: " + cheapestPrice);

		// Finding the second cheapest price

		// Storing initial price
		for (int i = 0; i < flyingobjects.length; i++) {
			if (flyingobjects[i] != null) {
				if (flyingobjects[i].getClass() == Airplane.class || flyingobjects[i].getClass() == Helicopter.class
						|| flyingobjects[i].getClass() == Quadcopter.class
						|| flyingobjects[i].getClass() == Multirotor.class) {
					if (((Airplane) flyingobjects[i]).getPrice() == cheapestPrice)
						continue;
					else {
						cheapestPrice2 = ((Airplane) flyingobjects[i]).getPrice();
						break;
					}
				}
				if (flyingobjects[i].getClass() == UAV.class || flyingobjects[i].getClass() == AgriculturalDrone.class
						|| flyingobjects[i].getClass() == MAV.class) {
					if (((UAV) flyingobjects[i]).getPrice() == cheapestPrice)
						continue;
					else {
						cheapestPrice2 = ((UAV) flyingobjects[i]).getPrice();
						break;
					}
				}
			}
		}
		// Finding the second cheapest price
		for (int i = 1; i < flyingobjects.length; i++) {
			if (flyingobjects[i] != null) {
				if (flyingobjects[i].getClass() == Airplane.class || flyingobjects[i].getClass() == Helicopter.class
						|| flyingobjects[i].getClass() == Quadcopter.class
						|| flyingobjects[i].getClass() == Multirotor.class) {
					if (((Airplane) flyingobjects[i]).getPrice() < cheapestPrice2
							&& ((Airplane) flyingobjects[i]).getPrice() > cheapestPrice) {
						cheapestPrice2 = ((Airplane) flyingobjects[i]).getPrice();
					}
				}
				if (flyingobjects[i].getClass() == UAV.class || flyingobjects[i].getClass() == AgriculturalDrone.class
						|| flyingobjects[i].getClass() == MAV.class) {
					if (((UAV) flyingobjects[i]).getPrice() < cheapestPrice2
							&& ((UAV) flyingobjects[i]).getPrice() > cheapestPrice) {
						cheapestPrice2 = ((UAV) flyingobjects[i]).getPrice();
					}
				}
			}
			if (flyingobjects[i] == null) {
				break;
			}
		}
		System.out.println("This is the second cheapest price: " + cheapestPrice2);

		// Displaying array objects
		for (int i = 0; i < flyingobjects.length; i++) {
			if (flyingobjects[i] != null) {
				if (flyingobjects[i].getClass() == Airplane.class || flyingobjects[i].getClass() == Helicopter.class
						|| flyingobjects[i].getClass() == Quadcopter.class
						|| flyingobjects[i].getClass() == Multirotor.class) {
					if (((Airplane) flyingobjects[i]).getPrice() == cheapestPrice)
						System.out.println("The cheapest price is a:\n" + flyingobjects[i].toString() + "\n");
					if (((Airplane) flyingobjects[i]).getPrice() == cheapestPrice2)
						System.out.println("The second cheapest price is a:\n" + flyingobjects[i].toString() + "\n");
				}
				if (flyingobjects[i].getClass() == UAV.class || flyingobjects[i].getClass() == AgriculturalDrone.class
						|| flyingobjects[i].getClass() == MAV.class) {
					if (((UAV) flyingobjects[i]).getPrice() == cheapestPrice)
						System.out.println("The cheapest price is a:\n" + flyingobjects[i].toString() + "\n");
					if (((UAV) flyingobjects[i]).getPrice() == cheapestPrice2)
						System.out.println("The second cheapest price is a:\n" + flyingobjects[i].toString() + "\n");
				}
			}

		}
		System.out.println(flyingobjects);
		Object[] copyArray = Assignment2_driver.copyFlyingObjects(flyingobjects);
		System.out.println(copyArray);
		// Copy method should work and creates a copy of the array
		// This can be verified by the address of each array being different
		// However, only the references to each object in the array were copied
		// Not new objects were created, hence a deep copy wasn't created.

		// Changing the info of the original array
		((Airplane) flyingobjects[0]).setBrand("koolaid");

		// Displaying basic objects of original array
		System.out.println("\nHere are the original flying objects created: ");
		for (int i = 0; i < flyingobjects.length; i++) {
			if (flyingobjects[i] != null)
				System.out.println(flyingobjects[i].toString() + "\n");
			if (flyingobjects[i] == null)
				break;
		}

		// Displaying basic objects
		System.out.println("\n\n\nHere are the copy flying objects created: ");
		for (int i = 0; i < copyArray.length; i++) {
			if (copyArray[i] != null)
				System.out.println(copyArray[i].toString() + "\n");
			if (copyArray[i] == null)
				break;
		}
		
		System.out.println("The program has ended!");

	}
}
