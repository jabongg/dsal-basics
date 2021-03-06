package com.learning.dsal.dp;

/**
 * Samsung R & D Noida Question September 2018
Difficulty Level : Medium
 Last Updated : 10 Sep, 2018
Round 1: There was an online coding round on 10th of September, 2018, For which about 50 candidates had come. I will come directly to that special question, for which one has to solve in 4 hours, and there were 50 test cases to be passed for that problem. Any one passing all test cases would be considered for next round of interview.

The question was like this?

You have to place an electronic banner of a company as high as it can be, so that whole the city can view the banner standing on top of TWO PILLERS.
The height of two pillers are to be chosen from given array.. say [1, 2, 3, 4, 6]. We have to maximise the height of the two pillars standing side by side, so that the pillars are of EQUAL HEIGHT and banner can be placed on top of it.
In the above array, (1, 2, 3, 4, 6) we can choose pillars like this, say two pillars as p1 and p2..
Then pillars can be,
p1 = 3 unit? Choosing element (3) from array,
Similarly p2 = 3 choosing (2 + 1) from array.
Since, two pillars are equal, we can put board on it?
But we have two maximise the height of the pillars,
And if we check for other heights, we can see p1 = 6 p2 = 4 + 2 which is greater than 3 ( the previous height)..
We have to see if we can further maximize the height? Yes it can be 8.
I.e. p1 = 6 + 2 = 8. p2 = 4 + 3 + 1 = 8.
Both pillars are equal and banner can be placed? And since this is the maximum height attainable for two pillars, we print the answer as 8. In case, there is no combination possible, print 0 (zero).

INPUT :
1
5
1 2 3 4 6
First line is  T  number of test cases to be followed.
Second line of input is number of different pillars.
Third line of input is  different available heights of pillars.
Note : heights of given pillars can be same .. I.e. array can have same elements repeated.

Output.
8




Simply print the maximum height attainable so that board/ banner can be placed.
In case there is no possible combination for placing banner with equal weighted pillars, then print 0.
Constraint?s : some general constraints were given but  I don?t remember exactly.
This was the question  to done in 4 hours.

I was out after first round, as I could not solve this problem. Hope this may help you for cracking Samsung interview.

 * @author User
 *
 */
public class HighestBanner {

	// A memoized solution for subset sum

	static boolean table[][] = new boolean[10][30];

	// Returns true if there is a subset
	// of set[] with sum equal to given sum
	static boolean isSubsetSum(int set[], int n, int sum) {

		boolean[][] table = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {

				if (i == 0 || j == 0) {
					if (i == 0) {
						table[i][j] = false; // initializing the row and column
					}

					if (j == 0) {
						table[i][j] = true;
					}
				}
				// in case item weight is less than the capacity
				else if (set[i - 1] <= j) {
					table[i][j] = table[i - 1][j - set[i - 1]] // including the item
							|| table[i - 1][j];// excluding the item
				} else {

					// item is not included because of less capacity
					table[i][j] = table[i - 1][j];
				}
			}
		}

		return table[n][sum];
	}

	/* Driver code */
	public static void main(String args[]) {
		int set[] = { 2, 3, 4, 6};
		// int sum = 15;
		int n = set.length;
		int  maxBannerHeight = isEqualSumPartion(set, n);
		System.out.println("Banner height : " + maxBannerHeight);
	}

	private static int isEqualSumPartion(int[] set, int n) {

		int partitionSum = 0;

		for (int i = 0; i < set.length; i++) {
			partitionSum = partitionSum + set[i];
		}

		// iterate each time till partition / 2 to get the maximum possible height;
		
		int max = Integer.MIN_VALUE;
		
		int maxValuePartition = partitionSum / 2;
		for (int i = 1; i <= maxValuePartition ; i++) {
			if (isSubsetSum(set, set.length, i)) {
				max = maxValuePartition;
			}
		}
		return max;
	}
	
//
//	// working 
//	
//	// Returns true if there is a subset
//	// of set[] with sum equal to given sum
//	static boolean[][] minimumSubsetSumDifference(int set[], int n, int sum) {
//		boolean[][] table = new boolean[n + 1][sum + 1];
//
//		for (int i = 0; i <= n; i++) {
//			for (int j = 0; j <= sum; j++) {
//
//				if (i == 0 || j == 0) {
//					if (i == 0) {
//						table[i][j] = false; // initializing the row and column
//					}
//					
//					if (j == 0) {
//						table[i][j] = true;
//					}
//				}
//				
//				// in case item weight is less than the capacity
//				else if (set[i - 1] <= j) {
//					table[i][j] = table[i - 1][j - set[i - 1]] // including the item
//							|| table[i - 1][j];// excluding the item
//				} else {
//					// item is not included because of less capacity
//					table[i][j] = table[i - 1][j];
//				}
//			}
//		}
//		return table;
//	}
//
//	/* Driver code */
//	public static void main(String args[]) {
//		int set[] = {1, 6, 11, 5};
//		int sum = 0;
//		
//		for (int i = 0; i < set.length; i++) {
//			sum += set[i];
//		}
//		
//		int n = set.length;
//		boolean[][] t = minimumSubsetSumDifference(set, n, sum);
//		
//		boolean[] lastRowMatrix = new boolean[t[0].length];
//		
//		for (int j = 0; j < t[0].length; j++) {
//			lastRowMatrix[j] = t[t.length - 1][j];
//		}
//		
//		
//		int[] trueValues = new int[lastRowMatrix.length];
//		int k = 0;
//		
//		for (int i = 0; i < lastRowMatrix.length / 2; i++) {
//			if (lastRowMatrix[i]) {
//				trueValues[k++] = i; // sum
//			}
//		}
//	
//		int minimum = Integer.MAX_VALUE;
//		
//		for (int i = 0; i < trueValues.length; i++) {
//			minimum = Math.min(minimum, sum - 2 * trueValues[i]);
//		}
//		
//		System.out.println(minimum);
//	}
}