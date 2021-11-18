package com.learning.site.ctci;

import java.util.HashMap;
import java.util.Map;

/**
 * Example: Print all positive integer solutions to the equation a3 + b3 and d
 * are integers between 1 and 1000.
 * 
 * @author User
 *
 */
public class EqualPairsEquation {

	public static void main(String[] args) {
		int n = 1000;
		// findPairOrderN4(n);
		// findPairOrderN3(n);
		findPairOrderN2(n);
	}

	private static void findPairOrderN4(int n) {
		long start = System.currentTimeMillis();
		System.out.println(start);
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				for (int c = 1; c <= n; c++) {
					for (int d = 1; d <= n; d++) {
						if (a * a * a + b * b * b == c * c * c + d * d * d) {
							System.out.println(a + "," + b + "," + c + "," + d);
							// break;
						}
					}
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end);

		System.out.println(end - start);

	}

	private static void findPairOrderN3(int n) {
		long start = System.currentTimeMillis();
		System.out.println(start);
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				for (int c = 1; c <= n; c++) {
					double d = Math.pow(a * a * a + b * b * b - c * c * c, 1 / 3);

					if (a * a * a + b * b * b == c * c * c + d * d * d) {
						System.out.println(a + "," + b + "," + c + "," + d);
						// break;
					}
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end);

		System.out.println(end - start);

	}

	private static void findPairOrderN2(int n) {
		long start = System.currentTimeMillis();
		Map<Integer, Pair> pairMap = new HashMap<>();
		
		System.out.println(start);
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				Pair p = new Pair(a, b);
				int result = a * a * a + b * b * b;
				pairMap.put(result, p);
			}
		}
		
		for (int c = 1; c <= n; c++) {
			for (int d = 1; d <= n; d++) {
				int result = c * c * c + d * d * d;

				if (pairMap.containsKey(result)) {
					Pair p = pairMap.get(result);
					System.out.println(p.element1 + " " + p.element2);
				}
				//pairMap.put(result, p);
			}
		}
		
		
		long end = System.currentTimeMillis(); 
		System.out.println(end);

		System.out.println(end - start);

	}
}

class Pair {
	int element1;
	int element2;

	public Pair(int element1, int element2) {
		super();
		this.element1 = element1;
		this.element2 = element2;
	}

}
