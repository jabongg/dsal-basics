package com.learning.dsal.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinDistanceBtwnNodesBST {
	
	public static void main(String[] args) {
		MinDistanceBtwnNodesBST obj = new MinDistanceBtwnNodesBST();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(48);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(49);

//		TreeNode root = new TreeNode(4);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(6);
//		root.left.left = new TreeNode(1);
//		root.left.right = new TreeNode(3);
		
		System.out.print(obj.minDiffInBST(root));
	}

    public int minDiffInBST(TreeNode root) {
        
        Queue < Integer > res = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;
        inorder(root, res, min);

        int min1 = res.poll();
        int min2 = res.poll();
        
        
        return Math.abs(min1 - min2);
    }

     public void inorder(TreeNode root, Queue<Integer> res, int min) {
        if (root == null) {
            return;
        }
        if (root.val < min) {
            min = root.val;
        }
        inorder(root.left, res, min);
        res.add(root.val);
        inorder(root.right, res, min);
    } 
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
