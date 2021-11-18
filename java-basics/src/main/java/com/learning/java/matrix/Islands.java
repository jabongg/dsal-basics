package com.learning.java.matrix;

/**
 * Given a boolean 2D matrix, find the number of islands. A group of connected
 * 1s forms an island. For example, the below matrix contains 5 islands
 * 
 * Example: Input : mat[][] = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1,
 * 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1} Output : 5
 * 
 * @author User
 *
 */
public class Islands {

	public static void main(String[] args) {
		char[][] mat = { { '1', '1', '0', '0', '0' }, { '0', '1', '0', '0', '1' }, { '1', '0', '0', '1', '1' }, { '0', '0', '0', '0', '0'},
				{ '1', '0', '1', '0', '1' } };
		
		System.out.println(new Islands().numIslands(mat));
	}

	public void DFSRec(char[][] mat, int N, int M, int i, int j) {
		mat[i][j] = 2; //why this base condition for recursion?
 
		// Right Side
		if (j + 1 < M) {
			if (mat[i][j + 1] == '1') {
				DFSRec(mat, N, M, i, j + 1);
			}
		}

		// Left Side
		if (j - 1 >= 0) {
			if (mat[i][j - 1] == '1') {
				DFSRec(mat, N, M, i, j - 1);
			}
		}

		// Up side
		if (i - 1 >= 0) {
			if (mat[i - 1][j] == '1') {
				DFSRec(mat, N, M, i - 1, j);
			}
		}

		// Down side
		if (i + 1 < N) {
			if (mat[i + 1][j] == '1') {
				DFSRec(mat, N, M, i + 1, j);
			}
		}

		// South East
		if (i + 1 < N && j + 1 < M) {
			if (mat[i + 1][j + 1] == '1') {
				DFSRec(mat, N, M, i + 1, j + 1);
			}
		}

		// South West
		if (i + 1 < N && j - 1 >= 0) {
			if (mat[i + 1][j - 1] == '1') {
				DFSRec(mat, N, M, i + 1, j - 1);
			}
		}

		// North West
		if (i - 1 >= 0 && j - 1 >= 0) {
			if (mat[i - 1][j - 1] == '1') {
				DFSRec(mat, N, M, i - 1, j - 1);
			}
		}

		// North East
		if (i - 1 >= 0 && j + 1 < M) {
			if (mat[i - 1][j + 1] == '1') {
				DFSRec(mat, N, M, i - 1, j + 1);
			}
		}
	}

	public int numIslands(char[][] mat) {
		int N = mat.length;
		int M = mat[0].length;
		return findIslands(mat, N, M);
	}

	public int findIslands(char[][] mat, int N, int M) {
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mat[i][j] == '1') {
					DFSRec(mat, N, M, i, j);
					count++;
				}
			}
		}

		return count;
	}

}