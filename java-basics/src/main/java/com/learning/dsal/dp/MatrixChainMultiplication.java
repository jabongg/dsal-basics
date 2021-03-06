package com.learning.dsal.dp;

/**
 * Problem Statement :
 * 
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.
We have many options to multiply a chain of matrices because matrix multiplication is associative. In other words, no matter how we parenthesize the product, the result will be the same. For example, if we had four matrices A, B, C, and D, we would have: 

(ABC)D = (AB)(CD) = A(BCD) = ....
However, the order in which we parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency. For example, suppose A is a 10 ? 30 matrix, B is a 30 ? 5 matrix, and C is a 5 ? 60 matrix. Then,  

(AB)C = (10?30?5) + (10?5?60) = 1500 + 3000 = 4500 operations
A(BC) = (30?5?60) + (10?30?60) = 9000 + 18000 = 27000 operations.


Output : Input: p[] = {40, 20, 30, 10, 30}   
Output: 26000  


 * @author User
 *
 */
public class MatrixChainMultiplication {

	public static void main(String[] args) {
		
		int[] A = {40, 20, 30, 10, 30};
		// find minimum cost to multiply the matrices
		int minimumCost = findMinimumCostOfMatrixMultiplication(A);
		System.out.println(minimumCost);
	}

	private static int findMinimumCostOfMatrixMultiplication(int[] A) {

		/*
		 * Find : 
		 * 1. i and j
		 * 2. base condition
		 * 3. make scheme to move for k
		 */
		
		//  initialize : point 1 completed
		int i = 1;
		int j = A.length - 1;
		
		return solve(A, i, j);
	}

	private static int solve(int[] A, int i, int j) {

		// base condition : point 2 covered
		if (i >= j) 
			return 0;
		
		
		int minimumCost = Integer.MAX_VALUE;
		
		// decide scheme to move k ->  i to k; and k + 1 to j; point 3 covered
		for (int k = i; k <= j - 1; k++) {
		
			int tempAnswer = solve(A, i, k) + solve(A, k + 1, j) + A[i - 1] * A[k] * A[j];
			if (tempAnswer < minimumCost) {
				minimumCost = tempAnswer;
			}
		}
		
		return minimumCost;
	}
	
	
}
