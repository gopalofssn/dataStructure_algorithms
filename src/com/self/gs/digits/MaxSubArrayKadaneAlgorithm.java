package com.self.gs.digits;

/*
  sub array - continous elementss
 */
public class MaxSubArrayKadaneAlgorithm {

	/*
	 
	 -2 -3 4 -1 -2 1 5 -3
      0 0  4  3  1 2 7 4     // Previous sum + current element 
      
      currentSum =0, maxSum=0;
      currentSum - max(a[i],a[i]+currentSum);
      maxSum - max(global,currentSum);

Time :  O(n)
	 
	 */

	private static int kadane(int[] nums) {
		if(nums==null || nums.length<3)
          return 0;
		int currentSum = 0, maxSum = 0;
		for(int i=0;i<nums.length;i++) {
			currentSum = nums[i]+currentSum;
			if(currentSum<0)
				currentSum = 0;
			System.err.println(currentSum);
			maxSum = Math.max(maxSum, currentSum);
		}
		
		return maxSum;
	}
	
	
	public static void main(String[] args) {
		System.err.println(kadane(new int[] {-2,-3,4,-1,-2,1,5,-3}));
	}

	

}
