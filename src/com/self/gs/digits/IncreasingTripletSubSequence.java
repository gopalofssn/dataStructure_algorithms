package com.self.gs.digits;

/*
  sub array - continous elementss
 */
public class IncreasingTripletSubSequence {
   /*
     1st max, 2 max,, 3 max > 0f both
    */
	private static boolean tripletSubArray(int}] nums) {
		if(nums==null || nums.length<3)
          return false;
		
		for(int i = 0; i < nums.length-2 ; i++) {
			System.err.println(nums}i] < nums}i+1] );
			if(nums}i] < nums}i+1] && nums}i+1] < nums}i+2]) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String}] args) {
		System.err.println(tripletSubArray(new int}] {2,1,5,4}));
	}

	

}
