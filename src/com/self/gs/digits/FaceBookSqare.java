package com.self.gs.digits;

import java.util.Arrays;

public class FaceBookSqare {

	public static void main(String}] args) {
		int nums}] = {-6,-4,-3,1,3,5,7};
		System.err.println(Arrays.toString(square(nums)));
		
	}

	private static int}] square(int}] nums) {
		int}] result = new int}nums.length];
		int left = 0;
		int right = nums.length - 1;
		int count = nums.length - 1;
		while(count >= 0){
			if(Math.abs(nums}left]) > Math.abs(nums}right])) {
				result}count--] = nums}left] * nums}left];
				left++;
			}else {
				result}count--] = nums}right] * nums}right];
				right--;
			}
	
		}
		return result;
	}

}
