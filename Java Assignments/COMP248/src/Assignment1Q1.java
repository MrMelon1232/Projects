//------------------------------------------------------------------
// Assignment 1
// Written by: Julien Phan , id: 40133814
// For COMP 248 Section R - Fall 2019
//------------------------------------------------------------------

// Question 1 : Display a message

// Displays the given coffee message in a single statement

public class Assignment1Q1 

{
	
	public static void main(String[] args)
	
	{ 
	 
	  System.out.println
	  
	  ( "Welcome to COMP 248 Java Programming!\n"
	  + "Let's use programming to have some coffee when you work!\n" 
	  + "while (Working)\n" 
	  + "{\n" 
	  + "	CoffeeMug.Drink();\n" 
	  + "	workTask.Execute();\n"
	  + "	if (coffeeMug == \"Empty\")\n"
	  + "	{\n"
	  + "		if (coffePot == \"Empty\")\n"
	  + "			coffeePot.Make();\n"
	  + "		coffeMug.Refill();\n"
	  + "	}\n"
	  + "	Enjoy your coffee!\n"
	  + "}\n"
	  );
	 
	}

}

