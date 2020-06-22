// -----------------------------------------------------
// Assignment 4
// Question: Part 2
// Written by: Julien Phan, ID:40133814
// -----------------------------------------------------

package Part_2;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * 
 * @author julienphan
 *
 */
public class CellListUtilization {


	/**
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
    	
        CellList listA=new CellList();
        CellList listB=new CellList();
        CellList listC;
        Scanner inputStream=null;
        
        try
        {
            inputStream=new Scanner(new FileInputStream("/Users/julienphan/Desktop/resources/Cell_Info.txt"));
            fileToList(inputStream, listA);
            inputStream.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Problem with opening the file, program will terminate.");
            System.exit(0);
        }
        catch (IOException e)
        {
            System.out.println("Problem with reading the file, program will terminate.");
            System.exit(0);
        }


        listA.showContents();

        search(listA);
        System.out.println("Do you want to search another serial number? Y/N");
        
        Scanner input = new Scanner(System.in);
        char s='a';
        s = input.next().toUpperCase().charAt(0);
        
        while(s == 'Y')
        {
            search(listA);
            System.out.println("Do you want to search another serial number? Y/N");
            s=input.next().toUpperCase().charAt(0);
        }

        //test the insertAtIndex method
        CellPhone newOne=new CellPhone(7684999, "Blackberry",460.98,2010);
        System.out.println("\n\nTest of insertAtIndex method:");

        //test if index bigger than size
        System.out.println("Test if index is bigger than the size of list.");
        listA.insertAtIndex(newOne, 24);
        
        //test if index equals to 0 ; test of addToStart method
        System.out.println("Test if index is 0 (special case).");
        listA.insertAtIndex(newOne, 0);
        
        //test to insert in the middle
        System.out.println("Test of general case.");
        listA.insertAtIndex(newOne, 5);
        
        System.out.println("The result of tested methods.");
        listA.showContents();
        
        //test if index is negative
        System.out.println("\n\nTest of deleteFromIndex method.");
        System.out.println("Test if index is negative.");
        listA.deleteFromIndex(-1);
        
        //test delete in the middle
        System.out.println("Test of general case.");
        listA.deleteFromIndex(5);
        
        //test when index is 0 ; test of deleteFromStart method 
        System.out.println("Test if index is 0 (special case).");
        listA.deleteFromIndex(0);
        System.out.println("The result of tested methods.");
        listA.showContents();
        
        //Test
        System.out.println("\nTest on an empty list.");
        listB.deleteFromIndex(0);

        //test if index equals to 0
        System.out.println("\n\nTest of repalceAtIndex method.");
        System.out.println("Test if index is 0 (not a special case)");
        listA.replaceAtIndex(newOne, 0);
        
        //test if index is in the middle
        System.out.println("test of general case");
        listA.replaceAtIndex(newOne,2);
        System.out.println("The result of above operations.");
        listA.showContents();
        
        //test if the list is empty
        System.out.println("\nTest on an empty list.");
        listB.replaceAtIndex(newOne, 3);
        listB.showContents();

        //Copy Constructor  Test
        System.out.println("\n\nTest of copy constructor of CellList class");
        System.out.println("==============================================================================");
        listC=new CellList(listA);
        listC.showContents();

        //Equals method Test
        System.out.println("\n\nTest of equals method of CellList class");
        System.out.println("==============================================================================");
        if(listC.equals(listA))
            System.out.println("ListA and ListC are equal by equals method.");
        else
            System.out.println("ListA and ListC are not equal by equals method.");
        if(listC.equals(listB))
            System.out.println("ListB and ListC are equal by equals method.");
        else
            System.out.println("ListB and ListC are not equal by equals method.");

    }//end of main method


    /**
     * 
     * @param inputStream
     * @param a
     * @throws IOException
     */
    
    //FileToList method
    public static void fileToList(Scanner inputStream, CellList a) throws IOException
    {
        while(inputStream.hasNextLine())
        {
            String line = inputStream.nextLine();
            Scanner lineScanner = new Scanner(line);
            long serialNumber = lineScanner.nextLong();
            String brand = lineScanner.next();
            double price = lineScanner.nextDouble();
            int year = lineScanner.nextInt();
            
            CellPhone newOne=new CellPhone(serialNumber,brand,price,year);
            if(!a.contains(serialNumber))
            {
                a.addToStart(newOne);
            }
        }
    }
    
    
    /**
     * 
     * @param a
     */
    
    //Search method
    public static void search(CellList a)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter a serial number that you want to search:");
        long number=input.nextLong();
        a.contains(number);
    }
}

