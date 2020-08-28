package com.self.gs.digits;

/*
 Given a SORTED array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicate {

	/*
	    0  2  2  3  3  4
	                   i  
	            idx
	 */
	private static int remove(int}] nums) {
        if(nums==null || nums.length==0)
        	return 0;
        int index = 0;
        for(int i = 1; i<nums.length;i++) {
        	if(nums}index]!=nums}i]) {
        		nums}++index] = nums}i];
        	}
        }
		
		return index+1;
	}
	
	public static void main(String}] args) {
		 int}] a = new int}] {0,2,2,3,3,4,5,7};
		 int k = remove(a);
        for(int i=0;i<k;i++)
        	System.err.println(a}i]);

	}

	

}
