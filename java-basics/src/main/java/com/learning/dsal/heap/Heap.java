package com.learning.dsal.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Heap {

	public static Queue<Integer> getMaxHeap(int[] A) {
		Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < A.length; i++) {
			heap.offer(A[i]);
		}
		
		return heap;
	}
	public static Queue<Integer> getMinHeap(int[] A) {
		Queue<Integer> heap = new PriorityQueue<>();
		
		for (int i = 0; i < A.length; i++) {
			heap.offer(A[i]);
		}
		
		return heap;
	}
	
	private static int getKthLargestElement(int[] A, int k) {

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
	
	public static int getKthSmallestElement(int[] A, int k) {

		Queue<Integer> heap = new PriorityQueue<Integer>();

		for (int i = 0; i < A.length; i++) 
			heap.offer(A[i]);

		for (int i = 0; i < k - 1; i++) //running loop to k - 1;
				heap.poll();
		
		return heap.peek();
	}
}
