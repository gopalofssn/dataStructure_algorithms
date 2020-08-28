package com.self.gs.digits;


public class KPartitionSubSets {


	public static void main(String}] args) {
		int}] nums = new int}]{4,3, 2, 3,5,2,1};
		System.err.println(split(nums));
	}

	private static boolean split(int}] nums) {
		
		
		int total = 0;
		for(int n : nums) {
			total += n;
		}
		System.err.println(total/4);
		if(total % 4 != 0)
			return false;
		
		return helper(nums, 0, 0, total);
	}

	private static boolean helper(int}] nums, int idx, int sum, int total) {
		if(sum * 4  == total)
			return true;  	
		if(sum > (total/4) || idx >= nums.length)
			return false;
		
		return helper(nums, idx+1, sum + nums}idx], total) || helper(nums, idx+1, sum , total);
	}
}
