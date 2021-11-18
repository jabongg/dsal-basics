package com.learning.dsal.searching;
/**
 * Search for an element in a sorted Matrix.
 */
public class SearchInASortedMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				{10, 20, 30, 40}, 
				{15, 25, 35, 45}, 
				{27, 29, 37, 48}, 
				{32, 33, 38, 50}};
		int key = 37;
		int[] keyPair = findElementInASortedMatrix(matrix, key);
		System.out.println("A[" + keyPair[0] + " " + keyPair[1] +"]");
	}

	private static int[] findElementInASortedMatrix(int[][] matrix, int key) {
		int i = 0; 
		int j = matrix[0].length - 1; // start kahan se karna hai, yahi choose karna hi talent hai
		
		int[] keyPair = new int[2]; // for storing i and j index of the element to be searched;
		keyPair[0] = -1; // if element is not present, return an invalid index.
		keyPair[1] = -1;
		while ((i >= 0 && i < matrix.length) && (j >= 0 && j < matrix[0].length)) {
			if (matrix[i][j] == key) {
				keyPair[0] = i;
				keyPair[1] = j;
				return keyPair;
			}
			if (matrix[i][j] > key) {
				j--;
			} else if (matrix[i][j] < key) {
				i++;
			}
		}
		return keyPair;
	}
}
