package hash_table_linear_probing;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: DataItem
 * Language: Java
 * Date: 4/26/18
 * Description: This class constructs a data item to be used in the hash table.
 */

// This class contains data item information
public class DataItem
{          
	// Instance variables 
	private String iData;               								// Data item (key)
// ------------------- Alternate Constructor -------------------
	public DataItem(String ii)        
	{ 
		iData = ii;
	}
// ------------------- End Alternate Constructor -------------------
	
// ------------------- Get Key Method -------------------
	public String getKey()
	{ 
		return iData;
	}
// ------------------- End Get Key Method -------------------
}  // End of class DataItem