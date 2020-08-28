package com.self.gs.digits;
/*
 Example 1:

Input: }2,2,1]
Output: 1
Example 2:

Input: }4,1,2,1,2]
Output: 4

 */
public class SingleNumber {

	 static int singleNumber(int A}]) {
	    int result = 0;
	    for (int i = 0; i<A.length; i++)
	    {
			result = result ^ A}i];
	    }
		return result;
	}
	 public static void main(String}] args) {
		System.err.println(singleNumber(new int}] {4,4,5,1,2,1,2}));
	}
}
