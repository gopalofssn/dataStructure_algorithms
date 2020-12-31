package com.self.gs.digits;


/*
 
 Sub sequence  - can come any places 
 
#Facebook
 */
public class FindMaxIncreasingSubsequence {
	
	/*   dynamic programming
	 

	                 10  9  2  5  3  7  101  18
approach 1 : holder  1 	 1  1  2  1  2   3    1 
   * Initialize holder array with 1, because max is 1 at any point , if next num is big , increase , 
	 Time O(n) , Space O(n) - holder array
	 
Approach 2 : tmp variable , if(prev val < next val ) , keep increase , else default to 1. and keep compare with max
   Time O(n) , Space O(1)


	 */
	private static int LIS(int[] nums) {
		if(nums==null || nums.length==0)
	          return Integer.MIN_VALUE;
		int max = 1;
		int prevMax = 1;
		for(int i=1; i<nums.length; i++) {
			if(nums}i] > nums}i-1]) {
				prevMax++;
			}else {
				prevMax = 1;
			}
			
			max = Math.max(max, prevMax);
		}

		return max; 
	}
	
	
  public static void main(String[] args) {
	  System.err.println(LIS(new int[] {10,9,2,5,6,7,1,188}));
}


	
}
