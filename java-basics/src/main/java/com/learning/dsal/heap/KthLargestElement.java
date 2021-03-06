package com.learning.dsal.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

	public static void main(String[] args) {
		// min-heap
		int[] A = { 7, 10, 4, 3, 20, 15 };
		int k = 4;

		// find the 3rd largest element i.e. 10
		System.out.println(k + "th largest element : " + findKthLargestElement(A, k));
	}

	private static int findKthLargestElement(int[] A, int k) {

		// priority queue will give min-heap
		Queue<Integer> heap = new PriorityQueue<Integer>();

		for (int i = 0; i < A.length; i++) {
			heap.offer(A[i]);

			if (heap.size() > k) {
				heap.poll();
			}
		}

		
		return heap.peek();
	}
}
