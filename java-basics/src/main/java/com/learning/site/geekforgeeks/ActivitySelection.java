package com.learning.site.geekforgeeks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Given N activities with their start and finish times. Select the maximum
 * number of activities that can be performed by a single person, assuming that
 * a person can only work on a single activity at a time.
 * 
 * Note : The start time and end time of two activities may coincide.
 * 
 * Example 1:
 * 
 * Input: N = 5 start[] = {1,3,2,5,8,5} end[] = {2,4,6,7,9,9} Output: 4
 * Explanation:Perform the activites 1,2,4,5
 * 
 * @author jang 5 1 3 2 5 8 5 2 4 6 7 9 9
 * 
 */

public class ActivitySelection {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] start = new int[n];
		int[] end = new int[n];

		for (int i = 0; i < n; i++) {
			start[i] = scanner.nextInt();
		}

		for (int i = 0; i < n; i++) {
			end[i] = scanner.nextInt();
		}

		scanner.close();

		int tasks = activitySelection(start, end, n);
		System.out.println(tasks);

	}

	static int activitySelection(int[] start, int[] end, int n) {
		ActivityTime[] activityTime = new ActivityTime[n];
		for (int i = 0; i < n; i++) {
			activityTime[i] = new ActivityTime(start[i], end[i]);
		}

		// sort the elements on the basis of end time.
		Arrays.sort(activityTime, new Comparator<ActivityTime>() {

			public int compare(ActivityTime at1, ActivityTime at2) {
				return at1.endTime - at2.endTime;
			}
		});

		
		
		int result = 0;
		int lastEndTime = 0;
		for (int i = 0; i < activityTime.length; i++) {
			if (activityTime[i].startTime >= lastEndTime) {
				result++;
				lastEndTime = activityTime[i].endTime;
			}
		}

		return result;
	}
}

