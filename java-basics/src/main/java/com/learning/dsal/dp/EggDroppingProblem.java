package com.learning.dsal.dp;

public class EggDroppingProblem {

	
    static public int superEggDrop(int e, int f) {

        // the floor at which egg breaks        
        if (f == 0 || f == 1) 
            return f;
        if (e == 1)
            return f;
        
        int minimumMoves = Integer.MAX_VALUE;
        
        for (int k = 1; k <= f; k++) {
            int tempFloor = Math.max(superEggDrop(e - 1, k - 1) // in case egg breaks
                            , superEggDrop(e, f - k))
                            + 1; // first attempt of dropping an egg from kth floor
            
            if (tempFloor < minimumMoves) {
                minimumMoves = tempFloor;
            }
        }
        return minimumMoves;
    }
    
    public static void main(String[] args) {
		int eggs = 3;
		int floors = 7;
		System.out.println(superEggDrop(eggs, floors));
	}
}