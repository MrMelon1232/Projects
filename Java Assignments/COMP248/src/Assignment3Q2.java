import java.util.Scanner;
// ----------------------------------------------------------
// Assignment 3
// Written by: Julien Phan  id: 40133814
// For COMP 248 Section R - Fall 2019
// ----------------------------------------------------------

// Question 2 (Simple Class)


public class Assignment3Q2 {

	
	
	public static void main(String[] args) 
	
	{
		
		// Welcome Message
		System.out.println("Welcome to the simple class example!\n");
		


	
}
	// CPU Class
	public static class CPUforpropertiesandmethodsrelatedtoanIntelCPU
	{
		Scanner keyboard = new Scanner(System.in);
		String supplied = keyboard.next();
		
		
		private int generation;
		private String seriesNum;
		private double AmmountPrice;
		private double speedCPU;
		private String launchday;
		private String supportSGX;
		
		// No argument Constructor
		CPUforpropertiesandmethodsrelatedtoanIntelCPU
		()
		{
		CPUforpropertiesandmethodsrelatedtoanIntelCPU CPU1 = new CPUforpropertiesandmethodsrelatedtoanIntelCPU();
		CPU1.initialize(1,"i3", 117 , 2.93 + "GHz", "Q1'10" , "SGX is not supported");
		}
		
		private void initialize(int i, String string, double j, String string2, String string3, String string4) {
			// TODO Auto-generated method stub
			
		}
		
		//6 Argument Constructor
		CPUforpropertiesandmethodsrelatedtoanIntelCPU
		(int gen, String series, double price, double speed, String launch, String support)
		{
		
			generation = gen;
			gen = Integer.parseInt(supplied);
			seriesNum = series;
			series = supplied;
			AmmountPrice = price;
			price = Integer.parseInt(supplied);
			speedCPU = speed;
			speed = Double.parseDouble(supplied);
			launchday = launch;
			launch = supplied;
			supportSGX= support;	
			support = supplied;
			
		}
		
		// 6 Accessor
		public int getGen()
		{
			return generation;
		}
		
		public String getSeries()
		{
			return seriesNum;
		}
		
		public double getPrice()
		{
			return AmmountPrice;
		}
		
		public double getSpeed()
		{
			return speedCPU;
		}
		
		public String getLaunch()
		{
			return launchday;
		}
		
		public String getSupport()
		{
			return supportSGX;
		}
		
		// Mutator
			public void setAmmountPrice (double Price)
			{
				this.AmmountPrice =Price;
			}	
			
			
			// Public method
			public double priceNow(String sQuarterYear)
			{
				String s1,s2;
				int yearNow = 0;
				int quarterNow=0;
				int quarterRelease=0;
				int yearRelease=0;
				for (int i =0; i < sQuarterYear.length(); i++)
				{
				if (sQuarterYear.charAt(i) == 39)
					s1 = sQuarterYear.substring(0,i);
				
				quarterNow = Integer.parseInt(sQuarterYear.substring(1,i));
				yearNow = Integer.parseInt(sQuarterYear.substring(i,sQuarterYear.length()));
				}
				for (int j =0; j < launchday.length(); j++)
				{
				if (launchday.charAt(j) == 39)
					s2 = launchday.substring(0,j);
				
				quarterRelease = Integer.parseInt(sQuarterYear.substring(1,j));
				yearRelease = Integer.parseInt(sQuarterYear.substring(j,sQuarterYear.length()));
				}
				for (;yearRelease <= yearNow ; yearRelease++)
				{
					quarterRelease=0;
					for(;quarterRelease <= quarterNow || AmmountPrice == 0; quarterRelease++)
					AmmountPrice = AmmountPrice * 0.02;
				}
				
			
				return AmmountPrice;
				
			}
	}
		
}