package com.learning.dsal.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxHeap {
	public static void main(String[] args) {
		
		// max-heap
		int[] A = { 7, 10, 4, 3, 20, 15 };

		Queue<Integer> minHeap = maxHeap(A);
		System.out.println(minHeap);
	}

	private static Queue<Integer> maxHeap(int[] A) {
		Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < A.length; i++) {
			heap.offer(A[i]);
		}
		
		return heap;
	}
	
}