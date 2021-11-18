package com.learning.dsal.tree;

public class Heap {

	//TODO : write proper code
	public static void main(String[] args) {
	
		BSTNode root = null;
		
		int[] A = {4, 1, 3, 2, 16, 9, 10, 14, 8};
		
		int[] heap = buildHeap(A);
		
		for (int e : heap) {
			System.out.print(e + " ");
		}
		
		//build max-heap
//		root = buildHeap(root, 4);
//		root = buildHeap(root, 1);
//		root = buildHeap(root, 3);
//		root = buildHeap(root, 2);
//		root = buildHeap(root, 16);
//		root = buildHeap(root, 9);
//		root = buildHeap(root, 10);
//		root = buildHeap(root, 14);
//		root = buildHeap(root, 8);
		
		//print
	}

	private static int[] buildHeap(int[] A) {
		// left : 2i + 1
		// right : 2i + 2
		int floor = (int) Math.floor(A.length / 2 );
		
		for (int i = floor; i >= 0; i--) {
			maxHeapify(A, i);
		}
		return A;
	}

	private static void maxHeapify(int[] A, int i) {
		int n = A.length;
		int l =  (int) Math.floor(2 * i + 1);
		int r =  (int) Math.floor(2 * i + 2);
		
		int largest = A[i];
		if (l <= n && A[l] > A[i]) {
			largest = A[l];
		} 
		if (r <= n && A[r] > A[i]) {
			largest = A[r];
		}
		
		//swap
		swap(A, i, largest);
		
	}

	private static void swap(int[] A, int i, int largest) {
		int temp = A[i];
		A[i] = largest;
		largest = temp;
	}
	
	
	
}
