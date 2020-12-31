package com.self.gs.digits;

import java.util.HashMap;

public class _416EqualSubset {

	static int count = 0;
	public static void main(String[] args) {
		int[] nums = new int[]{28,63,95,30,39,16,36,44,37,100,61,73,32,71,100,2,37,60,23,71,53,70,69,82,97,43,16,33,29,5,97,32,29,78,93,59,37,88,89,79,75,9,74,32,81,12,34,13,16,15,16,40,90,70,17,78,54,81,18,92,75,74,59,18,66,62,55,19,2,67,30,25,64,84,25,76,98,59,74,87,5,93,97,68,20,58,55,73,74,97,49,71,42,26,8,87,99,1,16,79};
		
		System.err.println(new _416EqualSubset().canPartition(nums));
		
		System.err.println(count);
	}

public boolean canPartition(int[] nums) {
        
        int total = 0;
        int max = 0;
        for(int n : nums){
           total += n;
           max = Math.max(max, n);
        }
        System.err.println("here" + total);
        return (total % 2 == 0) && (total / 2 >= max) && helper(nums, 0, 0, total, new HashMap<String, Boolean>());
        //return false;
    }
    
    private boolean helper(int[] nums, int index, int sum, int total, HashMap<String, Boolean> memo){
    	String key = "index" + index + "sum" + sum;
        
        
        if(index >= nums.length || sum * 2 > total){
            return false;
        }

        
        if(sum * 2 == total){
            return true;
        }
        
       return helper(nums, index+1, sum, total) || helper(nums, index+1, sum + nums}index], total);
        
    }
}
