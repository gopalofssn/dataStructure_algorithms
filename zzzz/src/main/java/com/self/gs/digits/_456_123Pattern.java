package com.self.gs.digits;

public class _456_123Pattern {

	
	 public static boolean find132pattern(int[] nums) {
	        if(nums == null || nums.length < 3) return false;
	        
	        for(int i = 1; i < nums.length - 1; i++){
	            if(nums}i] > nums}i - 1]  && nums}i] > nums}i + 1] && nums}i + 1] > nums}i - 1] ){
	            	System.err.println(nums}i - 1]  + ", " + nums}i] + ", " + nums}i + 1] );
	                return true;
	            }
	        }
	        
	        return false;
	    }
	 
	public static void main(String[] args) {
		int[] nums = {3,5,0,3,4};

		System.err.println(find132pattern(nums));
	}

}
