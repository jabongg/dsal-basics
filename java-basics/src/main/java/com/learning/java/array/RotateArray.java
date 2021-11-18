package com.learning.java.array;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 6;
		
		int[] rotated = new int[nums.length];
		
		System.out.print(nums);
		System.out.print(rotated);

		rotated = nums;
		
		System.out.print(nums);
		System.out.print(rotated);

		//rotate(nums, k);
		rotateArray(nums, k);
	}
	
	/* method to rotate array */
    public static void rotate(int[] nums, int k) {
        int numsSize = nums.length;
        int[] rotatedArray  = new int[numsSize];
        int j = 0;
        
        for (int i = numsSize - k; i < numsSize; i++) {
            rotatedArray[j] = nums[i];
            j++;
        }
        
        for (int i = 0; i < numsSize - k; i++) {
            rotatedArray[j] = nums[i];
            j++;
        }
        
        nums = rotatedArray;
        
      
        
       // System.out.print("[");

		/*
		 * for (int i = 0; i < rotatedArray.length; i++) { if (i == rotatedArray.length
		 * - 1) { System.out.print(rotatedArray[i]); } else {
		 * System.out.print(rotatedArray[i] + ","); } }
		 * 
		 * System.out.print("]");
		 */
    }

    
    
    public static void rotateArray(int[] nums, int k) {
        int numsSize = nums.length;
        
        System.out.print("[");

        for (int i = numsSize - k; i < numsSize; i++) {
            System.out.print(nums[i] + ",");
        }
        
        for (int i = 0; i < numsSize - k; i++) {
        	
            if (i ==  numsSize - k - 1) {
                System.out.print(nums[i]);
            } else {
                     System.out.print(nums[i] + ",");
            }
        }
 
        
        System.out.print("]");

    }       
}
