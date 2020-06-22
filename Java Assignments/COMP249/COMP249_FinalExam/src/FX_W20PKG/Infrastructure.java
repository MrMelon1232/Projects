package FX_W20PKG;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import CargoAirport.CargoAirport;
import CommercialAirport.CommercialAirport;

public class Infrastructure {
	
	//Task 3.C method
	public static int findTallestHighRise(Structure[] strArr) {
		
		double tallestHeight = 0;
		double initialHeight = 0;
		boolean found = false;
		
		for(int i = 0; i < strArr.length; i++)
		{
			if(strArr[i] != null)
			{
				if(strArr[i].getClass() == HighRise.class)
				{
					found = true;
					if(initialHeight == 0 )
					{
						initialHeight = ((HighRise)strArr[i]).getHeight();
					}
					
					if(((HighRise)strArr[i]).getHeight() > tallestHeight)
					{
						tallestHeight = ((HighRise)strArr[i]).getHeight();
					}
					
				}
			}
		}
		
		if(found) {
		for(int i = 0; i < strArr.length; i++) 
		{
			if(strArr[i] != null) {
				
				if(strArr[i].getClass() == HighRise.class)
				{
					if(((HighRise)strArr[i]).getHeight() == tallestHeight)
					{
						return i;
					}
				}
			}
		}
		}
		return -1;
	}

	
	//Task 3.D method
	public static void showBuildingInfo(Structure[] strArr) {
		
		for(int i =0; i < strArr.length; i++) {
			
			if(strArr[i] != null) 
			{
				if(strArr[i] instanceof Building)
				{
					System.out.println(strArr[i]);
				}
			}
			
		}
	}
	
	//Task 3.E method
	public static void displayAllObjects(Structure [] strArr, int n) {
		
		if(n == -1)
			return;
		else {
			displayAllObjects(strArr, n-1);
			System.out.println(strArr[n]);
		}
	}
	
	//Task 3.F method
	public static Structure[] copyStructures(Structure[] strArr)
	{
		Structure[] arrayCopy = new Structure[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			arrayCopy[i] = strArr[i].copy();
		}
		return arrayCopy;
	}
	
	//Task 5.B method
	public static void findExistingAirportCodes(PrintWriter pw, Structure[] strArr) {
		
		for(int i = 0; i < strArr.length; i++)
		{
			if(strArr[i] != null)
			{
				if(strArr[i] instanceof Airport)
				{
					pw.println(((Airport)strArr[i]).getCode());	
				}
			}
		}
		pw.close();
		
	}
	
