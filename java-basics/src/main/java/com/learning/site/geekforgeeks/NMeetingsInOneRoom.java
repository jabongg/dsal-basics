package com.learning.site.geekforgeeks;

//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class NMeetingsInOneRoom {
 public static void main(String args[]) throws IOException {
     BufferedReader br =
         new BufferedReader(new InputStreamReader(System.in));
     int t = Integer.parseInt(br.readLine().trim());

     while (t-- > 0) {
         String inputLine[] = br.readLine().trim().split(" ");
         int n = Integer.parseInt(inputLine[0]);

         int start[] = new int[n];
         int end[] = new int[n];

         inputLine = br.readLine().trim().split(" ");
         for (int i = 0; i < n; i++)
             start[i] = Integer.parseInt(inputLine[i]);

         inputLine = br.readLine().trim().split(" ");
         for (int i = 0; i < n; i++) 
             end[i] = Integer.parseInt(inputLine[i]);
             
         int ans = new NMeetingsInOneRoom().maxMeetings(start, end, n);
         System.out.println(ans);
     }
 }

 //Function to find the maximum number of meetings that can
 //be performed in a meeting room.
	public static int maxMeetings(int[] start, int[] end, int n) {
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
			if (activityTime[i].startTime > lastEndTime) {
				result = result + 1;
				lastEndTime = activityTime[i].endTime;
			}
		}
		
		return result;
	}
}





