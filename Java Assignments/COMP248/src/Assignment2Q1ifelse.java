import java.util.Scanner;

// ----------------------------------------------------------
// Assignment 2
// Written by: Julien Phan  id: 40133814
// For COMP 248 Section R - Fall 2019
// ----------------------------------------------------------

// Question 1 a) :Persian Calendar(if/else statement)

// This is a program that will display the corresponding month
// from the Persian Calendar when a number from 1 to 12 has
// been entered using an if/else statement.


public class Assignment2Q1ifelse 

{
	public static void main(String[] args) 
	{
		//Welcome message
		System.out.println
		("Welcome to the Persian Calendar Program!\n");
		Scanner keyboard = new Scanner(System.in);
		
		//Input
		System.out.print
		("Please enter the Month as a number 1-12: ");
		int num1 = keyboard.nextInt();
		
		//Month outputs
		if (num1 == 1)
			System.out.println("We are in Farvardin, Happy Spring");
		else
		if (num1 == 2)
			System.out.println("We are in Ordibehesht, Happy Spring");
		else
		if (num1 == 3)
			System.out.println("We are in Khordad, Happy Spring");
		else
		if (num1 == 4)
			System.out.println("We are in Tir, Have Fun in summer");
		else
		if (num1 == 5)
			System.out.println("We are in Mordad, Have Fun in summer");
		else
		if (num1 == 6)
			System.out.println("We are in Shahrivar, Have Fun in summer");
		else
		if (num1 == 7)
			System.out.println("We are in Mehr, Ready For Fall");
		else
		if (num1 == 8)
			System.out.println("We are in Aban, Ready For Fall");
		else
		if (num1 == 9)
			System.out.println("We are in Azar, Ready For Fall");
		else
		if (num1 == 10)
			System.out.println("We are in Dey, Keep warm Yourself in Winter");
		else
		if (num1 == 11)
			System.out.println("We are in Bahman, Keep warm Yourself in Winter");
		else
		if (num1 == 12)
			System.out.println("We are in Esfand, Keep warm Yourself in Winter");
		else
		if	(num1 > 12 || num1 < 1)
			System.out.println("This is not a valid month");
			
		//Closing Message
		System.out.println("\nThank You for using the Persian Calendar Program");

	}

}
