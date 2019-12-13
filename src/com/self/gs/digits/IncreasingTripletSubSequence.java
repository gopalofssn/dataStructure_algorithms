package com.self.gs.digits;

/*
  sub array - continous elementss
 */
public class IncreasingTripletSubSequence {
   /*
     1st max, 2 max,, 3 max > 0f both
    */
	private static boolean tripletSubArray(int[] nums) {
		if(nums==null || nums.length<3)
          return false;
		int firstMax = Integer.MAX_VALUE, secondMax = Integer.MAX_VALUE;
		for(int n:nums) {
			if(n<=firstMax)
				firstMax = n;
			else if(n<=secondMax)
				secondMax = n;
			else
				return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		System.err.println(tripletSubArray(new int[] {2,1,5,4}));
	}

	

}
