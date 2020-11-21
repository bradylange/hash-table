package hash_table_chaining;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: TreeNode
 * Language: Java
 * Date: 4/26/18
 * Description: This class contains methods and data about a single node that would be in a tree.
 */

// This class contains methods relevant to a tree node 
public class TreeNode 
{
	// Instance variables 
	int key; 																// Node's key value
	TreeNode leftChild; 													// Node's left child
	TreeNode rightChild; 													// Node's right child
// ------------------- Alternate Constructors -------------------
	// Alternate Constructor: Integer key 
	public TreeNode(int key)
	{
		this.key = key;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	// Alternate Constructor: Integer Key, TreeNode Left Node, TreeNode Right Node 
	public TreeNode(int key, TreeNode left, TreeNode right)
	{
		this.key = key;
		this.leftChild = left;
		this.rightChild = right;
	}
// ------------------- End Alternate Constructors -------------------
	
// ------------------- Display Method -------------------
	// Method that displays the node of a tree data structure 
	public void display()
	{
		System.out.print("(" + key + ")");
	}
// ------------------- End Display Method -------------------
	
// ------------------- Remove Method -------------------
	// Method that removes a node from the subtree
	public TreeNode remove(int delKey, TreeNode parent)
	{
		if (delKey < this.key)
		{
			if (leftChild != null)
			{
				return leftChild.remove(delKey, this);
			}
			else
			{
				return null;
			}
		}
		else if (delKey > this.key) 
		{
			
			if (rightChild != null)
			{
				return rightChild.remove(delKey, this);
			}
			else
			{
				return null;
			}
		}
		else 																	// Find the node
		{   	
		
			if (leftChild != null && rightChild != null) 
			{
			    TreeNode min = rightChild.minRightSubTree();
				this.key = min.key;
				return rightChild.remove(this.key, this);
			}
			else if (this == parent.leftChild) 
			{
				parent.leftChild = (leftChild != null) ? leftChild : rightChild;
				return this;
			}
			else if (this == parent.rightChild) 
			{
				parent.rightChild = (leftChild != null) ? leftChild : rightChild;
				return this;
			}
		}
		
		return null;
		
	}
// ------------------- End Remove Method -------------------
	
// ------------------- Minimum Right Sub Tree Method -------------------
	// Find a minimum value in the right subtree
	public TreeNode minRightSubTree()
	{
		if (this.leftChild == null)
		{
			return this;
		}
		else
		{
			return leftChild.minRightSubTree();
		}
	}
// ------------------- End Minimum Right Sub Tree Method -------------------
	
} // End of class TreeNode
