package com.self.gs.recurssion;

import java.util.*;

/*
 Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.   
 */
public class TargetSum494 {

    public int findTargetSumWays(int[] nums, int S) {
        
        return targetSumHelper(nums, S, 0, 0, new HashMap<String, Integer>());
    }
    
    private int targetSumHelper(int[] nums, final int S, final int index, int currentSum, Map<String, Integer> cache){
    	if(index == nums.length && S == currentSum){
        	return 1;
        }else if(index == nums.length ){
            return 0;
        }
	    String key = "index " + index;
	    if(cache.containsKey(key)) {
	    	return cache.get(key);
	    }
	    
        int countAtIndex =  targetSumHelper(nums, S, index + 1, currentSum - nums[index], cache) + 
                            targetSumHelper(nums, S, index + 1, currentSum + nums[index], cache);
        cache.merge(key, countAtIndex, (a, b) -> a + b);
        System.out.println(cache);
        return countAtIndex;
    }
    
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1};
		int sum = 3;
		System.out.println(new TargetSum494().findTargetSumWays(nums, sum));
	}

}
