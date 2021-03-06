package com.learning.java.stack.recursion;

/*
 * base condition : 
 * if n = 1 and k = 1
 * return 0;
 * 
 * The grammar looks like below
 * 
 *      K: 1 2 3 4 5 6 7 8 ->
 * n = 1 : 0
 * n = 2 : 0 1
 * n = 3 : 0 1 1 0
 * n = 4 : 0 1 1 0 1 0 0 1
 * n = 5 : 0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0
 * |
 * v
 * 
 * if (n = 4, k = 3) then method should return 1 as its relative position
 * 
 * Observation : for any n, half of the bits are exactly same as the previous row 
 * i.e. (n - 1)th row
 * and 
 * other half is 'compliment' of the respective bits of n-1th row after the middle element
 * .
 */
public class GrammarGenerate {

	public static void main(String[] args) {
		int n = 4;
		int k = 3;
		
		int digit = generateGrammar(n, k);
		System.out.println(digit);
	}

	private static int generateGrammar(int n, int k) {
		if (n == 1 && k == 1) {
			return 0;
		}
		int mid = (int) Math.pow(2,  n - 1) / 2;
		if (k <= mid) {
			return generateGrammar(n - 1, k);
		} else {
			return generateGrammar(n - 1, k - mid); // TODO: write compliment logic here
		}
	}
}
