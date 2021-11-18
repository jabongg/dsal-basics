package com.learning.site.geekforgeeks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumPlatforms {
	// Function to find the minimum number of platforms required at the
	// railway station such that no train waits.

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

		int tasks = findPlatform(start, end, n);
		System.out.println(tasks);

	}

	static int findPlatform(int arr[], int dep[], int n) {

		PriorityQueue<Integer> endTime = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			if (endTime.isEmpty()) {
				endTime.add(dep[i]);
			} else if (arr[i] > endTime.peek()) {
				endTime.poll();
				endTime.add(dep[i]);
			} else {
				endTime.add(dep[i]);
			}
		}

		return endTime.size();
	}

	static int findPlatform3(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			if (pq.isEmpty()) {
				pq.add(i);
			} else {
				if (arr[i] > dep[pq.peek()]) {
					pq.poll();
					pq.add(i);
				} else {
					pq.add(i);
				}
			}
		}
		return pq.size();
	}
	
	static int findPlatform4(int arr[], int dep[], int n) {
		int size = Arrays.stream(dep).max().getAsInt();
		int[] platforms = new int[size + 1];
		for (int i = 0; i < n; i++)
			for (int j = arr[i]; j <= dep[i]; j++)
				++platforms[j];
		return Arrays.stream(platforms).max().getAsInt();
	}



	static int findPlatform2(int[] start, int[] end, int n) {
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
		int lastEndTime = activityTime[0].endTime;
		for (int i = 1; i < activityTime.length; i++) {
			if (activityTime[i].startTime < lastEndTime) {
				result++;
			}
			lastEndTime = activityTime[i].endTime;
		}

		return result;
	}

}
