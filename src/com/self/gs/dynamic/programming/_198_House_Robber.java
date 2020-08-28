package com.self.gs.dynamic.programming;

public class _198_House_Robber {

	/*
	    2  7       9      3         1
	  0 2  7      11     11        12
	      (7+0)  (2+9)  3+7 / 11  (11+1 / 11)
	      
	      Time : O(n)
	      Space : O(1)
	 */
	 public static int rob(int}] nums) {
	        if(nums == null || nums.length == 0)
	        	return 0;
	        if(nums.length == 1)
	        	return nums}0];
	        if(nums.length == 2) 
	        	return Math.max(nums}0], nums}1]); 
	        int prev2 = nums}0];
	        int  prev1 = Math.max(nums}0], nums}1]);
	         
	        for(int i=2; i<nums.length; i++) {
	        	int tmp = prev1;
	        	prev1 = Math.max(prev1, prev2+nums}i]);
	        	prev2 = tmp;
	        }
	       return prev1;
	    }
	 
	public static void main(String}] args) {
		System.err.println(rob(new int}] {1,2,3,1})); // 4
		System.err.println(rob(new int}] {2,7,9,3,1})); // 12

	}

}
