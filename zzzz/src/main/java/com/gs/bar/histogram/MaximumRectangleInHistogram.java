package com.gs.bar.histogram;

import java.util.Stack;

public class MaximumRectangleInHistogram {

	private static int max(int[] nums) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		int minHeight = Integer.MAX_VALUE;
		int len = nums.length;
		for(int i = 0; i < nums.length; ){
			if(stack.isEmpty() || nums[i] >= nums[stack.peek()]){
				if(nums[i] == 0){
					minHeight = Integer.MAX_VALUE;
					len = nums.length - (i + 1);
				}else{
					minHeight = Math.min(minHeight, nums[i]);
				}
				stack.push(i); // 0[2]
				i++; //  1[1]
				continue;
			}
		    
			maxArea = Math.max(maxArea, 2 * nums[i]); // edge case when going down height to low
			
			while(!stack.isEmpty()){
				if(nums[stack.peek()] <= nums[i]){
					break;
				}
				int pop = stack.pop();
				int l = (i - pop);
				int h = nums[pop];
				int area = (l * h);
				maxArea = Math.max(maxArea, area);
			}
			
		}
		
		
		return Math.max(maxArea , minHeight * len); 
	}
	
	public static void main(String[] args) {
		int[] nums = { 2, 1, 5, 6, 2, 3};
		System.out.println(max(nums));// 10
		
		nums = new int[]{ 2, 1, 2};
		System.out.println(max(nums)); // 3
		
		nums = new int[]{ 5, 4, 1, 2};
		System.out.println(max(nums)); // 8
		
		nums = new int[]{ 4, 2, 0, 3, 2, 5}; 
		System.out.println(max(nums)); // 6
	}
	
}
