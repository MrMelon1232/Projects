// -----------------------------------------------------
// Assignment 4
// Question: Part 1
// Written by: Julien Phan, ID:40133814
// -----------------------------------------------------


package Part_1;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 
 * @author julienphan
 *
 */
public class Sub_Dictionary_Creator {


	/**
	 * 
	 * @param line
	 * @return
	 */
	
	//Method to Eliminate unwanted characters
    public static String eliminateIllegal(String line) {
    	
        char[] ch = line.toCharArray();
        
        
        if (ch[ch.length - 1] == '.' || ch[ch.length - 1] == ':' || ch[ch.length - 1] == ',' || ch[ch.length - 1] == '?'
                || ch[ch.length - 1] == ';' || ch[ch.length - 1] == '!' || ch[ch.length - 1] == ' ')
            return line.substring(0, line.length() - 1);
        
        else
        	if (ch.length > 2 && ch[ch.length - 2] == '\'')
            return line.substring(0, line.length() - 2);
        
        else 
        	if (ch.length == 1 && (ch[0] != 'A' || ch[0] != 'I' || ch[0] != 'a' || ch[0] != 'i'))
            return null;
        else
            return line;
    }

    /**
     * 
     * @param line
     * @return
     */
    
    //Method to see if word contains number
    public static boolean hasNum(String line) {
        char[] ch = line.toCharArray();
        
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i]))
                return true;
        }
        
        return false;
    }

    /**
     * 
     * @param myList
     * @param sc
     */
    
    //Method to create array list
    public static void createArrayList(ArrayList<String> myList, Scanner sc) {
    	
        while (sc.hasNext()) 
        {
            String line = sc.next().toUpperCase();
            line = eliminateIllegal(line);
            
            if (line != null && !myList.contains(line) && !hasNum(line) && line != "" && !myList.contains(line))
                myList.add(line);
        }
    }
    

    /**
     * 
     * @param arrayList
     * @param pw
     */
    
    //Method to write to file
    public static void writeToFile(ArrayList<String> arrayList, PrintWriter pw) 
    
    {
        pw.println("The document produced this sub-dictionary, which has "+arrayList.size()+" entries.");
        
        for (int i = 0; i < arrayList.size() - 1; i++) {
        	
            if (i == 0) 
            {
                pw.println("\n" + arrayList.get(0).charAt(0));
                pw.println("==");
                pw.println(arrayList.get(0));
            }
            
            if (i > 0) 
            {
                pw.println(arrayList.get(i));
                if (arrayList.get(i).charAt(0) != arrayList.get(i + 1).charAt(0)) {
                    pw.println("\n" + arrayList.get(i + 1).charAt(0));
                    pw.println("==");
                }
            }
        }
        pw.print(arrayList.get(arrayList.size()-1));
    }
    
   

    /**
     * 
     * @param args
     */
    
    //Main method
    public static void main(String[] args) {
    	
    	Scanner readInput = new Scanner(System.in);
    	String fileName;
    	
    	//Welcome message
    			System.out.println("Welcome to the Sub-Dictionary Creator Program!"
    					+ "\nPlease enter the text file name: ");
    			fileName = readInput.next();
    			

    	//Opening and writing to file
        Scanner sc = null;
        
        try {
            sc = new Scanner(new FileInputStream("/Users/julienphan/Desktop/resources/" + fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " could not be opened/found.");
            System.exit(0);
        }
        
        ArrayList<String> myList = new ArrayList<String>();
        createArrayList(myList, sc);
        myList.sort(null);
        PrintWriter pw = null;
        
        try {
            pw = new PrintWriter(new FileOutputStream("/Users/julienphan/Desktop/resources/SubDictionary.txt"));

            writeToFile(myList, pw);
            pw.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}