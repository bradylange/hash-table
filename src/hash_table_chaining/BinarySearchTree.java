package hash_table_chaining;

/*
 * Developer: Brady Lange
 * Course: Data Structures & Algorithms - CSIS 237
 * Class: BinarySearchTree
 * Language: Java
 * Date: 4/26/18
 * Description: This class contains methods and data about a binary search tree.
 */

// This class contains methods relevant to a binary search tree
public class BinarySearchTree 
{
	// Instance variables
	private TreeNode rootNode; 	 													// First node of the tree
	private int numNodes;      														// Number of nodes in the tree
// ------------------- Default Constructor -------------------
	// Default Constructor
	public BinarySearchTree()
	{
		rootNode = null;
		numNodes = 0;
	}
// ------------------- End Default Constructor -------------------
	
// ------------------- Is Binary Search Tree Methods -------------------
	// Method that checks whether this binary tree is a binary search tree
	public boolean isBST()
	{
		return isBST(rootNode);
	}
	
	// Helper Method: Recursive method that checks if the tree is a binary search tree
	private boolean isBST(TreeNode rootNode)
	{
		if (rootNode == null)
		{
			return true;
		}
		if (isSubTreeLess(rootNode.leftChild, rootNode.key) && 
			isSubTreeGreater(rootNode.rightChild, rootNode.key) &&
	        isBST(rootNode.leftChild) &&
	        isBST(rootNode.rightChild))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Helper Method: Checks if a sub tree is less using recursion
	private boolean isSubTreeLess(TreeNode subRoot, int value)
	{
		if (subRoot == null)
		{
			return true;
		}
		if (subRoot.key < value && 
			isSubTreeLess(subRoot.leftChild, value) &&
			isSubTreeLess(subRoot.rightChild, value))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Helper Method: Checks if a sub tree is greater using recursion
	private boolean isSubTreeGreater(TreeNode subRoot, int value)
	{
		if (subRoot == null)
		{
			return true;
		}
		if (subRoot.key >= value && 
			isSubTreeGreater(subRoot.leftChild, value) &&
			isSubTreeGreater(subRoot.rightChild, value))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
// ------------------- End Is Binary Search Tree Methods -------------------

// ------------------- Add Binary Search Tree Methods -------------------
	// Insert a node into the binary search tree
	public void addBST(int newKey)
	{
		rootNode = addNode(newKey, rootNode);
		numNodes++;
	}
	
	// Helper Method: Recursively inserts a node into the binary search tree
	private TreeNode addNode(int newKey, TreeNode subTreeRoot)
	{
		if (subTreeRoot == null)
		{
			// Create a new node
			subTreeRoot = new TreeNode(newKey);
		}
		else if (newKey < subTreeRoot.key)
		{
			subTreeRoot.leftChild = addNode(newKey, subTreeRoot.leftChild);
		}
		else
		{
			subTreeRoot.rightChild = addNode(newKey, subTreeRoot.rightChild);
		}
			
		return subTreeRoot;
	}
// ------------------- End Add Binary Search Tree Methods -------------------
	
// ------------------- Remove Method -------------------
	  // Remove a node from this binary search tree
	  public boolean remove(int delKey)
	  {
		  if (rootNode == null)
		  {
			  return false;
		  }
		  else 
		  {
			  if (delKey == rootNode.key) 
			  {
					TreeNode auxRoot = new TreeNode(0); // dummy rootNode
					auxRoot.leftChild = rootNode;
					TreeNode removedNode = rootNode.remove(delKey, auxRoot);
					rootNode = auxRoot.leftChild;
					if (removedNode != null) 
					{
						removedNode = null;
						numNodes--;
						return true;
					}
					else
					{
						return false;
					}
				}
				else 
				{
					TreeNode removedNode = rootNode.remove(delKey, null);
					if (removedNode != null) 
					{
						removedNode = null;
						numNodes--;
						return true;
					}
					else
					{
						return false;
					}
				}
			}
	 }
// ------------------- Remove Method -------------------
	
// ------------------- Searching Binary Search Tree Methods -------------------
	// Method that searches a node in the binary search tree
	public TreeNode inBST(int searchKey)
	{
		return inBST(searchKey, rootNode);
	}
	
	// Helper Method: Recursively searches for a node in the binary search tree
	private TreeNode inBST(int searchKey, TreeNode subTreeRoot) 
	{
		if (subTreeRoot == null)
		{
			return null;
		}
		else
		{
			if (searchKey == subTreeRoot.key)
			{
				return subTreeRoot;
			}
			else if (searchKey < subTreeRoot.key)
			{
				return inBST(searchKey, subTreeRoot.leftChild);
			}
			else
			{
				return inBST(searchKey, subTreeRoot.rightChild);
			}
		}
	}
// ------------------- End In Binary Search Tree Methods -------------------
	
// ------------------- Traversing Binary Search Tree Methods -------------------
	// Traverse this binary search tree in different ways
	public void traverse(int traverseType)
	{
		switch (traverseType)
	    {
	       case 1: System.out.print("Preorder traversal: ");
	               preOrder(rootNode);
	               break;
	       case 2: System.out.print("Inorder traversal: ");
	               inOrder(rootNode);
	               break;
	       case 3: System.out.print("Postorder traversal: ");
	               postOrder(rootNode);
	               break;
	    }
		System.out.println();
	}
	
	 // Helper method: recursive pre-order traverse
	 private void preOrder(TreeNode subTreeRoot)
	 {
	      if (subTreeRoot != null)
	      {
	    	  subTreeRoot.display();
	    	  preOrder(subTreeRoot.leftChild);
	    	  preOrder(subTreeRoot.rightChild);
	      }
	  }
	
	  // Helper method: recursive in-order traverse
	  private void inOrder(TreeNode subTreeRoot)
	  {
	      if (subTreeRoot != null)
	      {
	         inOrder(subTreeRoot.leftChild);
	         subTreeRoot.display();
	         inOrder(subTreeRoot.rightChild);
	      }
	  }
	
	// Helper method: recursive post-order traverse
	private void postOrder(TreeNode subTreeRoot)
	{
		if (subTreeRoot != null)
		{
			postOrder(subTreeRoot.leftChild);
			postOrder(subTreeRoot.rightChild);
			subTreeRoot.display();
		}
	}	
// ------------------- End Traversing Binary Search Tree Methods -------------------
  
// ------------------- Leaves Count Methods -------------------
	// Returns the amount of leaves in the binary tree
	public int leavesCount()
	{
		return leavesCount(rootNode);
	}
	
	// Helper method for leavesCount()
	private int leavesCount(TreeNode node)
	{
		// Base case
		if (node == null)
		{
			return 0;
		}
		else
		{
			if (node.leftChild == null && node.rightChild == null)
			{
				return 1;
			}
			else
			{
				return leavesCount(node.leftChild) + leavesCount(node.rightChild);
			} 
		}
	}
// ------------------- End Leaves Count Methods -------------------
	  
// ------------------- Height Count Methods -------------------
	// Returns the height of the binary tree
	public int heightCount()
	{
		return heightCount(rootNode);
	}
	
	// Helper method for heightCount()
	private int heightCount(TreeNode node)
	{
		if (node == null)
		{
			return 0;
		}
		else
		{
			int leftBranch = heightCount(node.leftChild);
			int rightBranch = heightCount(node.rightChild);
			  
			if (leftBranch > rightBranch)
			{
				return 1 + leftBranch;
			}
			else
			{
				return 1 + rightBranch;
			}
		}
			  
	}
// ------------------- End Height Count Methods -------------------
	
// ------------------- Getter Methods -------------------
	// Method that returns the rootNode of the binary search tree
	public TreeNode getRootNode() 
	{
		return rootNode;
	}
	
	// Method that returns the number of nodes in the binary search tree
	public int getNumNodes() 
	{
		return numNodes;
	}
// ------------------- End Getter Methods -------------------
	
} // End of class BinarySearchTree
