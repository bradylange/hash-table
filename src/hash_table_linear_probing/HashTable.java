package hash_table_linear_probing;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: HashTableApplication
 * Language: Java
 * Date: 4/26/18
 * Description: This class contains linear probing hash table features.
 */

// This class uses hash table linear probing
public class HashTable
{
	private DataItem [] hashArray;    												// Array holds the hash table
	private int arraySize;															// Array size (size of hash table)
	private DataItem nonItem;        												// For deleted items
// ------------------- Alternate Constructor -------------------
	// Alternate Constructor
	public HashTable(int size)     
	{
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem("Removed");   										// Deleted item key is removed
	}
// ------------------- End Alternate Constructor -------------------
	
// ------------------- Display Table Method -------------------
	// Method that displays the hash table 
	public void displayTable()
	{
		System.out.print("Table: ");
		for (int j = 0; j < arraySize; j++)
		{
			if (hashArray[j] != null)
			{
				System.out.print(hashArray[j].getKey() + " ");
			}
			else
			{
				System.out.print("** ");
			}
		}
		System.out.println("");
	}
// ------------------- End Display Table Method -------------------
	
// ------------------- Hash Function Method -------------------
	// Method that determines how the hash table is hashed out 
	public int hashFunction(String key)
	{
		int size;
		int result = 0;
		int letter = 0;
		size = key.length();
		
		for (int i = 0; i < size; i++)  												// Hash function
		{	
			letter = key.charAt(i) - 96; 
			result = (result * 27 + letter) % arraySize;
		}
		return result;     
	}
// ------------------- End Hash Function Method -------------------
	
// ------------------- Insert Method -------------------
	// Method that inserts data into the hash table 
	public void insert(DataItem item) 													// Assumes table is not full 
	{
		String key = item.getKey();      												// Extract key
		int hashVal = hashFunction(key);  												// Hash the key
		
		// Until empty cell or removed
		while (hashArray[hashVal] != null && !(hashArray[hashVal].getKey().equalsIgnoreCase(nonItem.getKey())))
		{
			++hashVal;                 													// Go to next cell
			hashVal %= arraySize;      													// Wrap around if necessary
		}
		hashArray[hashVal] = item;    													// Insert item
	}  
// ------------------- End Insert Method -------------------
	
// ------------------- Delete Method -------------------
	// Method that removes data from the hash table 
	public DataItem delete(String key)  
	{
		int hashVal = hashFunction(key);  												// Hash the key
		
		while (hashArray[hashVal] != null)  											// Until empty cell,
		{                               												
			if (hashArray[hashVal].getKey().equals(key))								// Found the key
			{
				DataItem temp = hashArray[hashVal]; 									// Save item
				hashArray[hashVal] = nonItem;       									// Delete item
				return temp;                        									// Return item
			}
			++hashVal;                 													// Go to next cell
			hashVal %= arraySize;      													// Wrap around if necessary
		}
		return null;                  													// Can't find item
	}  
// ------------------- End Delete Method -------------------
	
// ------------------- Find Method -------------------
	// Method that finds a key in the hash table 
	public DataItem find(String key)    												
	{
		int hashVal = hashFunction(key);  												// Hash the key
		
		while (hashArray[hashVal] != null)  											// Until empty cell,
		{                               												// Found the key
			if (hashArray[hashVal].getKey().equals(key))
			{
				return hashArray[hashVal]; 												// Return item
			}								
			++hashVal;                													// Go to next cell
			hashVal %= arraySize;      													// Wrap around if necessary
		}
		return null;                 													// Can't find item
	}
// ------------------- End Find Method -------------------
}  // End of class HashTable
