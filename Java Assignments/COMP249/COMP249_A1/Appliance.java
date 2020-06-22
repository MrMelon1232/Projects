import java.util.Scanner;

public class Appliance {

	// 6 Attributes
	private String type;
	private String brand;
	private long serialnum;
	private double price;
	private static int ApplianceObjects = 0;

	static Scanner keyboard = new Scanner(System.in);

	// Validate type
	public static boolean isValidType(String type) {
		if (type.equals("Fridge") || type.equals("Air Conditioner") || type.equals("Washer") || type.equals("Dryer")
				|| type.equals("Freezer") || type.equals("Stove") || type.equals("Dishwasher")
				|| type.equals("Water Heaters") || type.equals("Microwave"))
			return true;
		else
			return false;
	}

	// Constructor
	public Appliance(String type, String brand, long serialnum, double price) {
		this.type = type;
		this.brand = brand;

		this.serialnum = serialnum;
		if (price < 1)
			throw new IllegalArgumentException("Not a valid price");
		this.price = price;

		++ApplianceObjects;

	}

	// Copy Constructor
	public Appliance(Appliance C) {
		C.type = type;
		C.brand = brand;
		C.serialnum = serialnum;
		C.price = price;
	}

	// Accessors
	public String getType() {
		return this.type;
	}

	public String getBrand() {
		return this.brand;
	}

	public long getSerialnum() {
		return this.serialnum;
	}

	public double getPrice() {
		return this.price;
	}

	// Mutators
	public void setType(String type) {
		this.type = type;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setSerialnum(long serialnum) {
		this.serialnum = serialnum;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// toString method
	public String toString() {
		return "Appliance Serial #" + this.serialnum + "\nBrand: " + this.brand + "\nType: " + this.type + "\nPrice: "
				+ this.price;
	}

	// Number of Appliance method
	public static int findNumberOfCreatedAppliances() {
		return ApplianceObjects;
	}

	// equals() method
	public boolean equals(Appliance P) {
		if (P.brand == brand && P.type == type && P.price == price)
			return true;
		else
			return false;
	}

	// Brand search method
	public static String findAppliancesBy(String brandsearch, Appliance[] brandcheck) {
		boolean found = false;
		String output = "";
		for (int u = 0; u < brandcheck.length; u++) {
			if(brandcheck[u] != null)
			{
			if (brandcheck[u].getBrand().equals(brandsearch)) {
				found = true;
				output += "Appliance Serial #" + brandcheck[u].serialnum + "\nBrand: " + brandcheck[u].brand
						+ "\nType: " + brandcheck[u].type + "\nPrice: " + brandcheck[u].price + "\n\n";
			}
				if(brandcheck[u] == null)
					break;
			}
		}
		if (found) {
			return output + "\nWould you like to enter a new brand name or quit?";
		} else {
			return "There exists no appliance with that brand name."
					+ "\nWould you like to enter a new brand name or quit?";
		}
	}

	// Price search
	public static String findCheaperThan(double pricesearch, Appliance[] pricecheck) {
		boolean found = false;
		String output = "";
		for (int u = 0; u < pricecheck.length; u++) {
			if(pricecheck[u] != null)
			{
			if (pricecheck[u].getPrice() < pricesearch) {
				found = true;
				output += "Appliance Serial #" + pricecheck[u].serialnum + "\nBrand: " + pricecheck[u].brand
						+ "\nType: " + pricecheck[u].type + "\nPrice: " + pricecheck[u].price + "\n\n";
			}
			if(pricecheck[u] == null)
				break;
			}
		}
		if (found) {
			return output + "\nWould you like to enter a new price or quit?";
		} else {
			return "There exists no appliance with that price." + "\nWould you like to enter a new price or quit?";
		}

	}

}
