// -----------------------------------------------------
// Assignment 4
// Question: Part 2
// Written by: Julien Phan, ID:40133814
// -----------------------------------------------------

package Part_2;
import java.util.Scanner;

/**
 * 
 * @author julienphan
 *
 */

//CellPhone class
public class CellPhone implements Cloneable {
	
	//Variables
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	
	//Default Constructor
	public CellPhone() {
		
		serialNum = 0;
		brand = null;
		year = 0;
		price = 0;
	}
	
	/**
	 * 
	 * @param serialNum
	 * @param brand
	 * @param price
	 * @param year
	 */
	
	//Param Constructor
	public CellPhone(long serialNum, String brand, double price, int year) {
		
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	/**
	 * 
	 * @param other
	 * @param num
	 */
	
	//Copy Constructor
	public CellPhone(CellPhone other, long num) {
		
		this.serialNum = num;
		this.brand = other.brand;
		this.year = other.year;
		this.price = other.price;
	}

	/**
	 * 
	 * @return
	 */
	
	//Setters and Getters
	public long getSerialNum() {
		return serialNum;
	}

	/**
	 * 
	 * @param serialNum
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * 
	 * @return
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * 
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * 
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	//Clone method
	public CellPhone clone() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a non-existing serial number: ");
		long newNum = sc.nextLong();
		
		if(this.serialNum == newNum)
		{
			System.out.println("This serial number already exists! Please enter a new one!");
		}
		
		return new CellPhone(this,newNum);
		
	}
	
	//ToString method
	public String toString() {
		return "This is the serial number " + serialNum + 
				" with brand: " + brand + " and price: " + price + " and year: " + year;
	}
	
	//Equals method
	public boolean equals(Object someObject) {
		
		if(this == null || someObject == null || this.getClass() != someObject.getClass())
			return false;
		
		else
		{
			CellPhone newPhone = (CellPhone) someObject;
			return (this.brand.equals(newPhone.brand) &&
					this.price == newPhone.price &&
					this.year == newPhone.year);
		}
	}

}
