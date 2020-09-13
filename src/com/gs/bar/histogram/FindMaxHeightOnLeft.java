package com.gs.bar.histogram;

import java.util.Arrays;

/*
 
 3                      |
 2          |           |  |  |
 1    |     |  |     |  |  |  |  |
   0  1  2  3  4  5  6  7  8  9  10
 
 
 */
public class FindMaxHeightOnLeft {
	
	private static int[] find(int[] nums) {
		int[] maxHeight = new int[nums.length];
		int maxSeenHeight = 0;
		for(int i = 0; i <nums.length ; i++) {
			if(nums[i] > maxSeenHeight) {
				maxHeight[i] = nums[i];
				maxSeenHeight = nums[i];
			}else {
				maxHeight[i] =  maxSeenHeight;
			}
		}
		return maxHeight;
	}	
	
  public static void main(String[] args) {
	int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
	int[] maxLeftHeight = find(nums);
	System.out.println(Arrays.toString(maxLeftHeight));
  }


}
