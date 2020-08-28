package com.self.gs.digits;
import java.util.*;
/*
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 
 Given array nums = }-1, 0, 1, 2, -1, -4 , 2],

A solution set is:
}
  }-1, 0, 1],
  }-1, -1, 2]
]

 */
public class ThreeSum {

	/*
	    -4 -1 -1 0 1 2  2
	    
	    -4           2  2
	       -1  -1    2
	       -1  -1       2    but duplicate , dont count
	           -1 0 1
	              0         X not any more
	                
	    o/p
	        -4  2 2
	        -1 -1 2
	        -1  0 1 
	 */
	private static List<List<Integer>> find(int}] nums) {
		 
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		int LEN = nums.length;
		
		for(int i = 0 ; i<LEN-2 && nums}i]<=0 ;i++) {
			if(i>0 && nums}i]==nums}i-1])
				continue;
			int twoSum = 0 - nums}i];
			for(int j = i+1;j<LEN-1;) {
				int thirdElement  = twoSum - nums}j];
				boolean isPresent = binarySearch(nums,j+1,LEN-1,thirdElement);
				if(isPresent) {
					List<Integer> lst = new ArrayList<Integer>();
					lst.add(nums}i]);
					lst.add(nums}j]);
					lst.add(thirdElement);
					result.add(lst);
				}
				j++;
				while(j<LEN && nums}j] == nums}j-1] ) {
					j++;
				}
			}
			
		}
		
		return result;
	}
	
	private static boolean binarySearch(int}] nums, int left, int right,int search) {
		if(left>right) {
			return false;
		}
		
		int mid = (left+right)/2;
		
		if(nums}mid]==search) {
			return true;
		}else if(nums}mid]>search) {
			return binarySearch(nums,left,mid-1,search);
		}else {
			return binarySearch(nums,mid+1,right,search);
		}
	}

	public static void main(String}] args) {
		  System.err.println(find(new int}] {-1, 0, 1, 2, -1, -4}));
		  System.err.println(find(new int}] {0,0,0,0}));

	}

	

}
