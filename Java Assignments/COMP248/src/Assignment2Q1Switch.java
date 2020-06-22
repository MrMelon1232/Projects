import java.util.Scanner;

// ----------------------------------------------------------
// Assignment 2
// Written by: Julien Phan  id: 40133814
// For COMP 248 Section R - Fall 2019
// ----------------------------------------------------------

// Question 1 b): Persian Calendar(Switch Statement)

// This is a program that will display the corresponding month
// from the Persian Calendar when a number from 1 to 12 has
// been entered using a Switch statement.


public class Assignment2Q1Switch

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
		//Months output
		
		switch (num1)
		{
		case 1:
			System.out.println("We are in Farvardin, Happy Spring");
		break;
		case 2:
				System.out.println("We are in Ordibehesht, Happy Spring");
		break;		
		case 3:
				System.out.println("We are in Khordad, Happy Spring");
		break;
		case 4:
				System.out.println("We are in Tir, Have Fun in summer");
		break;
		case 5:
				System.out.println("We are in Mordad, Have Fun in summer");
		break;
		case 6:
				System.out.println("We are in Shahrivar, Have Fun in summer");
		break;
		case 7:
				System.out.println("We are in Mehr, Ready For Fall");
		break;
		case 8:
				System.out.println("We are in Aban, Ready For Fall");
		break;
		case 9:
				System.out.println("We are in Azar, Ready For Fall");
		break;
		case 10:
				System.out.println("We are in Dey, Keep warm Yourself in Winter");
		break;
		case 11:
				System.out.println("We are in Bahman, Keep warm Yourself in Winter");
		break;
		case 12:
				System.out.println("We are in Esfand, Keep warm Yourself in Winter");
		break;
		default: System.out.println("This is not a valid month");
		
		}
		
		//Closing Message
		System.out.println("\nThank You for using the Persian Calendar Program");
		
		
		
	}

}
