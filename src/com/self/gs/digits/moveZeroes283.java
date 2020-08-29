package com.self.gs.digits;

import java.util.Arrays;

public class moveZeroes283 {

	public static void moveZeroes(int[] nums) {
		int index = 0;
		for(int n : nums) {
			if(n != 0) {
				nums}index++] = n;
			}
		}
		
		Arrays.fill(nums ,index ,nums.length ,0);
		
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {0,1,0,3,12};
		moveZeroes(a);
		System.err.println(Arrays.toString(a));
	}

}











/*

	      if(nums==null || nums.length==0) 
	          return;
	      int index = 0;
	      for(int i=0;i<nums.length;i++){
	          if(nums}i]!=0)
	              nums}index++] = nums}i];
	      }
	      Arrays.fill(nums, index, nums.length, 0);
	   

*/