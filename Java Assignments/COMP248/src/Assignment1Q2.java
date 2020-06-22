import java.sql.Time;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Scanner;


//----------------------------------------------------------------------------------
// Assignment 1
// Written by: Julien Phan , id:40133814
// For COMP 248 Section R - Fall 2019
//----------------------------------------------------------------------------------

// Question 2: Time Converter Program

// Converts a number(up to 5-digits), entered initially in seconds, to hours and minutes 
// in the specific order of hours:min:time. If the time is invalid, swap the first and 
// last digit of the input and recalculate the corresponding time.



public class Assignment1Q2 

{
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	
	{ 
	  
	  System.out.println
	  ( "**********************************************\n"   
	  + "  Welcome to Time Converter Program\n" 
      + "**********************************************\n"
	  );
	  
	  //Scanner input
	  Scanner keyboardIn = new Scanner(System.in);
	  System.out.print
	  ( "Please enter the seconds which will be converted: "); 
	  
	  //Variables and Constants
	  
	  // Constant Variables
	  final int secondsInAMinute = 60;
	  final int MinuteInAHour = 60;
	  
	  //Seconds entered
	  int seconds = keyboardIn.nextInt();
	  int output = reverse(seconds);
	  int x = seconds % secondsInAMinute;
	  int x4 = output % secondsInAMinute;
	  
	  //Minutes
	  int x1 = seconds / secondsInAMinute;
	  int x2 = x1 % secondsInAMinute;
	  
	  //Hours
	  int y = x1 % MinuteInAHour;
	  int y1 = x1 / MinuteInAHour;
	  
	  //Format of Time
	  Format f = new SimpleDateFormat("k:mm:ss");
	  String strResult = f.format(new Time(y1, y, x));
	  
	  
	  // Corresponding hours, minutes, seconds
	  System.out.print
	  ( "\nThe correspond hours, minutes, seconds is ");
	  System.out.print
	  ( y1 + " hrs, " + x2 + " mins, " + x + " secs." );
	  System.out.print("\n");
	  
	  //Clock minute adjuster
	  x1 = x1 / 60;
	
	  //Minutes of Invalid Time
	  int x3 = output / secondsInAMinute;
	  int x5 = x3 % secondsInAMinute;
	  
	  //Hours of Invalid Time
	  int y3 = x3 / MinuteInAHour;
	  int y4 = y3 % 24;
	  
	  //Valid time 
	  if (y1 < 25)
	  	{
		  System.out.print
		  ( "\nThe valid time is: ");
		  System.out.println
		  (strResult + ".");
		  System.out.print("\n");
	  	}
	  
	  
	  else 
	  	{	   
		  // Not Valid Time
		  System.out.println
		  ("\nThere is no valid time of your input.");
		  System.out.print
		  ("\nThe swapped sequence of the input time is:" );
		  System.out.println
		  (output);
		  System.out.print
		  ("\nThe correspond hours, minutes, seconds is ");
		  System.out.println 
		  (y4 + " hrs, " + x5 + " mins, " + x4 + " secs.\n");
	  	}
	  
	  
	  //Closing Statement
	  System.out.print	  
	  ("Thank you for using the Time Converter Program!");
	  
	}
	  //Reverse first and last number
		public static int reverse (int seconds)
		  {
		 
		  String inputString = String.valueOf(seconds);
		  String outputString;
		  char firstChar = inputString.charAt(0);
		  char lastChar = inputString.charAt (inputString.length()-1);
		  String remaining = inputString.substring(1, inputString.length()-1);
		  outputString = lastChar + remaining + firstChar;
		  int output = Integer.parseInt(outputString) ;
		  return output;
		  
		  }
	

 }
