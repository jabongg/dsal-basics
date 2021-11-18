package com.learning.dsal.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {

	public static void main(String[] args) {
		// min-heap
		int[] A = { 7, 10, 4, 3, 20, 15 };
		int k = 3;

		// find the 3rd largest element i.e. 10
		System.out.println(k + "th smallest element : " + findKthSmallestElement(A, k));
	}

	private static int findKthSmallestElement(int[] A, int k) {

		// priority queue will give min-heap
		Queue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < A.length; i++) {
			heap.offer(A[i]);

			if (heap.size() > k) {
				heap.poll();
			}
		}

		
		return heap.peek();
	}
}
