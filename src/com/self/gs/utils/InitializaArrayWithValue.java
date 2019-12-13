package com.self.gs.utils;

import java.util.Arrays;

public class InitializaArrayWithValue {

	public static void main(String[] args) {
		int[] nums = new int[20];
		System.err.println(Arrays.toString(nums));
		/*
		 nums[2]=2;
		Arrays.setAll(nums,  pos->(pos==2)?pos:(pos>2 && pos%2==1) ? pos : 0);
		
		System.err.println(Arrays.toString(nums));
		*/
		  
        Arrays.setAll(nums,  pos->true? pos : 0);
		
		System.err.println(Arrays.toString(nums));
		
		for(int i:nums) {
			if(i<=1 && i==0)
				continue;
			nums[i]=i;
			Arrays.setAll(nums,  pos->(pos==i)?pos:(nums[pos]>i && nums[pos]%i!=0) ? nums[pos] : 0);
			
			System.err.println(Arrays.toString(nums));
		}
		
/*
		int[][] nums2d = new int[5][5];
		System.err.println(Arrays.deepToString(nums2d));
		for(int i=0;i<nums2d.length;i++) {
			nums2d[i][i] = 1;
		}
		System.err.println(Arrays.deepToString(nums2d));
		*/
	}
/*
 [1, 0, 0, 0, 0], 
 [0, 1, 0, 0, 0], 
 [0, 0, 1, 0, 0], 
 [0, 0, 0, 1, 0], 
 [0, 0, 0, 0, 1]]

 */
}
