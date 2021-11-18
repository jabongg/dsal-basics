package com.learning.dsal.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinarySearchTree {

	public static void main(String[] args) {

		BSTNode root = null;

		// for BST
		root = insert(root, 28);

		root = insert(root, 45);
		root = insert(root, 40);
		root = insert(root, 35);
		root = insert(root, 30);
		root = insert(root, 13);
		root = insert(root, 93);
		root = insert(root, 50);
		root = insert(root, 27);

		System.out.println("\nInorder Traversal:");
		inorder(root); // prints tree elements

		System.out.println("\nBFS : Level order traversal");
		BFS(root);

		System.out.println("\nLeft view  of the tree :");
		leftView(root);

		System.out.println("\nRight view of the tree");
		rightView(root);

		System.out.println("\nTop view of the tree");
		topView(root);
		System.out.println("\nBottom view of the tree");
		bottomView(root);

		System.out.println("\nVertical sum of the tree : ");
		verticalSumbetterWay(root);
		
		System.out.println("\n printing nodes vertically");
		printVertically(root);
	}

	// recursive solution
	static void inorder(BSTNode root) {

		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);

	}

	// iterative solution
	private static void inorderIterative(BSTNode root) {

		Stack<BSTNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			BSTNode curr = stack.peek();
			stack.pop(); // rachit
			continue;
		}

		if (root == null) {
			return;
		} else {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	static BSTNode insert(BSTNode root, int data) {
		if (root == null) {
			return new BSTNode(data);
		} else {
			if (data < root.data) {
				root.left = insert(root.left, data);
			}
			if (data > root.data) {
				root.right = insert(root.right, data);
			}
		}
		return root;
	}

	private static void BFS(BSTNode root) {
		// queue to store the order of the nodes left -> right
		Queue<BSTNode> q = new LinkedList<>();

		if (root == null)
			return;
		// otherwise push the root to queue
		q.offer(root);

		while (!q.isEmpty()) {

			BSTNode temp = q.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				q.offer(temp.left);
			}

			if (temp.right != null) {
				q.offer(temp.right);
			}
		}
	}

	private static void leftView(BSTNode root) {
		// queue to store the order of the nodes left -> right
		Queue<BSTNode> q = new LinkedList<>();

		if (root == null)
			return;
		// otherwise push the root to queue
		q.offer(root);

		while (!q.isEmpty()) {
			int queueSize = q.size();
			for (int i = 0; i < queueSize; i++) {

				BSTNode temp = q.poll();

				// right view : last element in queue at that level
				// left view : first element in queue at that level
				if (i == 0) {
					System.out.print(temp.data + " "); // left view
				}

				if (temp.left != null) {
					q.offer(temp.left);
				}
				if (temp.right != null) {
					q.offer(temp.right);
				}
			}
		}
	}

	private static void rightView(BSTNode root) {
		// queue to store the order of the nodes left -> right
		Queue<BSTNode> q = new LinkedList<>();

		if (root == null)
			return;
		// otherwise push the root to queue
		q.offer(root);

		while (!q.isEmpty()) {
			int queueSize = q.size();
			for (int i = 0; i < queueSize; i++) {

				BSTNode temp = q.poll();

				// right view : last element in queue at that level
				if (i == queueSize - 1) {
					System.out.print(temp.data + " ");
				}
				if (temp.left != null) {
					q.offer(temp.left);
				}
				if (temp.right != null) {
					q.offer(temp.right);
				}
			}
		}
	}


	/**
	 * @param root
	 */
	private static void topView(BSTNode root) {

		Map<Integer, List<BSTNode>> hdistanceNodesMap = getNodesWithHorizontalDistance(root);
		
		for (Entry<Integer, List<BSTNode>> entry : hdistanceNodesMap.entrySet()) {
			List<BSTNode> list = entry.getValue();
			System.out.print(list.get(0).data + " ");
		}
	} // method closes

	/**
	 * @param root
	 */
	private static void bottomView(BSTNode root) {

		Map<Integer, List<BSTNode>> hdistanceNodesMap = getNodesWithHorizontalDistance(root);
		
		for (Entry<Integer, List<BSTNode>> entry : hdistanceNodesMap.entrySet()) {
			List<BSTNode> list = entry.getValue();
			System.out.print(list.get(list.size() - 1).data + " ");

		}

	} // method closes

	public static void verticalSumbetterWay(BSTNode root) {

		// map to store horizontal distance and its corresponding sum
		Map<Integer, List<BSTNode>> hdistanceNodesMap = new TreeMap<>(); // otherwise need to write comparator
																			// to sort on the basis of keys.

		// queue to store the order of the nodes left -> right
		Queue<Pair> q = new LinkedList<>();

		if (root == null)
			return;

		Pair pair = new Pair(root, 0); // got no closing instance error for this class

		// otherwise push the root to queue
		q.offer(pair);

		while (!q.isEmpty()) {

			Pair temp = q.poll();

			int horizontalDistance = temp.horizontalDistance;
			BSTNode currNode = temp.node;

			List<BSTNode> list = null;

			if (!hdistanceNodesMap.containsKey(horizontalDistance)) {
				list = new ArrayList<BSTNode>();
				list.add(currNode);
			} else {
				list = hdistanceNodesMap.get(horizontalDistance);
				list.add(currNode);
			}

			hdistanceNodesMap.put(horizontalDistance, list);

			if (currNode.left != null) {
				q.offer(new Pair(currNode.left, horizontalDistance - 1));
			}

			if (currNode.right != null) {
				q.offer(new Pair(currNode.right, horizontalDistance + 1));
			}
		} // while closes

		System.out.println("Vertical level	" + "	" + "Sum");
		for (Entry<Integer, List<BSTNode>> entry : hdistanceNodesMap.entrySet()) {
			List<BSTNode> list = entry.getValue();
			Iterator<BSTNode> itr = list.iterator();
			System.out.print(entry.getKey() + " : ");
			int sum = 0;
			while (itr.hasNext()) {
				sum = sum + itr.next().data;
			}
			System.out.print(sum);
			System.out.println();

		}

	}


	public static void printVertically(BSTNode root) {

		Map<Integer, List<BSTNode>> hdistanceNodesMap = getNodesWithHorizontalDistance(root);
		
		for (Entry<Integer, List<BSTNode>> entry : hdistanceNodesMap.entrySet()) {
			List<BSTNode> list = entry.getValue();
			Iterator<BSTNode> itr = list.iterator();
			System.out.print(entry.getKey() + " : ");
			while (itr.hasNext()) {
				System.out.print(itr.next().data + " ");
			}
			System.out.println();

		}

	}
	
	public static Map<Integer, List<BSTNode>> getNodesWithHorizontalDistance(BSTNode root) {
		Map<Integer, List<BSTNode>> hdistanceNodesMap = new TreeMap<>(); // otherwise need to write comparator
																			// to sort on the basis of keys.

		// queue to store the order of the nodes left -> right
		Queue<Pair> q = new LinkedList<>();

		if (root == null)
			return hdistanceNodesMap;

		Pair pair = new Pair(root, 0); // got no closing instance error for this class

		// otherwise push the root to queue
		q.offer(pair);

		while (!q.isEmpty()) {

			Pair temp = q.poll();

			int horizontalDistance = temp.horizontalDistance;
			BSTNode currNode = temp.node;

			List<BSTNode> list = null;

			if (!hdistanceNodesMap.containsKey(horizontalDistance)) {
				list = new ArrayList<BSTNode>();
				list.add(currNode);
			} else {
				list = hdistanceNodesMap.get(horizontalDistance);
				list.add(currNode);
			}

			hdistanceNodesMap.put(horizontalDistance, list);

			if (currNode.left != null) {
				q.offer(new Pair(currNode.left, horizontalDistance - 1));
			}

			if (currNode.right != null) {
				q.offer(new Pair(currNode.right, horizontalDistance + 1));
			}
		} // while closes

		return hdistanceNodesMap;
	}
}
