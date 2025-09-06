// -----------------------------------------------------
// Assignment 3     
// Written by: John Basha ID40286668 
// ----------------------------------------------------- 

import java.io.*;
import java.util.*;

public class CellListUtilization {

	public static void main(String[] args) {
		
		// (a) Create at least two empty lists from the CellList class;
		CellList list1 = new CellList();
		CellList list2 = new CellList();
		
		String directoryPathToGetCellPhones = "C:\\Users\\jbash\\eclipse-workspace\\249 Assignment 3 v1\\Cell_Info.txt";
		
		Scanner sc = null;
		
		// (b) Open the Cell_Info.txt file, and read its contents line by line.
		try {	
			
			sc = new Scanner(new FileInputStream(directoryPathToGetCellPhones));
			
			while(sc.hasNextLine()) {
				long a = sc.nextLong();
				String b = sc.next();
				double c = sc.nextDouble();
				int d = sc.nextInt();
				
				CellPhone tempPhone = new CellPhone(a, b, c, d);
				// Checking for a duplicate phone. A duplicate phone means it has the same Serial Number which is not allowed
				if(!(list1.contains(a))) {
					list1.addToStart(tempPhone);
				}
				else {
					System.out.println("Serial Number " +a+ " exists already, so this new entry will not be added to the Cell List");
					continue; // Skip the duplicate
				}
			}
			
		}
		catch(IOException e) {
			System.out.println("Error with file processing: " + e.getMessage());
		}
		finally {
			sc.close();
		}
		
		// (c) Show the contents of the list you just initialized; 
		list1.showContents();
		
		// (d) Prompt the user to enter a few serial numbers and search the list that you created from the input file for these values.
		Scanner sc2 = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("You will be given three different rounds to find a Serial Number of a CellPhone inside the linked list");
		System.out.print("Round 1: Please enter a Serial Number: ");
		long r1SN = sc2.nextLong();
		System.out.println(list1.find(r1SN));
		System.out.println();
		System.out.print("Round 2: Please enter a Serial Number: ");
		long r2SN = sc2.nextLong();
		System.out.println(list1.find(r2SN));
		System.out.println();
		System.out.print("Round 3: Please enter a Serial Number: ");
		long r3SN = sc2.nextLong();
		System.out.println(list1.find(r3SN));
		System.out.println();
        // Closing sc2
        sc2.close();
		
		
		// (e) Following that, you must create enough objects to test each of the constructors/methods of your classes.
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		// Using parameterized constructors to create cell phones
		CellPhone cp0 = new CellPhone(999999, "Nokia", 43.00, 2009);
		CellPhone cp1 = new CellPhone(888888, "Apple", 770.00, 2015);
		CellPhone cp2 = new CellPhone(777777, "Samsung", 190.00, 2011);
		CellPhone cp3 = new CellPhone(666666, "Huawei", 550.00, 2020);
		CellPhone xx8 = new CellPhone(222222, "LG", 340.55, 2022);
		// Using the copy constructor to create a cell phone
		CellPhone cp4 = new CellPhone(cp3, 555555);
		// Using the clone method to clone a cell phone
		CellPhone xx9 = xx8.clone(); 
		
		// Using toString method to display cell phones created
		System.out.println(cp0);
		System.out.println(cp1);
		System.out.println(cp2);
		System.out.println(cp3);
		System.out.println(xx8);
		System.out.println(cp4);
		System.out.println(xx9);
		
		// Testing equals method
		System.out.println();
		System.out.println((cp0.equals(cp1)) ? "cp0 and cp1 are equal" : "cp0 and cp1 are not equal");
		System.out.println();
		
		// creating linked list of cell phones
		CellList theList = new CellList();
		theList.addToStart(cp0);
		theList.addToStart(cp1);
		theList.addToStart(cp2);
		theList.addToStart(cp3);
		theList.addToStart(cp4);
		// Display the contents of the list
        System.out.println("Initial list:");
        theList.showContents();
        
        // Test insertAtIndex
        CellPhone cp5 = new CellPhone(100000, "Sony", 999.99, 2023);
        System.out.println("\nInserting at index 2:");
        theList.insertAtIndex(cp5, 2);
        theList.showContents();
        
        // Test deleteFromIndex
        System.out.println("\nDeleting from index 3:");
        theList.deleteFromIndex(3);
        theList.showContents();
        
        // Test deleteFromStart
        System.out.println("\nDeleting from start:");
        theList.deleteFromStart();
        theList.showContents();
        
        // Test replaceAtIndex
        CellPhone cp6 = new CellPhone(200000, "LG", 599.99, 2024);
        System.out.println("\nReplacing at index 1:");
        theList.replacAtIndex(cp6, 1);
        theList.showContents();
        
        // Test find
        System.out.println("\nFinding serial number 880888:");
        CellList.CellNode foundNode = theList.find(880888);
        
        // Test contains
        System.out.println("\nChecking if serial number 200000 exists:");
        System.out.println(theList.contains(200000) ? "Serial number exists." : "Serial number does not exist.");
        
        // Test equals
        CellList anotherList = new CellList();
        anotherList.addToStart(cp0);
        anotherList.addToStart(cp1);
        anotherList.addToStart(cp6);
        anotherList.addToStart(cp3);
        System.out.println("\nComparing two lists:");
        System.out.println(theList.equals(anotherList) ? "Lists are equal." : "Lists are not equal.");
	}

}
