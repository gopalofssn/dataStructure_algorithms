package com.self.gs.string;
/*
 Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */
public class ReverseCharArray344 {
	private static char[] reverse(char[] s) {
		if(s==null || s.length==0) 
	          throw new IllegalArgumentException("S is null or empty !");
	     int l = 0;
	     int r = s.length - 1 ;
	     while(l<r){
	        char t = s[r];
	        s[r] = s[l];
	        s[l] = t;
	        l++;
	        r--;
	     }
		return s;
	}
	public static void main(String[] args) {
		 System.err.println(reverse(new char[] {'h','e','l','l','o'}));
	}
}
