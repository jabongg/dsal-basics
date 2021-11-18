package com.learning.java.array;

import java.util.Arrays;

/** Given a sorted array of positive integers, rearrange the array
alternatively i.e. first element should be the maximum value, second minimum value, 
third-second max, fourth-second min and so on

1 3 4 5 8 10
    |
    |
    V
    
10 1 8 3 5 4
    
@author जंग बहादुर पटेल
  
*/
public class RearrangeArray {

	public static void main(String[] args) {
		int[] A = {1, 3, 4, 5, 8, 10};

		int[] B = rearrangeArray(A);
		
		for (int el : B) {
			System.out.print(el + " ");
		}
	}
	
	public static int[] rearrangeArray(int[] A) {
		Arrays.sort(A);
		int lower = 0;
		int higher = A.length - 1;
		int currIdx = 0;
		int[] B = new int[A.length];

		while (lower < higher) {
			B[currIdx++] = A[higher--];
			B[currIdx++] = A[lower++];
		}
		
		return B;
	}
	
}
