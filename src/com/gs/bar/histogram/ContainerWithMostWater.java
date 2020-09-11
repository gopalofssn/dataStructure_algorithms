package com.gs.bar.histogram;

/*
https://leetcode.com/problems/container-with-most-water/
Input: [1,8,6,2,5,4,8,3,7]
Output: 49

max area it can frame 

8   | --------|---
7   |         |   |
6   | |       |   |
5   | |   |   |   |
4   | |   | | |   |
3   | |   | | | | |
2   | | | | | | | |
1 | | | | | | | | |
  0 1 2 3 4 5 6 7 8 
  	
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] nums  = {1,8,6,2,5,4,8,3,7};
		System.out.println("O(n*n) approach " + maxAreaNN(nums));
		System.out.println("O(n) approach " + maxAreaN(nums));
	}

	private static int maxAreaN(int[] nums) { // 2 pointer approach , smallest pointer goto next 
		int max = Integer.MIN_VALUE;
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int min = Math.min(nums[left], nums[right]);
			int area = min * ( right - left);
			max = Math.max(max, area);
			if(nums[left] < nums[right]) {
				left++;
			}else {
				right--;
			}
		}
		return max;
	}

	private static int maxAreaNN(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) { // loop 1
			for(int j = i + 1; j < nums.length; j++) { // loop 2
				int min = Math.min(nums[i], nums[j]);
				int area = min * ( j - i);
				max = Math.max(max, area);
			}
		}
		return max;
	}

}
