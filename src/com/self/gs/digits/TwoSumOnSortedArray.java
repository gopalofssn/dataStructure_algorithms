package com.self.gs.digits;

import java.util.Arrays;

//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
// COND - list is sorted
class Solution {
    public int[] twoSum(int[] nums, int target) {
    	int[] result = {-1,-1};
    	int l_pointer = 0;
    	int r_pointer = nums.length-1;
    	while(l_pointer<r_pointer) {
    		int sum = nums[l_pointer] + nums[r_pointer];
    		if(sum>target) {
    			r_pointer--;
    		}else if(sum<target) {
    			l_pointer++;
    		}else {
    			result[0] = l_pointer;
    			result[1] = r_pointer;
    			return result;
    		}
    	}
		return result;
        
    }
}

		
public class TwoSumOnSortedArray {
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int[] sol = new Solution().twoSum(nums, 34);
		System.out.println(Arrays.toString(sol));
	}
}
