package com.self.gs.digits;
import java.util.Arrays;
import java.util.List;

import com.self.gs.utils.PreetyPrint;

import java.util.ArrayList;
/*
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class Array3Sum15 {
	
   public static  List<List<Integer>> threeSum(int[] nums, int k) {
	   List<List<Integer>> result = new ArrayList<List<Integer>>();
	   Arrays.sort(nums);
	   PreetyPrint.print(nums);
	   
	   int expectedSum = k;
        
	   for(int i=0;i<nums.length-2;i++) {
		   if(i>0 && nums[i] == nums[i-1]){ // duplicates 
			   continue; 
		   }
		   int wantedSum = expectedSum - nums[i] ;
		   System.out.println("wantedSum " + wantedSum + "for " + nums[i]);
		   int l = i+1;
		   int r = nums.length-1;
		   while(l<r) {
			   int twoSum = nums[l] + nums[r];
			   if(twoSum == wantedSum) {
				   result.add(Arrays.asList(nums[i],nums[l],nums[r]));
				
				   while((nums[l]==nums[l+1])) { // conditions duplicates left side
					   l++;
					   continue;
				   }
				    while(nums[r] == nums[r-1]) { // conditions duplicates right side
					   r--;
					   continue;
				   }
				   l++;
				   r--;
			   }else if(twoSum>wantedSum) {
				   r--;
			   }else {
				   l++;
			   }
		   }
	   }
	   
	   return result;
    }

	public static void main(String[] args) {
		int[] input = new int[] {1,2,-1,-2};
		//PreetyPrint.print(input);
		System.out.println(threeSum(input,0));
	}

}
