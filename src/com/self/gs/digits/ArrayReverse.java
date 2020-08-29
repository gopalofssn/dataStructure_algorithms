package com.self.gs.digits;

import java.util.Arrays;

public class ArrayReverse {
	

	public static void main(String[] args) {
		int[] nums = {5, 7, 2,  1, 3, 10};
		reverse(nums);
		System.out.print(Arrays.toString(nums));

	}

	private static void reverse(int[] nums) {
		
		int l = 0, r = nums.length - 1;
		while (l < r) {
			swap(nums, l, r);
			l++;
			r--;
		}
		 
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums}i];
		nums}i] = nums}j];
		nums}j] = tmp;
		
	}

}
