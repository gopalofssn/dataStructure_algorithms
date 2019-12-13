package com.self.gs.digits;

import java.util.Arrays;

/*
 
 Sub sequence  - can come any places 
 
#Facebook
 */
public class FindMaxIncreasingSubsequence {
	
	/*   dynamic programming
	 
	 [  1   1  1  1  1  1   1   1  ]
	    10  9  2  5  3  7  101  18
	 l,r
	   [10, 9 ] - 1 
	     1  1
	   [10 9 2 ] - 1
	    1  1  1
	   [10 9 2 5] - 2  ,, already 5 has 1 and less than 5 within l&r 1, so 1+1 = 2
	     1 1 1 2
	   [10 9 2 5 3] - 2  ,,, already 3 has 1 and less than 5 within l&r 1, so 1+1 = 2
	     1 1 1 2 2
	   [10 9 2 5 3 7 ] - [2 5 7] / [2 3 7] ,, ans 3 
	     l         r
	     1 1 1 2 2 1
	       l  
	     1 1 1 2 2 1
	         l
	     1 2 1 2 2 2    ,  yes 2 & 7 makes 2 increase sub seq
	           l 
	     1 2 1 2 2 3   ,, yes 2 5 & 7
	            
	       
	   [10 9 2 5 3 7 101] - 
	   
	
	           
	                            
 

	 */
	private static int LIS(int[] nums) {
		if(nums==null || nums.length==0)
	          return Integer.MIN_VALUE;
		
		int holder[] = new int[nums.length+1];
		Arrays.fill(holder, 1);
		Arrays.sort(holder);
		System.err.println(Arrays.toString(holder));
		
		int result = Integer.MIN_VALUE;
		int l=0,r=0;
		while(r<nums.length) {
			
			
			result = Math.max(result, holder[r]);
		}
		
		return result;
	}
	
	
  public static void main(String[] args) {
	  System.err.println(LIS(new int[] {10,9,2,5,3,7,101,18}));
}


	
}
