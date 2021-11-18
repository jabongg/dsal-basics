package com.learning.dsal.heap;

import java.util.PriorityQueue;
import java.util.Queue;

//TODO : logic samajh nhi aaya : dikha nahi : not working

public class MedianFromDataStream {

	private Queue<Long> small;
	private Queue<Long> large;

	// constructor to initialize the heaps
	public MedianFromDataStream() {
		small = new PriorityQueue<Long>();
		large = new PriorityQueue<Long>();
	}

	public static void main(String[] args) {
		MedianFromDataStream ms = new MedianFromDataStream();

		int[] A = { 2, 3, 4 };
		for (int i = 0; i < A.length; i++) {
			ms.addNum(A[i]);
			double median = ms.findMedian();
			System.out.println(median);
		}
	}

	private void addNum(int x) {
		large.offer((long) x);
		small.offer(-large.poll());

		if (large.size() < small.size()) {
			large.offer(-small.poll());
		}
	}

	private double findMedian() {
		return (long) (large.size() > small.size() ? large.peek() : large.peek() - small.peek() / 2.0);

	}
}
