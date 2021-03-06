package com.learning.dsal.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class TreeNode {
	int data; // data of the TreeNode
	int hd; // horizontal distance of the TreeNode
	TreeNode left, right; // left and right references

	// Constructor of tree TreeNode
	public TreeNode(int key) {
		data = key;
		hd = 0;
		left = right = null;
	}
}

public class TreeViews {

	public static void main(String[] args) {
		TreeNode root = null;

		/*
		 * 20 / \ 8 22 / \ / \ 5 3 4 25 / \ 10 14
		 * 
		 * 
		 */

		root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(10);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(25);
		root.right.left.right = new TreeNode(14);

//		// for BST
//		root = insert(root, 28);
//
//		root = insert(root, 45);
//		root = insert(root, 40);
//		root = insert(root, 35);
//		root = insert(root, 30);
//		root = insert(root, 13);
//		root = insert(root, 93);
//		root = insert(root, 50);
//		root = insert(root, 27);
		System.out.println("inorder iterative way :" + inorder(root));
		System.out.println("preorder iterative way :" + preorder(root));
		System.out.println("postorder iterative way :" + postorder(root));

		bottomView(root);
	}

	static TreeNode insert(TreeNode root, int data) {
		if (root == null) {
			return new TreeNode(data);
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

	// Method that returns the bottom view.
	public static ArrayList<Integer> bottomView(TreeNode root) {
		// Code here

		Map<Integer, List<TreeNode>> map = bottomViewHelper(root);
		ArrayList<Integer> bottomIntegers = new ArrayList<>();
		for (Map.Entry<Integer, List<TreeNode>> entry : map.entrySet()) {
			List<TreeNode> list = entry.getValue();
			bottomIntegers.add(list.get(list.size() - 1).data);
			System.out.print(list.get(list.size() - 1).data + " ");
		}

		return bottomIntegers;
	}

	private static Map<Integer, List<TreeNode>> bottomViewHelper(TreeNode root) {
		// prepare map of horizontal distance and list of TreeNodes..
		// and return last element from the respective lists of corresponding horizantal
		// distaces.
		Map<Integer, List<TreeNode>> hdistanceTreeNodesMap = new TreeMap<>(); // otherwise need to write comparator

		Queue<TreeNode> q = new LinkedList<>();

		if (root == null) {
			return null;
		}

		q.offer(root);

		while (!q.isEmpty()) {
			List<TreeNode> list = null;// this will be mapped with hd
			TreeNode curr = q.poll();

			if (curr != null) {
				if (!hdistanceTreeNodesMap.containsKey(curr.hd)) {
					list = new ArrayList<>();
					list.add(curr);
					hdistanceTreeNodesMap.put(curr.hd, list);
				} else {
					list = hdistanceTreeNodesMap.get(curr.hd);
					list.add(curr);
					hdistanceTreeNodesMap.put(curr.hd, list);
				}

				if (curr.left != null) {
					curr.left.hd = curr.hd - 1;
					q.offer(curr.left);
				}

				if (curr.right != null) {
					curr.right.hd = curr.hd + 1;
					q.offer(curr.right);
				}
			}
		}

		return hdistanceTreeNodesMap;
	}

	static ArrayList<Integer> preorder(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		TreeNode p = root;
		Stack<TreeNode> s = new Stack<>();
		// s.push(root);

		while (true) {
			while (p != null) {
				list.add(p.data);
				s.push(p);
				p = p.left;
			}

			if (s.isEmpty()) {
				break;
			}

			p = s.pop();
			p = p.right;
		}

		return list;
	}

	static ArrayList<Integer> inorder(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		TreeNode p = root;
		Stack<TreeNode> s = new Stack<>();
		// s.push(root);

		while (true) {
			while (p != null) {
				s.push(p);
				p = p.left;
			}

			if (s.isEmpty()) {
				break;
			}

			p = s.pop();
			list.add(p.data);
			p = p.right;
		}

		return list;
	}

	static ArrayList<Integer> postorder(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		Stack<TreeNode> o = new Stack<>();
		// s.push(root);

		while (!s.isEmpty()) {
			TreeNode curr = s.pop();
			s.pop();
			
			o.push(curr);
			
			if (curr.left != null) {
				s.push(curr.left);
			}
			
			if (curr.right != null) {
				s.push(curr.right);
			}
		}
		
		while (!o.isEmpty()) {
			list.add(o.peek().data);
			o.pop();
		}
		return list;
	}
}