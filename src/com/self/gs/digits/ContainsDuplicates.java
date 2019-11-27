package com.self.gs.digits;
import java.util.*;
/*
 Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
public class ContainsDuplicates {

	 public boolean containsDuplicate(int[] nums) {
	     Set<Integer> numbers =  new HashSet<Integer>();
	     for(int n : nums) {
	    	 if(numbers.contains(n))
	    		 return true;
	    	 else
	    		 numbers.add(n);
	     }
		 
		 return false;
	    }
	 
	 public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.print(new ContainsDuplicates().containsDuplicate(nums));
	}
	
}
