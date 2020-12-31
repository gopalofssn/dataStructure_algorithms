package com.self.gs.digits;

import java.util.Arrays;

public class CumulativeSumOfArray {

	public static void main(String[] args) {
		int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
		System.err.println("result - " + Arrays.toString(findCummulativeSum(nums)));
		System.err.println("original  - " + Arrays.toString(nums));

	}

	//  i/p : 3, 4, 7, 2, -3, 1, 4, 2
	//  o/p : 3  7  14 16 13  14 18 20
	private static int[] findCummulativeSum(int[] nums) {
		
		if(nums == null || nums.length <= 1) return nums;
		
		for(int i = 1; i < nums.length ; i++) {
			nums}i] = nums}i] + nums}i - 1];
		}
		return nums;
	}

}
