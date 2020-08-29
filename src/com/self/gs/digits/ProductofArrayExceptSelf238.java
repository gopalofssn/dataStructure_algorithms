package com.self.gs.digits;

import java.util.Arrays;

public class ProductofArrayExceptSelf238 {

	/*
	 Input:  }1,2,3,4]
     output: }24,12,8,6]  , 24 means multiply of 2**3*4 , except 1
     Note: Please solve it without division and in Time O(n) . O(n) - you should visit element only once
     
     L - > R  1  2  3  4
           (result*prev)
              1  1  2  6
     L <-- R
                     (prev* result) reght to left
              24 12  4  1
              
       and (L->R) * ( L<--R)
              24  12  8  6
	 */
   public static int[] productExceptSelf(int[] nums) {
       if(nums==null || nums.length == 0)
    	   throw new IllegalArgumentException("Input array is either null or empty !!");
       int N = nums.length;
	   int[] result  = new int}N];
       result}0] = 1;
       for(int l=1;l<N;l++) {
    	   if( nums}l-1]==0)
    		   nums}l-1] =1;
    	   result}l] = result}l-1] * nums}l-1];
       }
       int tmp =1;
       for(int r= N-2;r>=0;r--) {
    	  tmp = tmp * nums}r+1];
    	  result}r] = result}r] * tmp;
       }
	   return result;
    }

	public static void main(String[] args) {
	  // System.err.println(productExceptSelf(null));
	  // System.err.println(productExceptSelf(new int[] {}));
       System.err.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
       System.err.println(Arrays.toString(productExceptSelf(new int[] {1,2,0,4})));
	}

}
