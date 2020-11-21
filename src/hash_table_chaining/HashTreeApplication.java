package hash_table_chaining;

// Imports the library to be able to communicate with the user through the console
import java.util.Scanner;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: HashTreeApplication
 * Language: Java
 * Date: 4/26/18
 * Description: This program tests the functionality of the separate chaining algorithm of using a binary search tree in a hash table.
 */

// This program tests the functionality of separate chaining in a hash table
public class HashTreeApplication
{
// ------------------- Main Method -------------------
	public static void main(String [] args)
	{
		System.out.println("***************************************** Hash Table - Separate Chaining *******************************************");
		// Getting user input 
		Scanner console = new Scanner(System.in);
		
		// Instantiating the constructor
		HashTableWithChaining hashTree = new HashTableWithChaining(10);
		
		// Adding data to the hash table
		TreeNode node;
		String answer;
		boolean end = false;
		
		System.out.println("Entering Nodes into the Hash Table: ");
		System.out.println("********************************************************************************************************");
		while (end != true)
		{
			System.out.println("Please enter data: ");
			node = new TreeNode(console.nextInt());
			hashTree.insert(node);
			System.out.println("Please type 'T' if you ARE DONE entering data and 'F' if you ARE NOT.");
			answer = console.next();

			if (answer.equalsIgnoreCase("T"))
			{
				end = true;
			}
			else
			{
				continue;
			}
		}
		System.out.println("********************************************************************************************************\n");
		
		// Displaying the hash table with the binary search trees in the appropriate indexes
		System.out.println("Displaying the Hash Table: ");
		System.out.println("********************************************************************************************************");
		hashTree.displayTable();
		System.out.println("********************************************************************************************************\n");
		
		// Finding a key in the hash binary search tree
		System.out.println("Finding a Node in the Hash Table: ");
		System.out.println("********************************************************************************************************");
		int search = 5;
		if (hashTree.find(search) == null)
		{
			System.out.println("The key " + search + " could not be found.");
		}
		else
		{
			System.out.println("The key " + search + " was found at the index of " + hashTree.hashFunction(5) + " in the hash table.");
		}
		System.out.println("********************************************************************************************************\n");
			
		
		// Removing a key from the hash binary search tree
		System.out.println("Removing a Node in the Hash Table: ");
		System.out.println("********************************************************************************************************");
		int delete = 20;
		if (hashTree.find(delete) == null)
		{
			System.out.println("The key " + delete + " could not be deleted as it doesn't exist.");
		}
		else
		{
			System.out.println("The key " + delete + " was found at the index of " + hashTree.hashFunction(5) + " in the hash table and was removed.");
			hashTree.delete(delete);
		}
		System.out.println("********************************************************************************************************\n");
		
		// Closing the scanner 
		console.close();
		
	}
// ------------------- End Main Method -------------------

} // End of class HashTreeApplication
