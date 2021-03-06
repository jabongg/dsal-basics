package com.learning.dsal.dp;

public class EggDroppingProblemMemoized {


    static int[][] t = new int[101][10001];
    
    public static int superEggDrop(int e, int f) {
        //initialize the table t with -1
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = -1;
            }
        }
        
        // the floor at which egg breaks
        if (f == 0 || f == 1) 
            return f;
        if (e == 1)
            return f;
        
        if (t[e][f] != -1) {
            return t[e][f];
        }
        
        int minimumMoves = Integer.MAX_VALUE;
        
        for (int k = 1; k <= f; k++) {
            int low, high;
        	
            if (t[e - 1][k - 1] != -1) {
                return t[e - 1][k - 1];
            } else {
                low = superEggDrop(e - 1, k - 1);
                t[e - 1][k - 1] = low;
            }
            
            if (t[e][f - k] != -1) {
                return t[e][f - k];
            } else {
                high = superEggDrop(e, f - k);
                t[e][f - k]= high;
            }
            
            int tempFloor = 1 + Math.max(low, high);
           
            /*
            int tempFloor = Math.max(superEggDrop(e - 1, k - 1) // in case egg breaks
                            , superEggDrop(e, f - k))
                            + 1; // first attempt of dropping an egg from kth floor
            */
           // t[e][f] = tempFloor;
            
            if (tempFloor < minimumMoves) {
                minimumMoves = tempFloor;
            }
        }
        return  t[e][f] = minimumMoves;
    }
    
    public static void main(String[] args) {
		int eggs = 2;
		int floors = 10;
		System.out.println(superEggDrop(eggs, floors));
	}
}