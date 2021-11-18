package com.learning.dsal.heap;

import java.util.Queue;

/**
 * connect ropes to get minimum cost. 
 * cost is equal to the given number.
 * @author User
 *
 */
public class ConnectRopes {

	public static void main(String[] args) {
		int[] ropes = {1, 2, 3, 4, 5};
		System.out.println(calculateMinimumCost(ropes));
	}

	private static int calculateMinimumCost(int[] ropes) {
		Queue<Integer> heap = Heap.getMinHeap(ropes);
		
		int cost = 0;
		
		while (!(heap.size() == 1)) {
			// choose the two minimum sized ropes
			int rope1 = heap.poll();
			int rope2 = heap.poll();
			
			cost += rope1 + rope2;
			heap.offer(rope1 + rope2);
		}
		return cost;
	}
	

}