	//Task 5.E method
	public static void displayAirportCodes(BufferedReader br) throws IOException
	{
		int x;
		x = br.read();
		while(x != -1)
		{
			System.out.print((char)x);
			x = br.read();
		}
		br.close();
	}
	
	
	
	
	public static void main(String[] args) {
		
		//Task 3.A and 3.B
		Structure [] StrArr = new Structure[66];
		StrArr[0] = new Structure(10,13);
		StrArr[1] = new Overpass(10,10,349,49,4923);
		StrArr[2] = new Structure(17,10);
		StrArr[3] = new Bridge(10,10,1231,45);
		StrArr[4] = new Airport(10,10, 42, "jfk");
		StrArr[5] = new Structure(10,155);
		StrArr[6] = new Building(10,10,30,"rock");
		StrArr[7] = new CargoAirport(10,10, 60, "gr32",30);
		StrArr[8] = new Building(10,10,50, "wood");
		StrArr[9] = new CondoBuilding(10,10, 412, "marbel", 74, 27);
		StrArr[10] = new ResidentialBuilding(10,10,31,"rock",31231);
		StrArr[11] = new Building(10,10,80 , "rock");
		StrArr[12] = new Bridge(10,10,10,20);
		StrArr[13] = new HighRise(10,10,30,"rock",20);
		StrArr[14] = new Bridge(10,10,1231,13);
		StrArr[15] = new Structure(20,10);
		StrArr[16] = new House(10,10, 32, "wood", 3, 2, 6);
		StrArr[17] = new Bridge(10,10,4539,540);
		StrArr[18] = new Overpass(10,10,594,404,49494);
		StrArr[19] = new Structure(10,14);
		StrArr[20] = new ResidentialBuilding(10,10,321,"rock",313);
		StrArr[21] = new CargoAirport(10,10, 40, "dq8",90);
		StrArr[22] = new Overpass(10,10,329,44,555);
		StrArr[23] = new CondoBuilding(10,10, 23, "marbel", 63, 33);
		StrArr[24] = new HighRise(10,10,10,"metal",100);
		StrArr[25] = new Bridge(10,10,12,130);
		StrArr[26] = new CommercialAirport(10,10, 51, "pwn", 80);
		StrArr[27] = new HighRise(10,10,320,"stone",68);
		StrArr[28] = new House(10,10,4124,"wood",3,1,3);
		StrArr[29] = new HighRise(10,10,321,"rock",12);
		StrArr[30] = new ResidentialBuilding(10,10,31,"rock",131);
		StrArr[31] = new CommercialAirport(10,10, 50, "dqw2",50);
		StrArr[32] = new Building(10,10, 70, "stone");
		StrArr[33] = new ResidentialBuilding(10,10,523,"rock",31231);
		StrArr[34] = new Overpass(10,10,139,319,3219);
		StrArr[35] = new ResidentialBuilding(10,10,12,"rock",32);
		StrArr[36] = new House(10,10, 40, "wood", 4, 2, 3);
		StrArr[37] = new Bridge(10,10,659,94);
		StrArr[38] = new House(10,10, 3, "wood", 1, 4, 1);
		StrArr[39] = new HighRise(10,10,3123,"glass",33);
		StrArr[40] = new Airport(10,10, 321, "secret");
		StrArr[41] = new House(10,10,3123,"wood",2,4,3);
		StrArr[42] = new CondoBuilding(10,10, 412, "marbel", 321, 65);
		StrArr[43] = new CommercialAirport(10,10, 60, "dqe2", 90);
		StrArr[44] = new Building(10,10,60, "glass");
		StrArr[45] = new CondoBuilding(10,10, 321, "marbel", 83, 36);
		StrArr[46] = new Overpass(10,10,439,4239,429);
		StrArr[47] = new CondoBuilding(10,10, 123, "marbel", 26, 55);
		StrArr[48] = new CargoAirport(10,10, 70, "f3l", 40);
		StrArr[49] = new Airport(10,10, 32, "code123");
		StrArr[50] = new House(10,10,231,"wood",4,1/2,1);
		StrArr[51] = new Airport(10,10, 42, "jello");
		StrArr[52] = new Airport(10,10, 19, "j79");
		StrArr[53] = new Structure(40,10);
		StrArr[54] = new CommercialAirport(10,10, 412, "pw2", 70);
		StrArr[55] = new HighRise(10,10,32,"wood",100);
		StrArr[56] = new CommercialAirport(10,10, 51, "e1e", 0);
		StrArr[57] = new ResidentialBuilding(10,10,12,"rock",312);
		StrArr[58] = new CommercialAirport(10,10, 42, "dw2", 40);
		StrArr[59] = new CondoBuilding(10,10, 241, "marbel", 34, 38);
		StrArr[60] = new CargoAirport(10,10, 80, "234", 310);
		StrArr[61] = new Airport(10,10, 123, "ok");
		StrArr[62] = new Building(10,10,40 ,"metal");
		StrArr[63] = new CargoAirport(10,10, 50, "241", 70);
		StrArr[64] = new Overpass(10,10,3120,3210,32);
		StrArr[65] = new CargoAirport(10,10, 30, "nope",100);
		
		
		
		
		//Task 3.C
		System.out.println("Starting Task 3.C\n=============================================");
		int index = findTallestHighRise(StrArr);
		
		if(index != -1)
		{
			System.out.println("Tallest HighRise was found at index: " + index + " Here is the"
					+ " info of that object");
			System.out.println(StrArr[index]);
		}
			
		else
			System.out.println("No HighRise objects were found in the array!");
		
		System.out.println("\nEnd of Task 3.C\n");
		
		
		//Task 3.D
		System.out.println("Starting Task 3.D\n=============================================");
		showBuildingInfo(StrArr);
		System.out.println("\nEnd of Task 3.D\n");
		
		System.out.println("Starting Task 3.E + \n=============================================");
		displayAllObjects(StrArr, StrArr.length-1);
		System.out.println("\nEnd of Task 3.E\n");
		
		
		//Task 3.F
		System.out.println("Starting Task 3.F\n=============================================");

		displayAllObjects(copyStructures(StrArr),copyStructures(StrArr).length-1);
		
		System.out.println("\nEnd of Task 3.F\n");
		
		
		//Task 4
		System.out.println("Starting Task 4\n=============================================");
		
		//Task 4.A
		ArrayList <Structure> strArrLst = new ArrayList<Structure>(30);
		
		//Task 4.b
		for(Structure obj: StrArr)
		{
			strArrLst.add(obj);
		}
		
		//Task 4.C
		strArrLst.remove(0);
		strArrLst.remove(0);
		strArrLst.remove(0);
		strArrLst.remove(0);
		strArrLst.remove(0);
		
		
		//Task 4.D
		System.out.println("Attempting to find " + StrArr[5] + " in the array list.");
		if(strArrLst.contains(StrArr[5]))
		{
			System.out.println("\nThe object was found at index " + strArrLst.indexOf(StrArr[5]));
		}
		else
			System.out.println("\nThe object was not found!");
			
		System.out.println("\nAttempting to find " + StrArr[4] + " in the array list.");
		if(strArrLst.contains(StrArr[4]))
		{
			System.out.println("\nThe object was found at index " + strArrLst.indexOf(StrArr[4]));
		}
		else
			System.out.println("\nThe object was not found!");
			
		System.out.println("\nEnd of Task 4\n");
		
		
		//Task 5
		System.out.println("Starting Task 5\n=============================================");
		
		//Task 5.A and 5.B
		PrintWriter pw = null;
		Path path = Paths.get("resources");
		String absolutePath = path.toFile().getAbsolutePath();
		File filename = new File(absolutePath + "/AirportCodes.txt");
		
		try {
			
		pw = new PrintWriter(new FileOutputStream(filename));
		findExistingAirportCodes(pw, StrArr);
		
		}catch(FileNotFoundException e)
		{
			System.out.println("Could not find file!");
		}
		
		
		//Task 5.D and 5.F
		BufferedReader br = null;
		try
		{
		br = new BufferedReader(new FileReader(filename));
		displayAirportCodes(br);
		
		
		}catch(FileNotFoundException e) {
			System.out.println("Could not find file!");
		}
		catch(IOException e)
		{
			System.out.println("Could not read file!");
		}
		
		System.out.println("\nEnd of Task 5\n");
		
		
		//Task 6
		System.out.println("Starting Task 6\n=============================================");
		
		System.out.println("Displaying initial linked list:");
		StructureList objList = new StructureList();
		objList.addToStart(StrArr[0]);
		objList.addToStart(StrArr[1]);
		objList.addToStart(StrArr[2]);
		objList.addToStart(StrArr[3]);
		objList.addToStart(StrArr[4]);
		objList.showListContents();
		
		System.out.println("\nDisplaying addToStart() method\n");
		objList.addToStart(StrArr[6]);
		objList.showListContents();
		
		System.out.println("\nDisplaying addAtEnd() method\n");
		objList.addAtEnd(StrArr[7]);
		objList.showListContents();
		
		//My clone method does not work as intended but everything else works
		System.out.println("\nDisplaying clone() method\n");
		StructureList list2 = (StructureList) objList.clone();
		list2.showListContents();
		
		System.out.println("\nDisplaying append() method");
		objList.append(list2);
		objList.showListContents();
		
		System.out.println("\nEnd of Task 6");
		
		
		
		
	}
}
