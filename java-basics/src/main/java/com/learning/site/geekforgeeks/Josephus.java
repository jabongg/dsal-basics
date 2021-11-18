package com.learning.site.geekforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.example.datastructures.PrintUtil;

public class Josephus {

	static int josephus(int n, int k) {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		while (q.size() != 1) {
			int temp = k - 1;
			while (temp > 0) {
				q.add(q.remove());

				temp--;
			}
			q.remove();
		}
		return q.peek();
	}

	public static void main(String[] args) {
		System.out.println(josephus(5, 3));
		System.out.println(josephusProblem(5, 3));
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(123);
		al.add(34);
		al.add(534);
		
		System.out.println(al);
		al.remove(2);
		System.out.println(al);

	}

	// brute force solution
	static int josephusProblem(int n, int k) {

		int[] warriors = new int[n];
		int[] aliveWarriors = new int[n];

		for (int i = 0; i < n; i++) {
			warriors[i] = i + 1; // n warriors starting from 1
		}

		for (int i = 0; i < n; i++) {
			aliveWarriors[i] = 1; // initially each warrior is alive
		}

		PrintUtil.printArray(warriors);
		PrintUtil.printArray(aliveWarriors);

		int aliveWarriorsCount = n;
		
		while (aliveWarriorsCount != 1) {
			// find kth warrior and kill it with sword.
			
			aliveWarriorsCount--;
		}
		return 0;
	}

}
