package hash_table_chaining;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: HashTableWithChaining
 * Language: Java
 * Date: 4/26/18
 * Description: This class constructs a separate chaining hash table with binary trees.
 */

// This class uses a binary search tree to separate chain 
public class HashTableWithChaining 
{
	// Instance variables	
	private BinarySearchTree [] hashArray;   									// Array of trees
	private int arraySize;														// Size of hash table 
// ------------------- Alternate Constructor -------------------
	// Alternate Constructor 
	public HashTableWithChaining(int size)      
	{
		arraySize = size;
		hashArray = new BinarySearchTree[arraySize];  							// Create array
		for (int j = 0; j < arraySize; j++)          							// Fill array
		{
			hashArray[j] = new BinarySearchTree();     							// With BST's
		}
	}
// ------------------- End Alternate Constructor -------------------
	
// ------------------- Display Table Method -------------------
	// Method that displays the hash table
	public void displayTable()
	{
		for (int j = 0; j < arraySize; j++) 									// For each cell,
		{
			System.out.print(j + ". "); 										// Display cell number
			hashArray[j].traverse(2); 											// Display in-order traverse of BST
		}
	}
// ------------------- End Display Table Method -------------------
	
// ------------------- Hash Function Method -------------------
	// Method that determines how the data is hashed into the table
	public int hashFunction(int key)      									
	{
		return key % arraySize;
	}
// ------------------- End Hash Function Method -------------------
	
// ------------------- Insert Method -------------------
	// Method that inserts a node into the hash table 
	public void insert(TreeNode theNode)  										
	{
		int key = theNode.key;
		int hashVal = hashFunction(key);   										// Hash the key
		hashArray[hashVal].addBST(theNode.key); 								// Insert at hashVal
	}  
// ------------------- End Insert Method -------------------
	
// ------------------- Delete Method -------------------
	// Method that deletes a node in the hash table
	public void delete(int key)       
	{
		int hashVal = hashFunction(key);   										// Hash the key
		hashArray[hashVal].remove(key); 										// Delete a node
	}  
// ------------------- End Delete Method -------------------
	
// ------------------- Find Method -------------------
	// Method that finds a node in the hash table 
	public TreeNode find(int key)         
	{
		int hashVal = hashFunction(key);   										// Hash the key
		TreeNode theNode = hashArray[hashVal].inBST(key);  						// Get link
		return theNode;                											// Return link
	}
// ------------------- Get Array Size Method -------------------
	// Method that returns the size of the hash table 
	public int getArraySize()
	{
		return arraySize;
	}
// ------------------- End Get Array Size Method -------------------
} // End of class HashTableWithChaining
