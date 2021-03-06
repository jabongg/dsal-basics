package com.learning.site.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlmostRectangle {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		while (t-- > 0) {
			int n = scan.nextInt();
			char[][] matrix = new char[n][n];

			for (int i = 0; i < n; i++) {
				String line = scan.next();
				for (int j = 0; j < n; j++) {
					matrix[i][j] = line.charAt(j);
				}
			}

			printAlmostRectangle(matrix);
		}
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	private static void printAlmostRectangle(char[][] matrix) {

		List<Point> points = findStarsIndices(matrix);

		createRectangle(points, matrix);

		printMatrix(matrix);
	}

	private static char[][] createRectangle(List<Point> points, char[][] A) {
		// simple math here

				int x1;
				int y1;

				int x2;
				int y2;

				Point p1 = points.get(0);
				x1 = p1.x;
				y1 = p1.y;

				Point p2 = points.get(1);
				x2 = p2.x;
				y2 = p2.y;
				
				for (int i = 0; i < A.length; i++) {
					for (int j = 0; j < A.length; j++) {
						if ((x1 == x2) || (y1 == y2)) {
							// cases of same row or column
							if ((y2 < A[0].length && y2 > 0|| y1 < A[0].length && y1 > 0 )) {
								
							}
							if ((x2 < A.length || x1 < A.length )) {
								
							}
							
							A[x1][y2] = '*';
							A[x2][y1] = '*';
						} else {

							A[x1][y2] = '*';
							A[x2][y1] = '*';	
						}
					}
				}
				
				return A;

		
	}

	private static List<Point> findStarsIndices(char[][] A) {

		List<Point> points = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[i][j] == '*') {
					points.add(new AlmostRectangle().new Point(i, j));
				}
			}
		}

		return points;
	}

	private static void printMatrix(char[][] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}

}
