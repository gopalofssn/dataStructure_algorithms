package com.self.gs.digits;

import java.util.Arrays;

//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
// COND - list is sorted
class Solution {
    public int[] twoSum(int[] nums, int target) {
   
    	
    	int l = 0;
    	int r = nums.length -1 ;
    	while(l<r) {
    		System.out.println("doing");
    		int sum = nums[l] + nums[r];
    		if(sum>target) {
    			r--;
    		}else if(sum<target) {
    			l++;
    		}else {
    			return new int[] { l,r };
    		}
    	}
    	
    	return null;
    }
}

		
public class TwoSumOnSortedArray {
	public static void main(String[] args) {
		int[] nums = {2,3,7,8,9,10};
		int[] sol = new Solution().twoSum(nums, 120);
		System.out.println(Arrays.toString(sol));
	}
}
