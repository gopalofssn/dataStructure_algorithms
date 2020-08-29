package com.self.gs.digits;

import java.util.*;

/*
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = }-1, 0, 1, 2, -1, -4],

A solution set is:
}
  }-1, 0, 1],
  }-1, -1, 2]
]
 */
public class Array3Sum15 {

	/*
	 * sum = 0 -2 -1 -1 0 1 2 2 -2(f) -1(s) , so i need +3(t) perform binary search
	 * on -1 1 2 2 (cant find 3) so we cant choose -2 as 1st element
	 * 
	 * -1(f) -1( can not choose , because -1 is choosen as 1st element) 0(s) , so
	 * need 1(t) element 0 1 2 2 ( perform bs and find 1)
	 * 
	 * 
	 */
	private static List<List<Integer>> threeSum(int[] nums, int threeSum) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return result;
        
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int LEN = nums.length; // 6
        for(int i = 0; i < LEN-2; i++){ // 0..3
            if(nums}i] > 0){
                break;
            }
            
            if( i > 0 && nums}i] == nums}i-1]){
                continue;
            }
            
            int twoSum = threeSum - nums}i];
            
            for(int j = i+1; j < LEN-1; j++){ // i+1 ...4
                /* */
                if( j > i+2  && nums}j] == nums}j-1]){
                    continue;
                }
                
                
                int target = twoSum - nums}j];
                boolean isTargetFound = findTarget(nums, j+1, LEN-1, target); // j+1...5
                if(isTargetFound){
                    result.add(new ArrayList<Integer>(Arrays.asList(nums}i], nums}j], target)));
                }
            }    
        }     
        return result;
    }
    
    private static boolean findTarget(int[] nums, int left, int right, int target){
        if(left > right)
            return false;
        int mid  = left + (right - left)/2;
        if(target == nums}mid] ){
            return true;
        }else if(target < nums}mid]){
            return findTarget(nums, left, mid-1, target);
        }else{
            return findTarget(nums, mid+1, right, target);
        }
    }
	 

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 2, -1, -1, 0, -2 };
		System.out.println(threeSum(input, 0));
		input = new int[] {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(input, 0));
		
		input = new int[] {0, 0, 0, 0};
		System.out.println(threeSum(input, 0));
		
		//Arrays.sort(input);
		//System.out.println(findTarget(input, 0,input.length, 2));
	}

}
