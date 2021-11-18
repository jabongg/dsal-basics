package com.learning.java.array;


import java.util.Scanner;
public class SubArrayWithGivenSum {

	/*
	 * 
	 * Input :
1
42 468
135 101 170 125 79 159 163 65 106 146 82 28 162 92 196 143 28 37 192 5 103 154 93 183 22 117 119 96 48 127 172 139 70 113 68 100 36 95 104 12 123 134

	 */
	public static void main (String[] args)
	 {
	 //code
	 
	    Scanner scanner = new Scanner(System.in);
	    int T = scanner.nextInt();
         for (int i = 0; i < T; i++) {
             int N = scanner.nextInt();
             int S = scanner.nextInt();
             int[] A = new int[N];
             
             for (int j = 0; j < N; j++) {
                 A[j] = scanner.nextInt();
             }
             
             subarrayWithGivenSum(A, S);
         }
	 }
	 
	 
	// not covering every scenario
	 public static void subarrayWithGivenSumNonNegative(int[] A, int S) {
	     int left = 0;
	     int right = 0;
	     boolean sumFound = false;
	     int currentSum = 0;
	     
	     while (right < A.length && left <= right) {
	         if (currentSum == S) {
	        	 sumFound = true;
	             System.out.println((left + 1) + " " + (right));// since right is already increased in right++
	             break;
	         }
	         if (currentSum < S) {
		         currentSum = currentSum + A[right];
	             right++;
	         } else {
	             currentSum = currentSum - A[left];
	             left++;
	         }
	     }
	     
	     if (!sumFound) {
	    	 System.out.println("-1");
	     }
	 }
	 
	 
	 
		// not covering every scenario
	 public static void subarrayWithGivenSum(int[] A, int S) {
	  
		 int currentSum = A[0];
		 int n = A.length;
		 int start = 0;
		 int end = 1;
	     boolean sumFound = false;

		 while (end <= n) {
			 if (currentSum == S) {
	        	 sumFound = true;

	             System.out.println((start) + " " + (end));// since right is already increased in right++
	             break;
			 }
			 
			 if (currentSum > S && start < end) {
				 currentSum = currentSum - A[start];
				 start++;
			 }
			 
			 if (currentSum < S && end < n) {
				 currentSum = currentSum + A[end];
				 end++;
			 }
		 }
		 
	     if (!sumFound) {
	    	 System.out.println("-1");
	     }
	 }

}