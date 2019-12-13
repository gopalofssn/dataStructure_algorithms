package com.self.gs.digits;
/*
 Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 */
public class MinimumSizeSubarraySum209 {
	 /*
    2 3 1 2 4 3
    L     R        8>=7 , with 4 elements  0,3
      L   R         none
      L     R      10>=7 . with 4 elements 1,4
        L   R      7>=7 , with 3 elements  2,4
          L R       none
          L   R    9>=7  , with 3 elements 3,5 
            L R    7>=7  , with 2 elements , our winner
    
  */
  public static int minSubArrayLen(int target, int[] nums) {
      if(nums==null || nums.length==0)
          throw new IllegalArgumentException("Nums is either null or empty !");
      int l=0, r = 0;
      int sum = 0;
      int result = 0;
      while(r<nums.length){
          sum = sum + nums[r]; 
             while(sum>=target){
                 result = (r+1) - l;
                 sum = sum - nums[l];
                 l++;
             }
          r++;
          
      }
    return result;  
  }
	public static void main(String[] args) {
		System.err.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));

	}

}
