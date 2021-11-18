package com.learning.site.codeforces;

import java.util.Scanner;

//Codeforces Round #713 (Div. 3)
public class SpyDetected {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int t = scan.nextInt();
	    
	    while (t-- > 0) {
	        int n = scan.nextInt();
	        int[] A = new int[n];
	        for (int i = 0; i < n; i++) {
	            A[i] = scan.nextInt();
	        }
            System.out.println(detectSpy(A));
	    }
	}
	private static int detectSpy(int[] A) {
	    int spyIdx = -1;
	    
	    for (int i = 0; i <= A.length - 3; i++) {
	        // 4 cases
	        
	        // case 1 : all 3 elements are same
	        //if ((A[i] == A[i+1]) && (A[i+1] == A[i+2])) {
	            // do nothing
	        //}
	        
	        // case 2 : if 1st element is spy
	        if ((A[i] != A[i+1]) && (A[i+1] == A[i + 2])) {
	            return i + 1; // index + 1 since index is starting from 1;
	        }
	        
	        // case 3 : if 2nd element is spy
	        if ((A[i] != A[i+1]) && (A[i] == A[i + 2])) {
	            return (i+1) + 1; // index + 1 since index is starting from 1;
	        }
	        
	        // case 4 : if 3rd element is spy
	        if ((A[i] == A[i+1]) && (A[i+1] != A[i + 2])) {
	            return (i+2) + 1; // index + 1 since index is starting from 1;
	        }
	    }
	    return spyIdx;
	}
	 
}
