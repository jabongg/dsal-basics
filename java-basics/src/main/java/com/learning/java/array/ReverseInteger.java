package com.learning.java.array;

public class ReverseInteger {
	/*
	 * public static int reverse(int x) { StringBuilder reverseNum = new
	 * StringBuilder(); // handle the sign
	 * 
	 * if ( x == 0) { return x; }
	 * 
	 * if (x < 0) { reverseNum.append("-"); x = (-1) * x; // taking modulus of the
	 * number }
	 * 
	 * while (x > 0 ) { reverseNum.append(x % 10); x = x / 10; }
	 * 
	 * 
	 * String reversed = reverseNum.toString(); x = Integer.parseInt(reversed);
	 * return x; }
	 */

	/*
	 * public static int reverse(int x) {
	 * 
	 * int max_32 = Integer.MAX_VALUE; int min_32 = Integer.MIN_VALUE;
	 * 
	 * if (( x < min_32) || (x > max_32)) { return 0; } else { int res = 0; int rem
	 * = 0;
	 * 
	 * int sign; sign = x < 0 ? -1 : 1;
	 * 
	 * x = Math.abs(x);
	 * 
	 * while (x != 0) { rem = x % 10; x = x /10;
	 * 
	 * res = res * 10 + rem;
	 * 
	 * if (res > max_32 || res < min_32) { return 0; }
	 * 
	 * } return res * sign;
	 * 
	 * } }
	 * 
	 */
	public static int reverse(int x) {
		int rev = 0;

		while (x != 0) {
			int digit = x % 10;
			x = x / 10;

			int tmp = rev;
			rev = rev * 10 + digit;

			// if check if overflowed
			if ((rev - digit) / 10 != tmp)
				return tmp * 10 + digit;

			System.out.println(rev);
		}

		return rev;

	}

	// main method
	public static void main(String[] args) {
		int x = 1534236469;
		int result = reverse(x);
		System.out.println(result);

	}
}
