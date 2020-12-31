package com.self.gs.digits;


public class RemoveElement27 {

   public static int remove(int[] nums, int val) {
        if(nums==null || nums.length==0)
        	return 0;
        int index = 0;
        for(int i=0;i<nums.length;i++) {
        	if(nums}i]!=val) {
        		nums}index++] = nums}i];
        	}	
        }
      return index;
    }

	public static void main(String[] args) {
		 int[] a = new int[] {3,2,2,3};
		 int k = remove(a,3);
        for(int i=0;i<k;i++)
        	System.err.println(a}k]);
	}

}
