package com.learning.dsal.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinHeap {
	public static void main(String[] args) {
		// min-heap
		int[] A = { 7, 10, 4, 3, 20, 15 };

		Queue<Integer> minHeap = minHeap(A);
		System.out.println(minHeap);
	}

	private static Queue<Integer> minHeap(int[] A) {
		Queue<Integer> heap = new PriorityQueue<>();
		
		for (int i = 0; i < A.length; i++) {
			heap.offer(A[i]);
		}
		
		return heap;
	}

}
