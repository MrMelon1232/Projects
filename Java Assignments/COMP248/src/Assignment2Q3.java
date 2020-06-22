import java.util.Scanner;

// ----------------------------------------------------------
// Assignment 2
// Written by: Julien Phan  id: 40133814
// For COMP 248 Section R - Fall 2019
// ----------------------------------------------------------

// Question 3: Mini Calculator

// This is a program that calculates the user's inputs, a mini calculator

public class Assignment2Q3 
{
	public static void main(String[] args) 
	
	{
	// Welcome Message
	System.out.println("Hello to mini calculator program.");
    
	// Initialization
	int i=0;
	String s1;
	
		// Do/while loop
		do
		{
	
			// Input
			System.out.println
			("Please enter the numbers along operation (press q to exit)\n");
			Scanner keyboard = new Scanner(System.in);
			s1 = keyboard.next();
			
			// If input isn't 'q'
			if (s1.charAt(0) != 113)
			{
				// Integer extraction from string s1
				for (; s1.charAt(i) >= 48 && s1.charAt(i) <= 57; i++);
					int num1 = Integer.parseInt(s1.substring(0,i));
					int num2 = Integer.parseInt(s1.substring(i+1,s1.length()));
					double output =0;		
	
					// Calculations
					if (s1.charAt(i) == 43 || s1.charAt(i) == 45 || s1.charAt(i) == 120 || s1.charAt(i) == 47)
					{
						if (s1.charAt(i) == 43)
						{
							output = num1 + num2;
							System.out.println("The answer is: " + output);
						}

						if (s1.charAt(i) == 45)
						{
							output = num1 - num2;
							System.out.println("The answer is: " +output);
						}

						if (s1.charAt(i) == 120)
						{
							output = num1 * num2;
							System.out.println("The answer is: " +output);
						}

						if (s1.charAt(i) == 47)
						{
							output = num1 / num2;
							System.out.println("The answer is: " +output);
						}
					}
			}	
			// If input is 'q'
			if (s1.charAt(0) == 113)
			{
				// Closing message
				System.out.print("Thanks for using mini calculator program.");
				System.exit(0);
			}
			
		}
		
		// While condition
		while(s1.charAt(i) == 43 || s1.charAt(i) == 45 || s1.charAt(i) == 120 || s1.charAt(i) == 47);
		
	}
		
}
