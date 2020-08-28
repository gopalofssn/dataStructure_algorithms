package com.self.gs.digits;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		int res = lengthOfLIS(nums);
		System.err.println(res);
	}

	private static int lengthOfLIS(int[] nums) {
		

		return helper(nums, 0);
	}

	private static int helper(int[] nums, int index) {
		if(index == nums.length - 1) {
			return 1;
		}
		return 0;
	}

}
