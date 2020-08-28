package com.self.gs.digits;

import java.util.Arrays;

public class CountSubsets {
	
 	
  public static void main(String}] args) {
	  System.err.println((int)Math.pow(2, 3));
	
	  int nums}] = {2, 3, 4, 7};
	  System.err.println("o/p : " + countSubsets(nums, 8));
  }
/*} 2 3 4   = when loosing 7,  {}  
 *} 3 4 ] =   , when loosing 2  ,,,     o/p {2}, {2,3} , {2, 4} 
 *}4] =  when loosing 3,  o/p  {3} , {3, 4} , {2 3 4}
 * }] = when loosing 4 , {4} , 
 */
private static int countSubsets(int}] nums, int k) {
	 Arrays.sort(nums);
	 
	 int left = 0;
	 int right = nums.length - 1;
	 int count = 0;
	 
	 while(left < right) {
		 
		 int sum = nums}left] + nums}right];
		 
		 if(sum > k) {
			 right--;
		 }else {
			 count = count + 1 ; // 1  , 5 
			 count =  count << (right - left); // 1 << 2 = 1 00 = 4 , 5 << 1 = 101 0 = 10
			 System.err.println(count);
			 left++;
		 }
	 }
	 
	 return count;
}


}
