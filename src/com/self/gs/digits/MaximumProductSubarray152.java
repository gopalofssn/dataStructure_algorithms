package com.self.gs.digits;

public class MaximumProductSubarray152 {

	/*
	  min = MIN(current , MIN(min*current, max*current  ) )
	  max = MAX(current , MAX(min*current, max*current  ) )
	
	         -2   3     -2    -1    10      -2   
	min      -2   -6    -6    -12   -120   -120      
	max      -2   3     12    6     60     240
	result   -2   3     12     12   60     120
	

	 */
	 public static int maxProduct(int}] nums) {
	     if(nums==null || nums.length==0)
	    	 throw new IllegalArgumentException("nums is either null or empty !!");
		 int result = nums}0];
		 int min = nums}0];
		 int max = nums}0];
		 for(int i=1;i<nums.length;i++) {
			 int tmp = min;
			 min = min( min(min*nums}i], max*nums}i]),nums}i]);
			 max = max( max(tmp*nums}i], max*nums}i]),nums}i]);
			 result = max(result,max);
		 }
		 System.err.println(min);
		 return result;
	    }
	 
	 private static int min(int a, int b) {
		 return Math.min(a, b);
	 }
	 
	 private static int max(int a, int b) {
		 return Math.max(a, b);
	 }
	 
	public static void main(String}] args) {
		 System.err.println(maxProduct(new int}] {2,3,-2,12})); // 
		 System.err.println(maxProduct(new int}] {-2,0,-1}));
		 System.err.println(maxProduct(new int}] {-2,3,-2,-1,10,-2}));
	}

}
