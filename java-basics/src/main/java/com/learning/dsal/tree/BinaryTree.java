package com.learning.dsal.tree;

//Java program to find maximum path sum in Binary Tree 

/* Class containing left and right child of current 

//An object of Res is passed around so that the 
//same value can be used by multiple recursive calls. */

class Res {
	public int val;
}

public class BinaryTree {

	static int finalValue = 0; // to store the intermediate maximum sum\
	static int diameterValue = 0;

	// Root of the Binary Tree
	BSTNode root;

	// This function returns overall maximum path sum in 'res'
	// And returns max path sum going through root.
	int findMaxUtil(BSTNode node, Res res) {

		// Base Case
		if (node == null)
			return 0;

		// l and r store maximum path sum going through left and
		// right child of root respectively
		int l = findMaxUtil(node.left, res);
		int r = findMaxUtil(node.right, res);

		// Max path for parent call of root. This path must
		// include at-most one child of root
		int max_single = Math.max(Math.max(l, r) + node.data, node.data);

		// Max Top represents the sum when the Node under
		// consideration is the root of the maxsum path and no
		// ancestors of root are there in max sum path
		int max_top = Math.max(max_single, l + r + node.data);

		// Store the Maximum Result.
		res.val = Math.max(res.val, max_top);

		return max_single;
	}

	int findMaxSum() {
		return findMaxSum(root);
	}

	// Returns maximum path sum in tree with given root
	int findMaxSum(BSTNode node) {

		// Initialize result
		// int res2 = Integer.MIN_VALUE;
		Res res = new Res();
		res.val = Integer.MIN_VALUE;

		// Compute and return result
		findMaxUtil(node, res);
		return res.val;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		BSTNode root = null;

		// for BST
		root = BinarySearchTree.insert(root, 28);

		root = BinarySearchTree.insert(root, 45);
		root = BinarySearchTree.insert(root, 40);
		root = BinarySearchTree.insert(root, 35);
		root = BinarySearchTree.insert(root, 30);
		root = BinarySearchTree.insert(root, 13);
		root = BinarySearchTree.insert(root, 93);
		root = BinarySearchTree.insert(root, 50);
		root = BinarySearchTree.insert(root, 27);

		System.out.println("\nInorder Traversal:");
		BinarySearchTree.inorder(root); // prints tree elements
		System.out.println();
		mirrorTree(root);
		BinarySearchTree.inorder(root); // prints tree elements
		System.out.println("\nboundary nodes :");
		printBoundaryElements(root);
		System.out.println("\nleafnodes :");
		printLeafNodes(root);
	}

	private static int height(BSTNode root) {
		// base condition
		if (root == null) {
			return 0;
		}

		int lh = height(root.left);
		int rh = height(root.right);

		return 1 + Math.max(lh, rh);
	}

	private static BSTNode mirror(BSTNode root) {
		if (root == null) {
			return root;
		} else {
			mirror(root.left);
			mirror(root.right);

			// swap

			BSTNode temp;
			temp = root.left;
			root.left = root.right;
			root.right = temp;

		}
		return root;

	}

	private static void mirrorTree(BSTNode root) {
		if (root == null) {
			return ;
		} else {
			mirror(root.left);
			mirror(root.right);

			// swap

			BSTNode temp;
			temp = root.left;
			root.left = root.right;
			root.right = temp;

		}
		//return root;

	}

	
	private static void printBoundaryElements(BSTNode root) {
		printLeftNodes(root);
		printLeafNodes(root);
		printRightNodes(root);
	}

	private static void printLeftNodes(BSTNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			System.out.print(root.data + " ");
			printLeftNodes(root.left);
		} else if (root.right != null) {
			System.out.print(root.data + " ");
			printLeftNodes(root.right);
		}
	}

	private static void printLeafNodes(BSTNode root) {

		if (root == null) {
			return;
		}
		printLeafNodes(root.left);

		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
		}
		printLeafNodes(root.right);
	}

	private static void printRightNodes(BSTNode root) {

		if (root == null) {
			return;
		}

		if (root.right != null) {
			printRightNodes(root.right);
			System.out.print(root.data + " ");
		} else if (root.left != null) {
			printRightNodes(root.left);
			System.out.print(root.data + " ");
		}
	}

	/*
	 * sum tree:
	 * 
	 * 2 /\ 4 7 / / \ -6 -2 8
	 * 
	 * | | v
	 * 
	 *
	 * 11(-6 +7+6) /\ (-6 + 0) -6 6(-2 + 8) / / \ 0 0 0
	 * 
	 * 
	 * make children as 0;
	 */
	private static int sum(BSTNode root) {
		if (root == null) {
			return 0; // setting children value as 0;
		}

		int lSum = sum(root.left);
		int rSum = sum(root.right);

		// induction step : what we do
		int temp = root.data;
		root.data = lSum + rSum;

		return temp + root.data;
	}

	/*
	 * diameter of a binary tree may or may not be BST
	 */
	private static int diameter(BSTNode root, int result) {
		if (root == null) {
			return 0;
		}

		int lDiameter = diameter(root.left, result);
		int rDiameter = diameter(root.right, result);

		int temp = Math.max(lDiameter, rDiameter) + 1;
		int answer = Math.max(temp, 1 + lDiameter + rDiameter);

		result = Math.max(result, answer);

		if (diameterValue < result) {
			diameterValue = result;
		}

		return temp;

	}

	static int diameter(BSTNode root) {
		// base case if tree is empty
		if (root == null)
			return 0;

		// get the height of left and right sub-trees
		int lheight = height(root.left);
		int rheight = height(root.right);

		// get the diameter of left and right sub-trees
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter of
		 * right subtree 3) Height of left subtree + height of right subtree + 1
		 */

		int result = Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
		return result;
	}

	static int diameterTree(BSTNode root) {
		return diameter(root);
	}

	/*
	 * Maximum Sum Path
	 */
	static int maximumPathSum(BSTNode root, int result) {
		if (root == null) {
			return 0;
		}

		int lSum = maximumPathSum(root.left, result);
		int rSum = maximumPathSum(root.right, result);

		// in case, sum doesn't end at the node
		int temp = Math.max(Math.max(lSum, rSum) + root.data, root.data);

		// in case, sum ends at the node
		int answer = Math.max(temp, lSum + rSum + root.data);
		result = Math.max(result, answer);

		if (finalValue < result) {
			finalValue = result;
		}

		return temp;
	}
}
