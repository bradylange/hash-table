package hash_table_linear_probing;

// Importing libraries for exceptions and input streams 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: HashTableApplication
 * Language: Java
 * Date: 4/26/18
 * Description: This program tests the functionality the linear probing hash table features.
 */

// This program tests the hash tables functionality and linear probing
public class HashTableApplication
{
// ------------------- Main Method -------------------
	// Method that compiles and runs the program 
	public static void main(String [] args) throws IOException
	{
		System.out.println("***************************************** Hash Table - Linear Probing *******************************************");
		// Local variables 
		DataItem aDataItem;																// Item that is in the hash table 
		int size;																		// Size of the hash table 
		String aKey;																	// A key in the hash table
			                                  
		System.out.print("Enter size of hash table: ");									// Get the size of the hash table 
		size = getInt();
		
		HashTable theHashTable = new HashTable(size);									// Instantiate the hash table
		
		while (true)                  													// Interact with the user 
		{
			System.out.print("Enter first letter of ");									// Let the user choose what they would like to do with the hash table 
			System.out.print("show, insert, delete, or find: ");
			char choice = getChar();
			switch (choice)
			{
				case 's':																// Display the hash tables contents 
					theHashTable.displayTable();
					break;
				case 'i':																// Insert data into the hash table using linear probing 
					System.out.print("Enter key value to insert: ");
					aKey = getString();
					aDataItem = new DataItem(aKey);
					theHashTable.insert(aDataItem);
					break;
				case 'd':																// Delete data from the hash table 
					System.out.print("Enter key value to delete: ");
					aKey = getString();
					aDataItem = theHashTable.delete(aKey);
					if (aDataItem == null)
					{
						System.out.println("Could not delete " + aKey + " as it could not be found.");
					}
					else
					{
						System.out.println("Deleted " + aKey);
					}
					break;
				case 'f':																// Find data in the hash table 
					System.out.print("Enter key value to find: ");
					aKey = getString();
					aDataItem = theHashTable.find(aKey);
					if (aDataItem != null)
					{
						System.out.println("Found " + aKey);
					}
					else
					{
						System.out.println("Could not find " + aKey);
					}
					break;	
				default:																// Not a valid entry 
					System.out.print("Invalid entry. Please try again!\n");	
					break;
			}  
			System.out.println("********************************************************************************************************\n");
		} 
	} 
// ------------------- End Main Method -------------------
	
// ------------------- Get String Method -------------------
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
// ------------------- End Get String Method -------------------
	
// ------------------- Get Character Method -------------------
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
// ------------------- End Get Character Method -------------------
	
// -------------------Get Integer Method -------------------
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
// ------------------- End Get Integer Method -------------------
}  // End of class HashTableApplication
