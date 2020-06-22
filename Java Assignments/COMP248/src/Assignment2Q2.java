import java.util.Scanner;

// ----------------------------------------------------------
// Assignment 2
// Written by: Julien Phan  id: 40133814
// For COMP 248 Section R - Fall 2019
// ----------------------------------------------------------

// Question 2 (Circumference Calculator and Display)

// This is a program that calculates the circumference of a square and
// displays the shape of the figure with the characters "X" and "\" for
// the main diagonal.


public class Assignment2Q2 
{
	public static void main(String[] args)
	
	{
	
	// Display message
	System.out.println
	("------------------------------------------------------");
	System.out.println
	("               Circumference Calculator               ");
	System.out.println
	("------------------------------------------------------");
	
	// Welcome Message
	System.out.println("Welcome to the Circumference Calculator Program");
	
	// Input
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Please enter the length of the side!");
	int num1 = keyboard.nextInt();
	
	// Circumference calculation
	int num2 = 4*num1;
	System.out.print
	("The Circumference of the Square is " + num2);
	
	// Shape of the Square
	
	// Variables
	
	for (int cols = 0 ; cols!= num1 ; cols++)
	{
		System.out.print("\n");
		System.out.print("                                     ");
		for (int rows = 0; rows!= num1; rows++)
		{
			if (rows == cols)
				System.out.print("\\ ");
			else
				System.out.print("X ");
		}
		
	}

	//Closing message
	System.out.println("\n\nThank You for using the Cirfumference Calculator");
	
	
	
	}

}
