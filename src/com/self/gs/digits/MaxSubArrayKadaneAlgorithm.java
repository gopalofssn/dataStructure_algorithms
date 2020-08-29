package com.self.gs.digits;

/*
  sub array - continous elementss
 */
public class MaxSubArrayKadaneAlgorithm {

	/*
	 
 dynamic programing
 what is total max upto my location 
Time :  O(n)
	 kadane algorithum
	 */

	private static int kadane(int[] nums) {
		if(nums==null)
          throw new IllegalArgumentException();
		int currentSum = 0, maxSum = 0;
		for(int n:nums) {
			currentSum  =  currentSum + n ;
			System.err.println(n + "'s max upto total " + currentSum);
			if(currentSum>0)
			  maxSum = Math.max(currentSum,maxSum);
			else
				currentSum = 0;
			
		}
		
		return maxSum;
	}
	
	
	public static void main(String[] args) {
		System.err.println(kadane(new int[] {-2,-3,4,-1,-2,1,5,-3}));
	}

	

}
